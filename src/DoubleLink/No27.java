package src.DoubleLink;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-27 10:32
 */
public class No27 {

    public static int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while(right >= 0 && nums[right] == val) right--; //将right移到从右数第一个值不为val的位置
        while(left <= right) {
            if(nums[left] == val) { //left位置的元素需要移除
                //将right位置的元素移到left（覆盖），right位置移除
                nums[left] = nums[right];
                right--;
            }
            left++;
            while(right >= 0 && nums[right] == val) right--;
        }
        return left;
    }
//    public static int removeElement(int[] nums, int val) {
//        int cur=nums.length-1,replace=cur;
//        while(cur>=0){
//            if(nums[cur]==val){
//                int t=nums[replace];
//                nums[replace]=val;
//                nums[cur]=t;
//                replace--;
//            }
//            cur--;
//
//        }
//        return replace+1;
//    }
    public static void main(String[] args) {
        //给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
        //
        //不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
        //
        //元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
        //
        //示例 1：
        //
        //输入：nums = [3,2,2,3], val = 3
        //输出：2, nums = [2,2]
        //解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
        //示例 2：
        //
        //输入：nums = [0,1,2,2,3,0,4,2], val = 2
        //输出：5, nums = [0,1,3,0,4]
        //解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。

        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(nums,val));
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        nums=new int[]{3,2,2,3};
        val=3;
        System.out.println();
        System.out.println(removeElement(nums,val));
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }





    }
}
