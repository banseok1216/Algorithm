C = int(input())
for i in range(C):
    N = int(input())
    lst = list(map(int,input().split(" ")))
    lst.sort()
    ans = 0
    for j in range(len(lst)):
        if j == 0:
            ans =  max(lst[j+1]-lst[j],lst[j+2] - lst[j])
        elif j == N-1:
            ans = max(ans, lst[N-1] - lst[N-2], lst[N-1] - lst[N-3])
        elif j == N-2:
            continue
        else:
            ans = max(ans, lst[j+2] -lst[j])
    print(ans)

