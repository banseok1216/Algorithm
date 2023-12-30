    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.*;
    import java.util.*;
    import java.lang.*;


    class Node implements Comparable<Node>{
        int x;
        int r;
            public Node(int x,int r){
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
        static int[][] arr, v;
        static boolean[] isPrime;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            m = Integer.parseInt(br.readLine());
            arr = new int[m][m];
            v= new int[m][1<<m];
            for(int i=0; i<m; i++){
                String[] str1 = br.readLine().split(" ");
                for(int j=0; j<m; j++){
                    arr[i][j] = Integer.parseInt(str1[j]);
                }
            }
            String[] str2 = br.readLine().split("");
            int bitset=0;
            int count=0;
            for(int i=0; i<str2.length; i++){
                if(str2[i].equals("Y")){
                    bitset|=(1<<i);
                    count++;
                }
            }
            for(int i=0; i<m; i++){
                Arrays.fill(v[i],-1);
            }
            max =Integer.MAX_VALUE;
            n = Integer.parseInt(br.readLine());
            if(count>=n){
                System.out.println(0);
            }
            else {
                dfs(0,count,bitset);
                if (max == Integer.MAX_VALUE) {
                    System.out.println(-1);
                } else {
                    System.out.println(max);
                }
            }
        }
        private static void dfs(int sum,int count, int bit) {
            if(count >= n ){
                max = Math.min(sum,max);
                return;
            }
            if(sum>=max) return;
            for(int i=0; i<m; i++) {
                if((bit &(1<<i)) != 0) {
                    for(int j=0; j<m; j++) {
                        if((i==j) || (bit&(1<<j)) == (1<<j)) continue;
                        int k = bit | (1 << j);
                        if (v[count][k] == -1 || v[count][k] > sum + arr[i][j]) {
                            v[count][k] = sum + arr[i][j];
                            dfs(sum + arr[i][j], count + 1, k);
                        }
                    }
                }
            }
        }
    }