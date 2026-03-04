package model;


import resources.Konstanten;

/**
 *  Diese Klasse ist eine enum Klasse enthielt alle enum Objekte nach ISO 3166-1 Standard (zweistellige Laenderabkuerzung) und Methoden eines IsoCountry.
 */

public enum IsoCountry {
        AF(Continent.AS), AX(Continent.EU), AL(Continent.EU), DZ(Continent.AF), AS(Continent.OC), AD(Continent.EU), AO(Continent.AF),
        AI(Continent.NA), AQ(Continent.AN), AG(Continent.NA), AR(Continent.SA), AM(Continent.AS), AW(Continent.NA), AU(Continent.OC),
        AT(Continent.EU), AZ(Continent.AS), BS(Continent.NA), BH(Continent.AS), BD(Continent.AS), BB(Continent.NA), BY(Continent.EU),
        BE(Continent.EU), BZ(Continent.NA), BJ(Continent.AF), BM(Continent.NA), BT(Continent.AS), BO(Continent.SA), BQ(Continent.NA),
        BA(Continent.EU), BW(Continent.AF), BV(Continent.AN), BR(Continent.SA), IO(Continent.AS), BN(Continent.AS), BG(Continent.EU),
        BF(Continent.AF), BI(Continent.AF), CV(Continent.AF), KH(Continent.AS), CM(Continent.AF), CA(Continent.NA), KY(Continent.NA),
        CF(Continent.AF), TD(Continent.AF), CL(Continent.SA), CN(Continent.AS), CX(Continent.AS), CC(Continent.AS), CO(Continent.SA),
        KM(Continent.AF), CG(Continent.AF), CD(Continent.AF), CK(Continent.OC), CR(Continent.NA), CI(Continent.AF), HR(Continent.EU),
        CU(Continent.NA), CW(Continent.NA), CY(Continent.EU), CZ(Continent.EU), DK(Continent.EU), DJ(Continent.AF), DM(Continent.NA),
        DO(Continent.NA), EC(Continent.SA), EG(Continent.AF), SV(Continent.NA), GQ(Continent.AF), ER(Continent.AF), EE(Continent.EU),
        SZ(Continent.AF), ET(Continent.AF), FK(Continent.SA), FO(Continent.EU), FJ(Continent.OC), FI(Continent.EU), FR(Continent.EU),
        GF(Continent.SA), PF(Continent.OC), TF(Continent.AN), GA(Continent.AF), GM(Continent.AF), GE(Continent.AS), DE(Continent.EU),
        GH(Continent.AF), GI(Continent.EU), GR(Continent.EU), GL(Continent.NA), GD(Continent.NA), GP(Continent.NA), GU(Continent.OC),
        GT(Continent.NA), GG(Continent.EU), GN(Continent.AF), GW(Continent.AF), GY(Continent.SA), HT(Continent.NA), HM(Continent.AN),
        VA(Continent.EU), HN(Continent.NA), HK(Continent.AS), HU(Continent.EU), IS(Continent.EU), IN(Continent.AS), ID(Continent.AS),
        IR(Continent.AS), IQ(Continent.AS), IE(Continent.EU), IM(Continent.EU), IL(Continent.AS), IT(Continent.EU), JM(Continent.NA),
        JP(Continent.AS), JE(Continent.EU), JO(Continent.AS), KZ(Continent.AS), KE(Continent.AF), KI(Continent.OC), KP(Continent.AS),
        KR(Continent.AS), KW(Continent.AS), KG(Continent.AS), LA(Continent.AS), LV(Continent.EU), LB(Continent.AS), LS(Continent.AF),
        LR(Continent.AF), LY(Continent.AF), LI(Continent.EU), LT(Continent.EU), LU(Continent.EU), MO(Continent.AS), MG(Continent.AF),
        MW(Continent.AF), MY(Continent.AS), MV(Continent.AS), ML(Continent.AF), MT(Continent.EU), MH(Continent.OC), MQ(Continent.NA),
        MR(Continent.AF), MU(Continent.AF), YT(Continent.AF), MX(Continent.NA), FM(Continent.OC), MD(Continent.EU), MC(Continent.EU),
        MN(Continent.AS), ME(Continent.EU), MS(Continent.NA), MA(Continent.AF), MZ(Continent.AF), MM(Continent.AS), NA(Continent.AF),
        NR(Continent.OC), NP(Continent.AS), NL(Continent.EU), NC(Continent.OC), NZ(Continent.OC), NI(Continent.NA), NE(Continent.AF),
        NG(Continent.AF), NU(Continent.OC), NF(Continent.OC), MK(Continent.EU), MP(Continent.OC), NO(Continent.EU), OM(Continent.AS),
        PK(Continent.AS), PW(Continent.OC), PS(Continent.AS), PA(Continent.NA), PG(Continent.OC), PY(Continent.SA), PE(Continent.SA),
        PH(Continent.AS), PN(Continent.OC), PL(Continent.EU), PT(Continent.EU), PR(Continent.NA), QA(Continent.AS), RO(Continent.EU),
        RU(Continent.EU), RW(Continent.AF), RE(Continent.AF), BL(Continent.NA), SH(Continent.AF), KN(Continent.NA), LC(Continent.NA),
        MF(Continent.NA), PM(Continent.NA), VC(Continent.NA), WS(Continent.OC), SM(Continent.EU), ST(Continent.AF), SA(Continent.AS),
        SN(Continent.AF), RS(Continent.EU), SC(Continent.AF), SL(Continent.AF), SG(Continent.AS), SX(Continent.NA), SK(Continent.EU),
        SI(Continent.EU), SB(Continent.OC), SO(Continent.AF), ZA(Continent.AF), GS(Continent.AN), SS(Continent.AF), ES(Continent.EU),
        LK(Continent.AS), SD(Continent.AF), SR(Continent.SA), SJ(Continent.EU), SE(Continent.EU), CH(Continent.EU), SY(Continent.AS),
        TW(Continent.AS), TJ(Continent.AS), TZ(Continent.AF), TH(Continent.AS), TL(Continent.AS), TG(Continent.AF), TK(Continent.OC),
        TO(Continent.OC), TT(Continent.NA), TN(Continent.AF), TR(Continent.AS), TM(Continent.AS), TC(Continent.NA), TV(Continent.OC),
        UG(Continent.AF), UA(Continent.EU), AE(Continent.AS), GB(Continent.EU), US(Continent.NA), UM(Continent.OC), UY(Continent.SA),
        UZ(Continent.AS), VU(Continent.OC), VE(Continent.SA), VN(Continent.AS), VG(Continent.NA), VI(Continent.NA), WF(Continent.OC),
        EH(Continent.AF), YE(Continent.AS), ZM(Continent.AF), ZW(Continent.AF), XK(Continent.EU);



