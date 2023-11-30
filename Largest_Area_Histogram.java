public class Largest_Area_Histogram {
    public static void main(String[] args) {
        int[] array = {2,1,5,6,2,3};
        System.out.println(area(array));
    }

    private static int area(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int[] NSR = new int[height.length];
        int[] NSL = new int[height.length];

        NSR[height.length-1] = height.length;
        NSL[0] = -1;

        for (int i = 1; i < height.length; i++) {
            int p = i - 1;

            while (p >= 0 && height[p] >= height[i]) {
                p = NSL[p];
            }
            NSL[i] = p;
        }

        for (int i = height.length-2; i >= 0; i--) {
            int p = i + 1;

            while (p < height.length && height[p] >= height[i]) {
                p = NSR[p];
            }
            NSR[i] = p;
        }
        
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, 
                               height[i]*(NSR[i]-NSL[i]-1));
        }
        return maxArea;
    }
}
