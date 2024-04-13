#책 구분을 위해 N개 번호 중복 x
#전략 -> 앞의 것을 기준 정렬 ->
C = int(input())
for _ in range(C):
    N,M= map(int,input().split(" "))
    lst =[]
    check = [False for i in range(N+1)]
    for i in range(M):
        first , second = map(int,input().split(" "))
        lst.append([second,first])
        lst.sort()
    ans = 0
    for i in range(len(lst)):
        for j in range(lst[i][1],lst[i][0]+1):
            if check[j]:
                continue
            else:
                check[j] = True
                ans+=1
                break
    print(ans)



