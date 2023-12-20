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
    static String[] result;
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
        String[] str2 = br.readLine().split(" ");
        ArrayList<Integer> truth = new ArrayList<>();
        for(int i=0; i<Integer.parseInt(str2[0]); i++){
            truth.add(Integer.parseInt(str2[i+1]));
        }
        list2 = new int[m+1];
        for(int i=0; i<m+1;i++){
            list2[i] = i;
        }
        ArrayList<ArrayList<Integer>> group = new ArrayList<>();
        for(int i=0; i<n; i++){
            String[] str3 = br.readLine().split(" ");
            group.add(new ArrayList<>());
            for(int j=0; j<Integer.parseInt(str3[0]); j++){
                group.get(i).add(Integer.parseInt(str3[j+1]));
                if(Integer.parseInt(str3[0]) >=2){
                    union(Integer.parseInt(str3[1]),Integer.parseInt(str3[j+1]));
                }
            }
        }
        check=0;
        for(int i =0; i<group.size(); i++){
            boolean b = true;
            for(int j=0; j<group.get(i).size(); j++){
                for(int k=0; k<truth.size(); k++){
                    if(find(truth.get(k)) == find(group.get(i).get(j))){
                        b= false;
                    }
                }
            }
            if(b){
                check++;
            }
        }
        System.out.println(check);
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