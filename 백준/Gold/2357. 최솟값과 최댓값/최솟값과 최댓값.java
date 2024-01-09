import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;

class Main {
    static int m, n, k, time;
    static int max;
    static ArrayList<Integer> ans = new ArrayList<>();
    static int[][] v, arr;
    static int[] v1, tree1,tree2;
    static String[] strarr;
    static String[] sum;
    static StringBuilder sb = new StringBuilder();
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(" ");
        n = Integer.parseInt(str1[0]);
        m = Integer.parseInt(str1[1]);
        v1 = new int[n];
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        tree1 = new int[(int)Math.pow(2, h + 1)];
        tree2 = new int[(int) Math.pow(2, h + 1)];
        for (int i = 0; i < n; i++) v1[i] = Integer.parseInt(br.readLine());
        makemin(0, n - 1, 1);
        makemax(0, n - 1, 1);
        for (int i = 0; i < m; i++) {
            String[] str3 = br.readLine().split(" ");
            int left = Integer.parseInt(str3[0])-1;
            int right = Integer.parseInt(str3[1])-1;
            int min  =pmin(0, n-1, 1, left, right);
            int max =pmax(0, n-1, 1, left, right);
            sb.append(min+" "+max+"\n");
        }
        System.out.println(sb);
    }
    public static int makemin(int start, int end,int node){
        if(start == end)
            return tree1[node] = v1[start];
        else{
            int mid = (start+end)/2;
            return tree1[node] = Math.min(makemin(start, mid, node*2),makemin(mid+1, end, node*2+1));
        }
    }
    public static int makemax(int start, int end,int node){
        if(start == end)
            return tree2[node] = v1[start];
        else{
            int mid = (start+end)/2;
            return tree2[node] = Math.max(makemax(start, mid, node*2),makemax(mid+1, end, node*2+1));
        }
    }
    public static int pmin(int start, int end, int node, int l, int r) {
        if(r < start || l> end ) return Integer.MAX_VALUE;
        if(l <= start && end <= r )return tree1[node];
        int mid = (start+end)/2;
        return Math.min(pmin(start, mid, node*2, l, r) , pmin(mid+1, end, node*2+1, l, r));
    }
    public static int pmax(int start, int end, int node, int l, int r) {
        if(r < start || l> end ) return 0;
        if(l <= start && end <= r )return tree2[node];
        int mid = (start+end)/2;
        return Math.max(pmax(start, mid, node*2, l, r) , pmax(mid+1, end, node*2+1, l, r));
    }
}