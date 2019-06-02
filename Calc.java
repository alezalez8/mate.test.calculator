package ua.com.mate.academy;

public class Calc {
    Converter konverRom = new Converter();
    private int num1;
    private int num2;
    private int resultDec;
    private String resultRom;

    public String calc(String first, String second, char operator, boolean roman) {

        if (!roman) {
            String string;
            num1 = Integer.parseInt(first);
            num2 = Integer.parseInt(second);
        } else {
            num1 = konverRom.romanToDecimal(first);
            num2 = konverRom.romanToDecimal(second);
        }

        switch (operator) {
            case '+':
                resultDec = num1 + num2;
                break;
            case '-':
                resultDec = num1 - num2;
                break;
            case '*':
                resultDec = num1 * num2;
                break;
            case '/': {
                if (num2 != 0) {
                    resultDec = num1 / num2;
                } else {
                    System.out.println("Warning! Divide on zero");
                    break;
                }
                break;
            }
            default:
                System.out.println("Operation ukwnoun. Please, input again");
        }

        if (!roman) {
            return Integer.toString(resultDec);
        } else {
            resultRom = konverRom.toRoman(resultDec);
            return resultRom;
        }
    }
}
