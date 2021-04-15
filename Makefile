ANTLR_JAR ?= /usr/local/lib/antlr-4.8-complete.jar
i ?= i.c
o ?= o.s
outFile ?= a.out
CC = riscv64-unknown-elf-gcc  -march=rv32im -mabi=ilp32
QEMU = qemu-riscv32

ifdef DEBUG
	EXTRA_ARGS = -backtrace
else
	EXTRA_ARGS =
endif

CLASSPATH = $(ANTLR_JAR):generated

RUNMD = python3 -m minidecaf $(EXTRA_ARGS)


all: asm
	$(CC) $(o)
	$(QEMU) $(outFile) ; echo $$?

asm: grammar-py
	$(RUNMD) $(i) $(o)

grammar-py:
	cd minidecaf && java -jar $(ANTLR_JAR) -Dlanguage=Python3 -visitor -o generated MiniDecafExpr.g4

clean:
	rm -rf generated minidecaf/generated
	rm -rf minidecaf/**__pycache__

reference:
	$(CC) $(i)
	$(QEMU) $(outFile) ; echo $$?

.PHONY: clean
