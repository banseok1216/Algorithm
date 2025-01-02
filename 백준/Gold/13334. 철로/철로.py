import heapq

n = int(input())
temp = []
board = []
for _ in range(n):
    a, b = map(int, input().split(" "))
    if a < b:
        temp.append((a, b))
    else:
        temp.append((b, a))
l = int(input())
for i in range(n):
    if temp[i][1] - temp[i][0] <= l:
        board.append((temp[i]))
board.sort(reverse=True)
answer = 0
q = []
heapq.heapify(q)
for i in range(len(board)):
    start = board[i][0]
    end = board[i][1]
    max_len = start + l
    while len(q) != 0 and -q[0] > max_len:
        heapq.heappop(q)
    heapq.heappush(q, -end)
    answer = max(answer, len(q))
print(answer)
