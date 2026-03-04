package control;

import model.*;
import resources.AirportIndex;
import resources.Konstanten;
import resources.Literal;
import utilities.FeetToMeters;
import utilities.FehlerInCSVDatei;
import utilities.HilfsMethoden;
import utilities.ZeitMessung;
import view.Ausgeben;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Diese Klasse dient zum Einlesen, korrigieren, Ergaenzen und ueberpruefung von .csv Dateien der Flughaefen.
 * Die Klasse enthaelt Methoden zum Einlesen, korrigieren,
 * Ergaenzen und ueberpruefung der Datei und speichert die eingelesenen Daten in einer ArrayList.
 * <p>
 * Diese Klasse enthaelt auch die Methode, um eine Zeile aus einer CSV-Datei zu parsen,
 * die Eingabewerte zu ueberpruefen und ein Airport-Objekt zu erstellen.
 * </p>
 */
public class DateiLeser
{
    /**
    * Diese Methode liest die .csv Datei der Flughaefen ein.
     * Sie erstellt Airport Objekt, speichert die Eintraege zeilenweise in einer ArrayList.
    * @Vorbedingung .csv Datei mit Flughaefen muss existieren.
    * @Nachbedingung Gibt eine ArrayList mit Flughaefen aus der .csv Datei zurueck.
    * @param feilPath der zu lesenden Datei
    * @return eine ArrayList mit Flughafen aus der .csv Datei
    */
    public static ArrayList<Airport> leseDaten (String feilPath)
    {
        ArrayList<Airport> airportsList =null;
        try
        {
            airportsList = pruefeKoordinaten(datenUmrechnen(dateiKorrigierenUndErgaenzen(
                                    dateiEinlesen(new BufferedReader(new FileReader(feilPath))))));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            Ausgeben.ausgeben(Konstanten.FILE_NOT_FOUND);
        }
        return airportsList;
    }

