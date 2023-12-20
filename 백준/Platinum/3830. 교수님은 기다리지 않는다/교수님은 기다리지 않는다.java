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
        while(true) {
            String[] str1 = br.readLine().split(" ");
            m = Integer.parseInt(str1[0]);
            n = Integer.parseInt(str1[1]);
            if(m==0 && n==0){
                break;
            }
            list2 = new int[m+1][2];
            for(int i=0; i<m+1; i++){
                list2[i][0] = i;
            }
            for(int i=0; i<n; i++){
                String[] str2 = br.readLine().split(" ");
                    if(str2[0].equals("!")){
                        union(Integer.parseInt(str2[1]),Integer.parseInt(str2[2]),Integer.parseInt(str2[3]));
                    }
                    if(str2[0].equals("?")) {
                        if(find(Integer.parseInt(str2[1])) != find(find(Integer.parseInt(str2[2])))){
                            stringBuilder.append("UNKNOWN").append("\n");
                        }
                        else{
                            int answer = list2[Integer.parseInt(str2[2])][1] - list2[Integer.parseInt(str2[1])][1];
                            stringBuilder.append(answer).append("\n");
                    }
                }
            }
        }
        System.out.println(stringBuilder);
    }
    private static void union(int x, int y,int w){
        int rootx= find(x);
        int rooty= find(y);
        if(rooty==rootx) return;
        list2[rooty][0] = rootx;
        list2[rooty][1] += (w+list2[x][1]-list2[y][1]);
    }
    private static int find(int x){
        if(list2[x][0] != x){
            int root=find(list2[x][0]);
            list2[x][1] += list2[list2[x][0]][1];
            list2[x][0] = root;
        }
        return list2[x][0];
    }
}