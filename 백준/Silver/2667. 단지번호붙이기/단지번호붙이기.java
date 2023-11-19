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
    static long min = Long.MAX_VALUE;
    static boolean[][] visited;
    static int[][] v;

    static int K = 0;
    static int R = 0;
    static int p = 0;
    static int q = 0;
    static Queue<Integer> Queue = new LinkedList<Integer>();
    static Deque<Integer> deque1 = new ArrayDeque<Integer>();
    static Deque<Integer> deque2 = new ArrayDeque<Integer>();
    static int[] list2;
    static Stack<Integer> stack = new Stack<Integer>();
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
//        String str1[] = br.readLine().split(" ");
        p = Integer.parseInt(br.readLine());
        v=new int[p][p];
        visited=new boolean[p][p];
        for(int i=0; i< p; i++){
            String str1[] = br.readLine().split("");
            for(int j=0; j<p; j++){
                v[i][j] = Integer.parseInt(str1[j]);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i< p; i++){
            for(int j=0; j<p; j++){
                if(!visited[i][j] && v[i][j] ==1){
                    visited[i][j] = true;
                    bfs(i,j);
                    list.add(K);
                    K=0;
                }
            }
        }
        list.sort(Comparator.naturalOrder());
        System.out.println(list.size());
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
    private static void bfs(int i,int j){
        Queue.add(i);
        Queue.add(j);
        treeArray_1 = new int[]{1,-1,0,0};
        treeArray_2 = new int[]{0,0,-1,1};
        K = 1;
        while(!Queue.isEmpty()) {
            int k  = Queue.poll();
            int t = Queue.poll();
            for(int s=0; s<4; s++){
                if(k+treeArray_1[s] >=0 && k+treeArray_1[s]<p && t+treeArray_2[s] >=0 && t+treeArray_2[s] <p){
                    if(!visited[k+treeArray_1[s]][t+treeArray_2[s]] && v[k+treeArray_1[s]][t+treeArray_2[s]] ==1){
                        Queue.add(k+treeArray_1[s]);
                        Queue.add(t+treeArray_2[s]);
                        K++;
                        visited[k+treeArray_1[s]][t+treeArray_2[s]]= true;
                    }
                }
            }
        }
    }
}