import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    static StringBuilder stringBuilder = new StringBuilder();
    static int[] treeArray_1;
    static int[] treeArray_2;
    static int[] abc;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] visited;
    static int[] v;

    static int K = 0;
    static int R = 0;
    static int p = 0;
    static int q = 0;
    static Queue<Integer> Queue = new LinkedList<Integer>();
    static Deque<Integer> deque1 = new ArrayDeque<Integer>();
    static Deque<Integer> deque2 = new ArrayDeque<Integer>();
    static int[] list2;
    static Stack<Integer> stack = new Stack<Integer>();
    static Queue<Integer> queue1 = new LinkedList<Integer>();
    static Queue<Integer> queuey = new LinkedList<Integer>();
    static HashSet<Integer> ok = new HashSet<>();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        String[] str1 = br.readLine().split(" ");
        stack.add(0);
        stack.add(Integer.parseInt(str1[0]));
        v=new int[m];
        for (int i=1; i<m; i++){
            if(stack.isEmpty()){
                stack.add(i);
                stack.add(Integer.parseInt(str1[i]));
            }
            else {
                if (stack.peek() >= Integer.parseInt(str1[i])) {
                    stack.add(i);
                    stack.add(Integer.parseInt(str1[i]));
                } else if (stack.peek() < Integer.parseInt(str1[i])) {
                    while (!stack.isEmpty() && stack.peek() < Integer.parseInt(str1[i])) {
                        stack.pop();
                        v[stack.peek()] = Integer.parseInt(str1[i]);
                        stack.pop();
                    }
                    stack.add(i);
                    stack.add(Integer.parseInt(str1[i]));
                }
            }
        }
        while(!stack.isEmpty()){
            stack.pop();
            v[stack.peek()] = -1;
            stack.pop();
        }
        for(int i=0; i<m; i++){
            stringBuilder.append(v[i] + " ");
        }
        System.out.println(stringBuilder);
    }
}