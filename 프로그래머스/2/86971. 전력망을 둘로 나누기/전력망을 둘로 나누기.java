import java.util.*;
class Solution {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int max =100000000;
    public int solution(int n, int[][] wires) {
        for(int i=0; i<n; i++){
            list.add(new ArrayList<Integer>());
        }
        for(int i=0; i<wires.length; i++ ){
            list.get(wires[i][0]-1).add(wires[i][1]-1);
            list.get(wires[i][1]-1).add(wires[i][0]-1);
        }
        for(int i=0; i<wires.length; i++){
            dfs(wires[i][0]-1,wires[i][1]-1);
        }
        int answer = -1;
        return max;
    }
    public static void dfs(int line1, int line2){
        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[list.size()];
        q.add(0);
        int count=0;
        while(!q.isEmpty()){
            int r = q.poll();
            count++;
            check[r] = true;
            for(int i=0; i<list.get(r).size(); i++){
                if(check[list.get(r).get(i)] || (r==line1 &&list.get(r).get(i) == line2) || (r==line2 &&list.get(r).get(i) == line1)){
                    continue;
                }
                q.add(list.get(r).get(i));
            }
        }
        max = Math.min(Math.abs(list.size() - 2*count),max);
    }
}