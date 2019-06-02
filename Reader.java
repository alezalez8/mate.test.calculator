package ua.com.mate.academy;

import java.util.Scanner;

public class Reader {
    public String readKeyboard() {
        System.out.println("Input expression");
        System.out.println("separate operands by space");
        Scanner in = new Scanner(System.in);
        String inputWord = in.nextLine();
        in.close();
        return inputWord;
    }
}
