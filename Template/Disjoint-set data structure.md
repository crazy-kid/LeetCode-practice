```java
int[] p = new int[n];//p[i]:节点i所属的集合
int[] size = new int[n];//size[i]节点i所属集合中的节点数量

for (int i = 0; i < n; ++i) {
    p[i] = i;
    size[i] = 1;
}

//返回节点i当前应该属于的集合，并且将连接的节点所属集合进行统一
int find(int x) {    
    if (p[x] != x) {
        // 路径压缩
        p[x] = find(p[x]);
    }
    return p[x];
}

//将节点a并入节点b所在集合
void union(int a, int b) {
    int pa = find(a), pb = find(b);
    if (pa == pb) {
        return;
    }
    p[pa] = pb;
    size[pb] += size[pa];
}
```    