import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i=0; i<commands.length; i++){
            ArrayList<Integer> check = new ArrayList<Integer>();
            for(int j=0; j<array.length; j++){
                if(j>=commands[i][0]-1 && j<=commands[i][1]-1){
                    check.add(array[j]);
                }
            }
            Collections.sort(check);
            ans.add(check.get(commands[i][2]-1));
        }
        int[] answer = new int[ans.size()];
        for(int i=0; i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}