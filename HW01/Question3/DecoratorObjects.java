package com.emire;

/**
 * @author Emire Korkmaz
 */

public abstract class DecoratorObjects implements Suits {
    protected Suits suit;

    /**
     * Constructor
     * @param suit Giysi turu(Decsuit, Orasuit, Torsuit)
     */

    public DecoratorObjects(Suits suit){
        this.suit = suit;
    }

    /**
     * Bu method giysinin maliyetini hesaplar.
     * @return Giysinin maliyeti
     */

    public abstract double cost();

    /**
     * Bu method giysinin agirligini hesaplar.
     * @return Giysinin agirligi
     */
    public abstract double weight();
}
