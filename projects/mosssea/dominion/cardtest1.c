
#include "dominion.h"
#include <string.h>
#include <stdio.h>
#include "rngs.h"
#include "dominion_helpers.h"



int main() {

    struct gameState g;
    int cards[10] = {adventurer, embargo, village, minion, mine, cutpurse, sea_hag, tribute,
                     smithy, council_room};

    printf("--------------------Testing Smithy Card----------\n");

    int choice1 = 0;
    int choice2 = 0;
    int choice3 = 0;

    initializeGame(4, cards, 100, &g);

    // testing smithy for each player and in each hand position
    int i = 0;
    int j = 0;
    int k = 0;
    int temp;
    for(i = 0; i < 4; i++){
        g.whoseTurn = i;
        for(j = 0; j < 5; j ++){
            initializeGame(4, cards, 100, &g);
            int check = 0;
            temp = g.hand[i][j]; // save current card at hand position to temp
            g.hand[i][j] = smithy;

            // get how many cards of each type player has (to check later)
            int numberOfCards[treasure_map + 1];
            for(k=0; k <= treasure_map; k++){
                numberOfCards[k] = fullDeckCount(i, k, &g);
            }

            // save supply of kingdom and victory cards (to check later)
            int supplyCards[treasure_map+1];
            for(k = 0; k <= treasure_map; k++){
                supplyCards[k] = g.supplyCount[k];
            }

            cardEffect(smithy, choice1, choice2, choice3, &g, 0, 0);

            // checking if hand count for player is as expected
            if(g.handCount[i] != 7){
                check += 1;
                printf("Expected 7 cards in player hand got %d!\n", g.handCount[i]);
            }

            // checking if cards came from player pile (that total cards of each type are same)
            numberOfCards[smithy] -= 1; // accounts for played smithy card
            for(k=0; k <= treasure_map; k++){
                if(numberOfCards[k] != fullDeckCount(i, k, &g)){
                    check++;
                    printf("player cards changed (card came from outside source)\n");
                }
            }

            // checking if handcount for other players is as expected
            for(k = 0; k < 4; k++){
                if(k != i){
                    if(g.handCount[k] != 7){
                        check += 1;
                        printf("Expected 5 cards in player %d hand got %d!", k, g.handCount[k]);
                    }
                }
            }

            // checks if supply card piles changed
            for(k=0; k <= treasure_map; k++){
                if(g.supplyCount[k] != supplyCards[k]){
                    printf("Supply cards altered!\n");
                    check++;
                }
            }

            if(check == 0){ // prints pass or fail for current player and position
                printf("Player %d position %d : Passed!\n", i, j);
            }
            else{
                printf("Player %d position %d : Failed!\n", i, j);
            }

            memset(&g, 23, sizeof(struct gameState));   // clear the game state

        }
    }

}

