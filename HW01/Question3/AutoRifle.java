package com.emire;

/**
 * @author Emire Korkmaz
 */

public class AutoRifle extends DecoratorObjects {

    /**
     * Constructor
     * @param suit Giysi turu(Decsuit, Orasuit, Torsuit)
     */

    public AutoRifle(Suits suit) {
        super(suit);
    }

    /**
     * Bu method giysinin maliyetini hesaplar.
     * @return Giysinin maliyeti
     */

    @Override
    public double cost() {
        return 30000 + suit.cost();
    }

    /**
     * Bu method giysinin agirligini hesaplar.
     * @return Giysinin agirligi
     */

    @Override
    public double weight() {
        return 1.5 + suit.weight();
    }
}
