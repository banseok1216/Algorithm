s = input()
count = s.count("a")
s += s
min_ans = 100000000000000000000
for i in range(len(s) - count):
    min_ans = min(s[i:i+count].count("b"), min_ans)
print(min_ans)