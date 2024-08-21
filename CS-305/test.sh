fileItemString=$(cat  lines.txt |tr "\n" " ")

fileItemArray=($fileItemString)

for item in ${fileItemArray[@]} ; do
	echo "$item (Time: $(date))"
done > ./test.log

git init

git add .

git commit -m "Updating files"

git remote add https://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@github.com/Luke-Frazer/cs305_lef92.git

git push origin main
