import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    static StringBuilder stringBuilder = new StringBuilder();
    static int[] treeArray_1;
    static char[] treeArray_2;
    static int[] abc;
    static int max = 0;
    static int min =1000000000;
    static boolean[] visited;
    static long[][] dp;
    static int K=0;
    static int p;
    static int q;
    static Queue<Integer> Queue = new LinkedList<Integer>();
    static Deque<Integer> deque1 = new ArrayDeque<Integer>();
    static Deque<Integer> deque2 = new ArrayDeque<Integer>();
    static String [][] list;
    static Stack<Integer> stack = new Stack<Integer>();
    static Queue<int []> queue = new LinkedList<int[]>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        String str1 = br.readLine();
        int k[][] = new int[26][str1.length()+1];
        int m = Integer.parseInt(br.readLine());

        for (int i=1; i<str1.length()+1; i++){
            char c = str1.charAt(i-1);
            for(int j=0; j<26; j++){
                if(i==1){
                    if(c - 97 == j){
                        k[j][i] = 1;
                    }
                    else {
                        k[j][i] = 0;
                    }
                }
                else if(c - 97 == j) {
                    k[c - 97][i] = k[c - 97][i-1] + 1;
                }
                else{
                    k[j][i] = k[j][i-1];
                }
            }
        }
        for(int i=0; i<m; i++){
            String[] str2 = br.readLine().split(" ");
            int s;
            if(Integer.parseInt(str2[1]) ==0){
                s = k[str2[0].charAt(0)-97][Integer.parseInt(str2[2])+1];
            }
            else {
                s = k[str2[0].charAt(0) - 97][Integer.parseInt(str2[2])+1] - k[str2[0].charAt(0) - 97][Integer.parseInt(str2[1])];
            }
            stringBuilder.append(s).append("\n");
        }
        System.out.println(stringBuilder);
        bw.close();
        br.close();
    }
}