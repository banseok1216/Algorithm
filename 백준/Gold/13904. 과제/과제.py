import heapq

N = int(input())
list1 = [0 for i in range(1001)]
que = []
for i in range(N):
    day,point = map(int, input().split(" "))
    heapq.heappush(que, (-point,day))
ans = 0
for i in range(N):
    node = heapq.heappop(que)
    count = node[1]
    while count >= 1 and list1[count] != 0:
        count-=1
    if count>=1:
        ans += -node[0]
        list1[count] = -node[0]
print(ans)