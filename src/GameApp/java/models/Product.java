package GameApp.java.models;

public abstract class Product {
    private String id;
    private static int idSeed = 1000;
    private String description;
    private double cost;
    private String productType;
    private boolean isRented;
    private boolean isBeingRepaired;
    private final String PREFIX = "PR";

    public Product(String description, double cost, String productType, boolean isRented, boolean isBeingRepaired) {
        this.description = description;
        this.cost = cost;
        this.productType = productType;
        id = String.format("%s%d",PREFIX, idSeed);
        idSeed++;
        this.isRented = isRented;
        this.isBeingRepaired = isBeingRepaired;
    }

    public Product(String id, String description, double cost, String productType, boolean isRented, boolean isBeingRepaired){
        this.id=id;
        this.description=description;
        this.cost=cost;
        this.productType = productType;
        this.isRented=isRented;
        this.isBeingRepaired=isBeingRepaired;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getProductType(){
        return productType;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean isRented) {
        this.isRented = isRented;
    }

    public boolean isBeingRepaired(){
        return isBeingRepaired;
    }

    public void setIsBeingRepaired(boolean isBeingRepaired){
        this.isBeingRepaired = isBeingRepaired;
    }

    @Override
    public String toString() {
        return String.format("Description : %s" +
                "\nCost: £%.2f", description, cost);
    }
}
