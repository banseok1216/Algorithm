N ,M ,K = map(int,input().split(" "))
left = min(M, K)
right = max(M, K)
ans=0
while(True):
    if(left %2 ==1 and right  == left+1):
        ans += 1
        break
    else:
        left = left//2 + left %2
        right = right // 2 + right % 2
        ans +=1
print(ans)