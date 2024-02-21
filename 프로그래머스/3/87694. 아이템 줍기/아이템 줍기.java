import java.util.*;
class Solution {
    static int[][] copy;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        copy = rectangle;
        int[][] ans = new int[102][102];
        Queue<Node> q = new LinkedList<Node>();
        for(int i=0; i<rectangle.length; i++){
            for(int j=rectangle[i][0]*2; j<rectangle[i][2]*2+1; j++){
                for(int k=rectangle[i][1]*2; k<rectangle[i][3]*2+1; k++){
                    if(j==rectangle[i][0]*2 || j==rectangle[i][2]*2 || k== rectangle[i][1]*2 || k==rectangle[i][3]*2){
                        if(checkPos(j,k)){
                            ans[j][k] = 1;
                        }
                    }
                }
            }
        }
        q.add(new Node(characterX*2,characterY*2,0));
        int[] list1 = new int[]{0,0,-1,1};
        int[] list2 = new int[]{-1,1,0,0};
        int answer = 100000000;
        while(!q.isEmpty()){
            Node node = q.poll();
            ans[node.x][node.y] = -1;
            System.out.println(node.x + "  " + node.y + " " + node.total);
            if(node.x == itemX*2 && node.y == itemY*2){
                answer = Math.min(answer,node.total);
                continue;
            }
            for(int i=0; i<4; i++){
                int nx = list1[i] + node.x;
                int ny = list2[i] + node.y;
                if(ans[nx][ny] == 1){
                    q.add(new Node(nx,ny,node.total+1));
                }
            }
        }
        return answer/2;
    }
    public boolean checkPos(int m, int n){
        boolean check = true;
        for(int i=0; i<copy.length; i++){
            if(copy[i][0]*2<m && copy[i][2]*2>m && copy[i][1]*2<n && copy[i][3]*2>n ){
                check = false;
                break;
            }
        }
        return check;
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