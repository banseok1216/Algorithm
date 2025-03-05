# N명의 어린이들이 있음
# 뒤바뀐 아이들의 번호의 순서를 바꾸어야 함
import bisect

N = int(input())
board = []
dp = []
for _ in range(N):
    board.append(int(input()))
for x in board:
    pos = bisect.bisect_left(dp, x)  # lis에서 x가 들어갈 위치 찾기
    if pos == len(dp):
        dp.append(x)
    else:
        dp[pos] = x
print(N - len(dp))