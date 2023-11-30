import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Nearest_smaller_Left {
    public static void main(String[] args) {
        int[] arr =  {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(solution(arr)));
    }
    private static Object[] solution(int[] array) {
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (s.size() == 0) {
                result.add(-1);
            }

            else if (s.size() > 0 && s.peek() < array[i]) {
                result.add(s.peek());
            }

            else if (s.size() > 0 && s.peek() > array[i]) {
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
        // result has answer now we need to return it

        return result.toArray();
    }
}
