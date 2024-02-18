import java.util.*;
class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            ans.add(Integer.parseInt(arr[i]));
        }
        Collections.sort(ans);
        String answer = "";
        for(int i=0; i<ans.size(); i++){
            if(i == 0){
                answer+=ans.get(i);
            }
            if(i== ans.size()-1){
                answer += " "+ans.get(i);
            }
        }
        return answer;
    }
}