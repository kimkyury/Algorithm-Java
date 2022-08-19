package day5;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class blanket {

    public static int len;
    public static String inputStr;
    public static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        inputStr = sc.nextLine();
        int len = inputStr.length();

        int cnt = 0;

        for (int i = 0; i < len; i++) {
            if (isRightBlanket(i) == true) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static boolean isRightBlanket(int startPoint) {
        boolean isRight = false;
        int i = 0;

        while (i < len) {
            char c = inputStr.charAt(startPoint++);

            if (startPoint >= len) {
                startPoint = 0;
            }

            if (c == '{') {
                if (inputStr.charAt(startPoint) != '}') {
                    return isRight;
                }
            } else if (c == '[') {
                if (inputStr.charAt(startPoint) != ']') {
                    return isRight;
                }

            } else if (c == '(') {
                if (inputStr.charAt(startPoint) != ')') {
                    return isRight;
                }
            }

            i++;

        }
        isRight = true;
        return isRight;
    }

}
