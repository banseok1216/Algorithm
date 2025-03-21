def solution(T, T1, T2, a, b, onboard):
    if T<T1:
        T,T1,T2 = -T,-T2,-T1
    N = len(onboard)
    DP = [[1e9]*100 for i in range(N)]; DP[0][T]=0
    for n in range(1,N):
        for t in range(T1,T+1):
            if onboard[n] and not T1<=t<=T2:
                continue
            DP[n][t] = min(DP[n-1][t-1],DP[n-1][t+1]+a,DP[n-1][t]+b)
        if not onboard[n]:
            DP[n][T] = min(DP[n][T],DP[n-1][T])
    return min(DP[-1])
