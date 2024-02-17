import java.util.*;
class Solution {
    static int x=0;
    static int y=0;
    static int z=0;
    static ArrayList<ArrayList<Integer>> arraylist = new ArrayList<ArrayList<Integer>>();
    static boolean[] bfscount;
    public int[] solution(int[][] edges) {
        int[][] count = new int[1000001][2];
        bfscount= new boolean[1000001];
        for(int i=0; i<1000001; i++){
            arraylist.add(new ArrayList<Integer>());
        }
        for(int i=0; i<edges.length; i++){
            count[edges[i][0]][0]++;
            count[edges[i][1]][1]++;
            arraylist.get(edges[i][0]).add(edges[i][1]);
        }
        int vertices = 0;;
         for(int i=1; i<count.length; i++){
             if(count[i][1] == 0 && count[i][0] == 0){
                 continue;
             }
             else{
                 if(count[i][1] == 0){
                    if(count[i][0]>=2){
                        vertices = i;
                        bfscount[vertices] = true;
                    }
                 }
            }
         }
        for(int i=0; i<arraylist.get(vertices).size(); i++){
            bfs(arraylist.get(vertices).get(i));
        }
        int[] answer = new int[]{vertices,x,y,z};
        return answer;
    }
    public static void bfs(int start){
        int r=0;
        int a=0;
        Queue<Integer> q = new  LinkedList<Integer>();
        q.add(start);
        while(!q.isEmpty()){
            int k = q.poll();
            bfscount[k] = true;
            for(int i=0; i<arraylist.get(k).size(); i++){
                if(arraylist.get(k).size()>=2){
                    r++;
                }
                if(bfscount[arraylist.get(k).get(i)]){
                    a++;
                }
                if(!bfscount[arraylist.get(k).get(i)]){
                    q.add(arraylist.get(k).get(i));
                }
            }
        }
        if(r== 0 && a>=1){
            x++;
        }
        if(a== 0){
            y++;
        }
        if(r>=1){
            z++;
        }
    }
}