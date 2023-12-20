import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node implements Comparable<Node>{
    int r,x,y;
    public Node(int x,int y,int r){
        this.x = x;
        this.r = r;
        this.y = y;
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
    static int[][] treeArray_1;
    static int[][] treeArray_2;
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
    static int[][] list2;
    static int[] list3;
    static int[] list4;
    static Stack<long[]> stack = new Stack<>();
    static Stack<String> stack1 = new Stack<>();
    static Queue<ArrayList<String>> queue1 = new LinkedList<ArrayList<String>>();
    static LinkedList<tree> queue = new LinkedList<tree>();
    static PriorityQueue<Node> queue3 = new PriorityQueue<Node>();
    static HashSet<Integer> ok = new HashSet<>();
    static ArrayList<ArrayList<tree>> T;
    static ArrayList<int[]> list = new ArrayList<>();
    static ArrayList<String> strings = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        m = Integer.parseInt(br.readLine());
        T= new ArrayList<>();
        for(int i=0; i<m+1; i++){
            T.add(new ArrayList<>());
        }
        for (int i=0; i<m-1; i++){
            String[] str1 = br.readLine().split(" ");
            int first = Integer.parseInt(str1[0]);
            int second = Integer.parseInt(str1[1]);
            int third = Integer.parseInt(str1[2]);
            T.get(first).add(new tree(second,third));
            T.get(second).add(new tree(first,third));
        }
        p =(int)Math.ceil(Math.log(m)/Math.log(2))+1;
        v = new int[m+1][p];
        list3 = new int[m+1];
        list4 = new int[m+1];
        init(7,1,0);
        fillParents();
        int n = Integer.parseInt(br.readLine());
        for(int j=0; j<n; j++){
            String[] str1 = br.readLine().split(" ");
            int first = Integer.parseInt(str1[0]);
            int second = Integer.parseInt(str1[1]);
            stringBuilder.append(list4[first] + list4[second] -2*list4[LCA(first,second)]).append("\n");
        }
        System.out.println(stringBuilder);
    }
    static void init(int cur, int h, int pa) {
        list3[cur] = h;
        for(tree nxt : T.get(cur)) {
            if(nxt.x!=pa) {
                list4[nxt.x] = list4[cur] + nxt.y;
                init(nxt.x, h+1, cur);
                v[nxt.x][0] = cur;
            }
        }
    }
    static void fillParents() {
        for(int i=1; i<p; i++) {
            for(int j=1; j<m+1; j++) {
                v[j][i] = v[v[j][i-1]][i-1];
            }
        }
    }
    static int LCA(int a, int b) {
        int ah = list3[a];
        int bh = list3[b];

        if(ah < bh) {
            int tmp =a;
            a= b;
            b= tmp;
        }

        for(int i=p-1; i>=0; i--) {
            if(Math.pow(2, i) <= list3[a] - list3[b]) {
                a = v[a][i];
            }
        }

        if(a==b) return a;

        for(int i=p-1; i>=0; i--) {
            if(v[a][i] != v[b][i]) {
                a = v[a][i];
                b = v[b][i];
            }
        }
        return v[a][0];
    }
}