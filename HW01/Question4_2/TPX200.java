package com.emire;
/**
 * @author Emire Korkmaz
 */

public class TPX200 implements Planes {

    private final String model = "TPX200";
    private final String purpose = "Domestic and short international flights";
    private final String skeleton = "Nickel alloy";
    private final String engine = "Twin jet engines";
    private final int seating = 100;

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getPurpose() {
        return purpose;
    }

    @Override
    public String getSkeleton() {
        return skeleton;
    }

    @Override
    public String getEngine() {
        return engine;
    }

    @Override
    public int getSeating() {
        return seating;
    }
}
