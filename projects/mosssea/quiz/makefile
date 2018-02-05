CFLAGS = -Wall -fpic -lm -fno-stack-protector

testme.o: testme.c
	gcc -c testme.c -g  $(CFLAGS)

testme: testme.o
	gcc -o testme -g  testme.o $(CFLAGS)

clean:
	rm testme *.gcno *.o *.gcda