public class Rain_Water_Trapping {
    public static void main(String[] args) {
        int[] array = {3,0,0,2,0,4};
        System.out.println(solution(array));        
    }
    public static int solution(int[] array) {
        int ans = 0;
        int[] water = new int[array.length];

        int[] maxLeft = new int[array.length];
        int[] maxRight = new int[array.length];

        maxLeft[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], array[i]);
        }

        maxRight[array.length-1] = array[array.length-1];
        for (int i = array.length-2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i+1], array[i]);

            water[i] = Math.min(maxLeft[i], maxRight[i]) - array[i];
            ans += water[i];
        }
        
        return ans;
    }
}
