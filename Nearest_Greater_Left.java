import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
/*
 * only loop direction get's changed
 */
public class Nearest_Greater_Left {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2};
        System.out.println(Arrays.toString(NGL(arr)));
    }
    private static int[] NGL(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) { // loop direction changed from left 
            if (stack.size() == 0) {
                result.add(-1);
            }
            else if (stack.size() > 0 && stack.peek() > arr[i]) {
                result.add(stack.peek());
            }
            else if (stack.size() > 0 && stack.peek() < arr[i]) {
                while (stack.size() > 0 && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if (stack.size() == 0) {
                    result.add(-1);
                } else {
                    result.add(stack.peek());
                }
            }
            stack.add(arr[i]);
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
