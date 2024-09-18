package src.Traversal;

import java.util.*;

/**
 * @author: Yuan Yuqing
 * @date: 2024-05-08 10:13
 */
public class No332 {

    private LinkedList<String> res=new LinkedList<>();
    private LinkedList<String> path=new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, Comparator.comparing(a -> a.get(1)));
        path.add("JFK");
        Boolean[] used=new Boolean[tickets.size()];
        Arrays.fill(used,false);
        backtracking(tickets,used);
        return res;


    }
    public boolean backtracking(List<List<String>> tickets,Boolean[] used){
        if (path.size() == tickets.size() + 1) {
            res = new LinkedList(path);
            return true;
        }
        for(int i=0;i<tickets.size();i++){
            if(!used[i]&&tickets.get(i).get(0).equals(path.getLast())){
                if(i > 0 && tickets.get(i).get(0).equals(tickets.get(i - 1).get(0)) && tickets.get(i).get(1).equals(tickets.get(i - 1).get(1)) && !used[i - 1]){ continue; }
                path.add(tickets.get(i).get(1));
                used[i]=true;
                if(backtracking(tickets,used)){
                    return true;
                }
                used[i]=false;
                path.removeLast();
            }


        }
        return false;


    }

    public static void main(String[] args) {

        //输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
        //输出：["JFK","MUC","LHR","SFO","SJC"]
        //示例 2：
        //
        //
        //输入：tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
        //输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
        //解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"] ，但是它字典排序更大更靠后。
        //

        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC","LHR"));
        tickets.add(Arrays.asList("JFK","MUC"));
        tickets.add(Arrays.asList("SFO","SJC"));
        tickets.add(Arrays.asList("LHR","SFO"));
        No332 no332 = new No332();
        List<String> itinerary = no332.findItinerary(tickets);
//        for (String s : itinerary) {
//            System.out.println(s);
//        }
//        System.out.println();

        tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK","SFO"));
        tickets.add(Arrays.asList("JFK","ATL"));
        tickets.add(Arrays.asList("SFO","ATL"));
        tickets.add(Arrays.asList("ATL","JFK"));
        tickets.add(Arrays.asList("ATL","SFO"));
        no332 = new No332();
//        itinerary = no332.findItinerary(tickets);
//        for (String s : itinerary) {
//            System.out.println(s);
//        }

        //tickets=[["JFK","SFO"],["JFK","ATL"],["SFO","JFK"],["ATL","AAA"],["AAA","BBB"],["BBB","ATL"],["ATL","AAA"],["AAA","BBB"],["BBB","ATL"],["ATL","AAA"],["AAA","BBB"],["BBB","ATL"],["ATL","AAA"],["AAA","BBB"],["BBB","ATL"],["ATL","AAA"],["AAA","BBB"],["BBB","ATL"],["ATL","AAA"],["AAA","BBB"],["BBB","ATL"],["ATL","AAA"],["AAA","BBB"],["BBB","ATL"],["ATL","AAA"],["AAA","BBB"],["BBB","ATL"],["ATL","AAA"],["AAA","BBB"],["BBB","ATL"],["ATL","AAA"],["AAA","BBB"],["BBB","ATL"],["ATL","AAA"],["AAA","BBB"],["BBB","ATL"],["ATL","AAA"],["AAA","BBB"],["BBB","ATL"],["ATL","AAA"],["AAA","BBB"],["BBB","ATL"],["ATL","AAA"],["AAA","BBB"],["BBB","ATL"],["ATL","AAA"],["AAA","BBB"],["BBB","ATL"],["ATL","AAA"],["AAA","BBB"],["BBB","ATL"],["ATL","AAA"],["AAA","BBB"],["BBB","ATL"],["ATL","AAA"],["AAA","BBB"],["BBB","ATL"],["ATL","AAA"],["AAA","BBB"],["BBB","ATL"],["ATL","AAA"],["AAA","BBB"],["BBB","ATL"],["ATL","AAA"],["AAA","BBB"],["BBB","ATL"],["ATL","AAA"],["AAA","BBB"],["BBB","ATL"],["ATL","AAA"],["AAA","BBB"],["BBB","ATL"],["ATL","AAA"],["AAA","BBB"],["BBB","ATL"],["ATL","AAA"],["AAA","BBB"],["BBB","ATL"],["ATL","AAA"],["AAA","BBB"],["BBB","ATL"]]
        tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK","SFO"));
        tickets.add(Arrays.asList("JFK","ATL"));
        tickets.add(Arrays.asList("SFO","JFK"));
        tickets.add(Arrays.asList("ATL","AAA"));
        tickets.add(Arrays.asList("AAA","BBB"));

        tickets.add(Arrays.asList("BBB","ATL"));
        tickets.add(Arrays.asList("ATL","AAA"));
        tickets.add(Arrays.asList("AAA","BBB"));
        tickets.add(Arrays.asList("BBB","ATL"));
        tickets.add(Arrays.asList("ATL","AAA"));
        tickets.add(Arrays.asList("AAA","BBB"));
        tickets.add(Arrays.asList("BBB","ATL"));
        tickets.add(Arrays.asList("ATL","AAA"));
        tickets.add(Arrays.asList("AAA","BBB"));
        tickets.add(Arrays.asList("BBB","ATL"));
        tickets.add(Arrays.asList("ATL","AAA"));
        tickets.add(Arrays.asList("AAA","BBB"));
        tickets.add(Arrays.asList("BBB","ATL"));
        tickets.add(Arrays.asList("ATL","AAA"));
        tickets.add(Arrays.asList("AAA","BBB"));
        tickets.add(Arrays.asList("BBB","ATL"));
        tickets.add(Arrays.asList("ATL","AAA"));
        tickets.add(Arrays.asList("AAA","BBB"));
        tickets.add(Arrays.asList("BBB","ATL"));
        tickets.add(Arrays.asList("ATL","AAA"));
        tickets.add(Arrays.asList("AAA","BBB"));
        tickets.add(Arrays.asList("BBB","ATL"));
        tickets.add(Arrays.asList("ATL","AAA"));
        no332 = new No332();
        itinerary = no332.findItinerary(tickets);
        for (String s : itinerary) {
            System.out.println(s);
        }

    }
}
