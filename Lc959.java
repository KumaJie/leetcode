package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Kuma
 * @date 2021年1月25日
 * 959.有斜杠划分的区域
 */
public class Lc959 {
    public static int regionsBySlashes(String[] grid) {
       int n = grid.length;
       int size = 4 * n * n;
       UnionFind unionFind = new UnionFind(size);
        for (int i = 0; i < n; i++) {
            char[] row = grid[i].toCharArray();
            for (int j = 0; j < n; j++) {
                /**
                 * \ 0/
                 * 3\/1
                 *  /\
                 * /2 \
                 * 将一块分为4个部分，其0部分在并查集中下标
                 * */
                int index = 4 * (i * n + j);
                char c = row[j];
//                单元格内合并
                if (c == '\\'){
                    unionFind.union(index,index + 1);
                    unionFind.union(index + 2,index + 3);
                }else if (c == '/'){
                    unionFind.union(index, index + 3);
                    unionFind.union(index + 1,index + 2);
                }else {
                    unionFind.union(index, index + 1);
                    unionFind.union(index + 1,index + 2);
                    unionFind.union(index + 2,index + 3);
                }
//                单元格间合并
//                向右合并
                if(j + 1 < n){
                    unionFind.union(index + 1, 4*(i*n+j+1)+3);
                }
                if (i + 1 < n){
                    unionFind.union(index + 2, 4*((i+1)*n+j));
                }
            }
        }
        return unionFind.getCount();
    }

    public static void dfs(int[][] areas, int i, int j){
        if(i >= 0 && i < areas.length && j >= 0 && j < areas[0].length && areas[i][j] == 0){
            areas[i][j] = 1;
            dfs(areas,i+1,j);
            dfs(areas,i-1,j);
            dfs(areas,i,j+1);
            dfs(areas,i,j-1);
        }
    }

    public static void input(int[][] areas){
        for (int[] area : areas){
            for (int i : area){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] grid = {"/\\", "\\/"};
        regionsBySlashes(grid);
    }

}
class UnionFind{
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

    public void union(int x,int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY){
            return;
        }
        parent[rootX] = rootY;
        this.count--;
    }
}