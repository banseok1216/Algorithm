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
class tree{
    int y,r;
    public tree(int y,int r){
        this.r = r;
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
    static boolean[] visited;
    static String[] result;
    static int[][] v;
    static long check=0;
    static String K = "YES";
    static int R = Integer.MAX_VALUE;
    static int p = 0;
    static int q = 0;
    static int m;
    static int n;
    static int[] list2;
    static int[] list3;
    static int[][] list4;
    static Stack<long[]> stack = new Stack<>();
    static Stack<String> stack1 = new Stack<>();
    static Queue<ArrayList<String>> queue1 = new LinkedList<ArrayList<String>>();
    static LinkedList<tree> queue = new LinkedList<tree>();
    static PriorityQueue<Node> queue3 = new PriorityQueue<Node>();
    static HashSet<Integer> ok = new HashSet<>();
    static ArrayList<ArrayList<tree>> graph;
    static ArrayList<int[]> list = new ArrayList<>();
    static ArrayList<String> strings = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        list2=new int[m];
        for(int i=0; i<m; i++){
            list2[i] = i;
        }
        for(int i=0; i<m; i++) {
            String[] str1 = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                if(Integer.parseInt(str1[j]) == 1){
                    union(i,j);
                }
            }
        }
        String[] str2 = br.readLine().split(" ");
        int start = Integer.parseInt(str2[0])-1;
        boolean check = true;
        for(int i=1; i<n;i++){
            if(find(start) != find(Integer.parseInt(str2[i])-1)){
                check=false;
                break;
            }
        }
        if(check) System.out.println("YES");
        if(!check) System.out.println("NO");
    }
    private static void union(int x, int y){
        x= find(x);
        y= find(y);
        if(x==y) return;
        if(x<y) list2[y] = x;
        else list2[x] = y;
    }
    private static int find(int x){
        if(list2[x] != x){
            list2[x]=find(list2[x]);
        }
        return list2[x];
    }
}