    /**
     * Liest Zeilen aus einer Datei mit einem BufferedReader ein.
     *
     * @param reader BufferedReader, der mit der Datei verbunden ist
     * @return Liste der eingelesenen Zeilen
     * @Vorbedingung Der BufferedReader "reader" ist nicht null und bereit, aus der Datei zu lesen.
     * @Nachbedingung Alle Zeilen der Datei werden in einer ArrayListe gespeichert.
     */
    public static ArrayList<String> dateiEinlesen(BufferedReader reader) {
        ZeitMessung zeitMessung = new ZeitMessung();
        zeitMessung.start();

        // Statische Variablen zur Verfolgung der verarbeiteten Zeilen
        int anzahlGelesenerZeilen = Literal.NULL;
        //Liste fuer die Speicherung der Rohdaten als Strings
        ArrayList<String> datei = new ArrayList<>();

        try {
            String zeile;
            while ((zeile = reader.readLine()) != null) {
                datei.add(zeile);
                anzahlGelesenerZeilen++;
            }
            long readTime = zeitMessung.berechneVergangeneZeitInMillisekunden();
            Ausgeben.ausgeben(Konstanten.BEARBEITUNGSDAUER_DES_EINLESEN + readTime + Konstanten.MILLISEKUNDEN+
                    Konstanten.NEXT_LINE + Konstanten.ANZAHL_AIRPORT + anzahlGelesenerZeilen );
        } catch (IOException e) {
            Ausgeben.ausgeben(Konstanten.EINLESEN_EXECEPTION);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                Ausgeben.ausgeben(Konstanten.READER_SCHLIESSE_FEHLER);
                e.printStackTrace();
            }
        }
        return datei;
    }

    /**
     * Parst und korrigiert die Daten und erstellt Airport-Objekte aus den Zeilen.
     *
     * @param datei Liste der zu parsenden Zeilen
     * @return Liste der Airport-Objekte
     *
     * @Vorbedingung Die Liste "datei" enthaelt valide Zeilen (Strings).
     * @Nachbedingung Eine Liste von Airport-Objekten wird zurueckgegeben. Fehlerhafte Zeilen werden ignoriert.
     */
    public static ArrayList<Airport> dateiKorrigierenUndErgaenzen(ArrayList<String> datei) {

        // Statische Variablen zur Verfolgung der verarbeiteten Zeilen
        int anzahlGuteZeilen = Literal.NULL;
        ArrayList<Airport> myAirports = new ArrayList<>();

        ZeitMessung zeitMessung = new ZeitMessung();
        zeitMessung.start();

        for (String currentLine : datei) {
            Airport airport = zeilenParsing(currentLine);
            if (airport != null) {
                myAirports.add(airport);
                anzahlGuteZeilen++;
            }
        }

        long readTime = zeitMessung.berechneVergangeneZeitInMillisekunden();
        Ausgeben.ausgeben(Konstanten.BEARBEITUNGSDAUER_DER_KORREKTUR_UND_ERGaeNZUNG + readTime + Konstanten.MILLISEKUNDEN+
                Konstanten.ANZAHL_GUTER_AIRPORT + anzahlGuteZeilen);

        return myAirports;
    }

    /**
     * Rechnet relevante Messwerte in den Airport-Objekten von Fuß in Meter um.
     *
     * @param myAirports Liste der Airport-Objekte
     * @return Liste der Airport-Objekte mit umgerechneten Messwerten
     *
     * @Vorbedingung Die Liste "myAirports" enthaelt gueltige Airport-Objekte.
     * @Nachbedingung Alle Messwerte in den Objekten wurden von Fuß in Meter umgerechnet.
     */
    public static ArrayList<Airport> datenUmrechnen(ArrayList<Airport> myAirports) {
        ZeitMessung zeitMessung = new ZeitMessung();
        zeitMessung.start();

        for (Airport airport : myAirports) {
            if (airport.getKoordinates() != null) {

                if (airport.getKoordinates().getElevation() != null) {
                    airport.getKoordinates().setElevation(FeetToMeters.convertFeetToMeters(airport.getKoordinates().getElevation()));
                }
            }

            if (airport.getRunway() != null) {
                if (airport.getRunway().getRunwayDimension().getRunwayLength() != null) {
                    airport.getRunway().getRunwayDimension().setRunwayLength(
                            FeetToMeters.convertFeetToMeters(airport.getRunway().getRunwayDimension().getRunwayLength()));
                }
                if (airport.getRunway().getRunwayDimension().getRunwayWidth() != null) {
                    airport.getRunway().getRunwayDimension().setRunwayWidth(
                            FeetToMeters.convertFeetToMeters(airport.getRunway().getRunwayDimension().getRunwayWidth()));
                }
            }
        }

        long readTime = zeitMessung.berechneVergangeneZeitInMillisekunden();
        Ausgeben.ausgeben(Konstanten.BEARBEITUNGSDAUER_DER_UMRECHNUNG + readTime + Konstanten.MILLISEKUNDEN);

        return myAirports;
    }

    /**
     * ueberprueft die Airport-Daten, um sicherzustellen, dass essenzielle Felder nicht null sind.
     * Diese Methode ueberprueft die Koordinaten der Flughaefen auf Gueltigkeit
     * und entfernt ungueltige Eintraege aus der ArrayList. Ein Flughafen gilt als
     * gueltig, wenn ihr Breitengrad zwischen -90 und 90 und ihr Laengengrad
     * zwischen -180 und 180 liegt.
     * <p>
     * @Vorbedingung flughaefen sind in einer ArrayList initialisiert
     * @Nachbedingung ArrayList nur mit gueltigen Eintraegen wird zurueckgegeben
     *
     * @param myAirports ArrayList mit Flughaefen, die ueberprueft werden sollen
     * @return Die uebergebene ArrayList ohne invalide Eintraege
     */
    public static ArrayList<Airport> pruefeKoordinaten (ArrayList<Airport> myAirports)
    {
        ZeitMessung stoppUhr = new ZeitMessung();
        stoppUhr.start();

        int anzahlValiderGelesenerZeilen = Literal.NULL;


        try
        {
            for (int i = Literal.NULL; i < myAirports.size(); i++)
            {
                if (!(myAirports.get(i).getKoordinates().getLongitude() <= Literal.HUNDERT_ACHTIG &&
                        myAirports.get(i).getKoordinates().getLongitude() >= Literal.MINUS_HUNDERT_ACHTIG &&
                        myAirports.get(i).getKoordinates().getLatitude() <=Literal.NEUNZIG &&
                        myAirports.get(i).getKoordinates().getLatitude() >= Literal.MINUS_NEUNZIG))
                {
                    // Invalide Flughaefen entfernen und Zaehler korrigieren
                    myAirports.remove(i);
                    i--;
                }
                else
                {
                    anzahlValiderGelesenerZeilen++;
                }
            }
        }
        catch (IndexOutOfBoundsException e)
        {
            Ausgeben.ausgeben(Konstanten.INDEX_OUT_OF_BOUNDS);
        }
        // Anzahl fehlerhafter Ladestationen und Anzahl verbleibender Ladestationen ausgeben

        Ausgeben.ausgeben(Konstanten.BEARBEITUNGSDAUER_DER_ueBERPRueFUNG +
                stoppUhr.berechneVergangeneZeitInMillisekunden() +
                Konstanten.MILLISEKUNDEN+Konstanten.NEXT_LINE+
                Konstanten.ANZAHL_VALIDE_FLUGHaeFEN +anzahlValiderGelesenerZeilen);

        return myAirports;
    }

    /**
     * Teilt jede eingelesene Zeile auf, ueberprueft die Werte und korrigiert diese,
     * um ein Airport-Objekt zu erzeugen.
     *
     * @param zeile Die Zeile aus der CSV-Datei als String.
     * @return Ein neues Airport-Objekt, wenn die Zeile korrekt ist; null, wenn ein Fehler auftritt.
     * @Vorbedingung Die Eingabezeile muss als String vorliegen.
     * @Nachbedingung Gibt ein korrekt erstelltes Airport-Objekt oder null zurueck.
     */
    public static Airport zeilenParsing(String zeile) {

        // Zeile in Werte aufteilen
        String[] value = zeile.split(Konstanten.RAGEX, Literal.MINUS_EINS);
        try {
            // AirportType-Objekt erstellen
            AirportType airportType = AirportType.AirportTypeFromString(value[AirportIndex.AIRPORT_TYPE]);
            Identity identity = new Identity(
                    Integer.parseInt(value[AirportIndex.ID]),
                    value[AirportIndex.AIRPORT_IDENT],
                    airportType,
                    value[AirportIndex.NAME]
            );

            // Koordinaten-Objekt erstellen
            Koordinaten coordinates = new Koordinaten(
                    FehlerInCSVDatei.latitudeFehler(HilfsMethoden.parsingDouble(value[AirportIndex.LATITUDE])),
                    FehlerInCSVDatei.longitudeFehler(HilfsMethoden.parsingDouble(value[AirportIndex.LONGITUDE])),
                    HilfsMethoden.parsingDouble(value[AirportIndex.ELEVATION])
            );

            // GeoLocation-Objekt erstellen
            IsoCountry isoCountry = IsoCountry.countryFromCode(value[AirportIndex.ISO_COUNTRY]);
            Continent continent = IsoCountry.continentFromCountry(value[AirportIndex.ISO_COUNTRY]);
            IsoRegion isoRegion = IsoRegion.IsoRegionFromCode(value[AirportIndex.ISO_REGION]);
            Gemeinde municipality = new Gemeinde(FehlerInCSVDatei.LehresStringFehler(value[AirportIndex.MUNICIPALITY]));

            GeoLocation location = new GeoLocation(continent, isoCountry, isoRegion,municipality);

            // RunwayDimension erstellen
            RunwayDimension runwayDimension = new RunwayDimension(
                    HilfsMethoden.parsingDouble(value[AirportIndex.RUNWAY_LENGTH]),
                    HilfsMethoden.parsingDouble(value[AirportIndex.RUNWAY_WIDTH])
            );

            // RunwaySurface und Beleuchtung erstellen
            RunwaySurface runwaySurface = RunwaySurface.runwaySurfaceFromCode(FehlerInCSVDatei.LehresStringFehler(value[AirportIndex.RUNWAY_SURFACE]));
            Beleuchtung lighting = new Beleuchtung(HilfsMethoden.parsingBoolean(value[AirportIndex.BELEUCHTUNG]));

            // Runway-Objekt erstellen
            Runway runway = new Runway(runwayDimension, runwaySurface, lighting);

            // Airport-Objekt zurueckgeben
            return new Airport(identity, coordinates, location, runway);


        } catch (Exception e) {
            // Fehlerhafte Zeile protokollieren
            return null;
        }
    }
}
