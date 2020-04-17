package GameApp.java.models;

import GameApp.java.models.hashmaps.HashMaps;

public class Console extends Product{
    private String bitDepth;
    private String formFactor;

    public Console(String description, double cost, BitDepth bitDepth, FormFactor formFactor, boolean isRented, boolean isBeingRepaired) {
        super(description, cost, "Console", isRented, isBeingRepaired);
        this.bitDepth = HashMaps.bitDepthStringMap.get(bitDepth);
        this.formFactor = HashMaps.formFactorStringMap.get(formFactor);
    }

    public Console(String id, String description, double cost, String bitDepth, String formFactor, boolean isRented, boolean beingRepaired){
        super(id, description, cost, "Console", isRented, beingRepaired);
        this.bitDepth=HashMaps.bitDepthStringMap.get(bitDepth);
        this.formFactor=HashMaps.formFactorStringMap.get(formFactor);
    }

    public String getBitDepth(){
        return bitDepth;
    }

    public String getFormFactor(){
        return formFactor;
    }

    @Override
    public String toString(){
        return String.format(super.toString() + "\nBit Depth: %s" +
                "\nForm Factor: %s\n", bitDepth, formFactor);
    }

}
