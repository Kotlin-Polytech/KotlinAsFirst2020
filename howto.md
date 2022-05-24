1 ПОРЯДОК ДЕЙСТВИЙ
2 git remote add upstream-my https://git@github.com/uphoros/KotlinAsFirst2021.git
3 git checkout -b backport
4 затем я в идее черрипикнул все свои коммиты в бранч backport и запушил изменения
5 git remote add upstream-theirs https://git@github.com/elisananeva/KotlinAsFirst2021.git (своим партнером я выбрал Степанову Елизавету)
6 git checkout master
7 git merge upstream-theirs/master
8 git merge origin/backport --strategy-option ours (мои коммиты в приоритете)
9 touch "howto.md"
10 git add "howto.md"
11 git commit -m "file howto.md"
12 touch "remotes.md"
13 git add "remotes.md"
14 git commit -m "file remote.md"
15 git push с токеном
