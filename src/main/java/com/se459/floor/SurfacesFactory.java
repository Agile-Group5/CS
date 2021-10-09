package com.se459.floor;

import com.se459.floor.interfaces.ISurfacesFactory;

public class SurfacesFactory implements ISurfacesFactory {
    
    @Override
    ISurfaces createBareFloor() {
        return new FloorTile();
    }

    @Override
    ISurfaces createLowCarpet() {
        return new FloorTile();
    }

    @Override
    ISurfaces createHighCarpet() {
        return new FloorTile();
    }



}
