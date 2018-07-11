.PHONY: tut clean

PANDOC = pandoc
SBT = sbt

basics1:
	@$(PANDOC) -t html5 \
          --template=default.revealjs --standalone --section-divs \
          --variable theme="beige" --variable transition="linear" \
          tut-out/basics1.md -o tut-out/basics1.html
	@echo "- converting basics1.md to basics1.html"

basics2:
	@$(PANDOC) -t html5 \
          --template=default.revealjs --standalone --section-divs \
          --variable theme="beige" --variable transition="linear" \
          tut-out/basics2.md -o tut-out/basics2.html
	@echo "- converting basics2.md to basics2.html"

abstraction1:
	@$(PANDOC) -t html5 \
          --template=default.revealjs --standalone --section-divs \
          --variable theme="beige" --variable transition="linear" \
          tut-out/abstraction1.md -o tut-out/abstraction1.html
	@echo "- converting abstraction1.md to abstraction1.html"

tut:
	$(SBT) tut

all: tut basics1 basics2 abstraction1

clean:
	rm -f tut-out/*.html