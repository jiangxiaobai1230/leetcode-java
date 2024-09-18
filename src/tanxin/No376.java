package src.tanxin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-05-11 10:03
 */
public class No376 {

    public int wiggleMaxLength(int[] nums) {
        int len=nums.length;
        if(len==1||(len==2&&nums[0]==nums[1]))return 1;
        if(len==2&&nums[0]!=nums[1])return 2;
        List<Integer> res=new ArrayList<>();
        res.add(nums[0]);
        boolean isAdd=false,findSecond=false;
        for(int i=1;i<len;i++){
            int num=nums[i]-nums[i-1];
            if(num==0)continue;
            if(!findSecond&&num>0){
                isAdd=true;
                findSecond=true;
                res.add(num);
                continue;
            }
            if(!findSecond&&num<0){
                isAdd=false;
                findSecond=true;
                res.add(num);
                continue;
            }

            if(findSecond&&isAdd&&num<0){
                res.add(num);
                isAdd=false;
            }
            if(findSecond&&!isAdd&&num>0){
                res.add(num);
                isAdd=true;
            }
        }
        return res.size();
    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums = [1,7,4,9,2,5]
        //输出：6
        //解释：整个序列均为摆动序列，各元素之间的差值为 (6, -3, 5, -7, 3) 。
        //示例 2：
        //
        //输入：nums = [1,17,5,10,13,15,10,5,16,8]
        //输出：7
        //解释：这个序列包含几个长度为 7 摆动序列。
        //其中一个是 [1, 17, 10, 13, 10, 16, 8] ，各元素之间的差值为 (16, -7, 3, -3, 6, -8) 。
        //示例 3：
        //
        //输入：nums = [1,2,3,4,5,6,7,8,9]
        //输出：2
        int nums[]={0,0,0};
        System.out.println(new No376().wiggleMaxLength(nums));
        nums=new int[]{1,17,5,10,13,15,10,5,16,8};
        System.out.println(new No376().wiggleMaxLength(nums));
        nums=new int[]{3,3,3,2,5};
        System.out.println(new No376().wiggleMaxLength(nums));

    }
}
