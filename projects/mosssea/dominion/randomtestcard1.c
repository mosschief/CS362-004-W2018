//
// Sean Moss
// Random Test for Garden Card
#include <time.h>
#include <stdio.h>
#include "dominion.h"
#include "dominion_helpers.h"
#include <stdlib.h>
int main{

    struct gameState g;
    int cards[10] = {adventurer, embargo, village, minion, mine, cutpurse, sea_hag, tribute,
                     smithy, council_room};
    int k = 0;
    int i = 0;
    int j = 0;
    int check = 0;

    printf("--------------------Testing Gardens Card----------\n");


    int i, j, k;

    // seed random
    srand(time(NULL));

    // runs 1000 random tests
    for(k = 0; k < 1000; k++) {

        struct gameState myGameState;

        // fill gamestate with random data

        for (i = 0; i < 2000; i++) {
            for (j = 0; j < sizeof(struct gameState); j++) {
                ((char *) myGameState)[j] = floor(rand() * 256);
            }
        }
        // choose random hand position (within limits)
        int handPos = rand() % 10;

        int myReturn = cardEffect(gardens,0,0,0, myGameState, handPos);

        if (myReturn != -1){
            printf("Test Failed! Return not equal to -1");
        }
    }

    return 0;
};