import math

W, H, X, Y, P = map(int, input().split(" "))

count = 0
for i in range(P):
    a, b = map(int, input().split(" "))
    if math.sqrt(pow((X - a), 2) + pow(Y + H / 2 - b, 2)) <= H/2 or math.sqrt(
            pow((X + W - a), 2) + pow(Y + H / 2 - b, 2)) <= H/2 or (X <= a <= X + W and Y <= b <= Y + H):
        count += 1
print(count)
