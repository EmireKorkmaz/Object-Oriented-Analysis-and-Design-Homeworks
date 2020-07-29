package com.emire;
/**
 * @author Emire Korkmaz
 */
public abstract class Factories {

    /**
     * Bu method bir ucak uretir.
     * @param model Uretilen ucagin modeli
     * @return Ucak objesi
     */

    public abstract Planes product(String model);

    /**
     * Bu method ucagin motor enjeksiyon tipini verir.
     * @return Ucagin motorunun enjeksiyon tipi
     */

    public abstract String getInjectionType();

    /**
     * Bu method ucagin koltugunun hangi maddeden yapildigi ile ilgili bilgi verir.
     * @return Ucagi koltugunun yapildigi malzeme bilgisi
     */

    public abstract String getSeatingCover();
}
