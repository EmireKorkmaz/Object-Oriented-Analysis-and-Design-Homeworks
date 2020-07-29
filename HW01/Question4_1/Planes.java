package com.emire;

/**
 * @author Emire Korkmaz
 */
public interface Planes {

    /**
     * Bu method ucagin modelini verir.
     * @return Ucagin modeli
     */

    String getModel();

    /**
     * Bu method ucagin ne amacla uretildigini soyler.
     * @return Ucagin hangi amacla uretilmek istendigi
     */

    String getPurpose();

    /**
     * Bu method ucagin govdesinin hangi maddeden yapıldıgını soyler.
     * @return Ucagın gövdesinin yapildigi madde
     */

    String getSkeleton();

    /**
     * Bu method ucagin hangi motoru kullandigini soyler.
     * @return Ucagin kullandigi motor turu
     */

    String getEngine();

    /**
     * Bu method ucakta kac koltuk oldugunu soyler.
     * @return Ucaktaki koltuk sayisi
     */

    int getSeating();
}
