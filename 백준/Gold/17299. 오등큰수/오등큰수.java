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
    static String[] v;

    static int K = 0;
    static int R = 0;
    static int p = 0;
    static int q = 0;
    static Queue<Integer> Queue = new LinkedList<Integer>();
    static Deque<Integer> deque1 = new ArrayDeque<Integer>();
    static Deque<Integer> deque2 = new ArrayDeque<Integer>();
    static int[] list2;
    static Stack<Integer> stack = new Stack<>();
    static Stack<String> stack1 = new Stack<>();
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
        String[] str = br.readLine().split(" ");
        treeArray_1 = new int [m+1];
        treeArray_2 = new int [m];
        list2 = new int [1000001];
        for(int i=0; i<m; i++){
            list2[Integer.parseInt(str[i])]++;
            treeArray_1[i] = (Integer.parseInt(str[i]));
        }
        for(int i=0; i<m; i++) {
            while(!stack.empty() && list2[treeArray_1[i]]>list2[treeArray_1[stack.peek()]]) {
                treeArray_2[stack.pop()] = treeArray_1[i];
            }
            stack.push(i);
        }
        while(!stack.empty()) {
            treeArray_2[stack.pop()] = -1;
        }
        for(int i=0; i<treeArray_2.length; i++){
            stringBuilder.append(treeArray_2[i] + " ");
        }
        System.out.println(stringBuilder);
    }

}
