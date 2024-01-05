import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;

class Main {
    static int m, n, k;
    static int max;
    static ArrayList<Integer> tree = new ArrayList<>();
    static ArrayList<Integer> ans = new ArrayList<>();
    static int[][] v;
    static int[] v1, arr, arr2;
    static String[] strarr;
    static String[] sum;
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m =Integer.parseInt(br.readLine());
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.y));
        PriorityQueue<Node> q2 = new PriorityQueue<>(Comparator.comparingInt(o -> o.x));
        PriorityQueue<Node> q1 = new PriorityQueue<>(Comparator.comparingInt((Node o) -> o.y).thenComparingInt(o -> o.x));
        for(int i=0; i< m;i++){
            String[] s = br.readLine().split(" ");
            int t1 = Integer.parseInt(s[0]);
            int t2 = Integer.parseInt(s[1]);
            if(t1>=t2) q2.add(new Node(t1,t2));
            q.add(new Node(t1,t2));
        }
        int time=1;
        int ans=0;
        HashSet<Integer> set = new HashSet<Integer>();
        while(!q.isEmpty() || !q1.isEmpty() || !q2.isEmpty()){
            while(!q.isEmpty() && q.peek().y <=time){
                q1.add(q.poll());
            }
            while(!q2.isEmpty() && set.contains(q2.peek().x)){
                q2.poll();
            }
            while(!q1.isEmpty() && set.contains(q1.peek().x)){
                q1.poll();
            }
            if(!q2.isEmpty() && q2.peek().x == time){
                Node o = q2.poll();
                set.add(o.x);
                ans = Math.max(ans, time - o.y);
                time++;
                continue;
            }
            if(!q1.isEmpty()){
                Node node = q1.poll();
                set.add(node.x);
                ans = Math.max(ans, time - node.y);
            }
            time++;
        }
        System.out.println(ans);
    }
}
class Node{
    int x,y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
