package com.se459.floor.interfaces;

public interface ISurfaces {

    String getSurfaceType();

    int getSurfaceCost();

    boolean hasDirt();

    boolean hasChargeStation();

    void updateCleanStatus(boolean hasDirt);

}
