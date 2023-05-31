/*GIVEN A STRING CONTAINING ONLY PARENTHESES, DETERMINE IF THE STRING IS VALID. AN INPUT
STRING IS VALID IF:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Example input: "()[]{}"
Expected output: True
Example input: "([)]"
Expected output: False
Expected Time Complexity: O(n), where n is the length of the input string.*/
import java.util.*;
class prob_6{
    public static boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        if(s.length()%2!=0) return false;
        for(char c:s.toCharArray()){
            if(c=='[' || c=='{' || c=='('){
                st.push(c);
            }
            else if(c=='}' && !st.empty() && st.peek()=='{'){
                st.pop();
            }
            else if(c==']' && !st.empty() && st.peek()=='['){
                st.pop();
            }
            else if(c==')' && !st.empty() && st.peek()=='('){
                st.pop();
            }
            else{
                return false;
            }
        }
        return st.empty();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        boolean res=isValid(input);
        System.out.println(res);
    }
}