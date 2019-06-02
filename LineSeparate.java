package ua.com.mate.academy;

import ua.com.mate.academy.Calc;

public class LineSeparate {

    public void separateInputLine(String inputsLine) {
        Calc calc = new Calc();
        String firstDigit = "";
        String secondDigit = "";
        char operand = ' ';
        int lineLeight = inputsLine.length();
        boolean roman = false;
        boolean resultOperation = true;

        String inputLine = inputsLine.toUpperCase();                                         // upper registr

        int firstSpace = inputLine.indexOf(' ');
        int lastSpace = inputLine.lastIndexOf(' ');
        if(firstSpace == lastSpace){
            throw new IllegalArgumentException("You enter expression without space between operands");

        }

        // search first number

        for (int i = 0; i < firstSpace; i++) {
            if (inputLine.charAt(i) >= '0' && inputLine.charAt(i) <= '9') {                       // check arabic
                firstDigit += inputLine.charAt(i);

            } else if ((inputLine.charAt(i) == 'I') | (inputLine.charAt(i) == 'V') | (inputLine.charAt(i) == 'X')
                    | (inputLine.charAt(i) == 'L') | (inputLine.charAt(i) == 'C') | (inputLine.charAt(i) == 'D')) {
                roman = true;
                firstDigit += inputLine.charAt(i);

            }
            operand = inputLine.charAt(i + 2);                                               // search operand
        }

        //   search second number
        for (int i = lastSpace + 1; i < lineLeight; i++) {
            secondDigit += inputLine.charAt(i);
            if (roman && (inputLine.charAt(i) == 'I') | (inputLine.charAt(i) == 'V') | (inputLine.charAt(i) == 'X')
                    | (inputLine.charAt(i) == 'L') | (inputLine.charAt(i) == 'C') | (inputLine.charAt(i) == 'D')) {
            } else {
                if (!roman && (inputLine.charAt(i) >= '0' && inputLine.charAt(i) <= '9')) {
                } else {
                    System.out.println("Wrong second operand");
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

}
