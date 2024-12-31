import heapq

T = int(input())
for _ in range(T):
    N = int(input())
    b = [0 for i in range(201)]
    hq = []
    heapq.heapify(hq)
    board = list(map(int, input().split()))
    check = [[0, 0, 0] for _ in range(201)]  # [점수 합산, 다섯 번째 주자 위치, 주자 수]
    for i in range(len(board)):
        b[board[i]] += 1
    point = 1
    for i in range(len(board)):
        team = board[i]
        if b[team] < 6:
            continue
        check[team][2] += 1
        if check[team][2] <= 4:
            check[team][0] += point
        if check[team][2] == 5:
            check[team][1] = point  # 다섯 번째 주자의 위치 저장
        point += 1
    for i in range(len(check)):
        if check[i][2] >= 6:
            heapq.heappush(hq, (check[i][0], check[i][1], i))

    if hq:
        # 최소 힙이므로 첫 번째 원소가 최소 점수 합산을 가진 팀
        # tie-breaker는 다섯 번째 주자 위치
        winning_team = heapq.heappop(hq)[2]
        print(winning_team)
