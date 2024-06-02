# 탐색 양의 수가 늑대보다 많아야한다.
# 최대한 많은 양을 모아야한다. 루트노드에는 항상
# 1) 완탐 2) 
from collections import deque
def solution(info, edges):
    tree = [[] for _ in range(len(info))]
    for edge in edges:
        tree[edge[0]].append(edge[1])
    queue = deque()
    queue.append((0,1,0,set()))
    answer = 0
    while queue:
        now , sheep, wolf, dic = queue.popleft()
        answer = max(answer, sheep)
        for nxt in tree[now]:
            dic.add(nxt)
        for check in dic:
            if info[check] == 0:
                queue.append((check,sheep+1,wolf,dic-{check}))
            elif info[check] == 1 and sheep > wolf+1:
                queue.append((check,sheep,wolf+1,dic-{check}))
            
    return answer