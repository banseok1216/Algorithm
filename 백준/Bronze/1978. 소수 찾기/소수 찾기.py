list1=[i+1 for i in range(1,1000)]

for i in range(999):
    if list1.count(i+2)==1:
        for _ in range(1000//(i+2)):
            if list1.count((_+2)*(i+2))==1:
                list1.remove((_+2)*(i+2))
            else:
                pass
        else:
            pass
q=int(input())
list2=[]
list2=list(map(int,input().split()))
answer=0
for i in list2:
    if list1.count(i)==1:
        answer+=1
    else:
        pass
print(answer)