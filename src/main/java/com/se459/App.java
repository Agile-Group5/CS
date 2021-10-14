package com.se459;

import com.se459.floor.FloorLayout;
import com.se459.floor.interfaces.IFloorLayout;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        IFloorLayout floor = new FloorLayout("floor_layout.json");

        // printing floor in detail
        floor.printDetailLayout();


        System.out.printf("\n\n\n");

        // printing floor
        System.out.println(floor.toString());

    }
}
