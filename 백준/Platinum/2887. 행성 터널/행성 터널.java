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
    int x,y,r,c;
    public tree(int c,int x,int y,int r){
        this.x = x;
        this.y = y;
        this.r= r;
        this.c= c;
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
    static int[][] list2;
    static int[] list3;
    static int[] list4;
    static int[] parents;
    static ArrayList<Node> T = new ArrayList<>();
    static ArrayList<int[]> list = new ArrayList<>();
    static ArrayList<tree> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        m= Integer.parseInt(br.readLine());
        parents = new int[m+1];
        for(int i=0; i<m+1; i++){
            parents[i] = i;
        }
        for(int i=0; i<m; i++) {
            String[] str1 = br.readLine().split(" ");
            ans.add(new tree(i,Integer.parseInt(str1[0]),Integer.parseInt(str1[1]),Integer.parseInt(str1[2])));
        }
        Collections.sort(ans, Comparator.comparingInt(o -> o.x));
        for(int j=1; j<m; j++) {
            tree p1 = ans.get(j-1);
            tree p2 = ans.get(j);
            int dis = Math.abs(p1.x-p2.x);
            T.add(new Node(p1.c,p2.c,dis));
        }
        Collections.sort(ans, Comparator.comparingInt(o -> o.y));
        for(int j=1; j<m; j++) {
            tree p1 = ans.get(j-1);
            tree p2 = ans.get(j);
            int dis = Math.abs(p1.y-p2.y);
            T.add(new Node(p1.c,p2.c,dis));
        }
        Collections.sort(ans, Comparator.comparingInt(o -> o.r));
        for(int j=1; j<m; j++) {
            tree p1 = ans.get(j-1);
            tree p2 = ans.get(j);
            int dis = Math.abs(p1.r-p2.r);
            T.add(new Node(p1.c,p2.c,dis));
        }
        Collections.sort(T);
        check=0;
        for(int i=0; i<T.size(); i++){
            int z = T.get(i).x;
            int c = T.get(i).y;
            if(find(z) != find(c)){
                unionSet(z,c);
                check+=T.get(i).r;
            }
        }
        System.out.println(check);
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