/*PROBLEM 8. GIVEN A STRING S CONSISTING OF LOWERCASE LETTERS, REMOVE ADJACENT DUPLICATES FROM S.
THE FINAL OUTPUT SHOULD BE IN LEXICOGRAPHICALLY SMALLEST ORDER.
Example input: "abbaca"
Expected output: "ca"
Expected Time Complexity: O(n), where n is the length of the input string.
*/
import java.util.*;
class prob_8{
    public static String removeDuplicates(String s){
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(!stack.isEmpty() && ch==stack.peek()){
            stack.pop();
            }
            else stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : stack){
            sb.append(ch);
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        String res=removeDuplicates(input);
        System.out.println(res);
    }
}