CFLAGS = -Wall -fpic -coverage -lm -fno-stack-protector

rngs.o: rngs.h rngs.c
	gcc -c rngs.c -g  $(CFLAGS)

dominion.o: dominion.h dominion.c rngs.o
	gcc -c dominion.c -g  $(CFLAGS)

playdom: dominion.o playdom.c
	gcc -o playdom playdom.c -g dominion.o rngs.o $(CFLAGS)
#To run playdom you need to entere: ./playdom <any integer number> like ./playdom 10*/
testDrawCard: testDrawCard.c dominion.o rngs.o
	gcc  -o testDrawCard -g  testDrawCard.c dominion.o rngs.o $(CFLAGS)

badTestDrawCard: badTestDrawCard.c dominion.o rngs.o
	gcc -o badTestDrawCard -g  badTestDrawCard.c dominion.o rngs.o $(CFLAGS)

testBuyCard: testDrawCard.c dominion.o rngs.o
	gcc -o testDrawCard -g  testDrawCard.c dominion.o rngs.o $(CFLAGS)

testAll: dominion.o testSuite.c
	gcc -o testSuite testSuite.c -g  dominion.o rngs.o $(CFLAGS)

interface.o: interface.h interface.c
	gcc -c interface.c -g  $(CFLAGS)

runtests: testDrawCard 
	./testDrawCard &> unittestresult.out
	gcov dominion.c >> unittestresult.out
	cat dominion.c.gcov >> unittestresult.out


player: player.c interface.o
	gcc -o player player.c -g  dominion.o rngs.o interface.o $(CFLAGS)

all: playdom player testDrawCard testBuyCard badTestDrawCard

unittest1: unittest1.c dominion.o rngs.o
	gcc -o unittest1 unittest1.c -g  dominion.o rngs.o $(CFLAGS)

unittest2: unittest2.c dominion.o rngs.o
	gcc -o unittest2 unittest2.c -g  dominion.o rngs.o $(CFLAGS)

unittest3: unittest3.c dominion.o rngs.o
	gcc -o unittest3 unittest3.c -g  dominion.o rngs.o $(CFLAGS)


unittest4: unittest4.c dominion.o rngs.o
	gcc -o unittest4 unittest4.c -g  dominion.o rngs.o $(CFLAGS)

cardtest1: cardtest1.c dominion.o rngs.o
	gcc -o cardtest1 cardtest1.c -g  dominion.o rngs.o $(CFLAGS)

cardtest2: cardtest2.c dominion.o rngs.o
	gcc -o cardtest2 cardtest2.c -g  dominion.o rngs.o $(CFLAGS)

cardtest3: cardtest3.c dominion.o rngs.o
	gcc -o cardtest3 cardtest3.c -g  dominion.o rngs.o $(CFLAGS)

cardtest4: cardtest4.c dominion.o rngs.o
	gcc -o cardtest4 cardtest4.c -g  dominion.o rngs.o $(CFLAGS)

unittestresults.out: unittest1 unittest2 unittest3 unittest4 cardtest1 cardtest2 cardtest3 cardtest4
	./unittest1 > unittestresult.out
	echo >> unittestresult.out
	./unittest2 >> unittestresult.out
	echo >> unittestresult.out
	./unittest3 >> unittestresult.out
	echo >> unittestresult.out
	./unittest4 >> unittestresult.out
	echo >> unittestresult.out
	./cardtest1 >> unittestresult.out
	echo >> unittestresult.out
	./cardtest2 >> unittestresult.out
	echo >> unittestresult.out
	./cardtest3 >> unittestresult.out
	echo >> unittestresult.out
	./cardtest4 >> unittestresult.out
	echo >> unittestresult.out
	echo >> unittestresult.out
	gcov -abcfu dominion.c -b >> unittestresult.out
	echo >> unittestresult.out
	cat dominion.c.gcov >> unittestresult.out

randomtestcard1: randomtestcard1.c dominion.o rngs.o
	gcc -o randomtestcard1 randomtestcard1.c -g  dominion.o rngs.o $(CFLAGS)

randomtestcard2: randomtestcard2.c dominion.o rngs.o
	gcc -o randomtestcard2 randomtestcard2.c -g  dominion.o rngs.o $(CFLAGS)

randomtestadventurer: randomtestadventurer.c dominion.o rngs.o
	gcc -o randomtestadventurer randomtestadventurer.c -g  dominion.o rngs.o $(CFLAGS)


randomtests: randomtestcard1 randomtestcard2 randomtestadventurer
	./randomtestcard1 > randomtestcard1.out
	echo >> randomtestcard1.out
	echo "Coverage Results for Garden Test" >> randomtestcard1.out
	echo "---------------------------------" >> randomtestcard1.out
	echo >> randomtestcard1.out
	gcov -abcfu dominion.c -b >> randomtestcard1.out
	./randomtestadventurer > randomtestadventurer.out
	echo >> randomtestadventurer.out
	echo "Coverage Results for Adventurer Test" >> randomtestadventurer.out
	echo "---------------------------------" >> randomtestadventurer.out
	echo >> randomtestadventurer.out
	gcov -abcfu dominion.c -b >> randomtestadventurer.out
	./randomtestcard2 > randomtestcard2.out
	echo >> randomtestcard2.out
	echo "Coverage Results for Great Hall Test" >> randomtestcard2.out
	echo "---------------------------------" >> randomtestcard2.out
	echo >> randomtestcard2.out
	gcov -abcfu dominion.c -b >> randomtestcard2.out
	echo >> randomtestcard1.out
	echo >> randomtestcard2.out
	echo >> randomtestadventurer.out
	cat dominion.c.gcov >> randomtestcard1.out
	cat dominion.c.gcov >> randomtestcard2.out
	cat dominion.c.gcov >> randomtestadventurer.out



clean:
	rm -f *.o playdom.exe playdom player player.exe unittest1 unittest2 unittest3 unittest4 cardtest1 cardtest2 cardtest3 cardtest4 randomtestcard1 randomtestcard2 randomtestadventurer *.gcov *.gcda *.gcno *.so *.out testDrawCard testDrawCard.exe
