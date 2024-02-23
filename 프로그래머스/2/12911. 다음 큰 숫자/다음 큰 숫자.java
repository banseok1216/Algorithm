import java.util.*;
class Solution {
    public int solution(int n) {
        int count =0;
        int check =0;
        boolean k = false;
        for(int i=0; i<25; i++){
            if((n & (1 << i)) == 0){
                if((1<<i) != 1 && k){        
                    n |= (1 << i);
                    n &= ~(1 << (i-1));
                    check =i;
                    break;
                }
            }
            else{
                k=true;
                 count ++;
            }
        }
        count--;
        for(int i=0; i< check; i++){
            if(count ==0){
                n &= ~(1 << i);
            }
            else{
                n |= (1 << i);
                count--;
            }
        }
        int answer = n;
        return answer;
    }
}