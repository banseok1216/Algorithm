import java.util.*;
class Solution {
    public int solution(int n) {
        int right =0;
        int left = 0;
        int answer = 0;
        int sum = 0;
        while(right<n){
            right+=1;
            sum += right;
            while(left< right && sum>n){
                sum -= left;
                left ++;    
            }
            if(sum == n){
                answer ++;
            }
        }
        return answer;
    }
}