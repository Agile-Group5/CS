package com.se459;

import static org.junit.Assert.assertEquals;

import com.se459.floor.SurfacesFactory;
import com.se459.floor.interfaces.ISurfaces;
import com.se459.floor.interfaces.ISurfacesFactory;

import org.junit.Test;

public class SurfacesFactoryTest {

    @Test
    public void testCreateCorrectSurfacesSuccess() {
        ISurfacesFactory testFactory = new SurfacesFactory();
        ISurfaces testBare;
        ISurfaces testLowCarpet;
        ISurfaces testHighCarpet;

        testBare = testFactory.createBareSurface(0, true, 0, 0);
        testLowCarpet = testFactory.createLowCarpet(0, false, 1, 1);
        testHighCarpet = testFactory.createHighCarpet(0, false, 2, 2);

        assertEquals("bare", testBare.getSurfaceType());
        assertEquals(1, testBare.getSurfaceCost());
        assertEquals("lowCarpet", testLowCarpet.getSurfaceType());
        assertEquals(2, testLowCarpet.getSurfaceCost());
        assertEquals("highCarpet", testHighCarpet.getSurfaceType());
        assertEquals(3, testHighCarpet.getSurfaceCost());
    }
    
}
