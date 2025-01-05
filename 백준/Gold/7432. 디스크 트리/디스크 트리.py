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


N = int(input())
root = Node(None)
for _ in range(N):
    board = list(input().split("\\"))
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


def search(parent: Node, depth):
    for s in sorted(parent.children):
        print(" " * depth + s.data)
        search(s, depth + 1)


search(root,0)
