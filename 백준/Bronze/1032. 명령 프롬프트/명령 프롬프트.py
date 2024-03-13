import sys

input = sys.stdin.readline

N = int(input())
list1 = [list(input().strip()) for _ in range(N)]
first = list1[0]
for i in range(1,N):
    check = list1[i]
    for j in range(len(first)):
        if(first[j] != check[j]):
            first[j] = "?"
a=""
for i in range(0,len(first)):
   a+= first[i]
print(a)