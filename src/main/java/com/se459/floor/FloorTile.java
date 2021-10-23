package com.se459.floor;

import com.se459.floor.interfaces.ISurfaces;

public class FloorTile implements ISurfaces {

    private String surfaceType;
    private int surfaceCost;
    private boolean isDirty;
    private boolean hasChargeStation;
    private final int xCoord;
    private final int yCoord;

    public FloorTile (int floorCost, String surfaceName, boolean isDirty, boolean hasChargeStation, int x, int y) {
        this.surfaceType = surfaceName;
        this.surfaceCost = floorCost;
        this.isDirty = isDirty;
        this.hasChargeStation = hasChargeStation;
        this.xCoord = x;
        this.yCoord = y;
    }

    @Override
    public String getSurfaceType() {return surfaceType;}

    @Override
    public int getSurfaceCost() {return surfaceCost;}

    @Override
    public boolean hasDirt() {return isDirty;}

    @Override
    public boolean hasChargeStation() { return hasChargeStation; }

    @Override
    public void updateCleanStatus(boolean hasDirt) { isDirty = hasDirt; }

    @Override
    public int getXCoord() { return xCoord; }

    @Override
    public int getYCoord() { return yCoord; }

    @Override
    public String toString() {
        return String.format("{X:%d, Y:%d, TYPE:%s, COST:%d, DIRTY:%s, STATION:%s}",
            xCoord, yCoord, surfaceType,surfaceCost,isDirty,hasChargeStation);
    }

}
