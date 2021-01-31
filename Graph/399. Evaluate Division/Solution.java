// java使用dfs方法

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];
        
        // 1. build adjcent list
        Map<String, Map<String, Double>> dict = buildGraph(equations, values);
        
        // 2. for tranverse the queries
        for(int i=0; i<queries.size(); i++){
            List<String> query = queries.get(i);
            String start = query.get(0);
            String stop = query.get(1);
            Set<String> seen = new HashSet<>();
            ans[i] = dfs(start, stop, dict, 1.0, seen);
        }
        return ans;
    }
    
    // 3. implement dfs for each query
    private double dfs(String start, String stop, Map<String, Map<String, Double>> dict, double curr, Set<String> seen){
        if(!dict.containsKey(start) || !dict.containsKey(stop))
            return -1;
        if(start.equals(stop))
            return curr;
        for(Map.Entry<String, Double> entry: dict.get(start).entrySet()){
            String next = entry.getKey();
            if(!seen.contains(next)){
                seen.add(next);
                double num = dfs(next, stop, dict, curr*entry.getValue(), seen);
                if(num>0)
                    return num;
                // seen.remove(next);
            }
        }
        return -1.0;
    }
    
    // function to build a graph in step 1
    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values){
        Map<String, Map<String, Double>> dict = new HashMap<>();
        for(int i=0; i<equations.size(); i++){
            String key1 = equations.get(i).get(0);
            String key2 = equations.get(i).get(1);
            dict.putIfAbsent(key1, new HashMap<String, Double>());
            dict.putIfAbsent(key2, new HashMap<String, Double>());
            dict.get(key1).put(key2, values[i]);
            dict.get(key2).put(key1, 1.0/values[i]);
        }
        return dict;
    }
        
}
