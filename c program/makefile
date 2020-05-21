#!make -f

Without_Sanitize: fsanitize.c
	gcc -w fsanitize.c
	./a.out
address: fsanitize.c
	gcc -w -fsanitize=address fsanitize.c
	./a.out
leak: fsanitize.c
	gcc -w -fsanitize=leak fsanitize.c
	./a.out
bounds: fsanitize.c
	gcc -w -fsanitize=bounds fsanitize.c
	./a.out
divZero: fsanitize.c
	gcc -w -fsanitize=integer-divide-by-zero fsanitize.c
	./a.out
clean:
			rm -f a.out
# RUN: gcc  -fsanitize=<Something> name file && ./a.out
