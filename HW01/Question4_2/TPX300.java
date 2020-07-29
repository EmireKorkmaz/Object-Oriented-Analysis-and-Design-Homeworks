package com.emire;
/**
 * @author Emire Korkmaz
 */

public class TPX300 implements Planes {

    private final String model = "TPX300";
    private final String purpose = "Transatlantic flights";
    private final String skeleton = "Titanium alloy";
    private final String engine = "Quadro jet engines";
    private final int seating = 250;

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
