ПОРЯДОК ДЕЙСТВИЙ
git remote add upstream-my https://git@github.com/uphoros/KotlinAsFirst2021.git
git checkout -b backport
затем я в идее черрипикнул все свои коммиты в бранч backport и запушил изменения
git remote add upstream-theirs https://git@github.com/elisananeva/KotlinAsFirst2021.git (своим партнером я выбрал Степанову Елизавету)
git merge upstream-theirs/master
git merge origin/backport --strategy-option ours (мои коммиты в приоритете)
touch "howto.md"
git add "howto.md"
git commit -m "file howto.md"
touch "remotes.md"
git add "remotes.md"
git commit -m "file remote.md"
git push
