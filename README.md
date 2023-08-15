# LeetCode-practice

- [LeetCode-practice](#leetcode-practice)
  - [JAVA NOTE](#java-note)
    - [`hashCode()`](#hashcode)
      - [Remark](#remark)
      - [**Example 1**](#example-1)

## JAVA NOTE
### `hashCode()`
#### Remark
1. 任何`class`都有`hashCode()`。
2. 返回值与对象在内存中的地址无关，只和内存中的内容有关。
3. 若两个对象的`equal()`返回为`true`，那么他们的`hashCode()`也返回相同的值，反之则不一定。
4. 同一个对象只要内容没有变化，`hashCode()`返回值也不会改变。
5. 该特性将影响到以`hashCode()`为核心的`HashMap`，`HashSet`等类。
   
#### **Example 1**
```Java
    String a = "abc";
    String b = "abc";
    System.out.println(a.hashCode() == b.hashCode());
```
***output:*** 
```Java
    >> true
```