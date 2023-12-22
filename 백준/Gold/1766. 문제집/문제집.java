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
class tree implements Comparable<tree>{
    int x,y;
    public tree(int x,int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(tree o){
        return this.x-o.x;
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
    static int[] list2;
    static int[] list3;
    static int[] list4;
    static int[] parents;
    static ArrayList<Node> T;
    static ArrayList<int[]> list = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        String[] str1 = br.readLine().split(" ");
        m = Integer.parseInt(str1[0]);
        n = Integer.parseInt(str1[1]);
        list2 = new int[m+1];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int j=0; j<m+1; j++){
            ans.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            String[] str2 = br.readLine().split(" ");
            list2[Integer.parseInt(str2[1])]++;
            ans.get(Integer.parseInt(str2[0])).add(Integer.parseInt(str2[1]));
        }
        for(int i=1; i<m+1; i++){
            if(list2[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int a = q.poll();
            stringBuilder.append(a).append(" ");
            for(int j=0;j<ans.get(a).size(); j++){
                list2[ans.get(a).get(j)]--;
                if(list2[ans.get(a).get(j)] ==0){
                    q.add(ans.get(a).get(j));
                }
            }
        }
        System.out.println(stringBuilder);
    }
}