def solution(n, tops):
    dp1 = [0 for i in range(n)]
    dp2 = [0 for i in range(n)]
    answer = 0                        
    if tops[0] == 0:
        dp1[0] = 2
        dp2[0] = 1
    else:
        dp1[0] = 3
        dp2[0] = 1
    for i in range(1,n):
        if tops[i] == 1:
            dp1[i] = dp1[i-1]*3+dp2[i-1]*2
            dp2[i] = dp1[i-1]+dp2[i-1]
        if tops[i] == 0:
            dp1[i] = dp1[i-1]*2+dp2[i-1]
            dp2[i] = dp1[i-1]+dp2[i-1]         
        dp1[i]%=10007
        dp2[i]%=10007
    return (dp1[n-1]+dp2[n-1])%10007