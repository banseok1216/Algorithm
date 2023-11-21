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
    static Stack<String> stack = new Stack<>();
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
        String[] str1 = br.readLine().split("");
        String[] str2 = br.readLine().split("");
        for(int i=0; i<str1.length; i++){
            stack.add(str1[i]);
            int n=0;
                while (!stack.isEmpty() && n != str2.length && Objects.equals(stack.peek(), str2[str2.length - n-1])){
                    stack1.add(stack.pop());
                    n++;
                }
                if(n==str2.length){
                    while (!stack1.isEmpty()) {
                        stack1.pop();
                    }
                }
                else{
                    while (!stack1.isEmpty()) {
                        stack.add(stack1.pop());
                    }
                }
        }
        if(stack.isEmpty()){
            System.out.println("FRULA");
        }
        else {
            v = new String[stack.size()];
            while(!stack.isEmpty()){
                v[stack.size()-1] = stack.pop();
            }
            for(int i=0; i<v.length; i++){
                stringBuilder.append(v[i]);
            }
            System.out.println(stringBuilder);
        }
    }
}