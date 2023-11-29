import sys
first=int(input())
list1=set(map(int,sys.stdin.readline().rstrip().split()))
second=int(input())
list2=list(map(int,sys.stdin.readline().rstrip().split()))
for i in list2:
  if i in list1:
    print(1,end=' ')
  else:
    print(0,end=' ')