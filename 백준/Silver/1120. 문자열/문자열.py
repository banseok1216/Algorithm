a,b=input().split()

result=[]
for i in range(len(b)-len(a)+1):#길이를 같게
    cnt=0
    for j in range(len(a)):#a길이만큼 자르기
        if a[j]!=b[j+i]:#a를 기준으로 b의 끝까지 검사
            cnt+=1#다르면 1증가, 문자열 전체 count후
    result.append(cnt)#배열에 추가
print(min(result))