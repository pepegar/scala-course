source := docs/mdoc-out
output := slides
sources := $(wildcard $(source)/*.md)
objects := $(patsubst %.md,%.pdf,$(subst $(source),$(output),$(sources)))
sbt := sbt

$(output)/%.pdf: $(source)/%.md
	pandoc \
		--pdf-engine=xelatex \
		--variable monofont="PragmataPro Mono" \
		--variable fontsize=12pt \
		--variable theme=Madrid \
		-f markdown $< \
		-t beamer \
		--highlight-style tango \
		-o $@

all: mdoc $(objects)

mdoc:
	$(sbt) docs/mdoc

watch:
	ls docs/*.md | entr make all

clean:
	rm -f $(output)/*.pdf
