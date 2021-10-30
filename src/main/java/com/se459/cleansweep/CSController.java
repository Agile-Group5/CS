package com.se459.cleansweep;

import java.util.List;
import java.util.Stack;

import com.se459.floor.FloorTile;
import com.se459.floor.interfaces.IFloorLayout;
import com.se459.floor.interfaces.ISurfaces;

public class CSController implements Runnable {

    // Sensors -- Surfaces, Navigation, Layout
    // Movement -- forward, backward, right, left; *path management
    // Power Management -- capacity and calculations
    // Dirt Management -- capacity and return to charge stations

    // Path Taken by CS
    private Stack<ISurfaces> path;
    private ISurfaces cleanSweepLocation;
    List<List<ISurfaces>> floorLayout;

    public CSController(IFloorLayout fl) {

        path = new Stack<ISurfaces>();
        this.floorLayout = fl.getFloor();

        // get current location and push to the path obj
        // first tile should ideally be charge station location
        path.push(floorLayout.get(0).get(0));

    }

    @Override
    public void run() {

        // this will probably be the biggest method and will call the other methods in
        // the private methods depending on the conditions

        // need some sort of mechanism that keeps track of power levels so it can invoke
        // returnToCharge()

        // need some sort of mechanism that keeps track of dirt levels so it can return
        // to be emptied

        // need some sort of mechanism that monitors both power levels & dirt to ensure
        // the vacuum returns when needed

        for (List l : floorLayout) {
            for ((ISurfaces) surface : l) {

            }

        }

    }

    private void traverse(FloorTile next) {
        // retrieve current location of the device and add it to the path before moving
        // on
        path.push(cleanSweepLocation);

        // update the power level of the vacuum
        CleanSweepSingleton.updateCurrentCharge(costToTraverse(cleanSweepLocation, next));

        // set location of vacuum to the next tile so it 'moves'
        cleanSweepLocation = next;
    }

    private double costToTraverse(ISurfaces current, ISurfaces next) {
        // energy cost to travel is avg of the cost of each tile
        return (current.getSurfaceCost() + next.getSurfaceCost()) / 2;
    }

    private void clean(FloorTile ft) {
        // need some sort of check from the tile or sensor if it's clean to call this
        // method

        // can floor tiles have a location var to ensure we can pinpoint which tile the
        // obj is on?
        System.out.printf("Cleaning floor tile %s with %d units of power \n", ft.getSurfaceType(), ft.getSurfaceCost());

        CleanSweepSingleton.updateCurrentCharge(ft.getSurfaceCost());
        CleanSweepSingleton.updateCurrentDirt();

        System.out.printf("[Current power level: %f] [Current dirt level: %d]\n",
                CleanSweepSingleton.getCurrentCharge(), CleanSweepSingleton.getCurrentDirt());

    }

    private void returnToChargeStation() { // currently working on moving backwards on the path taken
        ISurfaces ft = path.pop();

        while (!ft.hasChargeStation()) {
            // power update to move to previous tile
            CleanSweepSingleton.updateCurrentCharge(costToTraverse(cleanSweepLocation, ft));

            // update current location to previous tile
            cleanSweepLocation = ft;

            ft = path.pop();
        }
    }

    private void shutdownCS() { // should be invoked when CS cannot move in any direction
        CleanSweepSingleton.shutdown();
    }

    private void startupCS() { // not sure if needed but can expand/delete later
        CleanSweepSingleton.startup();
    }

}
