package src.tanxin;

import java.util.Collections;

/**
 * @author: Yuan Yuqing
 * @date: 2024-05-17 23:06
 */
public class No135 {


    public int candy(int[] ratings) {
        int sum=0;
        int[] candy=new int[ratings.length];
        candy[0]=1;
        for(int i=1;i<ratings.length;i++){
           if(ratings[i]>ratings[i-1]){
               candy[i]=candy[i-1]+1;
           }else candy[i]=1;

        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candy[i]=Math.max(candy[i],candy[i+1]+1);
            }
        }
        for(int i=0;i<ratings.length;i++){
            sum+=candy[i];
        }
        return sum;
    }

    public static void main(String[] args) {

        //示例 1：
        //
        //输入：ratings = [1,0,2]
        //输出：5
        //解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
        //示例 2：
        //
        //输入：ratings = [1,2,2]
        //输出：4
        //解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
        //     第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
        int[] ratings = {1,2,87,87,87,2,1};
        System.out.println(new No135().candy(ratings));
        ratings = new int[]{1,2,2};
        System.out.println(new No135().candy(ratings));


    }
}
