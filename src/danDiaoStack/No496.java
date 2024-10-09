package src.danDiaoStack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author: Yuan Yuqing
 * @date: 2024-10-09 23:17
 */
public class No496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack=new Stack<>();
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int len1=nums1.length,len2=nums2.length;
        int[] ans=new int[len1];
        stack.push(0);
        for(int i=1;i<len2;i++){
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                hashMap.put(nums2[stack.peek()], nums2[i]);
                stack.pop();

            }
            stack.push(i);

        }
        for(int i=0;i<len1;i++){
            ans[i]=hashMap.getOrDefault(nums1[i],-1);
        }
        return ans;


    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
        //输出：[-1,3,-1]
        //解释：nums1 中每个值的下一个更大元素如下所述：
        //- 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
        //- 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
        //- 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
        //示例 2：
        //
        //输入：nums1 = [2,4], nums2 = [1,2,3,4].
        //输出：[3,-1]
        //解释：nums1 中每个值的下一个更大元素如下所述：
        //- 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
        //- 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
        //
        int[] nums1 = {1,3,5,2,4};
        int[] nums2 = {6,5,4,3,2,1,7};
        No496 no496 = new No496();
        no496.nextGreaterElement(nums1, nums2);
        for (int i : no496.nextGreaterElement(nums1, nums2)) {
            System.out.println(i);
        }
        System.out.println();

        nums1 = new int[]{2,4};
        nums2 = new int[]{1,2,3,4};
        no496.nextGreaterElement(nums1, nums2);
        for (int i : no496.nextGreaterElement(nums1, nums2)) {
            System.out.println(i);
        }

    }
}
