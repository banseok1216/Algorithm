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
    static ArrayList<String> list = new ArrayList<>();
    static ArrayList<String> strings = new ArrayList<>();
    static String[] stringlist;
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
        p=m;
        q=n;
        R=0;
        stringlist = br.readLine().split(" ");
        for(int i=0; i<stringlist.length; i++){
            strings.add(stringlist[i]);
        }
        strings.sort(String::compareTo);
        visited = new boolean[q];

        dfs(0,0);
        list.sort(String::compareTo);
        for(int i=0; i<list.size(); i++){
            stringBuilder.append(list.get(i)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static void dfs(int start ,int index) {
        if(index==p) {
            String s = "";
            int count1 =0;
            int count2 =0;
            for (int i = 0; i < stringlist.length; i++) {
                if (visited[i]) {
                    s +=strings.get(i);
                    if (Objects.equals(strings.get(i), "a") || Objects.equals(strings.get(i), "e") || Objects.equals(strings.get(i), "i") || Objects.equals(strings.get(i), "o") || Objects.equals(strings.get(i), "u")) {
                        count1++;
                    } else {
                        count2++;
                    }
                }
            }
            if(count1>=1 && count2>=2){
                list.add(s);
            }
            return;
        }
        for(int i=start; i<q;i++){
            visited[i] = true;
            dfs(i+1, index+1);
            visited[i] = false;
        }
    }
}