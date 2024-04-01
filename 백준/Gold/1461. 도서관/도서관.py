N, M = map(int,input().split(" "))
lst = list(map(int,input().split(" ")))
plus =[0]
minus = [0]
for i in lst:
    if i>0:
        plus.append(i)
    else:
        minus.append(i)
plus.sort(reverse=True)
minus.sort()
count = 0
ans =0
while(count<len(plus)):
    ans+=plus[count]*2
    count+=M
count = 0
while(count<len(minus)):
    ans-=minus[count]*2
    count+=M
print(ans-max(-min(minus),max(plus)))
