l = list(map(int, input().split(" ")))
count = 0
for num in l:
    count += pow(num,2)
print(count % 10)
