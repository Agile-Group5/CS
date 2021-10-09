package com.se459.floor.interfaces;

public interface ISurfacesFactory {
    
    ISurfaces createBareFloor();

    ISurfaces createLowCarpet();

    ISurfaces createHighCarpet();
}
