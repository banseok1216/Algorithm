import sys
n,q = map(int,input().split())
num = []
vis = set()
for _ in range(q):
    a = int(sys.stdin.readline().rstrip())
    num.append(a)

def visit(a):
    ans = 0
    b = a
    while b > 0:
        if b in vis:
            ans = b
        b//=2
    if ans == 0:
        vis.add(a)
    print(ans)
    
for i in num:
    visit(i)