import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node  {
    int x,y;
    long r;

    public Node(int x,int y,long r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
}
class Main {
    static int m,n;
    static long max;
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static ArrayList<Integer> ans = new ArrayList<>();
    static long[][] v;
    static long[] parent,arr;
    static StringBuilder sb = new StringBuilder();
    static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(" ");
        m= Integer.parseInt(str1[0]);
        n= Integer.parseInt(str1[1]);
        int K = Integer.parseInt(str1[2]);
        String[] str2 = br.readLine().split(" ");
        int start = Integer.parseInt(str2[0]);
        int end = Integer.parseInt(str2[1]);
        for(int i=0; i<m+1;i++) list.add(new ArrayList<Node>());
        for(int i=0; i<n;i++){
            String[] str3 = br.readLine().split(" ");
            list.get(Integer.parseInt(str3[0])).add(new Node(Integer.parseInt(str3[1]),0,Integer.parseInt(str3[2])));
            list.get(Integer.parseInt(str3[1])).add(new Node(Integer.parseInt(str3[0]),0,Integer.parseInt(str3[2])));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(node -> node.r));
        pq.add(new Node(start,0,0));
        v = new long[m+1][m+1];
        check = new boolean[m+1][m+1];
        arr = new long[m+1];
        Arrays.fill(arr,-1);
        for(int i=0; i<m+1; i++){
            Arrays.fill(v[i],Integer.MAX_VALUE);
        }
        v[0][start] =0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(node.x == end){
                if(arr[node.y] == -1 || arr[node.y]>node.r) arr[node.y] = node.r;
            }
            if(node.y == m){
                continue;
            }
            else {
                if(!check[node.y][node.x]) {
                    check[node.y][node.x] = true;
                    for (int i = 0; i < list.get(node.x).size(); i++) {
                        int nxt = list.get(node.x).get(i).x;
                        long nxtdistance = list.get(node.x).get(i).r;
                        if (v[node.y + 1][nxt] > v[node.y][node.x] + nxtdistance && !check[node.y + 1][nxt]) {
                            v[node.y + 1][nxt] = v[node.y][node.x] + nxtdistance;
                            pq.add(new Node(nxt, node.y + 1, nxtdistance + node.r));
                        }
                    }
                }
            }
        }
        max = Integer.MAX_VALUE;
        for(int i=0; i<m+1; i++){
            if(arr[i] != -1){
                max = Math.min(arr[i],max);
            }
        }
        sb.append(max).append("\n");
        for(int j=0; j<K; j++){
            max = Integer.MAX_VALUE;
            int r = Integer.parseInt(br.readLine());
            for(int i=0; i<m+1; i++){
                if(arr[i] != -1){
                    arr[i] += r*i;
                    max = Math.min(arr[i],max);
                }
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}