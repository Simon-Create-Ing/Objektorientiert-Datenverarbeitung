package control;

import model.Airport;
import resources.AirportAttributen;
import resources.Konstanten;
import utilities.HilfsMethoden;
import utilities.ZeitMessung;
import view.Ausgeben;
import view.Eingeben;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * Diese Klasse dient zur Sortierung von .csv Dateien der Flughaefen.
 * Die Klasse enthaelt Methoden zur Sortierung der Datei und gibt die sortierte ArrayList zurueck.
 */
public class ArrayListSortieren {

    /**
     * Generische Methode zur Sortierung einer Liste von Flughaefen mit einem Comparator.
     * Implementiert das Comparable.
     * @Vorbedingung Die Liste von Flughaefen ist initialisiert und nicht null.
     * @Nachbedingung Eine vollstaendig sortierte Liste wird zurueckgegeben.
     * @param liste Liste von Flughaefen.
     * @param comparator Comparator fuer die Sortierung, das heißt die Attribute.
     * @return Sortierte Liste.
     */
    private static ArrayList<Airport> sortiere(ArrayList<Airport> liste, Comparator<Airport> comparator, String Kriterien) {
        ZeitMessung stoppUhr = new ZeitMessung(); // Zeitmessung
        stoppUhr.start();

        try {
            Collections.sort(liste, comparator); // list sortieren
        } catch (UnsupportedOperationException | IllegalArgumentException e) {
            Ausgeben.ausgeben(Konstanten.SORTIEREN_FEHLER);
            e.printStackTrace();
        }

        int anzahlSortierteFlughaefen = liste.size(); //  sortierte airports abzaehlen

        Ausgeben.ausgeben(Konstanten.DIE_LISTE_WURDE_MIT_ERFOLG_NACH +Kriterien+ Konstanten.SORTIERT);
        Ausgeben.ausgeben(Konstanten.BEARBEITUNGSDAUER_DER_SORTIERUNG_NACH+ Kriterien + Konstanten.COLUMN+
                stoppUhr.berechneVergangeneZeitInMillisekunden() + Konstanten.MILLISEKUNDEN);
        Ausgeben.ausgeben(Konstanten.ANZAHL_SORTIERTE_FLUGHaeFEN + anzahlSortierteFlughaefen);
        return liste;
    }

    /**
     * Sortiert eine Liste von Flughaefen nach der ID.
     * @Vorbedingung Die Liste von Flughaefen ist initialisiert und nicht null.
     * @Nachbedingung Eine nach der ID sortierte Liste wird zurueckgegeben.
     *
     * @param liste Liste von Flughaefen, die sortiert werden soll.
     * @return Sortierte Liste von Flughaefen.
     */
    public static ArrayList<Airport> sortiereNachId(ArrayList<Airport> liste) {
        String Kriterien =AirportAttributen.AIRPORT_ID;
        return sortiere(liste, new Comparator<Airport>() {
            @Override
            public int compare(Airport a1, Airport a2) {
                return Integer.compare(a1.getIdentity().getId(), a2.getIdentity().getId());
            }
        }, Kriterien);
    }

    /**
     * Sortiert eine Liste von Flughaefen nach dem Airport-Identifikator.
     * @Vorbedingung Die Liste von Flughaefen ist initialisiert und nicht null.
     * @Nachbedingung Eine nach dem Airport-Identifikator sortierte Liste wird zurueckgegeben.
     * @param liste Liste von Flughaefen, die sortiert werden soll.
     * @return Sortierte Liste von Flughaefen.
     */
    public static ArrayList<Airport> sortiereNachAirportIdent(ArrayList<Airport> liste) {
        String Kriterien = AirportAttributen.AIRPORT_IDENT;
        return sortiere(liste, new Comparator<Airport>() {
            @Override
            public int compare(Airport a1, Airport a2) {
                return HilfsMethoden.compareStrings(a1.getIdentity().getAirportIdent(), a2.getIdentity().getAirportIdent());
            }
        }, Kriterien);
    }

    /**
     * Sortiert eine Liste von Flughaefen nach dem Airport-Typ.
     * @Vorbedingung Die Liste von Flughaefen ist initialisiert und nicht null.
     * @Nachbedingung Eine nach dem Airport-Typ sortierte Liste wird zurueckgegeben.
     * @param liste Liste von Flughaefen, die sortiert werden soll.
     * @return Sortierte Liste von Flughaefen.
     */
    public static ArrayList<Airport> sortiereNachAirportType(ArrayList<Airport> liste) {
        String Kriterien =AirportAttributen.AIRPORT_TYPE;
        return sortiere(liste, new Comparator<Airport>() {
            @Override
            public int compare(Airport a1, Airport a2) {
                return a1.getIdentity().getAirportType().name().compareTo(a2.getIdentity().getAirportType().name());
            }
        }, Kriterien);
    }

