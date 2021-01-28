package leetcode;

/**
 * @author Kuma
 * @date 2021年1月27日
 * 1579.保证图可完全遍历
 */
public class Lc1579 {
    public static int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind a = new UnionFind(n);
        UnionFind b = new UnionFind(n);
        int ans = 0;
        for(int[] edge : edges){
            edge[1]--;
            edge[2]--;
//             公共边
            if(edge[0] == 3){
                if(!a.union(edge[1],edge[2])){
                    ans++;
                }else{
                    b.union(edge[1],edge[2]);
                }
            }
        }
//         独占边
        for(int[] edge : edges){
            if(edge[0] == 1){
                if(!a.union(edge[1],edge[2])){
                   ans++; 
                }
            }else if(edge[0] == 2){
                if(!b.union(edge[1],edge[2])){
                    ans++;
                }
            }
        }
        if(a.getCount() != 1 || b.getCount() != 1){
            return -1;
        }
        return ans;
    }
    static class  UnionFind{
        private int[] parent;
        //    连通分量
        private int count;

        public int getCount() {
            return count;
        }

        public UnionFind(int n){
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x){
            while (x != parent[x]){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public boolean union(int x,int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return false;
            }
            parent[rootX] = rootY;
            this.count--;
            return true;
        }
    }

    public static void main(String[] args) {
        int[][] a = {{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};
        int n = 4;
        maxNumEdgesToRemove(n,a);
    }
}


