.PHONY: tut pandoc all

tut:
	sbt tut

pandoc:
	pandoc -t html5 --template=default.revealjs --standalone --section-divs --variable theme="beige" --variable transition="linear" tut-out/slides.md -o tut-out/slides.html

all: tut pandocg
