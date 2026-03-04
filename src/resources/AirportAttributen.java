package resources;

/**
 * Enthaelt alle Flughafe Attribute als Strings.
 * Enthaelt die Auswahl von methoden waehrend der Sortierung(als string).
 */
public interface AirportAttributen {
    String AIRPORT_IDENT ="AirportIdent: ";
    String MUNICIPALITY ="Municipality ";
    String AIRPORT_TYPE = "AirportType";
    String CONTINENT = "Continent";
    String ISO_COUNTRY = "ISOCountry";
    String ISO_REGION = "ISORegion";
    String RUNWAY_LENGHT = "RunwayLength";
    String RUNWAY_WIDTH = "RunwayWidth";
    String AIRPORT_NAME = "AirportName";
    String LONGITUDE = "Longitude";
    String LATITUDE = "Latitude";
    String ELEVATION = "Elevation";
    String BELEUCHTUNG = "Beleuchtung";
    String AIRPORT_ID = "AirportId";
    String RUNWAY_SURFACE = "RunwaySurface";

    String SORTIERUNG_AUSWAHL =
            "1.  Id          " + "  2.  AirportIdent " + "  3.  AirportType" +
            "\n4.  Name        " + "  5.  Continent    " + "  6.  IsoCountry " +
            "\n7.  IsoRegion   " + "  8.  Beleuchtung  " + "  9.  Elevation  " +
            "\n10. RunwayLength" + "  11. RunwaySurface" + "  12. RunwayWidth" +
            "\n13. Municipality" + "  14. Latitude     " + "  15. Longitude  ";
}
