# 전체적인 방향은 이해했으나 작동 방식을 아직 잘 모르겠음!!

import sys
input = sys.stdin.readline

class Node:
  def __init__(self, item, left, right):
    self.item = item
    self.left = left
    self.right = right

# 전위 순회
def preorder(node):
  print(node.item, end='')
  if node.left != '.':
    preorder(tree[node.left])
  if node.right != '.':
    preorder(tree[node.right])

# 중위 순회
def inorder(node):
  if node.left != '.':
    inorder(tree[node.left])
  print(node.item, end='')
  if node.right != '.':
    inorder(tree[node.right])

# 후위 순회
def postorder(node):
  if node.left != '.':
    postorder(tree[node.left])
  if node.right != '.':
    postorder(tree[node.right])
  print(node.item, end='')

n = int(input())
tree = {}

for _ in range(n):
  node, left, right = map(str, input().split())
  tree[node] = Node(item=node, left=left, right=right)

print(tree)
preorder(tree['A'])
print()
inorder(tree['A'])
print()
postorder(tree['A'])