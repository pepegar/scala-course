.PHONY: mdoc

PANDOC = pandoc
SBT = sbt
HIGHLIGHT_STYLE=tango

basics1:
	@$(PANDOC) -t beamer \
             --highlight-style=$(HIGHLIGHT_STYLE) \
             --pdf-engine=xelatex \
             --from markdown \
             docs/mdoc-out/basics1.md -o slides/basics1.pdf
	@echo "- generating basics1.pdf"

basics2:
	@$(PANDOC) -t beamer \
             --highlight-style=$(HIGHLIGHT_STYLE) \
             --pdf-engine=xelatex \
             --from markdown \
             docs/mdoc-out/basics2.md -o slides/basics2.pdf
	@echo "- generating basics2.pdf"

abstraction1:
	@$(PANDOC) -t beamer \
             --highlight-style=$(HIGHLIGHT_STYLE) \
             --pdf-engine=xelatex \
             --from markdown \
             docs/mdoc-out/abstraction1.md -o slides/abstraction1.pdf
	@echo "- generating abstraction1.pdf"

typeclasses:
	@$(PANDOC) -t beamer \
             --highlight-style=$(HIGHLIGHT_STYLE) \
             --pdf-engine=xelatex \
             --from markdown \
             docs/mdoc-out/typeclasses.md -o slides/typeclasses.pdf
	@echo "- generating typeclasses.pdf"

scalacheck:
	@$(PANDOC) -t beamer \
             --highlight-style=$(HIGHLIGHT_STYLE) \
             --pdf-engine=xelatex \
             --from markdown \
             docs/mdoc-out/scalacheck.md -o slides/scalacheck.pdf
	@echo "- generating scalacheck.pdf"

implicits:
	@$(PANDOC) -t beamer \
             --highlight-style=$(HIGHLIGHT_STYLE) \
             --pdf-engine=xelatex \
             --from markdown \
             docs/mdoc-out/implicits.md -o slides/implicits.pdf
	@echo "- generating implicits.pdf"

taglessfinal:
	@$(PANDOC) -t beamer \
             --highlight-style=$(HIGHLIGHT_STYLE) \
             --pdf-engine=xelatex \
             --from markdown \
             docs/mdoc-out/taglessfinal.md -o slides/taglessfinal.pdf
	@echo "- generating taglessfinal.pdf"

mdoc:
	$(SBT) docs/mdoc

all: mdoc basics1 basics2 abstraction1 typeclasses scalacheck implicits taglessfinal

pandoc_all: basics1 basics2 abstraction1 typeclasses scalacheck implicits taglessfinal
