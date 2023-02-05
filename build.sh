# rm public -rf
# mkdir public
hugo --minify
sh npx pagefind --source public
ws -p 1313 -d public\