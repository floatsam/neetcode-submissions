class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1)
            return false;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(0);
        visited.add(0);

        while(!q.isEmpty()){
            int temp = q.poll();
            for(int num : adj.get(temp)){
                if(!visited.contains(num)){
                    q.add(num);
                    visited.add(num);
                }
            }
        }

        return visited.size() == n;
    }
}
