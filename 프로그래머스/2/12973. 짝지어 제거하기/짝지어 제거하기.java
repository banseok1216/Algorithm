import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<s.length(); i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i)-'0');
            }
            else{
                if(stack.peek() == s.charAt(i)-'0'){
                    stack.pop();      
                }
                else{
                    stack.push(s.charAt(i)-'0');
                }
            }
        }
                    
        int answer = -1;
        if(stack.size() == 0){
            answer =1;
        }
        else{
            answer =0;
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.

        return answer;
    }
}