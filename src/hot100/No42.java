package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-19 11:37
 */
public class No42 {
    //https://leetcode.cn/problems/trapping-rain-water/solutions/1974340/zuo-liao-nbian-huan-bu-hui-yi-ge-shi-pin-ukwm/?envType=study-plan-v2&envId=top-100-liked
    public int trap(int[] height) {
        int n=height.length;
        int pre=0,back=0;
        int res=0;
        int left=0,right=n-1;
        while (left<right){
            pre=Math.max(pre,height[left]);
            back=Math.max(back,height[right]);
            if(pre>back)res+=back-height[right--];
            else res+=pre-height[left++];
        }
        return res;
    }

    public static void main(String[] args) {
        //输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
        //输出：6
        //解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
        //示例 2：
        //
        //输入：height = [4,2,0,3,2,5]
        //输出：9\

        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        No42 no42 = new No42();
        System.out.println(no42.trap(height));
        height = new int[]{4,2,0,3,2,5};
        System.out.println(no42.trap(height));

    }
}
