import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node  {
    int x,y;
    long r;

    public Node(int x,int y,long r) {
        this.x = x;
        this.y =y;
        this.r = r;
    }
}
class Main {
    static int m,n,k;
    static int max;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static ArrayList<Integer> ans = new ArrayList<>();
    static long[][] v;
    static int[] v1,arr,arr2;
    static String[] strarr;
    static String[] sum;
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());
        strarr = new String[m];
        for(int i=0; i<m; i++){
            String str2 = br.readLine();
            strarr[i] = str2;
        }
        int k=1;
        for(int i=1; i<=m; i++)k*=i;
        n = Integer.parseInt(br.readLine());
        sum = new String[k];
        check = new boolean[m];
        max =0;
        int count =0;
        permutations(0,"");
        for(int i=0; i<k;i++){
            count+=make_table(sum[i]);
        }
        System.out.println(count);
    }
    private static int make_table(String str1){
        int len = str1.length();
        arr = new int[len];
        int idx =0;
        for(int i=1; i<len;i++){
            while(idx>0 && str1.charAt(i) != str1.charAt(idx)){
                idx = arr[idx-1];
            }
            if(str1.charAt(i) == str1.charAt(idx)) {
                arr[i] = ++idx;
            }
        }
        if(arr[str1.length()-1] % (str1.length()-arr[str1.length()-1]) != 0){
            if(n == 1) return 1;
            else return 0;
        }
        return n-1 == arr[str1.length()-1] / (str1.length()-arr[str1.length()-1]) ? 1 : 0;
    }
    private static void permutations(int count,String s){
        if(count == m){
            sum[max] = s;
            max++;
            return;
        }
        for(int i=0; i<m; i++){
            if(!check[i]) {
                check[i] = true;
                String st = s + strarr[i];
                permutations(count + 1, st);
                check[i] = false;
            }
        }
    }
}