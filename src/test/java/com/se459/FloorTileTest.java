package com.se459;

import static org.junit.Assert.assertEquals;

import com.se459.floor.FloorTile;
import com.se459.floor.interfaces.ISurfaces;

import org.junit.Test;

public class FloorTileTest {

    @Test
    public void testGetMethodsSuccess() {
        ISurfaces testTile = new FloorTile("bare", 1, false, 0, 0);
        String testType;
        boolean testDirty1;
        boolean testDirty2;
        boolean testHasStation;
        int testXCoord;
        int testYCoord;

        testType = testTile.getSurfaceType();
        testDirty1 = testTile.hasDirt();
        testHasStation = testTile.hasChargeStation();
        testXCoord = testTile.getXCoord();
        testYCoord = testTile.getYCoord();

        testTile.updateCleanStatus();
        testDirty2 = testTile.hasDirt();

        assertEquals("bare", testType);
        assertEquals(true, testDirty1);
        assertEquals(false, testHasStation);
        assertEquals(false, testDirty2);
        assertEquals(0, testXCoord);
        assertEquals(0, testYCoord);
    }
    
}
