import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node implements Comparable<Node>{
    int Rx,Ry,Bx,By,r,x,y;
    public Node(int y,int r){
        this.r = r;
        this.y = y;
    }

    @Override
    public int compareTo(Node o) {
        return this.r-o.r;
    }
}
public class Main {
    static StringBuilder stringBuilder = new StringBuilder();
    static String[][] v;
    static int[] parent;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        int M = Integer.parseInt(br.readLine());
        parent = new int[M+1];
        visited = new boolean[M+1];
        for(int i=1; i<M+1; i++){parent[i] = i;}
        int N = Integer.parseInt(br.readLine());
        boolean a =true;
        for(int j=0;j<N; j++){
            int k = Integer.parseInt(br.readLine());
            int h = find(k);
            if(h-1 != -1 && a){
                union(h-1,h);
                count++;
            }
            else if (a) {
                a=false;
            }
        }
        System.out.println(count);
    }
    public static void union(int a, int b){
        find(a);
        find(b);
        parent[b] = a;
    }
    public static int find(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}