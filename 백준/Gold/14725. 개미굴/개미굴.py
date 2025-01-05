class Node:
    def __init__(self, data, children=None):
        if children is None:
            children = []
        self.data = data
        self.children = children

    def __eq__(self, other):
        if self.data == other.data:
            return True
        return False

    def __lt__(self, other):
        return self.data < other.data


N = int(input())
root = Node(None)

for _ in range(N):
    board = list(input().split(" "))[1:]
    parent = root
    for char in board:
        e = Node(char)
        if e not in parent.children:
            parent.children.append(e)
            parent = e
        else:
            for child in parent.children:
                if child == e:
                    parent = child
                    break


def search(root: Node, depths):
    print("--" * depths + root.data)
    for child in sorted(root.children):
        search(child, depths + 1)


for r in sorted(root.children):
    search(r, 0)
