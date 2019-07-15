class IsbnVerifier {
    private int[] multiplier = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    boolean isValid(String stringToVerify) {
        String replace = stringToVerify.replace("-", "");
        String[] stringsInArray = replace.split("");
        int result = 0;
        if (stringsInArray.length != 10) {
            return false;
        }
        for (int i = 0; i < stringsInArray.length; i++) {
            if (conditionsAreOk(stringsInArray[i], i)) return false;
            int value = obtainValueOfString(stringsInArray[i]);
            result += value * multiplier[i];
        }
        return result % 11 == 0;

    }

    private boolean conditionsAreOk(String value, int position) {
        if (value.equals("X") && position != 9) {
            return true;
        }
        if (isTheStringDistincFromXOrDigit(value)) {
            return true;
        }
        return false;
    }

    private boolean isTheStringDistincFromXOrDigit(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c) && c != 'X') {
                return true;
            }
        }
        return false;
    }

    private int obtainValueOfString(String valueOfString) {
        return valueOfString.equals("X") ? 10 : Integer.valueOf(valueOfString);
    }

}

