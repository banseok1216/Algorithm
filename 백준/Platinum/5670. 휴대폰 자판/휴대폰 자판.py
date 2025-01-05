class Node:
    def __init__(self, data, children=None):
        if children is None:
            children = []
        self.children = children
        self.data = data

    def __eq__(self, other):
        if self.data == other.data:
            return True
        return False

    def __lt__(self, other):
        return self.data < other.data


def search(parent: Node, depth):
    global count
    if len(parent.children) == 0:
        count += depth
        return
    if len(parent.children) == 1:
        if parent.data == None:
            search(parent.children[0], depth + 1)
        else:
            search(parent.children[0], depth)
        return
    for s in parent.children:
        if s.data == -1:
            count += depth
            continue
        search(s, depth + 1)


while True:
    try:
        N = int(input())
        root = Node(None)
        for _ in range(N):
            board = list(input()) + [-1]
            parent = root
            for s in board:
                s = Node(s)
                if s not in parent.children:
                    parent.children.append(s)
                    parent = s
                else:
                    for i in parent.children:
                        if i == s:
                            parent = i
                            break
        count = 0
        search(root, 0)
        print(f"{count / N:.2f}")
    except:
        break
