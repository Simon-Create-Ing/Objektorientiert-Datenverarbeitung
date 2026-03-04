package control;

import model.*;
import resources.AirportAttributen;
import resources.Konstanten;
import resources.Literal;
import utilities.ZeitMessung;
import view.Ausgeben;

import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse dient fuer die Suche von Daten in der Flughaefen Daten.
 * Die Klasse enthaelt Methoden fuer die Suche von Daten in der Daten und gibt die gefundenen Daten zurueck.
 */

public class Suche {

    /**
     * Findet den Flughafen mit der schmalsten Landebahn in einem Land.
     *
     * @param liste Liste von Flughaefen.
     * @return Flughafen mit der schmalsten Landebahn oder null, wenn keine gefunden wird.
     *
     * @Vorbedingung Die ArrayListe "liste" ist nicht null und enthaelt gueltige Airport-Objekte.
     * @Nachbedingung Gibt den Flughafen mit der schmalsten Landebahn in einem Land zurueck oder null, wenn keiner gefunden wird.
     */
    public static Airport findeSchmalsteLandebahnInCountry(ArrayList<Airport> liste, IsoCountry country) {
        if (liste == null || liste.isEmpty()) {
            return null; // Leere oder null-Liste: null zurueckgeben
        }

        Airport airportMitSchmalsterLandebahn = null;
        double schmalsteBreite = Double.MAX_VALUE;

        ZeitMessung stoppUhr = new ZeitMessung();
        stoppUhr.start();

        for (Airport airport : liste) {
            if ((country.toString()).equalsIgnoreCase(airport.getGeoLocation().getIsoCountry().toString())) {
                Double runwayWidth = airport.getRunway().getRunwayDimension().getRunwayWidth();
                if (runwayWidth != null && runwayWidth < schmalsteBreite) {
                    schmalsteBreite = runwayWidth;
                    airportMitSchmalsterLandebahn = airport;
                }
            }
        }

        Ausgeben.ausgeben(Konstanten.DER_FLUGHAFEN_MIT_DER_SCHMALSTE_LANDEBAHN_INS_LAND +country+Konstanten.IST+
                airportMitSchmalsterLandebahn.getIdentity().getName()+
                Konstanten.NEXT_LINE+ Konstanten.PFEILE+AirportAttributen.AIRPORT_IDENT+
                airportMitSchmalsterLandebahn.getIdentity().getAirportIdent()+
                Konstanten.NEXT_LINE+Konstanten.PFEILE+ AirportAttributen.MUNICIPALITY+
                airportMitSchmalsterLandebahn.getGeoLocation().getGemeinde()+
                Konstanten.NEXT_LINE+Konstanten.PFEILE+Konstanten.RUNWAY_WIDTH_IN_METERS +
                airportMitSchmalsterLandebahn.getRunway().getRunwayDimension().getRunwayWidth());
        Ausgeben.ausgeben(Konstanten.BEARBEITUNGSDAUER_DER_SUCHE + stoppUhr.berechneVergangeneZeitInMillisekunden() +
                Konstanten.MILLISEKUNDEN);

        return airportMitSchmalsterLandebahn;
    }

