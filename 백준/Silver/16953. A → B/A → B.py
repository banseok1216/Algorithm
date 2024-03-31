N , M = map(int,input().split(" "))
count = 0
while(N<M):
    M= int(M)
    if M%2 == 0:
        M/=2
        count +=1
    elif str(M)[-1] == "1":
        count +=1
        M = int(str(M)[:-1])
    else:
        break
if(int(N)==int(M)):
    print(count+1)
else:
    print(-1)