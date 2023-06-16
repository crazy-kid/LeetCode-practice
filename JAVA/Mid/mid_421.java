package JAVA.Mid;

class Trie {
    Trie[] children = new Trie[2];

    Trie() {
    }

    void add(int num) {
        Trie cur = this;
        for (int i = 30; i >= 0; i--) {
            int mask = 1 << i;
            int bit = Integer.bitCount(num & mask);
            if (cur.children[bit] == null) {
                cur.children[bit] = new Trie();
            }
            cur = cur.children[bit];
        }
    }

    int maxXOR(int num) {
        int other = 0;
        Trie cur = this;
        for (int i = 30; i >= 0; i--) {
            int mask = 1 << i;
            int bit = Integer.bitCount(num & mask);
            bit = 1 - bit;
            if (cur.children[bit] == null) {
                cur = cur.children[1 - bit];
                other += (1 - bit) * mask;
            } else {
                cur = cur.children[bit];
                other += bit * mask;
            }
        }
        return other ^ num;
    }
}

public class mid_421 {

    public static void main(String[] args) {
        int[] nums = { 3, 10, 5, 25, 2, 8 };

        Trie root = new Trie();
        for (int i : nums) {
            root.add(i);
        }
        int ans = 0;
        for (int i : nums) {
            ans = Math.max(ans, root.maxXOR(i));
        }
    }
}
