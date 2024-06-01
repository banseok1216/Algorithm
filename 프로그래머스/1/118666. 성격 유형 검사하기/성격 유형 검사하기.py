    
def solution(survey, choices):
    check = {}
    check["R"] = 0
    check["T"] = 0
    check["C"] = 0
    check["F"] = 0
    check["J"] = 0
    check["M"] = 0
    check["A"] = 0
    check["N"] = 0
    for i in range(len(survey)):
        count = choices[i] - 4
        if count<0:
            check[survey[i][0]] += abs(count)
        elif count>0:
            check[survey[i][1]] += abs(count)
    answer = ''
    if(check["R"] >= check["T"]):
        answer += "R"
    else:
        answer += "T"
    if(check["C"] >= check["F"]):
        answer += "C"
    else:
        answer += "F"
    if(check["J"] >= check["M"]):
        answer += "J"
    else:
        answer += "M"
    if(check["A"] >= check["N"]):
        answer += "A"
    else:
        answer += "N"
    return answer