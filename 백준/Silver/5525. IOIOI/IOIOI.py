N = int(input())
first = "I"
for i in range(N):
    first+="O"+"I"
M = int(input())
lgt = input()
start = 0
ans = 0
success = False
for i in range(M-len(first)+1):
    if success:
        if i+2 <= M-len(first) and lgt[i+1] == "O" and lgt[i+2] == "I":
            ans+=1
            i +=2
        else:
            success = False
            continue
    if first[0] == lgt[i]:
        start = i
        ans +=1
        success = True
        for j in range(len(first)):
            if first[j] != lgt[i+j]:
               ans-=1
               success = False
               break
        i = start +len(first)-1
print(ans)

