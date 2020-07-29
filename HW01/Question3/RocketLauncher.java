package com.emire;

/**
 * @author Emire Korkmaz
 */

public class RocketLauncher extends DecoratorObjects{

    /**
     * Constructor
     * @param suit Giysi turu(Decsuit, Orasuit, Torsuit)
     */

    public RocketLauncher(Suits suit) {
        super(suit);
    }

    /**
     * Bu method giysinin maliyetini hesaplar.
     * @return Giysinin maliyeti
     */

    @Override
    public double cost() {
        return 150000 + suit.cost();
    }

    /**
     * Bu method giysinin agirligini hesaplar.
     * @return Giysinin agirligi
     */

    @Override
    public double weight() {
        return 7.5 + suit.weight();
    }
}