string = input()
arr = []
for i in range(len(string)):
    arr.append(string[i:])
arr.sort()
for i in arr:
    print(i)
