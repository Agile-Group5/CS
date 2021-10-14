package com.se459.floor.interfaces;

public interface ISurfacesFactory {
    
    ISurfaces createBareSurface(boolean isDirty, boolean hasChargeStation);

    ISurfaces createLowCarpet(boolean isDirty, boolean hasChargeStation);

    ISurfaces createHighCarpet(boolean isDirty, boolean hasChargeStation);

}
