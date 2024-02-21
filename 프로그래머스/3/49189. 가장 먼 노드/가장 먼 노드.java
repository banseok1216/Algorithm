import java.util.*;
class Solution {
    static PriorityQueue<Node> q = new PriorityQueue<Node>();
    public int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n+1;i++){
            list.add(new ArrayList<Integer>());
        }
        for(int i=0; i<edge.length;i++){
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }
        int[] check = new int[n+1];
        q.add(new Node(1,1));
        check[1] = 1;
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i=0; i<list.get(node.index).size(); i++){
                int nxt = list.get(node.index).get(i);
                if(check[nxt] == 0|| check[nxt] > node.total+1){
                    check[nxt] = node.total+1;
                    q.add(new Node(nxt,node.total+1));
                }
            }
        }
        Arrays.sort(check);
        int max =0;
        max = check[n];
        int answer = 0;
        for(int i=n; i>=0; i--){
            if(check[i] == max){
                answer++;
            }
        }
        return answer;
    }
}
class Node implements Comparable<Node> {
    int index;
    int total;
    Node(int index,int total){
        this.index = index;
        this.total = total;
    }
    @Override
    public int compareTo(Node o){
        return this.total - o.total;
    }   
}