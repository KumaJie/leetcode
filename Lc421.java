package leetcode;

/**
 * @author Kuma
 * @date 2021年5月16日
 * 421.数组中两个数的最大异或值
 */
public class Lc421 {
    static class Trie{
        Trie[] next = new Trie[2];

        void insert(int x){
            Trie root = this;
//            将x按位分解
            for (int i = 31; i >= 0; i--) {
                int u = x >> i & 1;
                if (root.next[u] == null){
                    root.next[u] = new Trie();
                }
                root = root.next[u];
            }
        }

        int search(int x){
            Trie root = this;
            int res = 0;
            for (int i = 31; i >= 0; i--){
                int u = x >> i & 1;
//                相反方向
                int r = 1 - u;
                if (root.next[r] != null){
                    root = root.next[r];
                    res = res * 2 + r;
                }else {
                    root = root.next[u];
                    res = res * 2 + u;
                }
            }
            return res ^ x;
        }
    }
    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie();
        for (int i : nums){
            root.insert(i);
        }
        int res = 0;
        for (int i : nums){
            res = Math.max(res, root.search(i));
        }
        return res;
    }
}
