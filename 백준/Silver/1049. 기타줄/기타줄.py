N , M = map(int, input().split(" "))
list1 = []
list2= []
for i in range(M):
    R, K = map(int, input().split(" "))
    list1.append(R)
    list2.append(K)
list1.sort()
list2.sort()
ans =0
if list1[0] >= list2[0]*6:
    ans = int(list2[0]*N)
else:
    ans += int( N//6 * list1[0])
    N %= 6
    if list1[0] < list2[0] *N:
        ans+= int(list1[0])
    else:
        ans+= int(list2[0]*N)
print(ans)