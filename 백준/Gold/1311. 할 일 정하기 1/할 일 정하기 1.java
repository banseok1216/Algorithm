import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;

class Main {
    static int m, n, k;
    static int max;
    static ArrayList<Integer> tree = new ArrayList<>();
    static ArrayList<Integer> ans = new ArrayList<>();
    static int[][] v,arr;
    static int[] v1, arr2;
    static String[] strarr;
    static String[] sum;
    static StringBuilder sb = new StringBuilder();
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());
        v= new int[m][m];
        arr = new int[1<<m][m+1];
        for(int i=0; i<(1<<m); i++) Arrays.fill(arr[i],Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            String[] str1 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                v[i][j] = Integer.parseInt(str1[j]);
            }
        }
        int ans=dfs(0,0);
        System.out.println(ans);
    }
    private static int dfs(int count,int bit){
        if(count == m){
            return 0;
        }
        if(arr[bit][count] !=Integer.MAX_VALUE){
            return arr[bit][count];
        }
        for(int i=0; i<m; i++){
            if((bit&(1<<i)) == 0){
                int bitset = bit|(1<<i);
                arr[bit][count] = Math.min(arr[bit][count],v[count][i]+dfs(count+1, bitset));
            }
        }
        return arr[bit][count];
    }
}
