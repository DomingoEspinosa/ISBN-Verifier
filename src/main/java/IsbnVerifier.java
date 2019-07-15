class IsbnVerifier {
    //(x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9 * 2 + x10 * 1) mod 11 == 0
    //( 3 * 10 + 5  * 9 + 9  * 8 + 8  * 7 + 2  * 6 + 1  * 5 + 5  * 4 + 0  * 3 + 8  * 2 + 8   * 1) mod 11 == 0
    //
    //3-598-21508-8
    private int[] multiplier = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    boolean isValid(String stringToVerify) {
        String replace = stringToVerify.replace("-", "");
        String[] stringsInArray = replace.split("");
        int result = 0;
        for (int i = 0; i < stringsInArray.length; i++) {
            if (isTheStringDistincFromXOrDigit(stringsInArray[i])){
                return false;
            }
            int value = obtainValueOfString(stringsInArray[i]);
            result += value * multiplier[i];
        }
        return result % 11 == 0;

    }

    private boolean isTheStringDistincFromXOrDigit(String s) {
        for (char c: s.toCharArray()){
            if (!Character.isDigit(c) && c != 'X'){
                return true;
            }
        }
        return false;
    }

    private int obtainValueOfString(String valueOfString) {
        return valueOfString.equals("X") ? 10: Integer.valueOf(valueOfString);
    }

}

