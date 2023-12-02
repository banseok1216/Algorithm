import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node implements Comparable<Node>{
    int i,w;
    public Node(int i,int w){
        this.i = i;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return o.w - this.w;
    }
}
public class Main {
    static StringBuilder stringBuilder = new StringBuilder();
    static int[][] treeArray_1;
    static int[][] treeArray_2;
    static int[] abc;
    static int max = 0;
    static int min = Integer.MAX_VALUE;
    static boolean[][] visited;
    static String[] result;
    static int[][] v;
    static boolean[] check;
    static String K = "YES";
    static int R = Integer.MAX_VALUE;
    static int p = 0;
    static int q = 0;
    static ArrayList<Node> person;
    static ArrayList<Node> chicken;
    static LinkedList<Integer> list1 = new LinkedList<>();
    static Deque<Integer> deque1 = new ArrayDeque<Integer>();
    static Deque<Integer> deque2 = new ArrayDeque<Integer>();
    static int[] list2;
    static int[] list3;
    static int[][] list4;
    static Stack<String> stack = new Stack<>();
    static Stack<String> stack1 = new Stack<>();
    static Queue<ArrayList<String>> queue1 = new LinkedList<ArrayList<String>>();
    static Queue<Integer> queue2 = new LinkedList<Integer>();
    static HashSet<Integer> ok = new HashSet<>();
    static ArrayList<ArrayList<Node>> graph;
    static ArrayList<String> list = new ArrayList<>();
    static ArrayList<String> strings = new ArrayList<>();
    static String[] stringlist;
    static int[] second;
    static long count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Node> priorityQueue1 = new PriorityQueue<>();
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>();
        Queue<Node> priorityQueue3 = new LinkedList<>();
        String[] str1 = br.readLine().split(" ");
        int m = Integer.parseInt(str1[0]);
        p=m;
        int n = Integer.parseInt(str1[1]);
        q=n;
        v= new int[m][n];
        visited=new boolean[m][n];
        list2 = new int[]{1,-1,0,0};
        list3 = new int[]{0,0,1,-1};
        list4 = new int[4][2];
        for(int i=0; i<m; i++){
            String[] str2 = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                v[i][j] = Integer.parseInt(str2[j]);
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dfs(i,j,0);
            }
        }
        System.out.println(max);
    }
    private static void dfs(int startx, int starty, int index){
        if(index == 4){
            count=0;
            for(int i=0; i<list4.length; i++){
                count += v[list4[i][0]][list4[i][1]];
            }
            max = (int) Math.max(count,max);
            return;
        }
        list4[index][0] = startx;
        list4[index][1] = starty;
        if(index==2){
            for(int i=0; i<4; i++) {
                int nx = list4[index-1][0] + list2[i];
                int ny = list4[index-1][1] + list3[i];
                if(nx>=0 && nx<p && ny>=0 && ny<q){
                    if(!(list4[index-2][0] == nx && list4[index-2][1] == ny) && !(list4[index][0] == nx && list4[index][1] == ny) ){
                        dfs(nx, ny, index + 1);
                    }
                }
            }
        }
        for(int i=0; i<4; i++){
            int nx =startx+list2[i];
            int ny =starty+list3[i];
            if(nx>=0 && nx<p && ny>=0 && ny<q){
                if(index==0) {
                    dfs(nx, ny, index + 1);
                }
                else if(!(list4[index-1][0] == nx &&list4[index-1][1] == ny)){
                    dfs(nx, ny, index + 1);
                }
            }
        }
    }
}