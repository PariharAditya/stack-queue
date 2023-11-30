import java.util.Stack;
import java.util.HashMap;

public class Next_Greater_Element {
    public static void main(String[] args) {

    }
    public static int[] nextGreaterElementSolution1(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && stack.peek() < nums2[i]) {
                hm.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        for(int i = 0; i< nums1.length; i++) {
            nums1[i] = hm.getOrDefault(nums1[i], -1);
        }

        return nums1;
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] indices = new int[10000 + 1];
        for (int i = 0; i < nums2.length; i++)
            indices[nums2[i]] = i;

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = findNextGreater(nums2, indices[nums1[i]]);
        }
        return nums1;
    }

    private static int findNextGreater(int[] nums, int ind) {
        for (int j = ind + 1; j < nums.length; j++) {
            if (nums[j] > nums[ind]) {
                return nums[j];
            }
        }
        return -1;
    }
}