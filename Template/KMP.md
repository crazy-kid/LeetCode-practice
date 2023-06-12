C++版
```C++
int match (char* P, char* S){ // KMP 算法
    int* next = buildNext(P); // 构造 next 表
    int m = (int) strlen (S), i = 0; // 文本串指针
    int n = (int) strlen(P), j = 0; //模式串指针
    while (j < n && i < m) // 自左向右逐个比对字符
        if (0 > j || S[i] == P[j]) // 若匹配，或 P 已移除最左侧
            {i++; j++;} // 则转到下一字符
        else
            j = next[j]; // 模式串右移（注意：文本串不用回退）
    delete [] next; // 释放 next 表
    return i - j;
}

int* buildNext(char* P) { // 构造模式串 P 的 next 表
    size_t m = strlen(P), j = 0; // “主”串指针
    int* N = new int[m]; // next 表
    int  t = N[0] = -1; // 模式串指针
    while (j < m - 1)
        if ( 0 > t || P[j] == P[t]){ // 匹配
            j++; t++;
            N[j] = t; // 此句可改进为 N[j] = (P[j] != P[t] ? t : N[t]);
        }else // 失配
        t = N[t];
    return N;

}
```

JAVA版
```java
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";

        int i = 0;// 主串下标 这是非降的
        int j = 0;// 字串下标
        int[] next = buildNext(needle);

        while (i < haystack.length()) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                if (j == needle.length() - 1) {
                    System.out.print(i - j);
                    return;
                }
                i++;
                j++;
            } else {
                if (j == 0)
                    i++;
                else {
                    j = next[j - 1];
                }
            }
        }

    }

    public static int[] buildNext(String s) {
        int[] next = new int[s.length()];
        int i = 1;
        int prelen = 0;
        while (i < next.length) {
            if (s.charAt(prelen) == s.charAt(i)) {
                prelen++;
                next[i] = prelen;
                i++;
            } else if (prelen == 0) {
                next[i] = 0;
                i++;
            } else
                prelen = next[prelen - 1];
        }
        return next;
    }
```