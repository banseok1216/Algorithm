    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.*;
    import java.util.*;
    import java.lang.*;


    class Node  {
        int x,y;
        long r;

        public Node(int x,int y,long r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }
    class Main {
        static int m,n;
        static long max;
        static ArrayList<ArrayList<Node>> list = new ArrayList<>();
        static long[][] arr, v;
        static int[] parent;
        static boolean[][] check;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str1 = br.readLine().split(" ");
            m= Integer.parseInt(str1[0]);
            n= Integer.parseInt(str1[1]);
            int K = Integer.parseInt(str1[2]);
            v = new long[m+1][K+1];
            check = new boolean[m+1][K+1];
            for(int i=0; i<m+1; i++){
                list.add(new ArrayList<>());
            }
            for(int i=1; i<m+1;i++){
                Arrays.fill(v[i],Long.MAX_VALUE);
            }
            v[1][0]=0;
            PriorityQueue<Node> pq = new PriorityQueue<>((Comparator.comparingLong(o -> o.r)));
            for(int i=0; i<n; i++){
                String[] str2 = br.readLine().split(" ");
                list.get(Integer.parseInt(str2[0])).add(new Node(Integer.parseInt(str2[1]),0,Integer.parseInt(str2[2])));
                list.get(Integer.parseInt(str2[1])).add(new Node(Integer.parseInt(str2[0]),0,Integer.parseInt(str2[2])));
            }
            pq.add(new Node(1,0,0));
            while(!pq.isEmpty()){
                Node node = pq.poll();
                if(!check[node.x][node.y]) {
                    check[node.x][node.y] = true;
                    for (int i = 0; i < list.get(node.x).size(); i++) {
                        if (node.y <= K && v[list.get(node.x).get(i).x][node.y] > v[node.x][node.y] + list.get(node.x).get(i).r) {
                            v[list.get(node.x).get(i).x][node.y] = v[node.x][node.y] + list.get(node.x).get(i).r;
                            pq.add(new Node(list.get(node.x).get(i).x, node.y, v[list.get(node.x).get(i).x][node.y]));
                        }
                        if (node.y + 1 <= K && v[list.get(node.x).get(i).x][node.y + 1] > v[node.x][node.y]) {
                            v[list.get(node.x).get(i).x][node.y + 1] = v[node.x][node.y];
                            pq.add(new Node(list.get(node.x).get(i).x, node.y + 1,  v[list.get(node.x).get(i).x][node.y + 1]));
                        }
                    }
                }
            }
            max = Long.MAX_VALUE;
            for(int i=0; i<=K;i++){
                max = Math.min(max,v[(int) m][i]);
            }
            System.out.println(max);
        }
    }