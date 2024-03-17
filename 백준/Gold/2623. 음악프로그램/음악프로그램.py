from collections import deque
N ,M = map(int, input().split(" "))
board = [0 for _ in range(N+1)]
tree =[[] for _ in range(N+1)]
que = deque()
for _ in range(M):
    list1 = list(map(int,input().split(" ")))
    K = list1[0]
    for i in range(1, K+1):
        if i>=2:
            board[list1[i]] += 1
            tree[list1[i-1]].append(list1[i])
for i in range(1,N+1):
    if board[i] == 0:
        que.append(i)
check=[False for _ in range(N+1)]
ans = []
while len(que) != 0 :
    node = que.popleft()
    if check[node] == False:
        check[node] = True
        ans.append(node)
    for nxt in tree[node]:
        board[nxt] -=1
        if board[nxt] == 0:
            que.append(nxt)
if len(ans) != N:
    print(0)
else:
    for answer in ans:
        print(answer)


