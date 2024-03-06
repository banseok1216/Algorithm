import math
import sys
from collections import deque

input = sys.stdin.readline


if __name__ == '__main__':
    X, Y, D, T = map(int, input().split(" "))
    distance = math.sqrt(X ** 2 + Y ** 2)
    ans = 0
    # 바로 도착할 수 있는 경우
    if distance < D:
        print(min(distance, 2.0*T , abs(distance-D)+T))
    else:
        remaining_distance_time = distance % D
        ans += distance // D * T
        ans += min(T,remaining_distance_time, abs(remaining_distance_time-D)+T)
        print(min(distance,ans))