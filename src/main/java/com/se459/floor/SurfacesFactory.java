package com.se459.floor;

import com.se459.floor.interfaces.ISurfaces;
import com.se459.floor.interfaces.ISurfacesFactory;

public class SurfacesFactory implements ISurfacesFactory {

    @Override
    public ISurfaces createBareSurface(int dirtAmt, boolean hasChargeStation, int xCoord, int yCoord) {
        return new FloorTile(1, "bare", dirtAmt, hasChargeStation, xCoord, yCoord);
    }

    @Override
    public ISurfaces createLowCarpet(int dirtAmt, boolean hasChargeStation, int xCoord, int yCoord) {
        return new FloorTile(2, "lowCarpet", dirtAmt, hasChargeStation, xCoord, yCoord);
    }

    @Override
    public ISurfaces createHighCarpet(int dirtAmt, boolean hasChargeStation, int xCoord, int yCoord) {
        return new FloorTile(3, "highCarpet", dirtAmt, hasChargeStation, xCoord, yCoord);
    }

}
