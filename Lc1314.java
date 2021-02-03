/**
* @author Kuma
* @date 2021年2月3日
* 1314.矩阵区域和
*/
class Lc1314{
  public int[][] matrixBlockSum(int[][] mat, int K) {
        int M = mat.length;
        int N = mat[0].length;
        int[][] res = new int[M][N];
        int[][] dp = new int[M+1][N+1];
        for(int i = 1;i < M+1;i++){
            for(int j = 1;j < N+1;j++){
                dp[i][j] = mat[i - 1][j - 1] + dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1];
                System.out.print(dp[i][j] + " ");        
            }
            System.out.println();
        }
        for(int i = 0;i < M;i++){
            int rl = i - K >= 0 ? i - K : 0;
            int rr = i + K >= M ? M - 1 : i + K;
            for(int j = 0;j < N;j++){
                int cl = j - K >= 0 ? j - K : 0;
                int cr = j + K >= N ? N - 1 : j + K;
                res[i][j] = dp[rr + 1][cr + 1] - dp[rr + 1][cl] - dp[rl][cr+1] + dp[rl][cl];
            }
        }
        return res;
    }
}
