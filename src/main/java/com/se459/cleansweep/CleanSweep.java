package com.se459.cleansweep;

import com.se459.floor.FloorTile;

public class CleanSweep {

    // dirt capacity
    private static final int maxDirtCapacity = 50;
    private static int currentDirtCapacity; // decreases with each cleaning

    // power capacity
    private static final int maxCharge = 250;
    private static int currentCharge; // decreases with use

    // sensors -- do we need sensor objects?
    private boolean CleanSensor = false;

    private boolean shutdown;

    public CleanSweep() { // initializing assuming that CS is at charging station
        currentCharge = maxCharge;
        currentDirtCapacity = maxDirtCapacity;
        shutdown = false;
    }

    public void run() {
        while (!shutdown) {
        }
    }

    private void clean(FloorTile ft) {
        // for each clean(); currentDirt increases by 1 unit
        // update methods once tile obj are updated

        /**
         * if (ft.getIsDirty) { currentDirtCapacity--; currentCharge -=
         * ft.getSurfaceCost; ft.setIsDirty = true; }
         * 
         * // call traverse once done cleaning traverse(ft);
         */
    }

    private void traverse(FloorTile current) {
        // clean sweep can move 90 degrees in any direction: forward, back, right, left
        // check if floor tiles are either Unknown, Open, Obstacles, or Stairs

        // to is not defined; need to determine how tiles are positioned and whether
        // clean sweep needs to know this information
        // currentCharge -= costToTraverse(current, to);
    }

    private double costToTraverse(FloorTile from, FloorTile to) {
        // cost of tile determines how much power is needed to traverse to it
        // return (from.getSurfaceCost + to.getSurfaceCost) / 2;

        return 0.0;

    }

    private void shutdown() { // cleansweep shuts down when it can no longer move in any direction
        shutdown = true;
    }
}