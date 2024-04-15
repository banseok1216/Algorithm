import copy
import sys
sys.setrecursionlimit(10**6)
T = int(input())
tree = [[] for i in range(T+1)]
for _ in range(T):
    N , M = map(int,input().split(" "))
    tree[N].append(M)
    tree[M].append(N)
check = [False for i in range(T+1)]
ans =[]
def dfs(start,cur,pre):
    global ans
    global check
    if start == cur:
        ans = copy.deepcopy(check)
        return
    if cur == 0:
        cur = start
    for i in tree[cur]:
        if not check[cur]:
            if i == pre:
                continue
            check[cur]= True
            dfs(start,i,cur)
            check[cur] = False
answer = 1000000000
def dfs1(pre,cur,count):
    global answer
    global ans
    if ans[cur]:
        answer = min(count,answer)
        return
    for i in tree[cur]:
        if i == pre:
            continue
        else:
            dfs1(cur,i,count+1)
for i in range(1,T+1):
    if len(ans) == 0:
        dfs(i,0,0)
for i in range(1,T+1):
    if ans[i]:
        print(0,end=" ")
    else:
        answer = 1000000000
        dfs1(0,i,0)
        print(answer, end=" ")