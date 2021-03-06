package gameSceneManager;

import gameLogicManager.gameModel.gameBoard.Terrain;
import gameLogicManager.gameModel.gameBoard.TerrainType;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.util.HashMap;


/**
 * Class for generating a terrain maps
 * @author Zeynep Cankara
 * @version 13.05.2020
 */

public class BoardGenerator {
    // Properties: Logic Related
    static HashMap<Integer, Color> terrainColorMap = new HashMap<Integer, Color>();
    // Define the terrain colors (7 Terrain type) + River
    static Color riverColor = Color.web("#101662");
    static Color desertColor = Color.web("#fff94f");
    static Color swampColor = Color.web("#10350e");
    static Color forestColor = Color.web("#1bbc0e");
    static Color mountainColor = Color.web("#959799");
    static Color lakeColor = Color.web("#3e625a");
    static Color wastelandColor = Color.web("#883b36");
    static Color plainColor = Color.web("#c85e11");


    // Contains terrainIdList which will be used to initialize the terrain map to defaultMap
    public static final int[] DEFAULT_MAP = {
            0, 4, 3, 2, 6, 5, 0, 1, 5, 3, 2, 5, 1,
            6, 7, 7, 0, 1, 7, 7, 6, 1, 7, 7, 6,
            7, 7, 1, 7, 4, 7, 3, 7, 3, 7, 4, 7, 7,
            3, 2, 6, 7, 7, 5, 2, 7, 5, 7, 5, 0,
            1, 0, 5, 2, 1, 0, 4, 6, 7, 7, 3, 1, 2,
            4, 3, 7, 7, 6, 3, 7, 7, 7, 0, 4, 0,
            7, 7, 7, 4, 7, 5, 7, 3, 7, 6, 2, 2, 6,
            6, 2, 0, 7, 7, 7, 2, 1, 7, 4, 0, 4,
            5, 1, 4, 2, 5, 3, 6, 0, 4, 7, 2, 3, 5
    };

    /**
     * Maps the terrainTypes to colorId
     */
    private static void initTerrainColorMap(){
        terrainColorMap.put(0, plainColor);
        terrainColorMap.put(1,swampColor);
        terrainColorMap.put(2, lakeColor);
        terrainColorMap.put(3, forestColor);
        terrainColorMap.put(4, mountainColor);
        terrainColorMap.put(5, wastelandColor);
        terrainColorMap.put(6, desertColor);
        terrainColorMap.put(7, riverColor);
    }

    /**
     * Generates the default terrain map
     */
    public static Scene generateDefaultTerrainMap(Scene scene) {
        initTerrainColorMap();

        for (int i = 0; i < DEFAULT_MAP.length; i++){
            Polygon hexagon = (Polygon) scene.lookup("#" +i);
            hexagon.setFill(terrainColorMap.get(DEFAULT_MAP[i]));
        }
        return scene;
    }


    /**
     * Generates the random terrain map
     */
    public static Scene generateRandomTerrainMap(Scene scene, int n) {
        initTerrainColorMap();

        for(int i = 0; i < DEFAULT_MAP.length; i++){
            // check river terrain
            Polygon hexagon = (Polygon) scene.lookup("#" + i);

            if(DEFAULT_MAP[i] != 7){
                int newTerrainTypeID = ( DEFAULT_MAP[i] + n ) % 7;
                hexagon.setFill(terrainColorMap.get(newTerrainTypeID));
            } else {
                hexagon.setFill(terrainColorMap.get(DEFAULT_MAP[i]));
            }
        }
        return scene;
    }

}
