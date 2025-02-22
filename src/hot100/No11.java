package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-19 11:57
 */
public class No11 {

    public int maxArea(int[] height) {
        int n=height.length;
        int left=0,right=n-1;
        int res=0;
        while (left<right){
            res=Math.max(res,(right-left)*Math.min(height[left],height[right]));
            if(height[left]>height[right]){
                int rightHeight=height[right];
                right--;
                while (right>left&&height[right]<=rightHeight)rightHeight--;
            }
            else {
                int leftHeight=height[left];
                left++;
                while (left<right&&height[left]<=leftHeight)left++;
            }
        }
        return res;

    }

//    public int maxArea(int[] height) {
//        int n=height.length;
//        int left=0,right=n-1;
//        int res=0;
//        while (left<right){
//            res=Math.max(res,(right-left)*Math.min(height[left],height[right]));
//            if(height[left]>height[right])right--;
//            else left++;
//        }
//        return res;
//
//    }

    public static void main(String[] args) {
        //输入：[1,8,6,2,5,4,8,3,7]
        //输出：49
        //解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
        //示例 2：
        //
        //输入：height = [1,1]
        //输出：1
        int[] height = {1,8,6,2,5,4,8,3,7};
        No11 no11 = new No11();
        System.out.println(no11.maxArea(height));
        System.out.println(no11.maxArea(new int[]{1,1}));


    }
}

