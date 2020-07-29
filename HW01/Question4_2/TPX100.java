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
