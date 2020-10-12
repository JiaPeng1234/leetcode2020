# https://leetcode.com/problems/copy-list-with-random-pointer/

# By Jiapeng
# queue + hashtable
# Runtime: 32 ms, faster than 90.79% of Python3 online submissions for Copy List with Random Pointer.
# Memory Usage: 14.7 MB, less than 45.32% of Python3 online submissions for Copy List with Random Pointer.

"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return None
        
        # 使用一个字典类型进行拷贝
        res = dict()
        
        # 数值拷贝
        node = head
        while node:
            res[node] = Node(node.val)
            node = node.next
        
        # 设置尾结点
        res[None] = None
        
        # 进行两个指针的拷贝
        node = head
        while node:
            res[node].next = res[node.next]
            res[node].random = res[node.random]
            node = node.next
        
        return res[head]
