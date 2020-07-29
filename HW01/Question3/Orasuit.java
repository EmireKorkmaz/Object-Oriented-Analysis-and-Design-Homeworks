package com.emire;

/**
 * @author Emire Korkmaz
 */

public class Orasuit implements Suits {

    private double price = 1500000;
    private double weight = 30;

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