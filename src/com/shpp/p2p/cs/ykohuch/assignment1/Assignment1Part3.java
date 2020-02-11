package com.shpp.p2p.cs.ykohuch.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part3 extends KarelTheRobot{

    /*basic method*/
    public void run() throws Exception {
        placeBeepers();
        findTheEdge();
        stopInTheCenter();
    }

    /*Karel placed beeper while front is clear he moves and put beepers*/
    private void placeBeepers() throws Exception{
        putBeeper();
        while (frontIsClear ()) {
            move();
            putBeeper();
        }
        turnAround();
    }

    /*Move to the next wall and find the edge*/
    private void findTheEdge() throws Exception{
        while (frontIsClear ()) {
            move();
        }
        turnAround();
        while(noBeepersPresent()) {
            move();
        }
        move();
        CheckingBeepers();
    }

    /*Moves 1 more space to control checking the last Beeper
    *  if is not the last Beeper karel turn around move and pic the beepers*/
    private void CheckingBeepers() throws Exception{
        if (beepersPresent()) {
            turnAround();
            if(frontIsClear()) {
                move();
                pickBeeper();
                turnAround();
                findTheEdge();
            }
        }
    }

    /*Karel stops in the middle of row*/
    private void stopInTheCenter() throws Exception{
        turnAround();
        move();
    }

    /* Method for rotate on 180 degrees*/
    private void  turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }
}
