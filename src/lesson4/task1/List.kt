@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson4.task1

import lesson1.task1.discriminant
import kotlin.math.sqrt

// Урок 4: списки
// Максимальное количество баллов = 12
// Рекомендуемое количество баллов = 8
// Вместе с предыдущими уроками = 24/33

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
    when {
        y < 0 -> listOf()
        y == 0.0 -> listOf(0.0)
        else -> {
            val root = sqrt(y)
            // Результат!
            listOf(-root, root)
        }
    }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * Из имеющихся целых чисел, заданного через vararg-параметр, сформировать массив их квадратов
 */
fun squares(vararg array: Int) = squares(array.toList()).toTypedArray()

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая (2 балла)
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double = TODO()

/**
 * Простая (2 балла)
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double = TODO()

/**
 * Средняя (3 балла)
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> = TODO()

/**
 * Средняя (3 балла)
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.
 */
fun times(a: List<Int>, b: List<Int>): Int = TODO()

/**
 * Средняя (3 балла)
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0 при любом x.
 */
fun polynom(p: List<Int>, x: Int): Int = TODO()

/**
 * Средняя (3 балла)
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Int>): MutableList<Int> = TODO()

/**
 * Средняя (3 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> = TODO()

/**
 * Сложная (4 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String = TODO()

/**
 * Средняя (3 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> = TODO()

/**
 * Сложная (4 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, n.toString(base) и подобные), запрещается.
 */
fun convertToString(n: Int, base: Int): String = TODO()

/**
 * Средняя (3 балла)
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int = TODO()

/**
 * Сложная (4 балла)
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, str.toInt(base)), запрещается.
 */
fun decimalFromString(str: String, base: Int): Int = TODO()

/**
 * Сложная (5 баллов)
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
    //val dec = listOf(1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000)
    //val rom = listOf("I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M")
    var answer = ""
    var a = n

    while (a >= 1000) {
        a -= 1000
        answer += "M"
    }
    while (a >= 900) {
        a -= 900
        answer += "CM"
    }
    while (a >= 500) {
        a -= 500
        answer += "D"
    }
    while (a >= 400) {
        a -= 400
        answer += "CD"
    }
    while (a >= 100) {
        a -= 100
        answer += "C"
    }
    while (a >= 90) {
        a -= 90
        answer += "XC"
    }
    while (a >= 50) {
        a -= 50
        answer += "L"
    }
    while (a >= 40) {
        a -= 40
        answer += "XL"
    }
    while (a >= 10) {
        a -= 10
        answer += "X"
    }
    while (a >= 9) {
        a -= 9
        answer += "IX"
    }
    while (a >= 5) {
        a -= 5
        answer += "V"
    }
    while (a >= 4) {
        a -= 4
        answer += "IV"
    }
    while (a >= 1) {
        a -= 1
        answer += "I"
    }

    return answer

}

/**
 * Очень сложная (7 баллов)
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    val list = listOf(
        Pair(900, "девятьсот"),
        Pair(800, "восемьсот"),
        Pair(700, "семьсот"),
        Pair(600, "шестьсот"),
        Pair(500, "пятьсот"),
        Pair(400, "четыреста"),
        Pair(300, "триста"),
        Pair(200, "двести"),
        Pair(100, "сто"),
        Pair(90, "девяносто"),
        Pair(80, "восемьдесят"),
        Pair(70, "семьдесят"),
        Pair(60, "шестьдесят"),
        Pair(50, "пятьдесят"),
        Pair(40, "сорок"),
        Pair(30, "тридцать"),
        Pair(20, "двадцать"),
        Pair(19, "девятнадцать"),
        Pair(18, "восемнадцать"),
        Pair(17, "семнадцать"),
        Pair(16, "шестнадцать"),
        Pair(15, "пятнадцать"),
        Pair(14, "четырнадцать"),
        Pair(13, "тринадцать"),
        Pair(12, "двенадцать"),
        Pair(11, "одиннадцать"),
        Pair(10, "десять"),
        Pair(9, "девять"),
        Pair(8, "восемь"),
        Pair(7, "семь"),
        Pair(6, "шесть"),
        Pair(5, "пять"),
        Pair(4, "четыре"),
        Pair(3, "три"),
        Pair(2, "два"),
        Pair(1, "один"),
        Pair(0, ""),
    )
    val rus = list.toMap()
    var beg = n / 1000
    var end = n % 1000
    var answer = ""
    if (end > 0) {
        if ((end % 100) in 11..19) {
            answer += rus.get(end % 100)
            end -= end % 100
            if (end > 0) answer = rus.get(end) + " " + answer
            if (answer[answer.lastIndex] == ' ') answer = answer.dropLast(1)
        } else {
            answer += rus.get(end % 10)
            end -= end % 10
            if (end % 100 > 0) answer = rus.get(end % 100) + " " + answer
            end -= end % 100
            if (end > 0) answer = rus.get(end) + " " + answer
            if (answer[answer.lastIndex] == ' ') answer = answer.dropLast(1)
        }
    }
    if (beg > 0) {

        if ((beg % 100) in 11..19) {
            answer = rus.get(beg % 100) + " тысяч $answer"
            beg -= beg % 100
            if (beg > 0) answer = rus.get(beg) + " " + answer
            return answer
        } else {
            val a = beg % 10
            //val b = beg % 100
            if (beg % 10 > 0) answer = when {
                ((beg % 10 == 0) && (beg % 100 !in 10..20)) -> " тысяч "
                ((beg % 10 == 1) && (beg % 100 !in 10..20)) -> "одна тысяча "
                ((beg % 10 == 2) && (beg % 100 !in 10..20)) -> "две тысячи "
                ((beg % 10 == 3) && (beg % 100 !in 10..20)) -> "три тысячи "
                ((beg % 10 == 4) && (beg % 100 !in 10..20)) -> "четыре тысячи "
                //((beg % 10 in 2..4) && (beg % 100 !in 10..20)) -> rus.get(beg) + " тысячи "
                else -> rus.get(beg % 10) + " тысяч "
            } + answer
            //answer = rus.get(beg % 10) + " " + answer
            beg -= beg % 10
            if (a == 0) answer = "тысяч $answer"
            if (beg % 100 > 0) answer = rus.get(beg % 100) + " " + answer
            beg -= beg % 100
            if (beg > 0) answer = rus.get(beg) + " " + answer
        }
    }
    if (answer[answer.lastIndex] == ' ') return answer.dropLast(1)
    return answer
}