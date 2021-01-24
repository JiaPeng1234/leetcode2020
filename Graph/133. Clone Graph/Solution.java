/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        
        //1. initialize need a HashMap old-copy, and a deque q
        Map<Node, Node> dict = new HashMap<>();
        Queue<Node> q = new ArrayDeque<>();
        Node first = new Node(node.val);
        q.offer(node);
        dict.put(node, first);
        
        //2. bfs:for-loop every neighbor of cur, if already in HashMap, no need copy no need put HashMap, just need add neighbor; 
        // if not in HashMap yet, copy, add HashMap, and add neighbor
        while(!q.isEmpty()){
            int leng = q.size();
            while(leng!=0){
                leng--;
                Node cur = q.poll();
                Node copy = dict.get(cur);
                for(Node nei: cur.neighbors){
                    if(!dict.containsKey(nei)){
                        Node copyNei = new Node(nei.val);
                        dict.put(nei, copyNei);
                        copy.neighbors.add(copyNei);
                        q.offer(nei);
                    }else{
                        copy.neighbors.add(dict.get(nei));
                    }
                }
            }
        }
        
        return first;
        
    }
}
