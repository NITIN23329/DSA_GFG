package oneDArray;

public class TappingRainWater {
    static int trappingWater(int arr[], int n) {
        int[] height =arr;
        if(height.length==0)return 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int max = height[0];
        for(int i= 0;i <height.length;i++){
            if(max<height[i])max = height[i];
            maxLeft[i] = max;
        }
        max = height[height.length-1];
        for(int i =height.length-1; i>=0;i--){
            if(max<height[i])max = height[i];
            maxRight[i] = max;
        }
        int res = 0;
        for(int i=0;i<height.length;i++){
            res += Math.min(maxLeft[i],maxRight[i]) - height[i];
        }
        return res;
    }
}
