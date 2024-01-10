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
    static String[] strarr;
    static int mod = 1000000007;
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
        tree = new long[(int)Math.pow(2, h + 1)];
        for (int i = 0; i < n; i++) v1[i] = Integer.parseInt(br.readLine());
        makemul(0, n- 1, 1);
        for (int i = 0; i < m+k; i++) {
            String[] str3 = br.readLine().split(" ");
            if(Integer.parseInt(str3[0]) == 1){
                long pre = v1[Integer.parseInt(str3[1])-1];
                if(pre == 0){
                    v1[Integer.parseInt(str3[1])-1] = Integer.parseInt(str3[2]);
                    makemul(0,n-1,1);
                }
                else {
                    update(0, n - 1, 1, Integer.parseInt(str3[1]) - 1, pre, Integer.parseInt(str3[2]));
                    v1[Integer.parseInt(str3[1]) - 1] = Integer.parseInt(str3[2]);
                }
            }
            else{
                int left = Integer.parseInt(str3[1])-1;
                int right = Integer.parseInt(str3[2])-1;
                long ans = pmul(0,n-1,1,left,right);
                sb.append(ans+"\n");
            }
        }
        System.out.println(sb);
    }
    public static long update(int start, int end,int node,int idx,long pre, int cur){
        if (idx < start || idx > end) {
            return tree[node];
        }
        if(start==end) return tree[node] = cur;
        int mid = (start+end)/2;
        return tree[node] = (update(start, mid, node * 2, idx, pre,cur) * update(mid + 1, end, node * 2 + 1, idx, pre,cur)) % mod;
    }
    public static long makemul(int start, int end,int node){
        if(start == end)
            return tree[node] = v1[start];
        else{
            int mid = (start+end)/2;
            return tree[node] = (makemul(start, mid, node*2)*makemul(mid+1, end, node*2+1))%mod;
        }
    }
    public static long pmul(int start, int end, int node, int l, int r) {
        if(r < start || l> end ) return 1;
        if(l <= start && end <= r )return tree[node];
        int mid = (start+end)/2;
        return (pmul(start, mid, node*2, l, r) * pmul(mid+1, end, node*2+1, l, r)) % mod;
    }
}