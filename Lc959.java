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
//        将1*1方格扩展为3*3方格
        int[][] areas = new int[n * 3][n * 3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '/'){
                    for (int k = 0; k < 3; k++) {
                        areas[i * 3 + k][j * 3 + 2 - k] = 1;
                    }
                }
                if (c == '\\'){
                    for (int k = 0; k < 3; k++) {
                        areas[i * 3 + k][j * 3 + k] = 1;
                    }
                }
            }
        }
        input(areas);
        int result = 0;
        Queue<int[]> qu = new LinkedList<>();
        for (int i = 0; i < areas.length; i++) {
            for (int j = 0; j < areas.length; j++) {
                if(areas[i][j] == 0){
//                    dfs(areas,i,j);
                    qu.offer(new int[]{i,j});
                    while (!qu.isEmpty()){
                        int[] tmp = qu.poll();
                        int x = tmp[0];
                        int y = tmp[1];
                        areas[x][y] = 1;
                        if(x + 1 < areas.length && areas[x + 1][y] == 0){
                            qu.offer(new int[]{x + 1, y});
                        }
                        if (y + 1 < areas.length && areas[x][y + 1] == 0){
                            qu.offer(new int[]{x, y + 1});
                        }
                        if(x - 1 >= 0 && areas[x - 1][y] == 0){
                            qu.offer(new int[]{x - 1, y});
                        }
                        if(y - 1 >= 0 && areas[x][y - 1] == 0){
                            qu.offer(new int[]{x, y - 1});
                        }
                    }
                    input(areas);
                    result++;
                }
            }
        }
        System.out.println(result);
        return result;
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