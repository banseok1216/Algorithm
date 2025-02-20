# 순서대로 N 개의 퍼즐 풀기 각 퍼즐은 난이도와 소요시간이 정해져 있음 퍼즐의 난이도 DIFF 현재 퍼즐의 소요시간 time_cur, time prev
# 당신의 숙련도를 level
# diff <= level 퍼즐 틀리지 않고 time_cur
# diff > lelvel 이면 diff - level 번 틀림 틀릴때 time_cur time_prev 다시 사용해야 함 마지막은 time_cur


def solution(diffs, times, limit):
    
    top = max(diffs)
    low = 1
    
    while low < top:
        mid = (top + low) // 2
        count = 0
        for i in range(len(diffs)):
            if diffs[i] <= mid :
                count += times[i]
            else:
                count += (diffs[i] - mid) * (times[i-1]  + times[i])
                count += times[i]
        if count <= limit:
            top = mid
        else:
            low = mid + 1
    answer = low
    return answer