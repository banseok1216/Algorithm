import java.io.*;
import java.util.*;
import java.lang.*;
class Solution {
    static boolean[][] visited;
    static int count;
    static int max;
    static int check;
    public int[] solution(int m, int n, int[][] picture) {
        count =0;
        max =0;
        check =0;
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && picture[i][j] != 0){
                    bfs(i,j,picture);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea,check);
                }
            }
        }
        numberOfArea = count;
    
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    private static void bfs(int m, int n, int[][] picture){
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{m,n});
        int[] list1 = new int[]{-1,1,0,0};
        int[] list2 = new int[]{0,0,-1,1};
        check =0;
        while(!q.isEmpty()){
            int[] list;
            list = q.poll();
            int x = list[0];
            int y = list[1];
            if(!visited[x][y]){
                check++;
                int color = picture[x][y];
                visited[x][y] = true;
                for(int i=0; i<4; i++){
                    if(x+list1[i] < visited.length && x+list1[i]>=0 && y+list2[i]>=0 && y+list2[i] <visited[0].length){
                        if(picture[x+list1[i]][y+list2[i]] == color){
                            q.offer(new int[]{x+list1[i],y+list2[i]});
                        }
                    }
                }
            }
        }
        count++;
    }
}