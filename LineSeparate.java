package ua.com.mate.academy;

public class LineSeparate {

    public void separateInputLine(String inputsLine) {
        Calc calc = new Calc();
        String firstDigit = "";
        String secondDigit = "";
        char operand = ' ';
        int lineLeight = inputsLine.length();
        boolean roman = false;
        boolean resultOperation = true;

        String inputLine = inputsLine.toUpperCase();

        int firstSpace = inputLine.indexOf(' ');
        int lastSpace = inputLine.lastIndexOf(' ');
        if (firstSpace == lastSpace) {
            throw new IllegalArgumentException("You enter expression without space between operands");

        }

        // search first number

        for (int i = 0; i < firstSpace; i++) {
            if (arabicSymbol(inputLine.charAt(i))) {
                firstDigit += inputLine.charAt(i);

            } else if (romanSymbol(inputLine.charAt(i))) {
                roman = true;
                firstDigit += inputLine.charAt(i);

            }
            operand = inputLine.charAt(i + 2);
        }

        //   search second number
        for (int i = lastSpace + 1; i < lineLeight; i++) {
            secondDigit += inputLine.charAt(i);
            if (roman && (romanSymbol(inputLine.charAt(i)))) {
            } else {
                if (!roman && (arabicSymbol(inputLine.charAt(i)))) {
                } else {
                    System.out.println("Wrong second number");
                    resultOperation = false;
                    break;
                }
            }
        }

        if (resultOperation) {
            System.out.println("Result is:");
            System.out.println(firstDigit + "  " + operand + "  " +
                    secondDigit + "  =  " + calc.calc(firstDigit, secondDigit, operand, roman));
        } else System.out.println("Input correct number");

    }

    private boolean arabicSymbol(char inputChar) {
        if (inputChar >= '0' && inputChar <= '9')
            return true;
        else
            return false;

    }

    private boolean romanSymbol(char inputChar) {
        if ((inputChar == 'I') | (inputChar == 'V') | (inputChar == 'X')
                | (inputChar == 'L') | (inputChar == 'C') | (inputChar == 'D'))
            return true;
        else
            return false;

    }

}
