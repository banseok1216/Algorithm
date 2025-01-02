def dfs(x, y):
    global answer
    if answer:  # 이미 목적지에 도달한 경우 종료
        return

    # 목적지에 도달 가능한 경우
    if abs(destX - x) + abs(destY - y) <= 1000:
        answer = True
        return

    # 가까운 편의점 순서로 탐색
    for i in range(N):
        if not visited[i]:
            nx, ny = mart[i]
            distance = abs(nx - x) + abs(ny - y)
            if distance <= 1000:  # 1000m 이내만 탐색
                visited[i] = True
                dfs(nx, ny)
                if answer:  # 목적지 도달 시 다른 탐색 중단
                    return


# 입력 처리
T = int(input())
for _ in range(T):
    N = int(input())  # 편의점 수
    homeX, homeY = map(int, input().split())  # 집 좌표
    mart = [tuple(map(int, input().split())) for _ in range(N)]  # 편의점 좌표
    destX, destY = map(int, input().split())  # 페스티벌 좌표

    # 편의점을 현재 위치에서 가까운 순으로 정렬
    mart.sort(key=lambda pos: abs(pos[0] - homeX) + abs(pos[1] - homeY))

    # 방문 여부 초기화
    visited = [False] * N
    answer = False

    # DFS 탐색 시작
    dfs(homeX, homeY)

    # 결과 출력
    print("happy" if answer else "sad")
