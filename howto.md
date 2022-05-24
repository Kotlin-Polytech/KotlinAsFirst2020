1 ПОРЯДОК ДЕЙСТВИЙ
2 git remote add upstream-my https://git@github.com/uphoros/KotlinAsFirst2021.git
3 git checkout -b backport
4 затем я в идее черрипикнул все свои коммиты в бранч backport и запушил изменения
5 git remote add upstream-theirs https://git@github.com/elisananeva/KotlinAsFirst2021.git (своим партнером я выбрал Степанову Елизавету)
6 git merge upstream-theirs/master
7 git merge origin/backport --strategy-option ours (мои коммиты в приоритете)
8 touch "howto.md"
9 git add "howto.md"
10 git commit -m "file howto.md"
11 touch "remotes.md"
12 git add "remotes.md"
13 git commit -m "file remote.md"
14 git push