    /**
     * Findet den Flughafen mit der kuerzesten beleuchteten Landebahn im Land.
     *
     * @param liste Liste von Flughaefen.
     * @return Flughafen mit der kuerzesten beleuchteten Landebahn oder null, wenn keine gefunden wird.
     *
     * @Vorbedingung Die Liste "liste" ist nicht null und enthaelt gueltige Airport-Objekte.
     * @Nachbedingung Gibt den Flughafen mit der kuerzesten beleuchteten Landebahn im Land zurueck oder null, wenn keiner gefunden wird.
     */
    public static Airport findeKuerzesteBeleuchteteLandebahnInCountry(ArrayList<Airport> liste, IsoCountry country) {
        if (liste == null || liste.isEmpty()) {
            return null; // Leere oder null-Liste: null zurueckgeben
        }

        Airport airportMitKuerzesterLandebahn = null;
        Double kuerzesteLaenge = null;

        ZeitMessung stoppUhr = new ZeitMessung();
        stoppUhr.start();

        for (Airport airport : liste) {
            Runway runway = airport.getRunway();
            Beleuchtung beleuchtung = runway.getBeleuchtung();

            if ((country.toString()).equalsIgnoreCase(airport.getGeoLocation().getIsoCountry().toString())
                    && runway.getRunwayDimension().getRunwayLength() != null
                    && beleuchtung != null && beleuchtung.istBeleuchtet()) {

                Double runwayLength = runway.getRunwayDimension().getRunwayLength();
                if (kuerzesteLaenge == null || runwayLength < kuerzesteLaenge) {
                    kuerzesteLaenge = runwayLength;
                    airportMitKuerzesterLandebahn = airport;
                }
            }
        }

        Ausgeben.ausgeben(Konstanten.FLUGHAFEN_MIT_DER_KUERZESTE_BELEUCHTETE_LANDEBAHN_INS_LAND +country+Konstanten.IST+
                airportMitKuerzesterLandebahn.getIdentity().getName()+
                Konstanten.NEXT_LINE+ Konstanten.PFEILE+AirportAttributen.AIRPORT_IDENT+
                airportMitKuerzesterLandebahn.getIdentity().getAirportIdent()+
                Konstanten.NEXT_LINE+Konstanten.PFEILE+AirportAttributen.MUNICIPALITY+
                airportMitKuerzesterLandebahn.getGeoLocation().getGemeinde().toString()+
                Konstanten.NEXT_LINE+Konstanten.PFEILE+Konstanten.RUNWAY_LENGHT_IN_METERS +
                airportMitKuerzesterLandebahn.getRunway().getRunwayDimension().getRunwayLength());
        Ausgeben.ausgeben(Konstanten.BEARBEITUNGSDAUER_DER_SUCHE + stoppUhr.berechneVergangeneZeitInMillisekunden() +
                Konstanten.MILLISEKUNDEN);
        return airportMitKuerzesterLandebahn;
    }

    /**
     * Zaehlt die Anzahl der Flughaefen in einem Land.
     *
     * @param liste Liste von Flughaefen.
     * @return Anzahl der Flughaefen in Australien.
     *
     * @Vorbedingung Die Liste "liste" ist nicht null und enthaelt gueltige Airport-Objekte.
     * @Nachbedingung Gibt die Anzahl der Flughaefen in dem Land zurueck.
     */
    public static int zaehleFlughaefenInCountry(ArrayList<Airport> liste, IsoCountry country) {
        int anzahlFlughaefen = Literal.NULL;

        ZeitMessung stoppUhr = new ZeitMessung();
        stoppUhr.start();

        for (Airport airport : liste) {
            if (country.toString().equalsIgnoreCase(airport.getGeoLocation().getIsoCountry().toString())) {
                anzahlFlughaefen++;
            }
        }

        Ausgeben.ausgeben(Konstanten.ANZAHL_DER_FLUGHaeFEN_INS_LAND +country+Konstanten.IST+ anzahlFlughaefen);
        Ausgeben.ausgeben(Konstanten.BEARBEITUNGSDAUER_DER_SUCHE + stoppUhr.berechneVergangeneZeitInMillisekunden() +
                Konstanten.MILLISEKUNDEN);

        return anzahlFlughaefen;
    }

