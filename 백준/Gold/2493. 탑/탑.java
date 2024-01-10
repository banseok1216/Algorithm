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
        n = Integer.parseInt(br.readLine());
        String[] str1 = br.readLine().split(" ");
        Stack<Node> stack = new Stack<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(str1[i]);
            while(!stack.isEmpty() && stack.peek().x<=m){
                stack.pop();
            }
            if(!stack.isEmpty() && stack.peek().x>m){
                ans[i] = stack.peek().y+1;
            }
            stack.add(new Node(Integer.parseInt(str1[i]), i));
        }
        for(int i=0; i<n; i++){
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
}
class Node{
    int x;
    int y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}