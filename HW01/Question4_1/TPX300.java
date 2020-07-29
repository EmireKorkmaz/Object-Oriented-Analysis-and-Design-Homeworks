package com.emire;

/**
 * @author Emire Korkmaz
 */

public class TPX300 implements Planes {

    private final String model = "TPX300";
    private final String purpose = "Transatlantic flights";
    private final String skeleton = "Titanium alloy";
    private final String engine = "Quadro jet engines";
    private final int seating = 250;

    /**
     * Bu method ucagin modelini verir.
     * @return Ucagin modeli
     */

    @Override
    public String getModel() { return model;
    }

    /**
     * Bu method ucagin ne amacla uretildigini soyler.
     * @return Ucagin hangi amacla uretilmek istendigi
     */

    @Override
    public String getPurpose() {
        return purpose;
    }

    /**
     * Bu method ucagin govdesinin hangi maddeden yapıldıgını soyler.
     * @return Ucagın gövdesinin yapildigi madde
     */

    @Override
    public String getSkeleton() {
        return skeleton;
    }

    /**
     * Bu method ucagin hangi motoru kullandigini soyler.
     * @return Ucagin kullandigi motor turu
     */

    @Override
    public String getEngine() {
        return engine;
    }

    /**
     * Bu method ucakta kac koltuk oldugunu soyler.
     * @return Ucaktaki koltuk sayisi
     */

    @Override
    public int getSeating() {
        return seating;
    }
}
