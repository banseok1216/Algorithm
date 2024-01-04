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
    static long[][] v;
    static int[] v1, arr, arr2;
    static String[] strarr;
    static String[] sum;
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v1 = new int[10001];
        Node root = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            try {
                m = Integer.parseInt(br.readLine());
                root.insert(m);
            } catch (NumberFormatException e) {
                break;
            }
        }
        postOrder(root);
        System.out.println(sb);
    }
    static void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
    }

}
class Node {
    int num;
    Node left, right;

    Node(int num) {
        this.num = num;
    }

    Node(int num, Node left, Node right) {
        this.num = num;
        this.left = left;
        this.right = right;
    }

    void insert(int n) {
        if (n < this.num) {
            if (this.left == null)
                this.left = new Node(n);
            else this.left.insert(n);
        } else {
            if (this.right == null)
                this.right = new Node(n);
            else this.right.insert(n);
        }
    }
}
