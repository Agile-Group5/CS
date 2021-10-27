package com.se459.floor.interfaces;

public interface ISurfacesFactory {
    
    ISurfaces createBareSurface(int dirtAmt, boolean hasChargeStation, int xCoord, int yCoord);

    ISurfaces createLowCarpet(int dirtAmt, boolean hasChargeStation, int xCoord, int yCoord);

    ISurfaces createHighCarpet(int dirtAmt, boolean hasChargeStation, int xCoord, int yCoord);

}