    /**
     * Sortiert eine Liste von Flughaefen nach der Namen.
     * @Vorbedingung Die Liste von Flughaefen ist initialisiert und nicht null.
     * @Nachbedingung Eine nach der Namen sortierte Liste wird zurueckgegeben.
     * @param liste Liste von Flughaefen, die sortiert werden soll.
     * @return Sortierte Liste von Flughaefen.
     */
    public static ArrayList<Airport> sortiereNachName(ArrayList<Airport> liste) {
        String Kriterien =AirportAttributen.AIRPORT_NAME;
        return sortiere(liste, new Comparator<Airport>() {
            @Override
            public int compare(Airport a1, Airport a2) {
                return a1.getIdentity().getName().compareTo(a2.getIdentity().getName());
            }
        }, Kriterien);
    }

    /**
     * Sortiert eine Liste von Flughaefen nach dem ISO-Land.
     * @Vorbedingung Die Liste von Flughaefen ist initialisiert und nicht null.
     * @Nachbedingung Eine nach dem ISO-Land sortierte Liste wird zurueckgegeben.
     * @param liste Liste von Flughaefen, die sortiert werden soll.
     * @return Sortierte Liste von Flughaefen.
     */
    public static ArrayList<Airport> sortiereNachIsoCountry(ArrayList<Airport> liste) {
        String Kriterien =AirportAttributen.ISO_COUNTRY;
        return sortiere(liste, new Comparator<Airport>() {
            @Override
            public int compare(Airport a1, Airport a2) {
                return a1.getGeoLocation().getIsoCountry().name().compareTo(a2.getGeoLocation().getIsoCountry().name());
            }
        }, Kriterien);
    }

    /**
     * Sortiert eine Liste von Flughaefen nach der ISO-Region.
     * @Vorbedingung Die Liste von Flughaefen ist initialisiert und nicht null.
     * @Nachbedingung Eine nach der ISO-Region sortierte Liste wird zurueckgegeben.
     * @param liste Liste von Flughaefen, die sortiert werden soll.
     * @return Sortierte Liste von Flughaefen.
     */
    public static ArrayList<Airport> sortiereNachIsoRegion(ArrayList<Airport> liste) {
        String Kriterien =AirportAttributen.ISO_REGION;
        return sortiere(liste, new Comparator<Airport>() {
            @Override
            public int compare(Airport a1, Airport a2) {
                return a1.getGeoLocation().getIsoRegion().name().compareTo(a2.getGeoLocation().getIsoRegion().name());
            }
        }, Kriterien);
    }

    /**
     * Sortiert eine Liste von Flughaefen nach dem Kontinent.
     * @Vorbedingung Die Liste von Flughaefen ist initialisiert und nicht null.
     * @Nachbedingung Eine nach dem Kontinent sortierte Liste wird zurueckgegeben.
     * @param liste Liste von Flughaefen, die sortiert werden soll.
     * @return Sortierte Liste von Flughaefen.
     */
    public static ArrayList<Airport> sortiereNachContinent(ArrayList<Airport> liste) {
        String Kriterien =AirportAttributen.CONTINENT;
        return sortiere(liste, new Comparator<Airport>() {
            @Override
            public int compare(Airport a1, Airport a2) {
                return a1.getGeoLocation().getContinent().name().compareTo(a2.getGeoLocation().getContinent().name());
            }
        }, Kriterien);
    }

    /**
     * Sortiert eine Liste von Flughaefen nach der Municipality.
     * @Vorbedingung Die Liste von Flughaefen ist initialisiert und nicht null.
     * @Nachbedingung Eine nach der Municipality sortierte Liste wird zurueckgegeben.
     * @param liste Liste von Flughaefen, die sortiert werden soll.
     * @return Sortierte Liste von Flughaefen.
     */
    public static ArrayList<Airport> sortiereNachMunicipality(ArrayList<Airport> liste) {
        String Kriterien =AirportAttributen.MUNICIPALITY;
        return sortiere(liste, new Comparator<Airport>() {
            @Override
            public int compare(Airport a1, Airport a2) {
                return a1.getGeoLocation().getGemeinde().getMunicipality().compareTo(a2.getGeoLocation().getGemeinde().getMunicipality());
            }
        }, Kriterien);
    }



