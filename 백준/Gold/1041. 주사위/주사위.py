import heapq
N = int(input())
board = list(map(int,input().split(" ")))
check = []
combinations = []
for i in (0, 5):
    combination = sorted((board[i], board[1], board[2]))
    heapq.heappush(combinations, combination)
    combination = sorted((board[i], board[2], board[1]))
    heapq.heappush(combinations, combination)
    combination = sorted((board[i], board[2], board[4]))
    heapq.heappush(combinations, combination)
    combination = sorted((board[i], board[4], board[2]))
    heapq.heappush(combinations, combination)
    combination = sorted((board[i], board[1], board[3]))
    heapq.heappush(combinations, combination)
    combination = sorted((board[i], board[3], board[1]))
    heapq.heappush(combinations, combination)
    combination = sorted((board[i], board[3], board[4]))
    heapq.heappush(combinations, combination)
    combination = sorted((board[i], board[4], board[3]))
    heapq.heappush(combinations, combination)

# 정렬 수행
sorted_combinations = sorted(combinations)
ans =0
lst = heapq.heappop(combinations)
if N == 1:
    print(sum(board) - max(board))
else:
    ans+= 4*sum(lst[0:3])
    ans += 4*(N-1)*sum(lst[0:2])
    ans += 4*(N-2) * sum(lst[0:2])
    ans += 4*(N-2)*(N-1)*lst[0]
    ans += (N - 2) * (N - 2) * lst[0]
    print(ans)