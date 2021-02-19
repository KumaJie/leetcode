package leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Kuma
 * @date 2021年2月19日
 * 1631.最小体力消耗路径
 */
public class Lc1631 {
    public int minimumEffortPath(int[][] heights) {
        List<graph> g = new LinkedList<>();
        int row = heights.length;
        int col = heights[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(i + 1 < row){
                    g.add(new graph(i * col + j,(i+1) * col + j,heights[i][j] - heights[i + 1][j]));
                }
                if (j + 1 < col){
                    g.add(new graph(i * col + j,i * col + j + 1,heights[i][j] - heights[i][j + 1]));
                }
            }
        }
        g.sort(Comparator.comparingInt(o -> o.weight));
        UnionFind uf = new UnionFind(row * col);
        for (graph i : g){
            uf.union(i.x,i.y);
            if (uf.check(0,row * col - 1)){
                return i.weight;
            }
        }
        return 0;
    }

    class graph{
        int x;
        int y;
        int weight;

        public graph(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = Math.abs(weight);
        }
    }


    class UnionFind{
        int[] parent;
        int count;
        UnionFind(int k){
            count = k;
            parent = new int[k];
            for (int i = 0; i < k; i++) {
                parent[i] = i;
            }
        }
        int find(int x){
            while (x != parent[x]){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY){
                return;
            }
            parent[rootX] = rootY;
            count--;
        }
        boolean check(int x,int y){
            return find(x) == find(y);
        }
    }
}
