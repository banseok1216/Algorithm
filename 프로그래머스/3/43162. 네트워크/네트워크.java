import java.util.*;
class Solution {
    static boolean[][] visited;
    static int count = 0;
    static boolean[] check;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n][n];
        check = new boolean[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && computers[i][j] == 1)
                    bfs(i,j,computers);
            }
        }
        for(int i=0; i<check.length; i++){
            if(!check[i]){
                count++;
            }
        }
        answer = count;
        return answer;
    }
    private static void bfs(int m, int n, int[][] computers){
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[] {m,n});
        while(!q.isEmpty()){
            int[] list;
            list = q.poll();
            int x = list[0];
            int y = list[1];
            if(!visited[x][y]){
                visited[x][y] = true;
                visited[y][x] = true;
                check[x] = true;
                check[y] = true;
                for(int i=0; i<computers.length; i++){
                    if(computers[x][i] == 1 && !visited[x][i]){
                        q.offer(new int[]{x,i});
                    }
                    if(computers[i][y] == 1 && !visited[i][y]){
                        q.offer(new int[]{i,y});
                    }
                }
            }
        }
        count++;
    }
}