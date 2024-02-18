import java.util.*;
class Solution {
    static HashMap<String, String> map = new HashMap<String,String>();
    static Queue<String> q1 = new LinkedList<String>();
    static Queue<String> q2 = new LinkedList<String>();
    public String[] solution(String[] record) {
        for(int i=0; i<record.length; i++){
            String[] arr = record[i].split(" ");
            if(arr[0].equals("Enter")){
                q1.add("들어왔습니다.");
                q2.add(arr[1]);
                if(map.containsKey(arr[1])){
                    map.replace(arr[1], arr[2]);
                }
                else{
                    map.put(arr[1], arr[2]);
                }
            }
            if(arr[0].equals("Leave")){
                q1.add("나갔습니다.");
                q2.add(arr[1]);
            }
            else{
                map.replace(arr[1], arr[2]);
            }
        }
        ArrayList<String> list = new ArrayList<>();
        while(!q1.isEmpty()){
            String s = q1.poll();
            String r = q2.poll();
            String ans = map.get(r)+"님이 "+s;
            list.add(ans);
        }
        
        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}