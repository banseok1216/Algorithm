import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] answer = new int[m][n];
        for(int i=0; i< puddles.length; i++){
            answer[puddles[i][0]-1][puddles[i][1]-1] = -1;
        }
        answer[0][0] =1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == m-1 && j==n-1){
                    break;
                }
                if(answer[i][j] == -1){
                    continue;
                }
                if(i==m-1){
                    if(answer[i][j+1] == -1){
                        continue;
                    }
                    answer[i][j+1] += answer[i][j];
                    answer[i][j+1] %=1000000007;
                }
                else if(j==n-1){
                    if(answer[i+1][j] == -1){
                        continue;
                    }
                    answer[i+1][j] += answer[i][j];
                    answer[i+1][j] %=1000000007;
                }
                else{
                    if(answer[i][j+1] != -1){
                        answer[i][j+1] += answer[i][j];
                        answer[i][j+1] %=1000000007;
                    }
                     if(answer[i+1][j] != -1){
                        answer[i+1][j] += answer[i][j];
                         answer[i+1][j] %=1000000007;
                    }
                }
            }
        }
        int ans = 0;
        ans = answer[m-1][n-1];
        return ans;
    }
}