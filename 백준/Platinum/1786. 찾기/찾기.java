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
    static String[] parent;
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        make_table(str2);
        System.out.println(kmp(str1,str2));
        System.out.println(sb);
    }
    private static void make_table(String str1){
        int n = str1.length();
        arr = new int[n];
        int idx =0;
        for(int i=1; i<n;i++){
            while(idx>0 && str1.charAt(i) != str1.charAt(idx)){
                idx = arr[idx-1];
            }
            if(str1.charAt(i) == str1.charAt(idx)) {
                arr[i] = ++idx;
            }
        }
    }
    private static int kmp(String str1, String str2){
        int count =0;
        int parentlength = str1.length();
        int patternlength = str2.length();
        int idx =0;
        for(int i=0; i<parentlength; i++){
            while(idx>0 && str1.charAt(i) != str2.charAt(idx)){
                idx = arr[idx-1];
            }
            if(str1.charAt(i) == str2.charAt(idx)){
                if(idx == patternlength-1){
                    count++;
                    sb.append(i - idx + 1).append(" ");
                    idx = arr[idx];
                }
                else{
                    idx++;
                }
            }
        }
        return count;
    }
}