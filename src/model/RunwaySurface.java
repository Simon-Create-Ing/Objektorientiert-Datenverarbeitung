package model;

import resources.Konstanten;

/**
 *  Diese Klasse ist eine enum Klasse enthielt alle enum Objekte nach ICAO-Standards und Methoden eines RunwaySurface.
 */

public enum RunwaySurface {
        ASPHALT,
        CONCRETE,
        GRAVEL,
        GRASS,
        SAND,
        DIRT,
        WATER,
        SNOW,
        ICE,
        UNKNOWN,
        ASPHALT_CONCRETE,
        TARMAC,
        BITUMEN,
        LOOSE_GRAVEL,
        HARD_DIRT,
        COMPACTED_DIRT,
        SANDY_SOIL,
        CLAY,
        SILT,
        LOAM,
        PEAT,
        VOLCANIC_ASH,
        CRUSHED_ROCK,
        GRAVEL_MIX,
        SAND_MIX,
        DIRT_MIX,
        GRASS_MIX,
        WATER_MIX,
        SNOW_MIX,
        ICE_MIX,
        ARTIFICIAL_TURF,
        NEOPRENE,
        METAL,
        STEEL,
        ALUMINUM;
    /**
     * Findet die entsprechende RunwaySurface vom enum List fuer die vorgegebene String und gibt Unknown zurueck, wenn keine gefunden wird.
     * @Vorbedingung Ein String muss schon vorgegeben werden
     * @Nachbedingung RunwaySurface vom enum List wird zurueckgegeben
     * @param value (String)
     * @return RunwaySurface vom enum List
     */
    public static RunwaySurface runwaySurfaceFromCode(String value)
    {
        for (RunwaySurface runwaySurface : RunwaySurface.values())
        {
            if (runwaySurface.name().equalsIgnoreCase(value) )
            {
                return runwaySurface;
            }else {
               return RunwaySurface.UNKNOWN;
            }
        }
        //falls String mit keinem Objekt vom enum List passt
        throw new IllegalArgumentException(Konstanten.INVALID_RUNWAY_SURFACE + value);
    }

    /**
     * Gibt der RunwaySurface vom enum List formatiert als String zurueck.
     * @Vorbedingung RunwaySurface vom enum List muss initialisiert sein.
     * @Nachbedingung RunwaySurface vom enum List wird formatiert als String zurueckgegeben.
     * @return RunwaySurface vom enum List formatiert als String
     */
    public String toString() {
        return name();
    }
}
