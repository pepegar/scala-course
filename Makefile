.PHONY: tut clean

PANDOC = pandoc
SBT = sbt
REVEAL_CDN = "https://cdnjs.cloudflare.com/ajax/libs/reveal.js/3.7.0"

basics1:
	@$(PANDOC) -t html5 \
          --template=default.revealjs --standalone --section-divs \
          --variable theme="beige" --variable transition="linear" \
          --variable revealjs-url=$(REVEAL_CDN) \
          docs/tut-out/basics1.md -o docs/tut-out/basics1.html
	@echo "- converting basics1.md to basics1.html"

basics2:
	@$(PANDOC) -t html5 \
          --template=default.revealjs --standalone --section-divs \
          --variable theme="beige" --variable transition="linear" \
          --variable revealjs-url=$(REVEAL_CDN) \
          docs/tut-out/basics2.md -o docs/tut-out/basics2.html
	@echo "- converting basics2.md to basics2.html"

abstraction1:
	@$(PANDOC) -t html5 \
          --template=default.revealjs --standalone --section-divs \
          --variable theme="beige" --variable transition="linear" \
          --variable revealjs-url=$(REVEAL_CDN) \
          docs/tut-out/abstraction1.md -o docs/tut-out/abstraction1.html
	@echo "- converting abstraction1.md to abstraction1.html"

typeclasses:
	@$(PANDOC) -t html5 \
          --template=default.revealjs --standalone --section-divs \
          --variable theme="beige" --variable transition="linear" \
          --variable revealjs-url=$(REVEAL_CDN) \
          docs/tut-out/typeclasses.md -o docs/tut-out/typeclasses.html
	@echo "- converting typeclasses.md to typeclasses.html"

scalacheck:
	@$(PANDOC) -t html5 \
          --template=default.revealjs --standalone --section-divs \
          --variable theme="beige" --variable transition="linear" \
          --variable revealjs-url=$(REVEAL_CDN) \
          docs/tut-out/scalacheck.md -o docs/tut-out/scalacheck.html
	@echo "- converting scalacheck.md to scalacheck.html"

move-files:
	@cp docs/tut-out/*.html server/src/main/resources

tut:
	$(SBT) docs/tut

all: tut basics1 basics2 abstraction1 typeclasses scalacheck move-files

clean:
	rm -f docs/tut-out/*.html
	rm -f server/src/main/resources/*.html
