package GameApp.java.models;

public class Game extends Product{
    private Console console;

    public Game(String description, double cost, Console console, boolean isRented, boolean isBeingRepaired) {
        super(description, cost, "Game", isRented, isBeingRepaired);
        this.console = console;
    }

    public Game(String id, String description, double cost, Console console, boolean isRented, boolean beingRepaired){
        super(id, description, cost, "Game", isRented, beingRepaired);
        this.console = console;
    }

    public Console getConsole(){
        return console;
    }

    @Override
    public String toString(){
        return super.toString() + "\nConsole: " + console.getDescription();
    }


}
