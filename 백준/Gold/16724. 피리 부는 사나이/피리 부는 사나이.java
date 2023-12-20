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
        String[] str1 = br.readLine().split(" ");
        m = Integer.parseInt(str1[0]);
        n = Integer.parseInt(str1[1]);
        result = new Character[m][n];
        visited = new boolean[m][n];
        list2 = new int[m*n];
        for(int i=0; i<list2.length; i++){
            list2[i] = i;
        }
        for(int i=0; i<m; i++){
            String st2 = br.readLine();
            for(int j=0; j<n; j++){
                result[i][j] = st2.charAt(j);
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    dfs(i,j);
                }
            }
        }
        int r=0;
        check=1;
        HashSet<Integer> set = new HashSet<>();
        set.add(find(list2[0]));
        for(int i=1; i<list2.length;i++) {
            if(!set.contains(find(list2[i]))) {
                set.add(list2[i]);
                check++;
            }
        }
        System.out.println(check);
    }
    private static void dfs(int x, int y){
        if(visited[x][y]){
            return;
        }
        visited[x][y] = true;
        if(result[x][y].equals('D')){
            union(x*n+y,(x+1)*n+y);
            dfs(x+1,y);
            return;
        }
        if(result[x][y].equals('L')){
            union(x*n+y,x*n+y-1);
            dfs(x,y-1);
            return;
        }
        if(result[x][y].equals('R')){
            union(x*n+y,x*n+y+1);
            dfs(x,y+1);
            return;
        }
        if(result[x][y].equals('U')){
            union((x-1)*n+y,x*n+y);
            dfs(x-1,y);
            return;
        }
    }
    private static void union(int x, int y){
        x= find(x);
        y= find(y);
        if(x==y) return;
        if(x<y) {
            list2[y] = x;
        }
        else {list2[x] = y;}
    }
    private static int find(int x){
        if(list2[x] != x){
            list2[x]=find(list2[x]);
        }
        return list2[x];
    }
}