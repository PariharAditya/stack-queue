import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Nearest_Greater_Right {
    public static void main(String[] args) {
        // int[] arr1 = {4, 1, 2};
        int[] arr1 = {1, 3, 4, 2};
        
        System.out.println(Arrays.toString(answer(arr1)));
    }

    static int[] answer(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = arr.length - 1; i >= 0; i--) { //loop direction from end i.e. Right
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
            stack.push(arr[i]);  // Push the current element onto the stack
        }

        // Reverse the result list to get the correct order
        int[] ans = new int[result.size()];
        for (int i = result.size() - 1; i >= 0; i--) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
