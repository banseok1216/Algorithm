N=int(input())
gasoo=[[0,"A"],[0,"B"],[0,"C"],[0,"D"],[0,"E"],
       [0,"F"],[0,"G"],[0,"H"],[0,"I"],[0,"J"],]
neverZero=[0 for i in range(10)]
for i in range(N):
    word=input()
    size=len(word)
    for j in range(size):
        index=ord(word[size-1-j])-65
        if j==size-1:
            neverZero[index]=1
        gasoo[index][0]+=10**j

gasoo.sort(reverse=True)
if gasoo[9][0]!=0:
    for i in range(9,-1,-1):
        if neverZero[ord(gasoo[i][1])-65]==0:
            temp=list(gasoo[i])
            gasoo.remove(temp)
            gasoo.append(temp)
            break

ans=0
for i in range(10):
    ans+=gasoo[i][0]*(9-i)
print(ans)