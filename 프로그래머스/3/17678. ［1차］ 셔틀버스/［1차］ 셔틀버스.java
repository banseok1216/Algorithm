import java.util.*;
class Solution {
    PriorityQueue<Integer> q = new PriorityQueue<Integer>();
    public String solution(int n, int t, int m, String[] timetable) {
        for(int i=0; i<timetable.length; i++){
            String[] arr = timetable[i].split(":");
            int hour = Integer.parseInt(arr[0]);
            int minutes = Integer.parseInt(arr[1]);
            int totalTime = minutes+ hour*60;
            q.add(totalTime);
        }
        int firstTime= 9*60;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0; i<n; i++){
            int count =0;
            if(i==n-1){ 
                while((count != m && !q.isEmpty()) && q.peek()<= firstTime + i*t){
                    arr.add(q.poll());
                    count++;
                }
            }
            else{
                while(count != m && !q.isEmpty() && q.peek()<= firstTime + i*t){
                    q.poll();
                    count++;
                }
            }
        }
        String answer = "";
        String tempHour = "";
        String tempMinutes = "";
        if(arr.size()<m){
            int temp = 9*60 + (n-1)*t;
            if(temp/60 <10){
                tempHour = "0"+temp/60;
            }
            else{
                tempHour = temp/60+"";
            }
            if(temp%60 <10){
                tempMinutes = "0"+temp%60;
            }
            else{
                tempMinutes = temp%60+"";
            }
            answer =  tempHour+":" + tempMinutes;
        }
        else{
            int temp = arr.get(m-1)-1;
            if(temp/60 <10){
                tempHour = "0"+temp/60;
            }
            else{
                tempHour = temp/60+"";
            }
            if(temp%60 <10){
                tempMinutes = "0"+temp%60;
            }
            else{
                tempMinutes = temp%60+"";
            }
            answer =  tempHour +":" +tempMinutes;
        }
        return answer;
    }
}