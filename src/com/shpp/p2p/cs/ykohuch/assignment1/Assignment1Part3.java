package com.shpp.p2p.cs.ykohuch.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part3 extends KarelTheRobot{
    public void run() throws Exception {
        placeBeepers();
        findTheEdge();
        stopInTheCenter();
    }

    private void placeBeepers() throws Exception{
        putBeeper();
        while (frontIsClear ()) {
            move();
            putBeeper();
        }
        turnAround();
    }

    // Move to the next wall and find the edge
    private void findTheEdge() throws Exception{
        while (frontIsClear ()) {
            move();
        }
        turnAround();
        while(noBeepersPresent()) {
            move();
        }								// Has found the edge
        move();
        CheckingBeepers();
    }


    // Moves 1 more space to control checking the last Beeper
    private void CheckingBeepers() throws Exception{
        if (beepersPresent()) { 		// if is not the last Beeper
            turnAround();
            if(frontIsClear()) {
                move();
                pickBeeper();                // go back and pick it up
                turnAround();
                findTheEdge();                // then turn around and bounce off the next wall.
            }
        }
    }

    //Karel stops in the middle of row
    private void stopInTheCenter() throws Exception{
        turnAround();
        move();
    }

    // Method for rotate on 180 degrees
    private void  turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }
}