    private final Continent continent;
    /**
     * Konstruktor, um eine IsoCounty Objekt(mit der passende Continent Objekt) zu erstellen.
     * @Vorbedingung Keine
     * @Nachbedingung Eine IsoCounty Objekt wird erstellt.
     * @param continent Ein Kontinent Objekt
     */

    IsoCountry(Continent continent)
    {
        this.continent = continent;
    }

    /**
     * Findet die entsprechende ISOCountry vom enum List fuer die vorgegebene String
     * @Vorbedingung ein String muss schon vorgegeben werden
     * @Nachbedingung ISOCountry vom enum List wird zurueckgegeben
     * @param value String vom Einlesen
     * @return IsoCountry vom enum List
     */
    public static IsoCountry countryFromCode(String value)
    {
        for (IsoCountry isoCountry : IsoCountry.values())
        {
            if (isoCountry.name().equalsIgnoreCase(value) )
            {
                return isoCountry;
            }
        }
        //falls String mit keinem Objekt vom enum List passt
        throw new IllegalArgumentException(Konstanten.INVALID_ISOCOUNTRY + value);
    }

    public Continent getContinent() {
        return continent;
    }
    /**
     * Findet die entsprechende Continent Objekt vom enum List fuer die vorgegebene String
     * @Vorbedingung ein String muss schon vorgegeben werden
     * @Nachbedingung Continent vom enum List wird zurueckgegeben
     * @param code String vom Einlesen
     * @return IsoCountry vom enum List
     */
    public static Continent continentFromCountry(String code)
    {
        for (IsoCountry isoCountry : IsoCountry.values())
        {
            if (isoCountry.name().equalsIgnoreCase(code))
            {
                return isoCountry.getContinent();
            }
        }
        //falls String mit keinem Objekt vom enum List passt
        throw new IllegalArgumentException(Konstanten.INVALID_CONTINENT+ code);
    }

    /**
     * Gibt der IsoCountry vom enum List formatiert als String zurueck.
     * @Vorbedingung IsoCountry vom enum List muss initialisiert sein.
     * @Nachbedingung isoCountry vom enum List wird formatiert als String zurueckgegeben.
     * @return IsoCountry vom enum List formatiert als String
     */
    public String toString() {
        return name();
    }
}

