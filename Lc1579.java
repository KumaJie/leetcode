package leetcode;

/**
 * @author Kuma
 * @date 2021年1月27日
 * 1579.保证图可完全遍历
 */
public class Lc1579 {
    public static int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind unionFindA = new UnionFind(n);
        UnionFind unionFindB = new UnionFind(n);
        for (int[] edge : edges){
            int u = edge[1] - 1;
            int v = edge[2] - 1;
            if (edge[0] == 1){
                unionFindA.union(u,v,1);
            }else if(edge[0] == 2){
                unionFindB.union(u,v,2);
            }else {
                unionFindA.union(u,v,3);
                unionFindB.union(u,v,3);
            }
        }
        return 0;

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

        public void union(int x,int y,int type){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return;
            }
            parent[rootX] = rootY;
            if (type != 3){
                this.count--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};
        int n = 4;
        maxNumEdgesToRemove(n,a);
    }
}


