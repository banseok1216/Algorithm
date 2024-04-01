import heapq

N = int(input())
que =[]
lst = list(map(int,input().split(" ")))
M = int(input())
for i in range(len(lst)):
    heapq.heappush(que,(lst[i],i))
if N == 1:
    print(0)
else:
    start = heapq.heappop(que)
    dp = []
    # 0 
    dp.append(start[1])
    #0 이라면
    if start[1] == 0:
        #다음거 pop
        temp=heapq.heappop(que)
        #무조건 바뀌어야함
        if temp[0]<=M:
            #바꿈
            dp[0] = temp[1]
            M-= lst[dp[0]]
            # 0 계속 추가
            while M-start[0] >= 0:
                M -= start[0]
                dp.append(start[1])
            count = N-1
            pointer = 0
            while(count!=0):
                while pointer < len(dp) and count>=dp[pointer] and M+ lst[dp[pointer]] - lst[count] >= 0:
                    M += lst[dp[pointer]]  - lst[count]
                    dp[pointer] = count
                    pointer+=1
                count-=1
    else:
        M -= lst[dp[0]]
        while M-start[0] >=0:
            M -= start[0]
            dp.append(start[1])
        count = N - 1
        pointer = 0
        while (count != 0):
            while pointer < len(dp) and count>=dp[pointer] and M+ lst[dp[pointer]] - lst[count] >= 0:
                M += lst[dp[pointer]] - lst[count]
                dp[pointer] = count
                pointer += 1
            count -= 1
    for i in range(len(dp)):
        print(dp[i],end="")