import heapq

N, K = map(int, input().split(" "))

l = list(input())
h = []
p = []
heapq.heapify(h)
heapq.heapify(p)
count = 0
for i in range(N):
    if l[i] == "H":
        heapq.heappush(h, i)
    else:
        heapq.heappush(p, i)
while p:
    person = heapq.heappop(p)
    while h and h[0] - person <= K:
        hambeger = heapq.heappop(h)
        if abs(hambeger - person) <= K:
            count += 1
            break
print(count)