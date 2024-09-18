package src.tanxin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-05-29 22:04
 */
public class No738 {


    public int monotoneIncreasingDigits(int n) {
        List<Integer> nums=new ArrayList<>();
        while (n!=0){
            nums.add(0,n%10);
            n=n/10;
        }
        int len=nums.size();
        for(int i=len-1;i>=0;i--){
            if(i>=1&& nums.get(i) >= nums.get(i - 1)){
                continue;
            }else {
                if(i==0){
                    if(nums.get(0)==0){
                        nums.remove(0);
                    }

                }else {
                    for(int j=i;j<len;j++) {
                        nums.set(j, 9);
                    }
                    nums.set(i - 1, nums.get(i - 1) - 1);

                }

            }

        }
        int res=0;
        for(int i=0;i<nums.size();i++){
            res+=nums.get(i);
            if(i!=nums.size()-1) {
                res = res * 10;
            }
        }
        return res;

    }

    public static void main(String[] args) {

        //示例 1:
        //
        //输入: n = 10
        //输出: 9
        //示例 2:
        //
        //输入: n = 1234
        //输出: 1234
        //示例 3:
        //
        //输入: n = 332
        //输出: 299
        //

        System.out.println(new No738().monotoneIncreasingDigits(603253281));
        System.out.println(new No738().monotoneIncreasingDigits(1234));
        System.out.println(new No738().monotoneIncreasingDigits(332));



    }
}
