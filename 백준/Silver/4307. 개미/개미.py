T = int(input())
for _ in range(T):
    N,M = map(int,input().split(" "))
    lst = []
    for i in range(M):
        lst.append(int(input()))
    lst.sort()
    if len(lst) == 1:
        print(str(min(N-lst[0],lst[0])),str(max(N-lst[0],lst[0])))
        continue
    first = 0
    for i in lst:
        if N//2 - i < 0:
            first=max(N-i,first)
        else:
            first= max(i,first)
    second = 0
    for i in range(len(lst)-1):
        second = max((lst[i+1] - lst[i]) + lst[i], N - lst[i+1]+ (lst[i+1] - lst[i]), second)
    print(str(first)+ " " + str(second))
