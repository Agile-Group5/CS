package com.se459.floor;

import com.se459.floor.interfaces.ISurfaces;

public class SurfacesFactory {

    public static ISurfaces createBareSurface() {
        return new FloorTile(1, "Bare");
    }

    public static ISurfaces createLowCarpet() {
        return new FloorTile(2, "LowCarpet");
    }

    public static ISurfaces createHighCarpet() {
        return new FloorTile(3, "HighCarpet");
    }

}
