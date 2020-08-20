// https://leetcode.com/problems/shortest-bridge/

/**
By Jiapeng
DFS + BFS
Runtime: 6 ms, faster than 98.12% of Java online submissions for Shortest Bridge.
Memory Usage: 40.4 MB, less than 66.63% of Java online submissions for Shortest Bridge.
**/
class Solution {
    public int shortestBridge(int[][] A) {
        int xn = A.length, yn = A[0].length;
        boolean exit_flag = false;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < xn; i++){
            for(int j = 0; j < yn; j++){
                if(A[i][j] == 1){
                    dfs(i, j, xn, yn, A, q);
                    exit_flag = true;
                    break;
                }
            }
            if(exit_flag)
                break;
        }
        
        int[] adjacent = {-1, 0, 1, 0, -1};
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                size--;
                int[] node = q.poll();
                int row = node[0], col = node[1];
                for(int i = 0; i < 4; i++){
                    int x = row + adjacent[i];
                    int y = col + adjacent[i+1];
                    if(x < 0 || y < 0 || x >= xn || y >= yn || A[x][y] == 2)
                        continue;
                    if(A[x][y] == 1)
                        return steps;
                    A[x][y] = 2;
                    q.offer(new int[]{x, y});
                }
            }
            steps++;
        }
        return -1;
    }
    
    private void dfs(int x, int y, int xn, int yn, int[][] A, Queue<int[]> q){
        if(x < 0 || y < 0 || x >= xn || y >= yn || A[x][y] != 1)
            return;
        A[x][y] = 2;
        q.offer(new int[]{x, y});
        dfs(x+1, y, xn, yn, A, q);
        dfs(x-1, y, xn, yn, A, q);
        dfs(x, y+1, xn, yn, A, q);
        dfs(x, y-1, xn, yn, A, q);
    }
}

/**
By Jiapeng
DFS + bidirectional BFS
WARNING: 这是一个非常非常蠢的办法，比单向BFS慢1000倍，得到的教训是：
当我们想要使用双向BFS的时候，一定要考虑我们所要搜索的实体是什么类型的，比如如果是String(就像127题)，那么ok，双向BFS使用set搜索速度还可以，
但是如果实体是一对坐标的话，那么在java里会出现一个问题，java的HashSet<int []>是无法搜素同样的数组的，因为不是同一个对象，物理地址不同，除非重写数组这个类的equals和HashCode函数
所以只能使用HashSet<List<Integer>>而不是HashSet<int []>，这会导致效率极低，但这还不是不使用双向BFS的最主要原因。
这道题不应该使用双向BFS的最主要原因是：集合Set搜索速度再快也是底层使用静态数组实现的，所以Set Map等等集合速度再快也不如静态数组，
当我们需要操作的实体是一对数字坐标的时候，我们有一张图，这张图就是题目给出的二维数组，这个二维静态数组就是我们实现最快速度搜索的最好工具，
我们无需再在Set中寻找我们需要的数值，我们只需要在这张二维数组相应的坐标上赋值我们需要的数字即可，这个数字就是我们为了实现各种目的的“记号”
Runtime: 2070 ms, faster than 5.01% of Java online submissions for Shortest Bridge.
Memory Usage: 63.8 MB, less than 5.59% of Java online submissions for Shortest Bridge.
**/
class Solution2 {
    public int shortestBridge(int[][] A) {
        int xn = A.length, yn = A[0].length;
        boolean exit_flag = false;
        for(int i = 0; i < xn; i++){
            for(int j = 0; j < yn; j++){
                if(A[i][j] == 1){
                    dfs(i, j, xn, yn, A);
                    exit_flag = true;
                    break;
                }
            }
            if(exit_flag)
                break;
        }
        
        Set<List<Integer>> s1 = new HashSet<>(), s2 = new HashSet<>();
        for(int i = 0; i < xn; i++){
            for(int j = 0; j < yn; j++){
                if(A[i][j] == 1){
                    s1.add(new ArrayList<>(Arrays.asList(i, j)));
                }
                else if(A[i][j] == 2){
                    s2.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        
        // bidirectional BFS
        int[] adjacent = {-1, 0, 1, 0, -1};
        int steps = 0;
        while(!s1.isEmpty() && !s2.isEmpty()){
            if(s1.size() > s2.size()){
                Set<List<Integer>> tmp = new HashSet<>();
                tmp = s2;
                s2 = s1;
                s1 = tmp;   // VERY IMPORTANT! SWITCH THE VALUE CORRECTLY!!
            }
            Set<List<Integer>> s = new HashSet<>();
            int size = s1.size();
            while(size > 0){
                size--;
                for(List<Integer> node: s1){
                    int row = node.get(0);
                    int col = node.get(1);
                    for(int i = 0; i < 4; i++){
                        int x = row + adjacent[i];
                        int y = col + adjacent[i+1];
                        if(x < 0 || y < 0 || x >= xn || y >= yn || A[x][y] == A[row][col])
                            continue;
                        if(s2.contains(new ArrayList<>(Arrays.asList(x, y))))
                            return steps;
                        A[x][y] = A[row][col];
                        s.add(new ArrayList<>(Arrays.asList(x, y)));
                    }
                }
            }
            s1 = s;
            steps++;
        }
        return -1;
    }
    private void dfs(int x, int y, int xn, int yn, int[][] A){
        if(x < 0 || y < 0 || x >= xn || y >= yn || A[x][y] != 1)
            return;
        A[x][y] = 2;
        dfs(x+1, y, xn, yn, A);
        dfs(x-1, y, xn, yn, A);
        dfs(x, y+1, xn, yn, A);
        dfs(x, y-1, xn, yn, A);
    }
}
