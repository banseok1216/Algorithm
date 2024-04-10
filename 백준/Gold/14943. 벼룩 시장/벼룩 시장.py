# 벼룩 시장
# 벼룩 배달 비용 벼룩의 수 * 두사람 거리
# 각각의 거리 잡고 그리디로 처리?
import heapq
from itertools import combinations

N = int(input())
board = list(map(int, input().split(" ")))
plus = []
minus = []
for i in range(len(board)):
        if board[i] > 0:
            heapq.heappush(plus,(i,board[i]))
        else:
            heapq.heappush(minus, (i, board[i]))
answer = 0
while(len(plus) != 0 and len(minus) != 0):
    nodePlus = heapq.heappop(plus)
    count = nodePlus[1]
    while(count != 0):
        nodeMinus = heapq.heappop(minus)
        if count + nodeMinus[1] > 0:
            count = count + nodeMinus[1]
            answer += abs(nodeMinus[1]) * abs(nodeMinus[0]-nodePlus[0])
        else:
            heapq.heappush(minus,(nodeMinus[0],count + nodeMinus[1]))
            answer += abs(count) * abs(nodeMinus[0] - nodePlus[0])
            count=0
print(answer)
