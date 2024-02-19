import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        int count =n;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<works.length; i++){
            q.add(works[i]);
        }
        while(count!=0){
            int k = q.poll();
            if(k>=1){
                q.add(k-1);
                count--;
            }
            else{
                break;
            }
        }
        long answer = 0;
        while(!q.isEmpty()){
            int r = q.poll();
            answer+=Math.pow(r,2);
        }
        
        return answer;
    }
}