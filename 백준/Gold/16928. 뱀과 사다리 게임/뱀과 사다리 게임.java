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
        String[] str1= br.readLine().split(" ");
        int m = Integer.parseInt(str1[0]);
        int n = Integer.parseInt(str1[1]);
        v=new int[101];
        treeArray_1= new int[101];
        treeArray_2= new int[101];
        for(int i=1; i<101; i++){
            v[i] = min;
        }

        for(int k=0; k<m; k++) {
            String[] str = br.readLine().split(" ");
            treeArray_1[Integer.parseInt(str[0])] = Integer.parseInt(str[1]);
        }
        for(int k=0; k<n; k++){
            String[] str = br.readLine().split(" ");
            treeArray_2[Integer.parseInt(str[0])] = Integer.parseInt(str[1]);
        }
        v[m] = n;
        Queue.add(1);
        Queue.add(0);
        bfs();
        System.out.println(v[100]);

    }
    private static void bfs(){
        while(!Queue.isEmpty()){
            int m = Queue.poll();
            int n= Queue.poll();
            if(m==1 && treeArray_1[m] !=0){
                Queue.add(treeArray_1[m]);
                Queue.add(n);
            }
            else {
                for (int i = 1; i <= 6; i++) {
                    if (m + i <= 100 && treeArray_1[m + i] != 0 && v[treeArray_1[m + i]] > n + 1) {
                        Queue.add(treeArray_1[m + i]);
                        Queue.add(n + 1);
                    }
                    if (m + i <= 100 && treeArray_2[m + i] != 0 && v[treeArray_2[m + i]] > n + 1) {
                        Queue.add(treeArray_2[m + i]);
                        Queue.add(n + 1);
                    } if (m + i <= 100 && v[m + i] > n + 1 && treeArray_1[m + i] == 0 && treeArray_2[m + i] == 0) {
                        v[m + i] = n + 1;
                        Queue.add(m + i);
                        Queue.add(n + 1);
                    }
                }
            }
        }
    }
}