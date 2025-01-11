import heapq

N = int(input())

l = []
for _ in range(N):
    a, b = map(int, input().split(" "))
    l.append([a, b])
l.sort()
answer = [0]
heapq.heapify(answer)
for a, b in l:
    t = answer[0]
    if a >= t:
        heapq.heappop(answer)
        heapq.heappush(answer, b)
    else:
        heapq.heappush(answer, b)
print(len(answer))