    /**
     * Sortiert eine Liste von Flughaefen nach der Latitude.
     * @Vorbedingung Die Liste von Flughaefen ist initialisiert und nicht null.
     * @Nachbedingung Eine nach der Latitude sortierte Liste wird zurueckgegeben.
     * @param liste Liste von Flughaefen, die sortiert werden soll.
     * @return Sortierte Liste von Flughaefen.
     */
    public static ArrayList<Airport> sortiereNachLatitude(ArrayList<Airport> liste) {
        String Kriterien =AirportAttributen.LATITUDE;
        return sortiere(liste, new Comparator<Airport>() {
            @Override
            public int compare(Airport a1, Airport a2) {
                return HilfsMethoden.compareDoubles(a1.getKoordinates().getLatitude(), a2.getKoordinates().getLatitude());
            }
        }, Kriterien);
    }

    /**
     * Sortiert eine Liste von Flughaefen nach der Longitude.
     * @Vorbedingung Die Liste von Flughaefen ist initialisiert und nicht null.
     * @Nachbedingung Eine nach der Longitude sortierte Liste wird zurueckgegeben.
     * @param liste Liste von Flughaefen, die sortiert werden soll.
     * @return Sortierte Liste von Flughaefen.
     */
    public static ArrayList<Airport> sortiereNachLongitude(ArrayList<Airport> liste) {
        String Kriterien =AirportAttributen.LONGITUDE;
        return sortiere(liste, new Comparator<Airport>() {
            @Override
            public int compare(Airport a1, Airport a2) {
                return HilfsMethoden.compareDoubles(a1.getKoordinates().getLongitude(), a2.getKoordinates().getLongitude());
            }
        }, Kriterien);
    }

    /**
     * Sortiert eine Liste von Flughaefen nach der Elevation.
     * @Vorbedingung: Die Liste von Flughaefen ist initialisiert und nicht null.
     * @Nachbedingung: Eine nach der Elevation sortierte Liste wird zurueckgegeben.
     * @param liste Liste von Flughaefen, die sortiert werden soll.
     * @return Sortierte Liste von Flughaefen.
     */
    public static ArrayList<Airport> sortiereNachElevation(ArrayList<Airport> liste) {
        String Kriterien =AirportAttributen.ELEVATION;
        return sortiere(liste, new Comparator<Airport>() {
            @Override
            public int compare(Airport a1, Airport a2) {
                return HilfsMethoden.compareDoubles(a1.getKoordinates().getElevation(), a2.getKoordinates().getElevation());
            }
        }, Kriterien);
    }

    /**
     * Sortiert eine Liste von Flughaefen nach der Runway-Laenge.
     * @Vorbedingung Die Liste von Flughaefen ist initialisiert und nicht null.
     * @Nachbedingung Eine nach der Runway-Laenge sortierte Liste wird zurueckgegeben.
     * @param liste Liste von Flughaefen, die sortiert werden soll.
     * @return Sortierte Liste von Flughaefen.
     */
    public static ArrayList<Airport> sortiereNachRunwayLength(ArrayList<Airport> liste) {
        String Kriterien =AirportAttributen.RUNWAY_LENGHT;
        return sortiere(liste, new Comparator<Airport>() {
            @Override
            public int compare(Airport a1, Airport a2) {
                return HilfsMethoden.compareDoubles(a1.getRunway().getRunwayDimension().getRunwayLength(),
                        a2.getRunway().getRunwayDimension().getRunwayLength());
            }
        }, Kriterien);
    }

    /**
     * Sortiert eine Liste von Flughaefen nach der Runway-Breite.
     * @Vorbedingung Die Liste von Flughaefen ist initialisiert und nicht null.
     * @Nachbedingung Eine nach der Runway-Breite sortierte Liste wird zurueckgegeben.
     * @param liste Liste von Flughaefen, die sortiert werden soll.
     * @return Sortierte Liste von Flughaefen.
     */
    public static ArrayList<Airport> sortiereNachRunwayWidth(ArrayList<Airport> liste) {
        String Kriterien = AirportAttributen.RUNWAY_WIDTH;
        return sortiere(liste, new Comparator<Airport>() {
            @Override
            public int compare(Airport a1, Airport a2) {
                return HilfsMethoden.compareDoubles(a1.getRunway().getRunwayDimension().getRunwayWidth(),
                        a2.getRunway().getRunwayDimension().getRunwayWidth());
            }
        }, Kriterien);
    }

