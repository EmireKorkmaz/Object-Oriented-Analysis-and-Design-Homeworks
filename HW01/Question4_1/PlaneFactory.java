package com.emire;

/**
 * @author Emire Korkmaz
 */

public class PlaneFactory {

    /**
     * Bu method bir ucak uretir.
     * @param model Uretilen ucagin modeli
     * @return Ucak objesi
     */

    public Planes product(String model){
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
            System.out.println("Yanlıs model seçimi");
            return null;
        }
        return plane;
    }
}
