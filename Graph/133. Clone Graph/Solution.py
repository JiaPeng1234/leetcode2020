# https://leetcode.com/problems/clone-graph/

# By Jiapeng
# Graph deep copy node, need a queue and a dict, queue + hashtable
# Runtime: 40 ms, faster than 59.33% of Python3 online submissions for Clone Graph.
# Memory Usage: 14.1 MB, less than 99.99% of Python3 online submissions for Clone Graph.

"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return None
        
        q = collections.deque()
        visited = {}
        
        copyHead = Node(node.val)
        visited[node] = copyHead
        q.append(node)
        
        while q:
            curNode = q.popleft()
            copyNode = visited[curNode]
            for neighbor in curNode.neighbors:
                if neighbor not in visited:
                    q.append(neighbor)
                    copyNeighbor = Node(neighbor.val)
                    visited[neighbor] = copyNeighbor
                    copyNode.neighbors.append(copyNeighbor)
                else:
                    copyNode.neighbors.append(visited[neighbor])
                    
        return copyHead