    /**
     * Sortiert eine Liste von Flughaefen nach dem RunwaySurface.
     * @Vorbedingung Die Liste von Flughaefen ist initialisiert und nicht null.
     * @Nachbedingung Eine nach dem RunwaySurface sortierte Liste wird zurueckgegeben.
     * @param liste Liste von Flughaefen, die sortiert werden soll.
     * @return Sortierte Liste von Flughaefen.
     */
    public static ArrayList<Airport> sortiereNachRunwaySurface(ArrayList<Airport> liste) {
        String Kriterien =AirportAttributen.RUNWAY_SURFACE;
        return sortiere(liste, new Comparator<Airport>() {
            @Override
            public int compare(Airport a1, Airport a2) {
                return a1.getRunway().getRunwaySurface().name().compareTo(a2.getRunway().getRunwaySurface().name());
            }
        }, Kriterien);
    }

    /**
     * Sortiert eine Liste von Flughaefen nach die Beleuchtung.
     * @Vorbedingung Die Liste von Flughaefen ist initialisiert und nicht null.
     * @Nachbedingung Eine nach der Beleuchtung sortierte Liste wird zurueckgegeben.
     * @param liste Liste von Flughaefen, die sortiert werden soll.
     * @return Sortierte Liste von Flughaefen.
     */
    public static ArrayList<Airport> sortiereNachBeleuchtung(ArrayList<Airport> liste) {
        String Kriterien = AirportAttributen.BELEUCHTUNG;
        return sortiere(liste, new Comparator<Airport>() {
            @Override
            public int compare(Airport a1, Airport a2) {
                return HilfsMethoden.compareBoolean(a1.getRunway().getBeleuchtung().istBeleuchtet(),
                        a2.getRunway().getBeleuchtung().istBeleuchtet());
            }
        }, Kriterien);
    }


    /**
     * Sortiert eine Liste von Flughaefen nach den kombinierten Kriterien:
     * Enthaelt die Aufrufe der notwendigen Sortierungsmethoden
     * @param liste Liste von Flughaefen, die sortiert werden soll.
     * @return Die sortierte Liste von Flughaefen.
     * @Vorbedingung Die Liste ist initialisiert und nicht null.
     * @Nachbedingung Die Liste ist nach den Kriterien sortiert.
     */
    public static ArrayList<Airport> sortiereNachKombiniertenKriterien(ArrayList<Airport> liste) {
        Ausgeben.ausgeben(Konstanten.ANFANG_SORTIERUNG );
        Ausgeben.ausgeben(Konstanten.WOLLEN_SIE_DIE_DATEN_SORTIEREN);
        int n= Eingeben.sortierungMethodenWertEingeben();
        Ausgeben.ausgeben(AirportAttributen.SORTIERUNG_AUSWAHL);
        for (int i = 0; i < n; i++) {

            System.out.println(Konstanten.ENTSPRECHENDE_ZAHL_FUER_DIE_ATTRIBUTE);
            int m = Eingeben.sortierungMethodenWertEingeben();
            switch (m) {
                case 1:
                    liste = sortiereNachId(liste);
                    break;
                case 2:
                    liste = sortiereNachAirportIdent(liste);
                    break;
                case 3:
                    liste = sortiereNachAirportType(liste);
                    break;
                case 4:
                    liste = sortiereNachName(liste);
                    break;
                case 5:
                    liste = sortiereNachContinent(liste);
                    break;
                case 6:
                    liste = sortiereNachIsoCountry(liste);
                    break;
                case 7:
                    liste = sortiereNachIsoRegion(liste);
                    break;
                case 8:
                    liste = sortiereNachBeleuchtung(liste);
                    break;
                case 9:
                    liste = sortiereNachElevation(liste);
                    break;
                case 10:
                    liste = sortiereNachRunwayLength(liste);
                    break;
                case 11:
                    liste = sortiereNachRunwaySurface(liste);
                    break;
                case 12:
                    liste = sortiereNachRunwayWidth(liste);
                    break;
                case 13:
                    liste = sortiereNachMunicipality(liste);
                    break;
                case 14:
                    liste = sortiereNachLatitude(liste);
                    break;
                case 15:
                    liste = sortiereNachLongitude(liste);
                    break;
                default:
                    Ausgeben.ausgeben(Konstanten.EINGABE_FEHLER_DER_SORTIERUNG);
            }

        }
        // Sortierung nach Runway-Breite und dann nach ISO-Country und dann nach Kontinent
        Ausgeben.ausgeben(Konstanten.ENDE_SORTIERUNG);
        Ausgeben.printSortierungErgebnisse(liste);
        return liste;
    }


}

