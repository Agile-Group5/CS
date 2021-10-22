package com.se459.floor.interfaces;

public interface ISurfacesFactory {
    
    ISurfaces createBareSurface(boolean isDirty, boolean hasChargeStation, int xCoord, int yCoord);

    ISurfaces createLowCarpet(boolean isDirty, boolean hasChargeStation, int xCoord, int yCoord);

    ISurfaces createHighCarpet(boolean isDirty, boolean hasChargeStation, int xCoord, int yCoord);

}
