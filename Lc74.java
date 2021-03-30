package leetcode;

/**
 * @author Kuma
 * @date 2021年3月30日
 * 74.搜索二维矩阵
 */
public class Lc74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        return binarySearch(matrix, target, 0 , matrix.length * matrix[0].length - 1);
    }

    public static boolean binarySearch(int[][] matrix, int target, int left, int right){
        if (left <= right){
            int mid = (left + right) / 2;
            int i = mid / matrix[0].length;
            int j = mid % matrix[0].length;
            if (matrix[i][j] > target){
                return binarySearch(matrix, target, left, mid - 1);
            }else if (matrix[i][j] < target){
                return binarySearch(matrix, target, mid + 1, right);
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        searchMatrix(arr,3);
    }
}
