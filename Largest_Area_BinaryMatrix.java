public class Largest_Area_BinaryMatrix {
    public static void main(String[] args) {

    }

    public static int maximalRectangle(char[][] matrix) {
        int max = 0;
        int ans[] = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    ans[j] = 0;
                } else {
                    ans[j] += 1;
                }
            }
            max = Math.max(max, maxRectangleArea(ans));
        }
        return max;
    }

    static int maxRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int[] NSR = new int[height.length];
        int[] NSL = new int[height.length];

        NSR[height.length - 1] = height.length;
        NSL[0] = -1;

        for (int i = 1; i < height.length; i++) {
            int p = i - 1;

            while (p >= 0 && height[p] >= height[i]) {
                p = NSL[p];
            }
            NSL[i] = p;
        }

        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < height.length && height[p] >= height[i]) {
                p = NSR[p];
            }
            NSR[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea,
                    height[i] * (NSR[i] - NSL[i] - 1));
        }
        return maxArea;
    }
}
