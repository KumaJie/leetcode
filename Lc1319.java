package leetcode;

/**
 * @author Kuma
 * @date 2021年1月23日
 * 1319.连通网络的操作次数
 */
public class Lc1319 {
    public static int makeConnected(int n, int[][] connections) {
//        连通图的最小边数
        if(connections.length < n - 1){
            return -1;
        }
        int[] unionFind = new int[n];
        for (int i = 0; i < unionFind.length; i++) {
            unionFind[i] = i;
        }
        for (int[] connection : connections){
            int a = connection[0];
            int b = connection[1];
            int old = unionFind[a];
            for (int i = 0; i < unionFind.length; i++) {
                if (unionFind[i] == old){
                    unionFind[i] = unionFind[b];
                }
            }
        }
//        通过并查集可以得到连通分量的个数，合并所有连通分量即可求出最少的操作次数
        int result = 0;
        for (int i = 0; i < unionFind.length; i++) {
            if (unionFind[i] == i){
                result++;
            }
        }
        return result-1;
    }

    public static void main(String[] args) {
        int n = 12;
        int[][] b = {{1,5},{1,7},{1,2},{1,4},{3,7},{4,7},{3,5},{0,6},{0,1},{0,4},{2,6},{0,3},{0,2}};
        makeConnected(n,b);
    }
}