    /**
     * Berechnet die Gesamtlaenge der beleuchteten Landebahnen in einem Kontinent.
     * @param liste Liste von Flughaefen.
     * @return Gesamtlaenge der beleuchteten Landebahnen in Metern.
     * @Vorbedingung Die Liste "liste" ist nicht null und enthaelt gueltige Airport-Objekte.
     * @Nachbedingung Gibt die aufsummierte Laenge aller beleuchteten Landebahnen in dem Kontinent zurueck.
     */
    public static double berechneBeleuchteteLandebahnLaengeInContinent(ArrayList<Airport> liste, Continent continent) {
        double aufsummierteLaenge = Literal.NULL_DOUBLE;

        ZeitMessung stoppUhr = new ZeitMessung();
        stoppUhr.start();

        for (Airport airport : liste) {
            Runway runway = airport.getRunway();
            Beleuchtung beleuchtung = runway.getBeleuchtung();

            if ((continent.toString()).equalsIgnoreCase(airport.getGeoLocation().getContinent().toString())
                    && runway.getRunwayDimension().getRunwayLength() != null
                    && beleuchtung != null && beleuchtung.istBeleuchtet()) {

                aufsummierteLaenge += runway.getRunwayDimension().getRunwayLength();
            }
        }

        Ausgeben.ausgeben(Konstanten.AUFSUMMIERTE_LaeNGE_IN_METERS_DER_BELEUCHTETEN_LANDEBAHNEN_IM_KONTINENT +continent+Konstanten.IST+ aufsummierteLaenge);
        Ausgeben.ausgeben(Konstanten.BEARBEITUNGSDAUER_DER_SUCHE + stoppUhr.berechneVergangeneZeitInMillisekunden() +
                Konstanten.MILLISEKUNDEN);

        return aufsummierteLaenge;
    }

    /**
     * Filtert alle deutschen Flughaefen aus einer Liste.
     * @param airportList Liste von Flughaefen.
     * @return Liste der deutschen Flughaefen.
     * @Vorbedingung Die Liste "airportList" ist nicht null und enthaelt gueltige Airport-Objekte.
     * @Nachbedingung Gibt eine Liste aller Flughaefen in Deutschland zurueck.
     */
    public static ArrayList<Airport> filterGermanAirports(ArrayList<Airport> airportList) {
        ArrayList<Airport> germanAirports = new ArrayList<>();
        for (Airport airport : airportList) {
            if (airport != null && (IsoCountry.DE.toString()).equalsIgnoreCase(airport.getGeoLocation().getIsoCountry().toString())) {
                germanAirports.add(airport);
            }
        }
        return germanAirports;
    }

    /**
     * Sucht einen Flughafen basierend auf der Gemeinde.
     *
     * @param airportList Liste von Flughaefen.
     * @param id Gemeinde, nach der gesucht wird.
     * @return Gefundener Flughafen oder null, wenn keiner gefunden wird.
     * @Vorbedingung Die Liste "airportList" ist nicht null und enthaelt gueltige Airport-Objekte. Die Gemeinde "municipality" ist nicht null.
     * @Nachbedingung Gibt den ersten Flughafen mit der angegebenen Gemeinde zurueck oder null, wenn keiner gefunden wird.
     */
    public static Airport findAirportById(List<Airport> airportList, int id) {
        for (Airport airport : airportList) {
            if (airport != null && airport.getIdentity().getId() == id) {
                return airport;
            }
        }
        Ausgeben.ausgeben(Konstanten.KEIN_FLUGHAFEN_WURDE_GEFUNDEN + id);
        return null;
    }

    /**
     * Fuehrt alle vorgegebenen Suchen und Analysen durch.
     * Enthaelt die Aufrufe der notwendigen Suchmethoden
     *
     * @Vorbedingung Eine gueltige Liste von Flughaefen ist vorhanden.
     * @Nachbedingung Die Ergebnisse der Suchen und Analysen werden ausgegeben.
     */
    public static ArrayList<Airport> allesSuchen(ArrayList<Airport> airportListe) {

        // Suche nach dem Flughafen mit der schmalsten Landebahn in Neuseeland
        Airport schmalsteLandebahnNZ = findeSchmalsteLandebahnInCountry(airportListe, IsoCountry.NZ);

        // Suche nach dem Flughafen mit der kuerzesten beleuchteten Landebahn in Deutschland
        Airport kuerzesteBeleuchteteLandebahnDE = findeKuerzesteBeleuchteteLandebahnInCountry(airportListe, IsoCountry.DE);

        // Zaehlen der Flughaefen in Australien
        int anzahlFlughaefenAU = zaehleFlughaefenInCountry(airportListe, IsoCountry.AU);

        // Berechnung der aufsummierten Laenge beleuchteter Landebahnen in Afrika
        double beleuchteteLandebahnLaengeAF = berechneBeleuchteteLandebahnLaengeInContinent(airportListe, Continent.AF);

        return airportListe;
    }
}
