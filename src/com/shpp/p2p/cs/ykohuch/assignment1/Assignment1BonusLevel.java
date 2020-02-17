package com.shpp.p2p.cs.ykohuch.assignment1;
import com.shpp.karel.KarelTheRobot;

public class Assignment1BonusLevel extends KarelTheRobot{

    /*the robot follows the level and cleans it from debris*/
    public void run() throws Exception{
        while (noBeepersPresent()){
            cleanTheColumn();
            move();
            if(frontIsBlocked()){
                break;
            }
            if(beepersPresent()){
                move();
            }
        }
    }

    /*the robot goes first to the top and then to the bottom and cleans them as needed*/
    private void cleanTheColumn() throws Exception {
            goUp();
            goDown();
    }

    /*karel moves to the upper cell and cleans her*/
    private void goUp() throws Exception{
        turnLeft();
        if(frontIsClear()) {
            move();
            checkTheCell();
        }else {
            turnAround();
        }
    }

    /*karel moves to the lower cell and cleans her*/
    private void goDown() throws Exception{
        if(frontIsClear()) {
            move();
            checkTheCell();
            turnRight();
        }else {
            turnLeft();
        }
    }

    /*a method that spells out the logic of cleaning a cell*/
    private void checkTheCell() throws Exception{
        if(beepersPresent()){
            while (beepersPresent()){
                pickBeeper();
            }
            turnAround();
            move();
        }else{
            turnAround();
            move();
        }
    }

    /* Method for rotate on 180 degrees*/
    private void  turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    // Method for turn right
    private void turnRight() throws Exception {
        for (int i=0; i<3; i++){
            turnLeft();
        }
    }
}
