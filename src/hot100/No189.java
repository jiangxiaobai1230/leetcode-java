package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-09 19:54
 */
public class No189 {
//    public void rotate(int[] nums, int k) {
//        int len=nums.length;
//        int[] res=new int[len];
//        for(int i=0;i<len;i++){
//            res[(i+k)%len]=nums[i];
//        }
//        for(int i=0;i<len;i++){
//            nums[i]=res[i];
//        }
//
//
//    }

    public void rotate(int[] nums, int k) {
        int len=nums.length;
        k=k%len;
        if(k==0)return;
        reverse(nums,0,len-1);
        reverse(nums,0,k-1);
        reverse(nums,k,len-1);


    }
    void reverse(int[] nums,int begin,int end){
        for(int i=begin;i<=(begin+end)/2;i++){
            int temp=nums[i];
            nums[i]=nums[end+begin-i];
            nums[end+begin-i]=temp;

        }
    }

    public static void main(String[] args) {
        //示例 1:
        //
        //输入: nums = [1,2,3,4,5,6,7], k = 3
        //输出: [5,6,7,1,2,3,4]
        //解释:
        //向右轮转 1 步: [7,1,2,3,4,5,6]
        //向右轮转 2 步: [6,7,1,2,3,4,5]
        //向右轮转 3 步: [5,6,7,1,2,3,4]
        //示例 2:
        //
        //输入：nums = [-1,-100,3,99], k = 2
        //输出：[3,99,-1,-100]
        //解释:
        //向右轮转 1 步: [99,-1,-100,3]
        //向右轮转 2 步: [3,99,-1,-100]
        int[] nums = {1};
        No189 no189 = new No189();
        no189.rotate(nums, 0);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        nums = new int[]{-1,-100,3,99};
        no189.rotate(nums, 2);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

    }
}
