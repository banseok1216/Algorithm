import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node implements Comparable<Node>{
    int r,x,y;
    public Node(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Node o) {
        return this.x-o.x;
    }
}
class tree{
    int x,y;
    public tree(int x,int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static StringBuilder stringBuilder = new StringBuilder();
    static boolean abc;
    static int max = 0;
    static int min = Integer.MAX_VALUE;
    static boolean[][] visited;
    static Character[][] result;
    static int[][] v;
    static int check=0;
    static String K = "YES";
    static int R = Integer.MAX_VALUE;
    static int p = 0;
    static int q = 0;
    static int m;
    static int n;
    private int C;
    static int[] list2;
    static int[] list3;
    static int[] list4;
    static ArrayList<ArrayList<tree>> T;
    static ArrayList<int[]> list = new ArrayList<>();
    static ArrayList<Node> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        String[] str1 = br.readLine().split(" ");
        int N = Integer.parseInt(str1[0]);
        int M = Integer.parseInt(str1[1]);
        int K = Integer.parseInt(str1[2]);
        list4=new int[M];
        String[] str2 = br.readLine().split(" ");
        list2=new int[M];
        for(int i=0; i<M; i++){
            list2[i] = Integer.parseInt(str2[i]);
        }
        list4 = new int[M+1];
        for(int i=0; i<M; i++){
            list4[i] = i;
        }
        Arrays.sort(list2);
        String[] str3 = br.readLine().split(" ");
        list3 = new int[K];
        for(int i=0; i<K; i++){
            list3[i] = Integer.parseInt(str3[i]);
        }
        for(int i=0; i<list3.length; i++){
            max= M;
            min= 0;
            while(min<max){
                int mid = (max+min)/2;
                if(list3[i]<list2[mid]){max = mid;}
                else{min = mid+1;}
            }
            int idx = find(min);
            stringBuilder.append(list2[idx]).append("\n");
            union(idx, idx+1,M);
        }
        System.out.println(stringBuilder);
    }
    private static int find(int u){
        if( u == list4[u] )
            return u;
        return list4[u] = find(list4[u]);
    }
    private static void union(int u, int v,int m){
        if( u >= m ) return;
        u = find(u);
        v = find(v);
        list4[u] = v;
    }
}