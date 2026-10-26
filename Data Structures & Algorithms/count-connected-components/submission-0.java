class Solution {
    private HashSet<Integer> visited;
    private int result;
    public int countComponents(int n, int[][] edges) {
        visited = new HashSet<>();
        result = 0;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i = 0; i < n; i++){
            if(!visited.contains(i)){
                dfs(adj, i);
                result++;
            }
        }
        return result;
    }
    private void dfs(List<List<Integer>> adj, int curr){
        if(visited.contains(curr)){
            return;
        }
        visited.add(curr);
        for(int temp: adj.get(curr)){
            dfs(adj, temp);
        }
    }
}
