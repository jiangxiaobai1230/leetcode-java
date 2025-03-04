package src.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-27 17:17
 */
public class No216 {
    private List<List<Integer>> res=new ArrayList<>();
    private List<Integer>path=new ArrayList<>();
    private int[] isvisited=new int[10];
    private int sum=0;
    public List<List<Integer>> combinationSum3(int k, int n) {
        isvisited[0]=1;
        dfs(1,k,n);
        return res;

    }
    private void dfs(int index,int k,int n){
        if(sum>n||index>k+1)return;
        if(sum==n&&k==path.size()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<10;i++){
            if(isvisited[i]!=1){
                if((path.size()==0)||(path.size()>=1&&i>path.get(path.size()-1))) {
                    isvisited[i] = 1;
                    path.add(i);
                    sum += i;
                    dfs(index + 1, k, n);
                    sum -= i;
                    path.remove(path.size() - 1);
                    isvisited[i] = 0;
                }else continue;
            }
        }

    }

    public static void main(String[] args) {
        //示例 1:
        //
        //输入: k = 3, n = 7
        //输出: [[1,2,4]]
        //解释:
        //1 + 2 + 4 = 7
        //没有其他符合的组合了。
        //示例 2:
        //
        //输入: k = 3, n = 9
        //输出: [[1,2,6], [1,3,5], [2,3,4]]
        //解释:
        //1 + 2 + 6 = 9
        //1 + 3 + 5 = 9
        //2 + 3 + 4 = 9
        //没有其他符合的组合了。
        //示例 3:
        //
        //输入: k = 4, n = 1
        //输出: []
        //解释: 不存在有效的组合。
        //在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。

        No216 no216 = new No216();
        System.out.println(no216.combinationSum3(3,7));
        no216 = new No216();
        System.out.println(no216.combinationSum3(3,9));
        no216 = new No216();
        System.out.println(no216.combinationSum3(4,1));

    }
}
