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
    static ArrayList<ArrayList<Node>> graph;
    static ArrayList<int[]> list = new ArrayList<>();
    static ArrayList<String> strings = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        boolean abc = true;
        while(abc) {
            q++;
            String[] str1 = br.readLine().split(" ");
            int m = Integer.parseInt(str1[0]);
            int n = Integer.parseInt(str1[1]);
            if(m==0&n==0){
                abc = false;
                break;
            }
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int j = 0; j < m + 1; j++) {
                list.add(new ArrayList<>());
            }
            for (int i = 0; i < n; i++) {
                String[] str2 = br.readLine().split(" ");
                list.get(Integer.parseInt(str2[0])).add(Integer.parseInt(str2[1]));
                list.get(Integer.parseInt(str2[1])).add(Integer.parseInt(str2[0]));
            }
            HashSet<Integer> set = new HashSet<Integer>();
            int count = 0;
            for (int i = 1; i < m + 1; i++) {
                if (!set.contains(i)) {
                    if (bfs(i, set, list)) {
                        count++;
                    }
                }
            }
            if (count == 0) {
                stringBuilder.append("Case "+q+": No trees.").append("\n");
            }
            if (count == 1) {
                stringBuilder.append("Case "+q+": There is one tree.").append("\n");
            }
            if (count >= 2) {
                stringBuilder.append("Case "+q+": A forest of " + count + " trees.").append("\n");
            }
        }
        System.out.println(stringBuilder);
    }
    private static boolean bfs(int start,HashSet<Integer> set,ArrayList<ArrayList<Integer>> list){
        queue= new LinkedList<tree>();
        queue.add(new tree(0,start));
        while(!queue.isEmpty()){
            tree T = queue.poll();
            if(!set.contains(T.r)) {
                set.add(T.r);
                for (int i = 0; i < list.get(T.r).size(); i++) {
                    int k = list.get(T.r).get(i);
                    if(T.y != k){
                        if(set.contains(k)){
                            return false;
                        }
                        else{
                            queue.add(new tree(T.r,k));
                        }
                    }
                }
            }
        }
        return true;
    }
}