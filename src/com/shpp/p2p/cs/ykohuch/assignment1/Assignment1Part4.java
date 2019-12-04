package com.shpp.p2p.cs.ykohuch.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part4 extends KarelTheRobot{

    public void run() throws Exception{
           while (frontIsClear()){
               fillInnRow();
           }
    }

    //fill in the odd line and move on to the next row
    private void fillInnRow() throws Exception {
        putBeeper();
        while (frontIsClear()){
            jumpThroughTheCell();
        }
        if(facingEast()){            //if current row is odd and fill, Karel moving to the pair row
            goToThePairRow();
        }
        else{
            goToTheOddRow();        //if current row is pair and fill, Karel moving to the odd row
        }
    }



    //The function allows  to reach the end of the line and put the beeper through one cell
    private void jumpThroughTheCell() throws Exception{
        if (beepersPresent()) {
            move();
            if(frontIsClear()) { //additional check to prevent the robot from colliding with the wall
                move();
                putBeeper();
            }
        }
    }

    private void goToThePairRow() throws Exception {
        if (frontIsBlocked()) {
            turnLeft();
            if (frontIsClear()) {  //additional check to prevent the robot from colliding with the wall in the north side of table
                move();
                turnLeft();
            }
        }
    }

    private void goToTheOddRow() throws Exception {
        if (frontIsBlocked()){
            turnRight();
            if(frontIsClear()) { //additional check to prevent the robot from colliding with the wall in the north side of table
                move();
                turnRight();
            }
        }
    }

    // Method for turn right
    private void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }
}

