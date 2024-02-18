import java.util.*;

class Solution {
    public static String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            StringBuilder modifiedWord = new StringBuilder();
            if(arr[i].equals("")){
                answer += " ";
                continue;
            }
            modifiedWord.append(Character.toUpperCase(word.charAt(0)));
            for (int j = 1; j < word.length(); j++) {
                modifiedWord.append(Character.toLowerCase(word.charAt(j)));
            }
            answer += modifiedWord.toString();
            if (i < arr.length - 1) {
                answer += " ";
            }
        }
        for(int i=0; i<s.length()-answer.length(); i++){
         answer+=" ";   
        }
        return answer;
    }
}
