import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node implements Comparable<Node>{
    int r,x,y;
    public Node(int x,int y,int r){
        this.x = x;
        this.y = y;
        this.r = r;
    }

    @Override
    public int compareTo(Node o) {
        return this.r-o.r;
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
    static int[][] result;
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
    static int[] parents;
    static ArrayList<Node> T;
    static ArrayList<int[]> list = new ArrayList<>();
    static ArrayList<Node> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        String[] str1 = br.readLine().split(" ");
        m = Integer.parseInt(str1[0]);
        n = Integer.parseInt(str1[1]);
        parents=new int[m+1];
        for(int i=0; i<m+1; i++){
            parents[i] = i;
        }
        T = new ArrayList<>();
        for(int i=0; i<n; i++){
            String[] str2= br.readLine().split(" ");
            int start = Integer.parseInt(str2[0]);
            int end = Integer.parseInt(str2[1]);
            int weight = Integer.parseInt(str2[2]);
            T.add(new Node(start,end,weight));
        }
        Collections.sort(T);
        p=0;
        for(int i=0; i<n;i++){
            int cost = T.get(i).r;
            int a = T.get(i).x;
            int b = T.get(i).y;
            if(find(a) != find(b)){
                unionSet(a,b);
                max = Math.max(cost,max);
                p+=cost;
            }
        }
        System.out.println(p);
    }
    private static int find(int x){
        if(x==parents[x]) return x;
        return parents[x] = find(parents[x]);
    }
    private static void unionSet(int a, int b) {
        a=find(a);
        b=find(b);
        if(a < b) parents[b] = a;
        else parents[a] = b;
    }

}