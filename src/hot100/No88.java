package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-10-06 00:17
 */
public class No88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0)return;
        if(m==0){
            for(int i=0;i<n;i++){
                nums1[i]=nums2[i];
            }
        }
        int index=m+n-1;
        int index1=m-1,index2=n-1;
        while (index2>=0){
            if(index1>=0&&nums1[index1]>nums2[index2]){
                nums1[index--]=nums1[index1--];

            }else {
                nums1[index--]=nums2[index2--];

            }

        }

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        //输出：[1,2,2,3,5,6]
        //解释：需要合并 [1,2,3] 和 [2,5,6] 。
        //合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
        //示例 2：
        //
        //输入：nums1 = [1], m = 1, nums2 = [], n = 0
        //输出：[1]
        //解释：需要合并 [1] 和 [] 。
        //合并结果是 [1] 。
        //示例 3：
        //
        //输入：nums1 = [0], m = 0, nums2 = [1], n = 1
        //输出：[1]
        //解释：需要合并的数组是 [] 和 [1] 。
        //合并结果是 [1] 。
        //注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
        //
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        new No88().merge(nums1,3,nums2,3);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
        System.out.println("==========================");

    }
}
