# A 3점 연속 발차기 현재 ㄴ점수 만큼 상대도 3점 득점 위험
# B 1점 연속 발차기
from collections import deque

T = int(input())
for i in range(T):
    N ,M = map(int,input().split(" "))
    que = deque()
    que.append((N,M,0))
    answer = 0
    while(len(que) != 0):
        node = que.popleft()
        if node[0]> node[1]:
            continue
        if node[0] == node[1]:
            answer= node[2]
            break
        que.append((node[0]*2,node[1]+3,node[2]+1))
        que.append((node[0]+1, node[1], node[2] + 1))
    print(answer)