import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        boolean[] check = new boolean[routes.length];
        int count =0;
        int flag =0;
        int answer = 0;
        while(count<routes.length){
            flag = routes[count][1];
            while(count<routes.length && flag >= routes[count][0]){
                count++;
            }
            answer++;
        }
        return answer;
    }
}