N, K = map(int, input().split(" "))
board = list(map(int, input().split(" ")))
tab = set()
count = 0
answer = 0
wait = {}
for i in range(K):
    if board[i] not in wait:
        wait[board[i]] = [i]
    else:
        wait[board[i]].append(i)
for i in range(K):
    if len(tab) < N:
        tab.add(board[i])
        wait[board[i]].pop(0)
        continue
    if board[i] in tab:
        wait[board[i]].pop(0)
        continue
    else:
        target = 0
        count = 0
        for num in tab:
            if num not in wait or len(wait[num]) == 0:
                target = num
                break
            else:
                if wait[num][0] > count:
                    target = num
                    count = wait[num][0]
        tab.remove(target)
        tab.add(board[i])
        wait[board[i]].pop(0)
    answer += 1
print(answer)
