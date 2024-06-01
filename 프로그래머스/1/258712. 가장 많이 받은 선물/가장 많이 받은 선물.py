def solution(friends, gifts):
    check1 = {friend: 0 for friend in friends}  # 각 친구가 받은 선물 수
    check2 = {friend: {f: 0 for f in friends if f != friend} for friend in friends}  # 친구들 간 선물 교환 횟수
    ans = {friend: 0 for friend in friends}  # 각 친구의 선물 지수

    # 각 친구가 받은 선물 수와 선물 지수 계산
    for gift in gifts:
        source, target = gift.split(" ")
        check1[source] += 1
        check1[target] -= 1
        check2[source][target] += 1

    for source in friends:
        for target in friends:
            if target != source:
                # 선물을 더 많이 준 친구의 선물 지수를 증가
                if check2[source][target] > check2[target][source]:
                    ans[source] += 1
                # 선물을 더 많이 준 친구가 같은 경우, 선물 지수가 높은 친구의 선물 지수를 증가
                elif check2[source][target] == check2[target][source]:
                    if check1[source] > check1[target]:
                        ans[source] += 1

    print(ans)
    return max(ans.values())  # 딕셔너리의 값을 확인하여 최댓값 반환

