    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.*;
    import java.util.*;
    import java.lang.*;


    class Node implements Comparable<Node> {
        int x;
        int r;

        public Node(int x, int r) {
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
        static int[] arr, v;
        static boolean[][] check;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int K = Integer.parseInt(br.readLine());
            for (int i = 0; i < K; i++){
                m = Integer.parseInt(br.readLine());
                v = new int[m+1];
                check = new boolean[m+1][m+1];
                String[] str1 = br.readLine().split(" ");
                for(int j=0; j<str1.length; j++){
                    for(int l=j+1; l<m && l!=j; l++){
                        check[Integer.parseInt(str1[j])][Integer.parseInt(str1[l])] = true;
                        v[Integer.parseInt(str1[l])]++;
                    }
                }
                n= Integer.parseInt(br.readLine());
                for(int j=0; j<n; j++){
                    String[] str2 = br.readLine().split(" ");
                    if(check[Integer.parseInt(str2[0])][Integer.parseInt(str2[1])]){
                        v[Integer.parseInt(str2[1])]--;
                        v[Integer.parseInt(str2[0])]++;
                    }
                    if(check[Integer.parseInt(str2[1])][Integer.parseInt(str2[0])]){
                        v[Integer.parseInt(str2[1])]++;
                        v[Integer.parseInt(str2[0])]--;
                    }
                    check[Integer.parseInt(str2[0])][Integer.parseInt(str2[1])] = !check[Integer.parseInt(str2[0])][Integer.parseInt(str2[1])];
                    check[Integer.parseInt(str2[1])][Integer.parseInt(str2[0])] = !check[Integer.parseInt(str2[1])][Integer.parseInt(str2[0])];
                }
                Queue<Integer> q = new LinkedList<>();
                for(int j=1; j<=m; j++){
                    if(v[j] == 0){
                        q.add(j);
                    }
                }
                if(q.isEmpty()){
                    System.out.println("IMPOSSIBLE");
                }
                else{
                    int count =0;
                    StringBuilder st = new StringBuilder();
                    boolean avail = false;
                    while(!q.isEmpty()){
                        int b = q.poll();
                        count++;
                        st.append(b+" ");
                        if(count ==m){
                            avail = true;
                        }
                        for(int k=1; k<m+1;k++){
                            if(check[b][k]){
                                check[b][k] = false;
                                v[k]--;
                                if(v[k] ==0){
                                    q.add(k);
                                }
                            }
                        }
                    }
                    if(!avail){
                        System.out.println("IMPOSSIBLE");
                    }
                    else{
                        System.out.println(st);
                    }
                }

            }
        }
    }