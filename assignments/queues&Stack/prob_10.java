/*
PROBLEM 10. EVALUATE THE VALUE OF AN ARITHMETIC EXPRESSION IN REVERSE POLISH NOTATION (RPN). VALID
OPERATORS ARE +, -, *, AND /. EACH OPERAND MAY BE AN INTEGER OR ANOTHER EXPRESSION.
Example input: ["2", "1", "+", "3", "*"]
Expected output: 9
Example input: ["4", "13", "5", "/", "+"]
Expected output: 6
Expected Time Complexity: O(n), where n is the length of the input list.*/
import java.util.*;
class prob_10{
    public static int revPolishNot(String[] tokens){
        Stack<String> stack = new Stack<String>();
        int x,y;
        String result="";
        int get=0;
        String choice;
        int value=0;
        String p="";
        for (int i=0;i<tokens.length;i++){
            if (tokens[i] != "+" && tokens[i] != "-"
                && tokens[i] != "*" && tokens[i] != "/") {
                stack.push(tokens[i]);
                continue;
            }
            else 
                choice=tokens[i];
            switch (choice){
            case "+":
                x=Integer.parseInt(stack.pop());
                y=Integer.parseInt(stack.pop());
                value=x+y;
                result=p+value;
                stack.push(result);
                break;
            case "-":
                x=Integer.parseInt(stack.pop());
                y=Integer.parseInt(stack.pop());
                value=y-x;
                result=p+value;
                stack.push(result);
                break;
            case "*":
                x=Integer.parseInt(stack.pop());
                y=Integer.parseInt(stack.pop());
                value=x*y;
                result=p+value;
                stack.push(result);
                break;
            case "/":
                x=Integer.parseInt(stack.pop());
                y=Integer.parseInt(stack.pop());
                value=y/x;
                result=p+value;
                stack.push(result);
                break;
            default:
                continue;
            }
        }
        return Integer.parseInt(stack.pop());
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        String[] str=input.split(" ");
        // for(int i=0;i<str.length;i++)
        // System.out.println(str[i]);
        int res=revPolishNot(str);
        System.out.println(res);
    }
}