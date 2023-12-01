import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node {
    int i,w;
    public Node(int i,int w){
        this.i = i;
        this.w = w;
    }
}
public class Main {
    static StringBuilder stringBuilder = new StringBuilder();
    static int[][] treeArray_1;
    static int[][] treeArray_2;
    static int[] abc;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static String[] result;
    static int[][] v;
    static boolean[] check;
    static String K = "YES";
    static int R = Integer.MAX_VALUE;
    static int p = 0;
    static int q = 0;
    static ArrayList<Node> person;
    static ArrayList<Node> chicken;
    static LinkedList<Integer> list1 = new LinkedList<>();
    static Deque<Integer> deque1 = new ArrayDeque<Integer>();
    static Deque<Integer> deque2 = new ArrayDeque<Integer>();
    static int[] list2;
    static Stack<String> stack = new Stack<>();
    static Stack<String> stack1 = new Stack<>();
    static Queue<ArrayList<String>> queue1 = new LinkedList<ArrayList<String>>();
    static Queue<Integer> queue2 = new LinkedList<Integer>();
    static HashSet<Integer> ok = new HashSet<>();
    static ArrayList<ArrayList<Node>> graph;
    static ArrayList<int[]> list = new ArrayList<int[]>();
    static int[] first;
    static int[] second;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        String[] str1 = br.readLine().split(" ");
        int m = Integer.parseInt(str1[0]);
        int n = Integer.parseInt(str1[1]);
        p = m;
        q = n;
        person=new ArrayList<>();
        chicken=new ArrayList<>();
        v = new int[m][m];
        for (int i = 0; i < m; i++) {
            String[] str2 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                v[i][j] = Integer.parseInt(str2[j]);
                if(Integer.parseInt(str2[j]) == 2){
                    chicken.add(new Node(i,j));
                }
                else if(Integer.parseInt(str2[j]) == 1){
                    person.add(new Node(i,j));
                }
            }
        }
        dfs(0,0);
        System.out.println(min);
    }

    private static void dfs(int start ,int index) {
        if (index == chicken.size()-q) {
            count = 0;
            for (int i = 0; i < person.size(); i++) {
                int temp = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (v[chicken.get(j).i][chicken.get(j).w] == 2) {
                        int a = Math.abs(person.get(i).i - chicken.get(j).i) + Math.abs(person.get(i).w - chicken.get(j).w);
                        temp = Math.min(temp, a);
                    }
                }
                count += temp;
            }
            min = Math.min(min, count);
        }
        for (int i = start; i < chicken.size(); i++) {
                v[chicken.get(i).i][chicken.get(i).w] = 0;
                dfs(i + 1, index + 1);
                v[chicken.get(i).i][chicken.get(i).w] = 2;
            }
    }
}