@file:Suppress("UNUSED_PARAMETER")

package lesson12.task1

/**
 * Класс "Телефонная книга".
 *
 * Общая сложность задания -- средняя, общая ценность в баллах -- 14.
 * Объект класса хранит список людей и номеров их телефонов,
 * при чём у каждого человека может быть более одного номера телефона.
 * Человек задаётся строкой вида "Фамилия Имя".
 * Телефон задаётся строкой из цифр, +, *, #, -.
 * Поддерживаемые методы: добавление / удаление человека,
 * добавление / удаление телефона для заданного человека,
 * поиск номера(ов) телефона по заданному имени человека,
 * поиск человека по заданному номеру телефона.
 *
 * Класс должен иметь конструктор по умолчанию (без параметров).
 */
class PhoneBook {
    var bookList: MutableList<Person> = mutableListOf()
    /**
     * Добавить человека.
     * Возвращает true, если человек был успешно добавлен,
     * и false, если человек с таким именем уже был в телефонной книге
     * (во втором случае телефонная книга не должна меняться).
     */
    fun addHuman(name: String): Boolean {
        var check: Boolean? = null
        for (i in bookList){
            if (i.getName() == name)
                check = false
        }
        return if (check == false)
            check
        else{
            bookList.plusAssign(Person(name, setOf()))
            true
        }
    }

    /**
     * Убрать человека.
     * Возвращает true, если человек был успешно удалён,
     * и false, если человек с таким именем отсутствовал в телефонной книге
     * (во втором случае телефонная книга не должна меняться).
     */
    fun removeHuman(name: String): Boolean {
        var check: Boolean? = false
        var del = Person(null.toString(), emptySet())
        for(i in bookList){
            if(i.getName() == name) {
                del = i
                check = true
            }
        }
        return if(check == true) {
            bookList.minusAssign(del)
            true
        }
        else false
    }

    /**
     * Добавить номер телефона.
     * Возвращает true, если номер был успешно добавлен,
     * и false, если человек с таким именем отсутствовал в телефонной книге,
     * либо у него уже был такой номер телефона,
     * либо такой номер телефона зарегистрирован за другим человеком.
     */
    fun addPhone(name: String, phone: String): Boolean {
        var numb = -1
        var check: Boolean = false
        for(i in bookList){
            numb += 1
            if(i.getName() == name && !i.getNumberList().contains(phone)) {
                check = true
                bookList[numb] = i.addNumber(phone)
            }
        }
        return check
    }

    /**
     * Убрать номер телефона.
     * Возвращает true, если номер был успешно удалён,
     * и false, если человек с таким именем отсутствовал в телефонной книге
     * либо у него не было такого номера телефона.
     */
    fun removePhone(name: String, phone: String): Boolean {
        var check: Boolean = false
        var numb = -1
        for(i in bookList){
            numb += 1
            if(i.getName() == name && i.getNumberList().contains(phone)) {
                bookList[numb] = i.removeNumber(phone)
                check = true
            }
        }
        return check
    }

    /**
     * Вернуть все номера телефона заданного человека.
     * Если этого человека нет в книге, вернуть пустой список
     */
    fun phones(name: String): Set<String> {
        var result: Set<String> = setOf()
        var check: Boolean = false
        for (i in bookList){
            if (i.getName() == name)
                result = i.getNumberList()
        }
        return result
    }

    /**
     * Вернуть имя человека по заданному номеру телефона.
     * Если такого номера нет в книге, вернуть null.
     */
    fun humanByPhone(phone: String): String? {
        var result: String? = null
        for(i in bookList){
            if(i.getNumberList().contains(phone)) result = i.getName()
        }
        return result
    }



    /**
     * Две телефонные книги равны, если в них хранится одинаковый набор людей,
     * и каждому человеку соответствует одинаковый набор телефонов.
     * Порядок людей / порядок телефонов в книге не должен иметь значения.
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PhoneBook

        if (bookList == other.bookList) return false

        return true
    }

    override fun hashCode(): Int {
        return bookList.hashCode()
    }

}


data class Person(val person_name: String, var phone_numbers: Set<String>){
    private var personname: String = person_name
    private var numberList:Set<String> = phone_numbers


    // Получить имя
    fun getName(): String {
        return personname
    }

    // Получить номер
    fun getNumberList(): Set<String> {
        return numberList
    }

    // Добавить номер
    fun addNumber(number:String): Person {
        var result = Person(person_name = person_name, phone_numbers = phone_numbers + setOf(number))
        return result
    }

    // Удалить номер
    fun removeNumber(number: String): Person {
        var result = Person(person_name = person_name, phone_numbers = phone_numbers - setOf(number))
        return result
    }
}
