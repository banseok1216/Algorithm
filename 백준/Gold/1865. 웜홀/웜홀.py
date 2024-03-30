INF = 0xffffff
def bf(i: int):
    dis = [INF] * (N + 1)
    dis[i] = 0  # 시작위치의 거리 가중치 초기화
    for cnt in range(N):
        for edge in edges:
            cur = edge[0]
            goal = edge[1]
            weight = edge[2]
            if dis[goal] > dis[cur] + weight:
                dis[goal] = dis[cur] + weight
                if cnt == N - 1:
                    return True
    return False
TC = int(input())

for tc in range(TC):
    N, M, W = map(int, input().split())
    edges = []
    for _ in range(M):
        S, E, T = map(int, input().split())
        edges.append([S, E, T])
        edges.append([E, S, T])
    for _ in range(W):
        S, E, T = map(int, input().split())
        edges.append([S, E, -T])

    negative_cycle_exist = bf(1)
    print('YES' if negative_cycle_exist else 'NO')