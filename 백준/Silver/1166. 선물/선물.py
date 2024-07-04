from bisect import bisect_left, bisect_right
N,L,W,H = map(int,input().split(" "))
start = 0
end = min(L,W,H)
for _ in range(10000):
    mid = (start+end)/2
    count = (L//mid) * (W//mid) * (H//mid)
    if count >= N:
        start = mid
    else:
        end = mid

print(start)