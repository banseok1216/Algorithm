from collections import deque

n, r, c = map(int, input().split())
ans = 0
def divide(x, y, max_val, k):
    global ans
    line = 2 ** (k-1)
    if k == 0:
        ans = max_val-1
        return
    if x > r >= x -line and y > c >= y-line:
        divide(x, y, max_val, k - 1)
    if x-line > r >= 0 and y > c >= y - line:
        divide(x-line, y, max_val - 2 * 2 ** (2 * (k - 1)), k - 1)
    if x-line > r >= 0 and y - line > c >= 0:
        divide(x-line, y -line, max_val - 3 * 2 ** (2 * (k - 1)), k - 1)
    if x > r >= x-line and y -line > c >= 0:
        divide(x, y -line, max_val - 1 * 2 ** (2 * (k - 1)), k - 1)

divide(2 ** n, 2 ** n, 2 ** (2 * n), n)

print(ans)
