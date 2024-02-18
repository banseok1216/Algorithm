import java.util.*;

class Solution {
    static int[] inputInfo;
    static int[] answer;
    static int total=0;

    public static int[] solution(int n, int[] info) {
        inputInfo = info;
        answer = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        dfs(0, n, new int[11]);
        if (answer[0] == -1) {
            return new int[]{-1};
        }
        return answer;
    }

    public static void dfs(int cur, int n, int[] points) {
        if (cur == n) {
            int R = 0;
            int A = 0;
            for (int i = 0; i < points.length; i++) {
                if (points[i] > inputInfo[i]) {
                    R += (10 - i);
                } else {
                    if (points[i] == 0 && inputInfo[i] == 0) {
                        continue;
                    } else {
                        A += (10 - i);
                    }
                }
            }
            if (R > A) {
                if (answer[0] == -1) {
                    for(int i=0; i<points.length; i++){
                        answer[i] = points[i];
                        total = R-A;
                    }
                } else {
                    if(total>R-A){
                        return;
                    }
                    if(total<R-A){
                        for(int i=0; i<points.length; i++){
                            answer[i] = points[i];
                            total = R-A;
                        }
                        return;
                    }
                    for (int i = 10; i >= 0; i--) {
                        if (answer[i] > points[i]) {
                            break;
                        }
                        if (answer[i] < points[i]) {
                            for(int j=0; j<points.length; j++){
                                answer[j] = points[j];
                            }
                            break;
                        }
                    }
                }
            }
            return;
        }
        for (int i = 0; i < 11; i++) {
            if(points[i] <  inputInfo[i] && cur+inputInfo[i]+1 <=n){
                points[i] += inputInfo[i]+1;
                dfs(cur+inputInfo[i]+1, n, points);
                points[i] -= inputInfo[i]+1;
            }
            else{
                if(points[i] == inputInfo[i]){
                    points[i]++;
                    dfs(cur + 1, n, points);
                    points[i]--;
                }
                else{
                    points[n]+= n-cur;
                    dfs(n, n, points);
                    points[n]-= n-cur;
                }
            }
        }
    }
}