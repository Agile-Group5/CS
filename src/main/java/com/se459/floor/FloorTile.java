package com.se459.floor;

import com.se459.floor.interfaces.ISurfaces;

public class FloorTile implements ISurfaces {

    int xCoordinate;
    int yCoordintate;
    private String floorName;
    private int surfaceCost;
    private boolean isDirty;
    

    public FloorTile (int floorCost, String surfaceName) {
        this.floorName = surfaceName;
        this.surfaceCost = floorCost;
        this.isDirty = false;
    }


    // getters here
    @Override
    public String getSurfaceName() {return floorName;}

    @Override
    public int getSurfaceCost() {return surfaceCost;}

}
