a = dict()
a["IV"] = 4
a["IX"] = 9
a["XL"] = 40
a["XC"] = 90
a["CD"] = 400
a["CM"] = 900
a["I"] = 1
a["V"] = 5
a["X"] = 10
a["L"] = 50
a["C"] = 100
a["D"] = 500
a["M"] = 1000

board = [
    (4, "IV"),
    (9, "IX"),
    (40, "XL"),
    (90, "XC"),
    (400, "CD"),
    (900, "CM"),
    (1, "I"),
    (5, "V"),
    (10, "X"),
    (50, "L"),
    (100, "C"),
    (500, "D"),
    (1000, "M")
]

board.sort(reverse=True)

s1 = input()
s2 = input()
sum1 = 0
sum2 = ""
i = 0
while i < len(s1):
    nxt = i + 1
    if nxt < len(s1):
        if s1[i] + s1[nxt] in a:
            sum1 += a[s1[i] + s1[nxt]]
            i += 2
        else:
            sum1 += a[s1[i]]
            i += 1
    else:
        sum1 += a[s1[i]]
        i += 1
i = 0
while i < len(s2):
    nxt = i + 1
    if nxt < len(s2):
        if s2[i] + s2[nxt] in a:
            sum1 += a[s2[i] + s2[nxt]]
            i += 2
        else:
            sum1 += a[s2[i]]
            i += 1
    else:
        sum1 += a[s2[i]]
        i += 1
print(sum1)
temp = sum1
for num, code in board:
    for _ in range(temp // num):
        sum2 += code
    temp %= num
print(sum2)
