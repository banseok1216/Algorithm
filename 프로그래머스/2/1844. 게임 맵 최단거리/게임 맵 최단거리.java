import java.util.*;
class Solution {
    static Queue<Node> q = new LinkedList<Node>();
    static int[][] check;
    public int solution(int[][] maps) {
        int answer = -1;
        check = new int[maps.length][maps[0].length];
        q.add(new Node(0,0,1));
        int[] list1 = new int[]{-1,1,0,0};
        int[] list2 = new int[]{0,0,1,-1};
        while(!q.isEmpty()){
            Node node = q.poll();
            check[node.x][node.y] =node.total;
            if(node.x == maps.length-1 && node.y ==maps[0].length-1 ){
                answer = node.total;
                break;
            }
            for(int i=0; i<4; i++){
                int nx = node.x+list1[i];
                int ny = node.y+list2[i];
                if(nx>=0 && nx<maps.length && ny>=0 && ny<maps[0].length &&maps[nx][ny] == 1){
                    if(check[nx][ny]==0 || check[nx][ny]>node.total+1){
                        check[nx][ny] = node.total+1;
                        q.add(new Node(nx,ny,node.total+1));
                    }
                }
            }
        }
        return answer;
        
    }
}
class Node{
    int x;
    int y;
    int total;
    Node(int x, int y,int total){
        this.x = x;
        this.y = y;
        this.total = total; 
    }
}