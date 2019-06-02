package ua.com.mate.academy;

public class Calculator {
    public static void main(String[] args) {
        Reader inputLine = new Reader();
        String input = inputLine.readKeyboard();

        LineSeparate inputExpretion = new LineSeparate();
        inputExpretion.separateInputLine(input);
    }
}
