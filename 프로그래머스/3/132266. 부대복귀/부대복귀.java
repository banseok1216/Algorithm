import java.util.*;
//최단시간에 도착
//경로가 없어져 복귀가 불가능한 부대원도 있을 수 있습니다.
// 복귀가 불가능한 경우 해당 부대원의 최단시간은 -1입니다.
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> answerList  = new ArrayList<Integer>();
        for(int i=0; i<n+1; i++){
            list.add(new ArrayList<Integer>());
        }
        for(int i=0; i<roads.length; i++){
            list.get(roads[i][0]).add(roads[i][1]);
            list.get(roads[i][1]).add(roads[i][0]);
        }
            PriorityQueue<Node> q = new PriorityQueue<Node>();
            int[] check = new int[n+1];
        for(int i=0; i<check.length; i++){
            check[i] = -1;
        }
            q.add(new Node(destination,0));
            int ans = -1;
            while(!q.isEmpty()){
                Node node= q.poll();
                if(check[node.cur] > node.total || check[node.cur] ==-1){
                    check[node.cur] = node.total;
                }
                for(int j=0; j<list.get(node.cur).size(); j++){
                    int r = list.get(node.cur).get(j);
                    if(check[r] > node.total+1 || check[r] ==-1){
                        q.add(new Node(r,node.total+1));
                    }
                }
            }
        int[] answer = new int[sources.length];
            for(int j=0; j<sources.length; j++){
                answer[j] = check[sources[j]];
            }
        return answer;
    }
}
class Node implements Comparable<Node>{
    int cur;
    int total;
    Node(int cur, int total){
        this.cur=cur;
        this.total=total ;
    }
    @Override
    public int compareTo(Node o){
        return this.total - o.total;
    }
}