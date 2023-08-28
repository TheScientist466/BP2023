import java.util.Scanner;
import java.util.Stack;

public class Eval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String infixExp = sc.nextLine();
        String postfixExp = toPostfix(infixExp);
        System.out.println(Evaluate(postfixExp));
    }

    static String toPostfix(String str) {
        String out = "";
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch != ' ') {
                if(Character.isDigit(ch)) {
                    out += ch;
                }
                else if(ch == '(' || ch == '^')
                    stack.push(ch);
                else if(ch == ')') {
                    while(!stack.isEmpty() && stack.peek() != '(') {
                        out += stack.pop();
                    }
                    stack.pop();
                }
                else {
                    if(stack.isEmpty() || precedence(ch) > precedence(stack.peek())) {
                        stack.push(ch);
                    }
                    else {
                        while(!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                            out += stack.pop();
                        }
                        stack.push(ch);
                    }
                }
            }
        }

        while(!stack.isEmpty())
            out += stack.pop();

        return out;
    }

    static int Evaluate(String postfixExp) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < postfixExp.length(); i++) {
            char ch = postfixExp.charAt(i);
            if(Character.isDigit(ch)) {
                stack.push(ch - '0');
            }
            else {
                stack.push(operate(stack.pop(), stack.pop(), ch));
            }
        }
        return stack.pop();
    }

    static int operate(int right, int left, char operator) {
        switch(operator) {
            case '+':
                return left + right;
            case '-':
                return left - right;
            case '*':
                return left * right;
            case '/':
                return left / right;
            case '%':
                return left % right;
            case '^':
                return (int)Math.pow(left, right);
            default:
                return 0;
        }
    }

    static int precedence(char x) {
        if(x == '+' || x == '-')
            return 0;
        else if(x == '*' || x == '/' || x == '%')
            return 1;
        else if(x == '^')
            return 2;
        else
            return -1;
    }
}
