package com.emire;

/**
 * @author Emire Korkmaz
 */

public class Torsuit implements Suits{

    private double price = 5000000;
    private double weight = 50;

    /**
     * Bu method giysinin maliyetini hesaplar.
     * @return Giysinin maliyeti
     */

    @Override
    public double cost() {
        return price;
    }

    /**
     * Bu method giysinin agirligini hesaplar.
     * @return Giysinin agirligi
     */

    @Override
    public double weight() {
        return weight;
    }
}
