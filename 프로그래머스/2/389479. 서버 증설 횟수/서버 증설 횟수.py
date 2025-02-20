from collections import deque

def solution(players, m, k):
    
    q = deque()
    count = 0
    answer = 0
    for i in players:
        while len(q) != 0 and q[0] + k <= count:
            q.popleft()
        while len(q) * m < i-(m-1):
            q.append(count)
            answer +=1
        count += 1
            
    return answer