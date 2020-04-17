package GameApp.java.models.validators;

import GameApp.java.models.Product;

public class BasketValidator {
    private static final int CONSOLE_LIMIT = 1;
    private static final int GAME_LIMIT = 3;
    private static int gameCount = 0;
    private static int consoleCount = 0;

    public static void addProduct(Product product) throws Exception{
        if(productIsAConsole(product)){
            if(consoleLimitIsNotReached()){
                consoleCount++;
            }
            else{
                throw new Exception("Sorry, you've reached your console limit for this rental!\n");
            }
        }
        else if(productIsAGame(product)){
            if(gameLimitIsNotReached()){
                gameCount++;
            }
            else{
                throw new Exception("Sorry you've reached your games limit for this rental!\n");
            }
        }
    }
    public static void removeProduct(Product product){
        if(productIsAConsole(product)){
            consoleCount--;
        }
        else if(productIsAGame(product)){
            gameCount--;
        }
    }

    public static void reset(){
        gameCount=0;
        consoleCount=0;
    }

    private static boolean productIsAConsole(Product product){
        return product.getProductType().equals("Console");
    }

    private static boolean productIsAGame(Product product){
        return product.getProductType().equals("Game");
    }

    private static boolean consoleLimitIsNotReached(){
        return consoleCount<CONSOLE_LIMIT;
    }
    private static boolean gameLimitIsNotReached(){
        return gameCount<GAME_LIMIT;
    }
    public static boolean consoleLimitReached(){
        return consoleCount == CONSOLE_LIMIT;
    }
    public static boolean gameLimitReached(){
        return gameCount == GAME_LIMIT;
    }
    public static int getGameCount(){
        return gameCount;
    }
    public static int getConsoleCount(){
        return consoleCount;
    }
}
