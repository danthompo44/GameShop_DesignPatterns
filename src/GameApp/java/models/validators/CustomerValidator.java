package GameApp.java.models.validators;

public class CustomerValidator {
    private static StringBuilder errors = new StringBuilder();

    public static void validate(String forename, String surname, String address) throws Exception{
        errors.setLength(0);
        if(isNotNull("First name", forename)){
            isEmpty("First name", forename);
        }
        if(isNotNull("Surname", surname)){
            isEmpty("Surname", surname);
        }
        if(isNotNull("Address", address)){
            isEmpty("Address", address);
        }
        if(errors.length()>0){
            throw new Exception(errors.toString());
        }
    }

    private static boolean isNotNull(String attribute, String value){
        if(value==null){
            errors.append(attribute).append(" can't be null!\n");
            return false;
        }
        return true;
    }

    private static void isEmpty(String attribute, String value){
        if(value.isEmpty()){
            errors.append(attribute).append(" can't be empty!\n");
        }
    }
}
