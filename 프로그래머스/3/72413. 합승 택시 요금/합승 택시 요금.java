import java.util.*;
class Solution {
    static ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
    public int solution(int n, int s, int a, int b, int[][] fares) {
        for(int i=0; i<n+1; i++){
            list.add(new ArrayList<Node>());
        }
        for(int i=0; i<fares.length;i++){
            list.get(fares[i][0]).add(new Node(fares[i][1],fares[i][2]));
            list.get(fares[i][1]).add(new Node(fares[i][0],fares[i][2]));
        }
        PriorityQueue<Node> q = new PriorityQueue<Node>();
        q.add(new Node(s,0));
        int[] check = new int[n+1];
        Arrays.fill(check,-1);
        check[s]=0;
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i=0; i<list.get(node.index).size(); i++){
                int nxt = list.get(node.index).get(i).index;
                int total = list.get(node.index).get(i).total;
                if(check[nxt] == -1 || check[nxt]>node.total+total){
                    check[nxt]=node.total+total;
                    q.add(new Node(nxt,node.total+total));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        q = new PriorityQueue<Node>();
            q.add(new Node(a,0));
            int[] check1 = new int[n+1];
            Arrays.fill(check1,-1);
            check1[a]=0;
            while(!q.isEmpty()){
                Node node = q.poll();
                for(int i=0; i<list.get(node.index).size(); i++){
                    int nxt = list.get(node.index).get(i).index;
                    int total = list.get(node.index).get(i).total;
                    if(check1[nxt] == -1 || check1[nxt]>node.total+total){
                        check1[nxt]=node.total+total;
                        q.add(new Node(nxt,node.total+total));
                    }
                }
            }
        q = new PriorityQueue<Node>();
            q.add(new Node(b,0));
            int[] check2 = new int[n+1];
            Arrays.fill(check2,-1);
            check2[b]=0;
            while(!q.isEmpty()){
                Node node = q.poll();
                for(int i=0; i<list.get(node.index).size(); i++){
                    int nxt = list.get(node.index).get(i).index;
                    int total = list.get(node.index).get(i).total;
                    if(check2[nxt] == -1 || check2[nxt]>node.total+total){
                        check2[nxt]=node.total+total;
                        q.add(new Node(nxt,node.total+total));
                    }
                }
            }
        for(int i=1; i<n+1;i++){
            if(check[i] != -1 && check1[i] != -1 && check2[i] != -1){
                min = Math.min(check[i] + check1[i] + check2[i] , min);                
            }
        }
        return min;
    }
}
class Node implements Comparable<Node>{
    int index;
    int total;
    Node(int index, int total){
        this.index = index;
        this.total = total;
    }
    @Override
    public int compareTo(Node o){
        return this.total - o.total;
    }
}