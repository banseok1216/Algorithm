T = int(input())


def find_depth(node, tree):
    depth = 0
    while node in tree:
        node = tree[node]
        depth += 1
    return depth


def find(node1, node2, tree):
    depth1 = find_depth(node1, tree)
    depth2 = find_depth(node2, tree)

    while depth1 > depth2:
        node1 = tree[node1]
        depth1 -= 1
    while depth1 < depth2:
        node2 = tree[node2]
        depth2 -= 1

    while node1 != node2:
        node1 = tree[node1]
        node2 = tree[node2]
    return node1


for _ in range(T):
    N = int(input())
    tree = dict()
    for _ in range(N-1):
        a, b = map(int, input().split(" "))
        tree[b] = a
    a, b = map(int, input().split(" "))
    print(find(a,b,tree))


