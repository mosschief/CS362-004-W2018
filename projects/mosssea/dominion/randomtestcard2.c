//
// Sean Moss
// Random Test for Garden Card
#include <time.h>
#include <stdio.h>
#include "dominion.h"
#include "dominion_helpers.h"
#include <stdlib.h>
#include <math.h>

#define ANSI_COLOR_RED     "\x1b[31m"
#define ANSI_COLOR_GREEN   "\x1b[32m"
#define ANSI_COLOR_RESET   "\x1b[0m"

int main() {

    int cards[10] = {adventurer, embargo, village, minion, mine, cutpurse, sea_hag, tribute,
                     smithy, council_room};
    int k = 0;
    int i = 0;
    int j = 0;
    int check = 0;

    printf("--------------------Testing Great Hall Card----------\n");

    // seed random
    srand(time(NULL));

    // runs 1000 random tests
    for(k = 0; k < 1000; k++) {

        struct gameState g;

        int possibleCards[5] = {copper, silver, gold, village, tribute};

        // choose random hand position (within limits)
        int handPos = rand() % 10;

        // choose random number of players
        int players = rand() % 4 + 1;

        // initialize game
        initializeGame(players, cards, rand()%9999999 + 1, &g);

        // choose random starting decks (including hand and discard)
        for(i = 0; i < players; i++){
            g.handCount[i] = rand() % 25;
            g.discardCount[i] = rand() % 15;
            g.deckCount[i] = rand() % 25;
            for(j = 0; j < g.handCount[i]; j++){
                g.hand[i][j] = possibleCards[rand()%5];
            }
            for(j = 0; j < g.discardCount[i]; j++){
                g.discard[i][j] = possibleCards[rand()%5];
            }
            for(j = 0; j < g.deckCount[i]; j++){
                g.deck[i][j] = possibleCards[rand()%5];
            }
        }

        int myReturn = cardEffect(great_hall,0,0,0, &g, handPos, NULL);

        if (myReturn != -1){
            printf(ANSI_COLOR_RED  "Test Failed at handpos %d! Return not equal to -1\n" ANSI_COLOR_RESET, handPos);
            check += 1;
        }
    }

    if(check == 0){
        printf( ANSI_COLOR_GREEN "All tests passed!\n" ANSI_COLOR_RESET);
    }

    return 0;
};