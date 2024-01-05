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
    static int[][] v;
    static int[] v1, arr, arr2;
    static String[] strarr;
    static String[] sum;
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int m =Integer.parseInt(br.readLine());
        v = new int[26][200001];
        for(int i=0; i<s.length(); i++){
            v[s.charAt(i)-'a'][i+1] ++;
        }
        for(int j=1; j<200001; j++){
            for(int i=0; i<26; i++){
                v[i][j] += v[i][j-1];
            }
        }
        for(int i=0; i<m; i++){
            String[] str = br.readLine().split(" ");
            sb.append(v[str[0].charAt(0)-'a'][Integer.parseInt(str[2])+1]-v[str[0].charAt(0)-'a'][Integer.parseInt(str[1])]).append("\n");
        }
        System.out.println(sb);
    }
}
