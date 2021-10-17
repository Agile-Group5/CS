package com.se459.floor;

import com.se459.floor.interfaces.ISurfaces;
import com.se459.floor.interfaces.ISurfacesFactory;

public class SurfacesFactory implements ISurfacesFactory {

    @Override
    public ISurfaces createBareSurface(boolean isDirty, boolean hasChargeStation) {
        return new FloorTile(1, "bare", isDirty, hasChargeStation);
    }

    @Override
    public ISurfaces createLowCarpet(boolean isDirty, boolean hasChargeStation) {
        return new FloorTile(2, "lowCarpet", isDirty, hasChargeStation);
    }

    @Override
    public ISurfaces createHighCarpet(boolean isDirty, boolean hasChargeStation) {
        return new FloorTile(3, "highCarpet", isDirty, hasChargeStation);
    }

}
