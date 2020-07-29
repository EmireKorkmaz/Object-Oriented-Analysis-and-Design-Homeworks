package com.emire;
/**
 * @author Emire Korkmaz
 */

public class OtherFactory extends Factories {

    private final String injectionType = "Geared turbofan";
    private final String seatingCover = "Leather";

    /**
     * Bu method bir ucak uretir.
     * @param model Uretilen ucagin modeli
     * @return Ucak objesi
     */

    @Override
    public Planes product(String model) {
        Planes plane;

        if(model.equals("TPX100")){
            plane = new TPX100();
        }
        else if (model.equals("TPX200")){
            plane = new TPX200();
        }
        else if (model.equals("TPX300")){
            plane = new TPX300();
        }
        else {
            return null;
        }
        return plane;
    }

    /**
     * Bu method ucagin motor enjeksiyon tipini verir.
     * @return Ucagin motorunun enjeksiyon tipi
     */

    @Override
    public String getSeatingCover() {
        return seatingCover;
    }

    /**
     * Bu method ucagin koltugunun hangi maddeden yapildigi ile ilgili bilgi verir.
     * @return Ucagi koltugunun yapildigi malzeme bilgisi
     */

    @Override
    public String getInjectionType() {
        return injectionType;
    }
}
