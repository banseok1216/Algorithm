# 첫번째 문장
# 두번쨰 단어 개수 N
# N개 단어
S = input()
N = int(input())
INF = 10000000
lst = []
for _ in range(N):
    lst.append(input())
board = [INF for i in range(len(S)+1)]
board[0] = 0
for k in range(len(S)):
    count = k
    if board[k] == INF:
        continue
    for j in range(N):
        stringCheck1 = list(S[count:count+len(lst[j])])
        stringCheck2 = list(lst[j])
        stringCheck1.sort()
        stringCheck2.sort()
        if stringCheck1 == stringCheck2:
            check1 = list(S[count:count + len(lst[j])])
            check2 = list(lst[j])
            go = 0
            for i in range(len(check1)):
                if check1[i] != check2[i]:
                    go +=1
            board[count + len(lst[j])] = min(go+board[count],board[count + len(lst[j])])
if board[len(S)] == INF:
    print(-1)
else:
    print(board[len(S)])
