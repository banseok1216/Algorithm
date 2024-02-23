import java.util.*;
class Solution {
    static ArrayList<Integer> list = new ArrayList<Integer>();
    static int answer =0;
    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
        for(int i=0; i<tangerine.length; i++){
            if(i==0){
                list.add(1);
            }
            else{
                if(tangerine[i] != tangerine[i-1]){
                    list.add(1);
                }
                else{
                    list.set(list.size()-1,list.get(list.size()-1)+1);
                }
            }
        }
        Collections.sort(list);
        int sum =0;
        for(int i = list.size()-1 ; i>=0 ;i--){
            answer ++;
            sum+=list.get(i);
            if(sum>=k){
                break;
            }
            
        }
        return answer;
    }
}