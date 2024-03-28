N = int(input())
list1 = list(map(int, input().split(" ")))
M = int(input())
list2 = list(map(int,input().split(" ")))
list1.sort(reverse= True)
list2.sort(reverse= True)
ans = 0
while len(list2) != 0:
    n=0
    ans +=1
    if list2[0]>list1[0]:
        break
    for i in list1:
        if len(list2) == 0:
            break
        while n!= len(list2) and list2[n] > i:
            n +=1
        if n != len(list2):
            del list2[n]
if len(list2) != 0:
    print(-1)
else:
    print(ans)


