package JAVA.Mid;

import java.util.HashMap;

class mid_677 {

    HashMap<Character, mid_677> children = new HashMap<Character, mid_677>();
    boolean isEnd = false;
    int val = 0;

    public mid_677() {

    }

    public void insert(String key, int val) {
        char start = key.charAt(0);
        if (!children.containsKey(start)) {
            mid_677 child = new mid_677();
            children.put(start, child);
        }
        if (key.length() == 1) {
            children.get(start).isEnd = true;
            children.get(start).val = val;
        } else {
            children.get(start).insert(key.substring(1, key.length()), val);
        }
    }

    public int sum(String prefix) {
        if (prefix.length() == 0)
            return subSum();
        else {
            char start = prefix.charAt(0);
            if (children.containsKey(start))
                return children.get(start).sum(prefix.substring(1, prefix.length()));
            else
                return 0;
        }
    }

    public int subSum() {
        int ans = 0;
        if (isEnd)
            ans += val;
        for (char key : children.keySet()) {
            ans += children.get(key).subSum();
        }
        return ans;
    }
}
