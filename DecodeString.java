import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String g = "3[a]2[b]";
        System.out.println(decodeString(g));
    }
    public static String decodeString(String s) {
        /*we are using two stack int and character and final answer stringBuilder */
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        StringBuilder ans = new StringBuilder();

        /*
        * iterte string push if ch = numeric value to numStack  
        * string append & if ch = '[' append the character to strStack 
        * if ch = ']' pop the numstack value for running the loop and appending it to a temp string then to ans
        */ 
        int len = s.length();
        for(int i = 0; i < len; i++) {
            Character ch = s.charAt(i);

            if(Character.isDigit(ch)) {
                int num = ch - '0';
 
                while(i+1 < len && Character.isDigit(s.charAt(i+1))) { //handling string when 3[a]2[b]3[v]
                    num *= 10 + s.charAt(i+1) - '0';
                    i++; 
                }
                numStack.push(num);
            } else if (ch == '[') {
                strStack.push(ans.toString());
                ans = new StringBuilder();
            } else if (ch == ']') {
                int loopTermination = numStack.pop();
                StringBuilder temp = new StringBuilder(strStack.pop());

                for(int j = 0; j < loopTermination; j++) {
                    temp.append(ans);
                }
                ans = temp;
            } else {
                ans.append(ch);
            }
        }
        return ans.toString();
        
    }
}

