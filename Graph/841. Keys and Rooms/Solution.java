class Solution {
    public Set<Integer> visited = new HashSet<>();
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        dfs(rooms, 0);
        return visited.size()==rooms.size();
        
    }
    
    private void dfs(List<List<Integer>> rooms, int cur){
        if(visited.contains(cur))
            return;
        visited.add(cur);
        for(int key: rooms.get(cur)){
            dfs(rooms, key);
        }
    }
}
