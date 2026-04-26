public class inputValidation {

//    string validation
    public static boolean isValidString(String input) {
        return input != null && !input.trim().isEmpty();
    }

//    int validation
    public static boolean isValidInt(int input) {
        return input > 0;
    }

//    double validation
    public static boolean isValidDouble(double input) {
        return input >= 0;
    }

//    boolean check?
    public static boolean isValidBoolean(boolean input) {
        return true;
    }


}//class
