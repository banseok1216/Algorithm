import heapq

def solution(alp, cop, problems):
    INF = int(1e9)
    answer = INF
    
    max_alp = 0
    max_cop = 0
    
    for problem in problems:
        max_alp = max(max_alp, problem[0])
        max_cop = max(max_cop, problem[1])
    
    dp = [[INF] * 151 for _ in range(151)]
    dp[alp][cop] = 0
    
    h = []
    heapq.heappush(h, (0, -alp, -cop))
    problems += [[0, 0, 1, 0, 1], [0, 0, 0, 1, 1]]
    problems.sort()
    while h:
        time, alp, cop = heapq.heappop(h)
        alp *= -1 
        cop *= -1
        if max_alp <= alp and max_cop <= cop:
            answer = time
            break
        for problem in problems:
            if alp < problem[0]:
                break
            if cop < problem[1]:
                continue
            next_alp = alp + problem[2]
            next_cop = cop + problem[3]
            if next_alp > 150:
                next_alp = 150
            if next_cop > 150:
                next_cop = 150
            next_time = time + problem[4]
            if dp[next_alp][next_cop] > next_time:
                dp[next_alp][next_cop] = next_time
                heapq.heappush(h, (next_time, -next_alp, -next_cop))
    
    return answer