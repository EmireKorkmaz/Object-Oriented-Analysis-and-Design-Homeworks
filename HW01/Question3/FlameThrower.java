package com.emire;

/**
 * @author Emire Korkmaz
 */

public class FlameThrower extends DecoratorObjects {

    /**
     * Constructor
     * @param suit Giysi turu(Decsuit, Orasuit, Torsuit)
     */

    public FlameThrower(Suits suit){
        super(suit);
    }

    /**
     * Bu method giysinin maliyetini hesaplar.
     * @return Giysinin maliyeti
     */

    @Override
    public double cost() {
        return 50000 + suit.cost();
    }

    /**
     * Bu method giysinin agirligini hesaplar.
     * @return Giysinin agirligi
     */

    @Override
    public double weight() {
        return 2 + suit.weight();
    }
}
