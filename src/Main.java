package ru.spbau.demidov.task1;

import java.text.ParseException;

/**
 * Created by administrator on 28.02.14.
 */
public class Main {
    /**
     * This application can sum numbers that were entered via command line.
     */
    public static void main(String[] args) {
        StringBuilder strBuilder = new StringBuilder();
        for (String s : args) {
            strBuilder.append(s);
            strBuilder.append(' ');
        }
        String inputString = strBuilder.toString();

        boolean isNegative = false;
        int summa = 0;
        int tmpNumber = 0;

        try {
            for (int i = 0; i < inputString.length(); i++) {
                char ch = inputString.charAt(i);
                if (ch == '-') {
                    if (tmpNumber != 0) {
                        throw new ParseException("Parse exception: minus is not in the right place", i);
                    }
                    if (isNegative == true) {
                        isNegative = false;
                    } else {
                        isNegative = true;
                    }
                } else if (Character.isWhitespace(ch)) {
                    if (isNegative == true && tmpNumber == 0) {
                        throw new ParseException("Parse exception: you want null to be negative?", i);
                    } else if (isNegative == true) {
                        tmpNumber *= -1;
                    }
                    summa += tmpNumber;
                    isNegative = false;
                    tmpNumber = 0;
                }  else if (ch >= '0' && ch <= '9') {
                    int digit = ch - '0';
                    tmpNumber *= 10;
                    tmpNumber += digit;

                } else {
                    throw new ParseException("Parse exception", i);
                }

            }
            System.out.println(summa);
        }    catch (ParseException msg) {
            System.out.println(msg.getMessage());
        }
    }
}
