import sys
import heapq

n, m = map(int, sys.stdin.readline().rstrip().split())
pq = []
parents = [i for i in range(n)]

for i in range(n):
    row = list(sys.stdin.readline().rstrip())
    for j in range(i+1, n):
        if row[j] == 'Y': heapq.heappush(pq, [i, j])

def find(node):
    if parents[node] == node: return node
    else:
        parents[node] = find(parents[node])
        return parents[node]
def union(node1, node2):
    root1, root2 = find(node1), find(node2)
    if root1 == root2: return False
    else:
        parents[root2] = root1
        return True

if len(pq) < m: print(-1)
else:
    answer = [0 for _ in range(n)]
    edge_num = 0
    pq2 = []
    while pq:
        node1, node2 = heapq.heappop(pq)
        if union(node1, node2):
            answer[node1] += 1
            answer[node2] += 1
            edge_num += 1
        else:
            heapq.heappush(pq2, [node1, node2])
    if edge_num != n-1: print(-1)
    else:
        for _ in range(m-edge_num):
            node1, node2 = heapq.heappop(pq2)
            answer[node1] += 1
            answer[node2] += 1
        print(*answer)