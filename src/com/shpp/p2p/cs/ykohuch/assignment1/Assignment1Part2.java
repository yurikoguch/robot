package com.shpp.p2p.cs.ykohuch.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part2 extends KarelTheRobot{

    /*basic method
    * karel fill in the column
    * karel moves to the next column
    * if front is blocked karel fill in the last column and ends program*/
    public void run() throws Exception {
        while (frontIsClear()){
            fillTheColumn();
            moveToTheNext();
        } if (frontIsBlocked()){
            fillTheColumn();
        }
    }

    /*fill in column*/
    private void fillTheColumn() throws Exception{
        turnLeft();
        checkingBeepers();
        goToTheStart();
    }

   /* function for the making 4 steps to the next column*/
    private void moveToTheNext() throws Exception{
        for (int i=0; i<4; i++){
            if(frontIsClear()) {
                move();
            }
        }
    }

    /*check for beepers  put them on, and making steps to the north*/
    private void checkingBeepers() throws  Exception {
            if (noBeepersPresent()) {
                putBeeper();
            }
            while(frontIsClear()){
                move();
                checkingBeepers();
            }
        }

    /*go to the start of column*/
    private void goToTheStart() throws Exception{
        turnAround();
        while (frontIsClear()){
            move();
        }
        turnLeft();
    }

   /* Method for rotate on 180 degrees*/
    private void  turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }
}
