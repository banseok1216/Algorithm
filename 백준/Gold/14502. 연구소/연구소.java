import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    static StringBuilder stringBuilder = new StringBuilder();
    static int[] treeArray_1;
    static int[] treeArray_2;
    static int[] abc;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[][] visited;
    static int[][] v;
    static boolean checkBipartite;
    static String K = "YES";
    static int R = 0;
    static int p = 0;
    static int q = 0;
    static LinkedList<int []> Queue = new LinkedList<int[]>();
    static LinkedList<Integer> list = new LinkedList<>();
    static LinkedList<Integer> list1 = new LinkedList<>();
    static Deque<Integer> deque1 = new ArrayDeque<Integer>();
    static Deque<Integer> deque2 = new ArrayDeque<Integer>();
    static int[] list2;
    static Stack<Integer> stack = new Stack<>();
    static Stack<String> stack1 = new Stack<>();
    static Queue<Integer> queue1 = new LinkedList<Integer>();
    static Queue<Integer> queuey = new LinkedList<Integer>();
    static HashSet<Integer> ok = new HashSet<>();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        String str1[] = br.readLine().split(" ");
        p = Integer.parseInt(str1[0]);
        q = Integer.parseInt(str1[1]);
        v  = new int[p][q];
        visited = new int[p][q];
        for(int i=0; i<p; i++){
            String[] str2 = br.readLine().split(" ");
            for(int j=0; j<q; j++){
                v[i][j] = Integer.parseInt(str2[j]);
            }
        }
        makewall((0));
        if(max <=0){
            System.out.println(0);
        }
        else {
            System.out.println(max);
        }
    }
    private static void makewall(int count){
        if(count ==3){
            R=0;
            for(int i=0; i<p; i++){
                for(int j=0; j<q; j++){
                    visited[i][j] = v[i][j];
                    if(v[i][j] ==2) {
                        Queue.add(new int[]{i,j});
                    }
                }
            }
            bfs();
            for(int i=0; i<p; i++){
                for(int j=0; j<q; j++){
                    if(visited[i][j] ==0) {
                        R+=1;
                    }
                }
            }
            max = Math.max(R,max);
        }
        else{
            for(int i=0; i<p; i++) {
                for (int j = 0; j < q; j++) {
                    if(v[i][j] == 0){
                        v[i][j] =1;
                        makewall(count+1);
                        v[i][j]=0;
                    }
                }
            }
        }
    }
    private static void bfs(){
        int[] x = {-1,1,0,0};
        int[] y = {0,0,-1,1};
        while(!Queue.isEmpty()){
            int[] list;
            list= Queue.poll();
            for(int i=0; i<4; i++){
                if(list[0]+x[i]>=0&&list[1]+y[i]>=0 && list[0]+x[i] <= visited.length-1 && list[1]+y[i] <= visited[0].length-1 && visited[list[0]+x[i]][list[1]+y[i]] == 0){
                    visited[list[0]+x[i]][list[1]+y[i]] = 2;
                    Queue.add(new int[]{list[0]+x[i],list[1]+y[i]});
                }
            }
        }
    }
}