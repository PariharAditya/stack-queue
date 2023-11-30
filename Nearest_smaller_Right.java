import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Nearest_smaller_Right {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 2, 10, 8 };
        // { 2, 2, -1, 8, -1 };

        System.out.println(Arrays.toString(NSR(arr)));

    }

    private static int[] NSR(int[] array) {
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = array.length - 1; i >= 0; i--) {
            if (s.size() == 0) {
                result.add(-1);
            }

            else if (s.size() > 0 && s.peek() < array[i]) {
                result.add(s.peek());
            }

            else if (s.size() > 0 && s.peek() >= array[i]) {
                while (s.size() > 0 && s.peek() >= array[i]) {
                    s.pop();
                }
                if (s.size() == 0) {
                    result.add(-1);
                } else {
                    result.add(s.peek());
                }
            }
            s.push(array[i]);
        }
        Collections.reverse(result);
        // result has answer now we need to return it
        int[] ans = new int[result.size()];
        for (int i = 0; i <= result.size()-1; i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

}
