package com.se459.floor;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.se459.floor.interfaces.IFloorLayout;
import com.se459.floor.interfaces.ISurfaces;
import com.se459.floor.interfaces.ISurfacesFactory;

import org.json.JSONArray;
import org.json.JSONObject;

public class FloorLayout implements IFloorLayout {
    
    private List<List<ISurfaces>> floor;
    private JSONArray jsonArray;

    public FloorLayout(String jsonFileName) {
        StringBuilder stringInput = new StringBuilder();
        String jsonPath = "/json/"+jsonFileName;

        try {
            InputStream inputStream = this.getClass().getResourceAsStream(jsonPath);    
            Scanner scan = new Scanner(inputStream);

            while (scan.hasNextLine()) {
                stringInput.append(scan.nextLine());
            }

            jsonArray = new JSONArray(stringInput.toString());
            floor = jsonToArrayLists();

            scan.close();
            inputStream.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private List<List<ISurfaces>> jsonToArrayLists() {
        List<List<ISurfaces>> layout = new ArrayList<>();
        ISurfacesFactory factory = new SurfacesFactory();

        for (int i = 0; i < jsonArray.length(); i++) {
            List<ISurfaces> row = new ArrayList<>();
            layout.add(row);

            for (int j = 0; j < jsonArray.getJSONArray(i).length(); j++) {
                JSONArray col = jsonArray.getJSONArray(i);
                JSONObject jsonTile = col.getJSONObject(j);

                // creating tile from json data
                ISurfaces tile = null;
                String tileType = jsonTile.getString("type");
                boolean hasDirt = jsonTile.getBoolean("isDirty");
                boolean hasChargeStation = jsonTile.getBoolean("hasChargeStation");

                try {
                    if (tileType.equals("bare")) {
                        tile = factory.createBareSurface(hasDirt, hasChargeStation);
                    } else if (tileType.equals("lowCarpet")) {
                        tile = factory.createLowCarpet(hasDirt, hasChargeStation);
                    } else if (tileType.equals("highCarpet")) {
                        tile = factory.createHighCarpet(hasDirt, hasChargeStation);
                    } 

                    // adding tile to the layout
                    layout.get(i).add(tile);
                } catch (Exception e) {
                    System.err.println("***ERROR: unknown surface detected.");
                }
            }
        }

        return layout;
    }
    

    /***
     * 
     * Method to print all floor tiles in detail as they appear in the floor layout
     */
    @Override
    public void printDetailLayout() {
        for (List<ISurfaces> tiles : floor)
            System.out.printf("[%s]\n", tiles);
    }

    /***
     * 
     * Method toString prints a simple view of the floor layout
     */
    @Override
    public String toString() {
        StringBuilder grid = new StringBuilder();

        for (int i = 0; i < floor.size(); i++) {
            for (int j = 0; j < floor.get(i).size(); j++) {
                List<ISurfaces> row = floor.get(i);
                ISurfaces t = row.get(j);
                grid.append(String.format("%-15s", t.getSurfaceType()));
            }
            grid.append("\n");
        }

        return grid.toString();
    }

}
