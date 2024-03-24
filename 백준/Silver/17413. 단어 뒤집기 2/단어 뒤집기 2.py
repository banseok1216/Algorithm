string = input()
start = 0
running = False
ans =""
for i in range(len(string)):
    if string[i] == "<":
        ans += ''.join(reversed(string[start:i]))
        running = True
    if running:
        ans += string[i]
    if string[i] == ">":
        running = False
        start = i+1
    if not running:
        if string[i] == " ":
            ans += ''.join(reversed(string[start:i]))
            ans += " "
            start = i+1

ans += ''.join(reversed(string[start:]))
print(ans)