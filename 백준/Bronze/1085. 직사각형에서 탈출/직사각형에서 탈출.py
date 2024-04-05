x ,y,w,h = map(int,input().split(" "))
ans = min(x,y,abs(w-x),abs(y-h))
print(ans)