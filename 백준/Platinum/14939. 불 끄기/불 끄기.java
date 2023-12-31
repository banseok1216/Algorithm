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
        static boolean[][] arr, v;
        static int[] parent;
        static boolean[][] check;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            check = new boolean[10][10];
            max = Integer.MAX_VALUE;
            for(int i=0; i<10; i++){
                String[] str1 = br.readLine().split("");
                for(int j=0; j<10; j++){
                    if(str1[j].equals("O")){
                        check[i][j] = true;
                    }
                }
            }
            for(int k=0; k<1024; k++){
                int count =0;
                boolean[][] board;
                board = copy(check);
                for(int i=0; i<10; i++){
                    if((k&(1<<i)) != 0){
                        press(0,i,board);
                        count++;
                    }
                }
                for(int i=1; i<10;i++){
                    for(int j=0; j<10; j++){
                        if(board[i-1][j]){
                            press(i,j,board);
                            count++;
                        }
                    }
                }
                boolean avail = true;
                for(int i=0; i<10; i++){
                    if(board[9][i]){
                        avail = false;
                    }
                }
                if(avail){
                    max=  Math.min(count,max);
                }
            }
            if(max== Integer.MAX_VALUE){
                System.out.println(-1);
            }
            else{
                System.out.println(max);
            }
        }
        private static boolean[][] copy(boolean[][] board2){
            boolean[][] board1 = new boolean[10][10];
            for(int i=0; i<10; i++){
                for(int j=0; j<10; j++){
                    board1[i][j] = board2[i][j];
                }
            }
            return board1;
        }
        private static void press(int x, int y,boolean[][] b){
            int[] dy = new int[]{0, 0, 1, 0, -1};
            int[] dx = new int[]{0, 1, 0, -1, 0};
            for(int i=0; i<5; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && ny>=0 && nx<10 && ny<10){
                    b[nx][ny] = !b[nx][ny];
                }
            }
        }
    }