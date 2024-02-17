import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
            int check = (brown-4)/2;
            for(int i=1; i<=check/2; i++){
                if((i)*(check-i) == yellow){
                    answer = new int[]{check-i+2,i+2};
                    break;
                } 
            }
        return answer;
    }
}