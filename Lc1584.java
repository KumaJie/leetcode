package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Kuma
 * @date 2021年1月23日
 * 1584.连接所有点的最小费用
 */
public class Lc1584 {
    public static int minCostConnectPoints(int[][] points) {
        /*
          Kruskal算法
         */
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                edges.add(new Edge(i,j,dist(points,i,j))) ;
            }
        }
        edges.sort(Comparator.comparingInt(o -> o.len));
        int[] unionFind = new int[points.length];
        for (int i = 0; i < unionFind.length; i++) {
            unionFind[i] = i;
        }
        int result = 0;
        for (Edge edge : edges){
            int x = edge.x;
            int y = edge.y;
            if(unionFind[x] != unionFind[y]){
                result += edge.len;
                int old = unionFind[x];
                for (int i = 0; i < unionFind.length; i++) {
                    if(unionFind[i] == old){
                        unionFind[i] = unionFind[y];
                    }
                }
            }
        }
        System.out.println(result);
        return result;
    }

    public static int dist(int[][] points, int x,int y){
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }

    public static void main(String[] args) {
        int[][] b = {{0,0},{1,1},{1,0},{-1,1}};
        minCostConnectPoints(b);
    }
}
class Edge{
    int x;
    int y;
    int len;

    public Edge(int x, int y, int len) {
        this.x = x;
        this.y = y;
        this.len = len;
    }
}