package exam;

import java.util.Scanner;
import stack.Stack;

public class StackEx1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("수식 입력 : ");
        String expression = sc.nextLine();

        Stack s = new Stack(expression.length());

        boolean check = true;

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            if (ch == '(') {
                s.push(ch);
            }

            else if (ch == ')') {

                if (s.isEmpty()) {
                    check = false;
                    break;
                }

                s.pop();
            }
        }

        if (!s.isEmpty()) {
            check = false;
        }

        System.out.println(check);

        sc.close();
    }
}