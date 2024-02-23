import java.util.*;
class Solution {
    public int[] solution(String s) {
        String r = "";
        int count =0;
        int ans =0;
        while (!s.equals("1")){
            r="";
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)-'0' == 1){
                    r+=s.charAt(i);
                }
                else{
                    count ++;
                }
            }
            int temp = r.length();
            s="";
            System.out.println(temp);
            while(temp != 0){
                if(temp%2 == 0){
                    s="0"+s;
                }
                else{
                    s="1"+s;
                }
                temp = temp/2;
            }
            System.out.println(s);
            ans++;
        }
        int[] answer = {ans,count};
        return answer;
    }
}