import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node implements Comparable<Node>{
    int Rx,Ry,Bx,By,r,x,y;
    public Node(int y,int r){
        this.r = r;
        this.y = y;
    }

    @Override
    public int compareTo(Node o) {
        return this.r-o.r;
    }
}
public class Main {
    static StringBuilder stringBuilder = new StringBuilder();
    static String[][] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        int z = Integer.parseInt(br.readLine());
        for(int x = 0; x<z;x++) {
            String[] str1 = br.readLine().split(" ");
            int M = Integer.parseInt(str1[0]);
            int N = Integer.parseInt(str1[1]);
            v = new String[M][N];
            boolean[][] visited = new boolean[M][N];
            int count = 0;
            ArrayList<ArrayList<int[]>> list = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                list.add(new ArrayList<>());
            }
            HashSet<Integer> set = new HashSet<>();
            Queue<int[]> q = new LinkedList<>();
            for (int i = 0; i < M; i++) {
                String[] str2 = br.readLine().split("");
                for (int j = 0; j < N; j++) {
                    if (i == 0 || i == M - 1 || j == 0 || j == N - 1) {
                        if (!str2[j].equals("*") && !str2[j].equals(".")) {
                            int m = str2[j].charAt(0);
                            if (m >= 65 && m <= 90) {
                                list.get(m - 65).add(new int[]{i, j});
                            }
                            if (m >= 97 && m <= 122) {
                                set.add(m - 97);
                                q.add(new int[]{i, j});
                            }
                        }
                        if (str2[j].equals(".")) {
                            q.add(new int[]{i, j});
                        }
                        if (str2[j].equals("$")) {
                            q.add(new int[]{i, j});
                        }
                    }
                    v[i][j] = str2[j];
                }
            }
            String str3 = br.readLine();
            if(!str3.equals("0")) {
                for (int i = 0; i < str3.length(); i++) {
                    set.add(str3.charAt(i) - 97);
                }
            }
            for (int m : set) {
                for (int j = 0; j < list.get(m).size(); j++) {
                    if (!visited[list.get(m).get(j)[0]][list.get(m).get(j)[1]]) {
                        q.add(new int[]{list.get(m).get(j)[0], list.get(m).get(j)[1]});
                    }
                }
            }
            int[] listx = new int[]{0, 0, -1, 1};
            int[] listy = new int[]{-1, 1, 0, 0};
            while (!q.isEmpty()) {
                int[] abc = q.poll();
                if (!visited[abc[0]][abc[1]]) {
                    visited[abc[0]][abc[1]] = true;
                    if (v[abc[0]][abc[1]].equals("$")) {
                        count++;
                    }
                    for (int i = 0; i < 4; i++) {
                        int nx = listx[i] + abc[0];
                        int ny = listy[i] + abc[1];
                        if (nx >= 0 && nx < M && ny >= 0 && ny < N && !v[nx][ny].equals("*") && !visited[nx][ny]) {
                            if (!v[nx][ny].equals(".") && !v[nx][ny].equals("$")) {
                                int m = v[nx][ny].charAt(0);
                                if (m >= 65 && m <= 90) {
                                    if (set.contains(m - 65)) {
                                        q.add(new int[]{nx, ny});
                                    } else {
                                        list.get(m - 65).add(new int[]{nx, ny});
                                    }
                                }
                                if (m >= 97 && m <= 122) {
                                    q.add(new int[]{nx, ny});
                                    set.add(m - 97);
                                    for (int j = 0; j < list.get(m - 97).size(); j++) {
                                        if (!visited[list.get(m - 97).get(j)[0]][list.get(m - 97).get(j)[1]]) {
                                            q.add(new int[]{list.get(m - 97).get(j)[0], list.get(m - 97).get(j)[1]});
                                        }
                                    }
                                }
                            } else {
                                q.add(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
            stringBuilder.append(count).append("\n");
        }
        System.out.println(stringBuilder);
    }
}