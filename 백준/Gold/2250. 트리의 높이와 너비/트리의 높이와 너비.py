N = int(input())
graph = [[] for i in range(N + 1)]
is_child = [False] * (N + 1)

for _ in range(N):
    root, left, right = map(int, input().split(" "))
    graph[root] = [left, right]
    if left != -1:
        is_child[left] = True
    if right != -1:
        is_child[right] = True

root_node = -1
for i in range(1, N + 1):
    if not is_child[i]:
        root_node = i
        break
check = {}
index = 0


def dfs(root, count):
    global index
    left, right = graph[root]
    if left != -1:
        dfs(left, count + 1)
    index += 1
    if count in check:
        check[count].append(index)
    else:
        check[count] = [index]
    if right != -1:
        dfs(right, count + 1)
    return
dfs(root_node, 1)
answer = []
for key, check_list in check.items():
    answer.append([check_list[-1] - check_list[0] +1, -key])
answer.sort(reverse=True)
print(-answer[0][1],answer[0][0])