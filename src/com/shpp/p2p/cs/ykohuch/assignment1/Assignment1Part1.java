package com.shpp.p2p.cs.ykohuch.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part1 extends KarelTheRobot {

    /*basic method*/
    public void run() throws Exception {
      goToTheBeeper();
      takeTheBeeper();
      goToTheStart() ;
    }

    /*karel going to the beeper and stand in the cell, where beeper is placed*/
    private void goToTheBeeper() throws Exception {
        goToTheNeighboringRow();
        for (int i=0; i<4; i++){
            move();
        }
    }

   /*
     *pic the beeper and turn around
     *result:karel looking to the west*/
    private void takeTheBeeper() throws Exception{
        pickBeeper();
        turnAround();
    }

   /*
    *Karel moving from the beeper point to home
    *result: Karel on the starting position and looking to east*/
    private void goToTheStart() throws Exception{
        for (int i=0; i<4; i++){
            move();
        }
        goToTheNeighboringRow();
        turnAround();
    }

    // Method for turn right
    private void turnRight() throws Exception {
        for (int i=0; i<3; i++){
            turnLeft();
        }
    }

    // Method for rotate on 180 degrees
    private void  turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

     /*
     *Method for jumping to the next door row and turn left
     *result: Karel on the neighbor row and looking to the east*/
    private void goToTheNeighboringRow() throws Exception{
        turnRight();
        move();
        turnLeft();
    }
}

