import heapq

N = int(input())
plus =  []
minus =  []
zero = []

for i in range(N):
    num = int(input())
    if num > 0 :
        heapq.heappush(plus,-num)
    elif num == 0:
        heapq.heappush(zero,num)
    else:
        heapq.heappush(minus,num)
count = 0
first = 0
second = 0
ans = 0
while(len(plus) != 0):
    node = -heapq.heappop(plus)
    if count == 0:
        if node == 1:
            ans += node
        else:
            first = node
            count+=1
    elif count == 1:
        if node == 1:
            ans += node
            ans += first
            count = 0
        else:
            second = node
            ans += first * second
            count=0
if count == 1:
    ans += first
count = 0
first = 0
second = 0
while(len(minus) != 0):
    node = heapq.heappop(minus)
    if count == 0:
        first = node
        count+=1
    elif count == 1:
        second = node
        ans += first * second
        count=0
if count == 1:
    if len(zero) != 0:
        pass
    else:
        ans += first
print(ans)




