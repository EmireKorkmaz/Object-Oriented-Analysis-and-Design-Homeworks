package com.emire;

/**
 * @author Emire Korkmaz
 */

public class TPX100 implements Planes {

    private final String model = "TPX100";
    private final String purpose = "Domestic Flights";
    private final String skeleton = "Aluminum Alloy";
    private final String engine = "Single jet engine";
    private final int seating = 50;

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
