package com.emire;

/**
 * @author Emire Korkmaz
 */

public class Laser extends DecoratorObjects {

    /**
     * Constructor
     * @param suit Giysi turu(Decsuit, Orasuit, Torsuit)
     */

    public Laser(Suits suit) {
        super(suit);
    }

    /**
     * Bu method giysinin maliyetini hesaplar.
     * @return Giysinin maliyeti
     */

    @Override
    public double cost() {
        return 200000 + suit.cost();
    }

    /**
     * Bu method giysinin agirligini hesaplar.
     * @return Giysinin agirligi
     */

    @Override
    public double weight() {
        return 5.5 + suit.weight();
    }
}