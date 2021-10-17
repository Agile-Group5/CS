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

        testBare = testFactory.createBareSurface(false, true);
        testLowCarpet = testFactory.createLowCarpet(false, false);
        testHighCarpet = testFactory.createHighCarpet(true, false);

        assertEquals("bare", testBare.getSurfaceType());
        assertEquals(1, testBare.getSurfaceCost());
        assertEquals("lowCarpet", testLowCarpet.getSurfaceType());
        assertEquals(2, testLowCarpet.getSurfaceCost());
        assertEquals("highCarpet", testHighCarpet.getSurfaceType());
        assertEquals(3, testHighCarpet.getSurfaceCost());
    }
    
}
