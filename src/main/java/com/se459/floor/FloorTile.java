package com.se459.floor;

import com.se459.floor.interfaces.ISurfaces;

public class FloorTile implements ISurfaces {

    private String surfaceType;
    private int surfaceCost;
    private boolean isDirty;
    private boolean hasChargeStation;

    public FloorTile (int floorCost, String surfaceName, boolean isDirty, boolean hasChargeStation) {
        this.surfaceType = surfaceName;
        this.surfaceCost = floorCost;
        this.isDirty = isDirty;
        this.hasChargeStation = hasChargeStation;
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
    public String toString() {
        return String.format("{TYPE:%s, COST:%d, DIRTY:%s, STATION:%s}",
            surfaceType,surfaceCost,isDirty,hasChargeStation);
    }

}
