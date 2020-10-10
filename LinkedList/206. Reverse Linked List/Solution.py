# https://leetcode.com/problems/reverse-linked-list/

# By Jiapeng
# linked list
# Runtime: 32 ms, faster than 88.83% of Python3 online submissions for Reverse Linked List.
# Memory Usage: 15.4 MB, less than 7.80% of Python3 online submissions for Reverse Linked List.

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        A0 = None
        A1 = head
        A2 = head.next
        while A1:
            A1.next = A0
            A0 = A1
            A1 = A2
            if A2:
                A2 = A2.next
        return A0
