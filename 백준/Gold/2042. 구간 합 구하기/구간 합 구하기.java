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
    static long[] v1, tree;
    static int mod = 1000003;
    static String[] strarr;
    static String[] sum;
    static StringBuilder sb = new StringBuilder();
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(" ");
        n = Integer.parseInt(str1[0]);
        m = Integer.parseInt(str1[1]);
        k = Integer.parseInt(str1[2]);
        v1 = new long[n];
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        tree = new long[(int) Math.pow(2, h + 1)];
        for (int i = 0; i < n; i++) v1[i] = Long.parseLong(br.readLine());
        makeheap(0, n - 1, 1);
        for (int i = 0; i < m + k; i++) {
            String[] str3 = br.readLine().split(" ");
            int op = Integer.parseInt(str3[0]);
            if (op == 1) {
                int idx = Integer.parseInt(str3[1]) - 1;
                long num = Long.parseLong(str3[2]);
                long dif = num - v1[idx];
                update(0, n - 1, 1, idx, dif);
                v1[idx] = num;
            }
            else {
                int left = Integer.parseInt(str3[1])-1;
                int right = Integer.parseInt(str3[2])-1;
                long sum =pSum(0, n-1, 1, left, right);
                sb.append(sum+"\n");
            }
        }
        System.out.println(sb);
    }
    public static long makeheap(int start, int end,int node){
        if(start == end)
            return tree[node] = v1[start];
        else{
            int mid = (start+end)/2;
            return tree[node] = makeheap(start, mid, node*2) + makeheap(mid+1, end, node*2+1);
        }
    }
    public static long pSum(int start, int end, int node, int l, int r) {
        if(r < start || l> end ) return 0;
        if(l <= start && end <= r )return tree[node];
        int mid = (start+end)/2;
        return pSum(start, mid, node*2, l, r) + pSum(mid+1, end, node*2+1, l, r);
    }
    public static void update(int start, int end, int node, int idx, long dif) {
        if (start <= idx && idx <= end) {
            tree[node] += dif;
        } else return;

        if (start == end) return;

        int mid = (start + end) / 2;
        update(start, mid, node * 2, idx, dif);
        update(mid + 1, end, node * 2 + 1, idx, dif);
    }
}