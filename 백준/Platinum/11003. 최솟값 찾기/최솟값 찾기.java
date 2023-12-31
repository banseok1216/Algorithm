    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.*;
    import java.util.*;
    import java.lang.*;


    class Node implements Comparable<Node> {
        int x;
        int r;

        public Node(int x,int r) {
            this.x = x;
            this.r = r;
        }

        @Override
        public int compareTo(Node o) {
            return this.r - o.r;
        }
    }
    class Main {
        static int m,n,max;
        static ArrayList<Integer> list = new ArrayList<>();
        static int[][] arr, v;
        static int[] parent;
        static boolean[][] check;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str1 = br.readLine().split(" ");
            m = Integer.parseInt(str1[0]);
            n = Integer.parseInt(str1[1]);
            String[] str2 = br.readLine().split(" ");
            StringBuilder sb = new StringBuilder();
            ArrayDeque<Integer> dq = new ArrayDeque<>();
            int[] data = new int[m];
            for (int i = 0; i < m; i++) {
                data[i] = Integer.parseInt(str2[i]);
                while (!dq.isEmpty() && data[dq.getLast()] > data[i]) dq.removeLast();
                dq.addLast(i);
                if (!dq.isEmpty() && dq.getFirst() <= i - n) dq.removeFirst();
                sb.append(data[dq.getFirst()]).append(" ");
            }
            System.out.println(sb);
        }
    }