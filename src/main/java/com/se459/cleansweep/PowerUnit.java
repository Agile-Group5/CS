package com.se459.cleansweep;

import com.se459.floor.FloorTile;

public class PowerUnit {

    private double maxCharge = 250;
    private double currentCharge;
    private FloorTile floorTile;
    
    public PowerUnit(FloorTile floorTile) {
        this.floorTile = floorTile;
    }

// Bare floor - 1 unit
// Low-pile carpet - 2 units
// High-pile carpet - 3 units
// The charge required for the Clean Sweep to move from location A to location B is the average of
// the required charge costs for the surfaces at the two locations. For example, if the Clean Sweep
// moves from a bare floor to low-pile carpet, then the charge required is 1.5 units. It costs the same
// amount of charge to clean the current location as it does to traverse that location.
    public static double detectFloor(FloorTile A, FloorTile B) {
        // if surface is bare then it equals 1 unit
        //if surface is low-pile, 2 units, high-pile, 3 units
        double units = 0;
        //bare -> bare
        if(A.getSurfaceCost() == 1 && B.getSurfaceCost() == 1 ) {
            units = 1;
        }
        //bare -> low
        else if (A.getSurfaceCost() == 1 && B.getSurfaceCost() == 2) {
            units = 1.5;
        }
        //bare -> high
        else if(A.getSurfaceCost() == 1 && B.getSurfaceCost() == 3) {
            units = 2;
        }
        //low -> high
        else if(A.getSurfaceCost() == 2 && B.getSurfaceCost() == 3) {
            units = 2.5;
        }
        //high -> bare
        else if(A.getSurfaceCost() == 3 && B.getSurfaceCost() == 1) {
            units = 2;
        }
        return units;
        //check the floor type in location A to location B and average the units based on the surface to
        //get the unit cost of required charge
    }

    //should set/update the current battery level depending on what surface it travels on?
    public void updateBattery(FloorTile A, FloorTile B) {
        this.currentCharge -= detectFloor(A, B);

    }
    //used to set the current charge of the robot to full 
    public void chargeBattery() {
        this.currentCharge = maxCharge;
    }







}