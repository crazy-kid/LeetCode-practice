# 0-1背包问题

## 问题描述
设有长度为$n$的两个数组weight和value表示$n$个不同的物品的重量和价值。现在有一个最大载重为$m$的背包。现在将一些物品放入背包，求解背包中物品价值之和的最大值。

## 求解方式
利用动态规划求解

$dp[i][j]$定义为从前$i$个物品中选择且总重量不超过$j$时背包价值之和的最大值。

那么我们可以得到动态规划方程

$$
dp[i][j]=
\begin{cases}
    dp[i-1][j-value[i]],&\text{选择第}i\text{个物品}\\
    dp[i-1][j], &\text{不选择第}i\text{个物品}
\end{cases}
$$

所求答案即为$dp[n][m]$

> https://www.bilibili.com/video/BV1cg411g7Y6/?spm_id_from=333.337.search-card.all.click&vd_source=d4271b6eacb73942c28e1384bb8e8bd7