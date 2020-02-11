package com.shpp.p2p.cs.ykohuch.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part4 extends KarelTheRobot{

    /*basic method
    * Karel fill in rows while front is clear
    * if it is the one column world Karel used functional behind 'if'*/
    public void run() throws Exception {
        while (frontIsClear()) {
            fillInnRow();
        }
        if (frontIsBlocked()) {
            if(facingEast()){
                if(noBeepersPresent()){
                    turnLeft();
                    while (frontIsClear()) {
                        fillInnRow();
                    }
                }
            }
        }
    }


   /* fill in the odd line and move on to the next row
    if current row is odd and fill, Karel moving to the pair row
    if current row is pair and fill, Karel moving to the odd row*/
    private void fillInnRow() throws Exception {
        putBeeper();
        while (frontIsClear()){
            jumpThroughTheCell();
        }
        changingDirection();
    }

    /*The function allows  to reach the end of the line and put the beeper through one cell*/
    private void jumpThroughTheCell() throws Exception{
        if (beepersPresent()) {
            move();
            if(frontIsClear()) {
                move();
                putBeeper();
            }
        }
    }

    /*Karel changing the line and checks if the beeper is in the last cell
     of the previous row to fill the next line correctly if there is an odd number of cells in it */
    private void changingDirection() throws Exception {
        if(facingEast()){
            if(beepersPresent()){
                if(leftIsClear()) {
                    goToThePairRow();
                    move();
                }
            }
            goToThePairRow();
        }
        if(facingWest()){
            if(beepersPresent()) {
                if(rightIsClear()){
                    goToTheOddRow();
                    move();
                }
            }
            goToTheOddRow();
        }
    }

    /*Karel fill in pair row*/
    private void goToThePairRow() throws Exception {
        if (frontIsBlocked()) {
            turnLeft();
            if (frontIsClear()) {
                move();
                turnLeft();
            }
        }
    }

    /*Karel fill in odd row*/
    private void goToTheOddRow() throws Exception {
        if (frontIsBlocked()){
            turnRight();
            if(frontIsClear()) {
                move();
                turnRight();
            }
        }
    }

    // Method for turn right
    private void turnRight() throws Exception {
        for (int i=0; i<3; i++){
            turnLeft();
        }
    }
}

