# DP 买卖股票

## 各题解法思想

### 121 --- 123

- 121 只买卖一次

```
相当于将问题转化为求连续子数组中最大差值
---> 在i日时能获得的最大值
int tmp: 暂时累计能获利的值
int max: 获利的最大值
tmp += price[i] - price[i-1]
tmp = max(tmp,0);
max =  max(max, tmp);
```

- 122 买卖多次

```
可连续买卖 -> 数组中累计最大值
int tmp: 暂时累计能获利的值
int max: 获利的最大值
tmp += price[i] - price[i-1]
tmp = max(tmp,0);
max += tmp;
```

- 123 只能买卖 2 次

```
一. 讨巧做法
设定两组变量
{hold1,sold1}
{hold2,sold2}
分别表示在i日的四种交易方式 买入第一只 卖出第一只 买入第二只 卖出第二只
hold1 = max(hold1,-p) 1.继续持有之前的hold1 2.买入
sold1 = max(sold1,hold1 + p) 1.手里没货，所以是上次卖出的盈利 2.卖出
hold2 = max(hold2,sold1 - p) 1.继续持有之前的hold2 2.买入
sold2 = max(sold2,hold2 + p) 1.手里没货，所以是上次卖出的盈利 2.卖出
最后的 sold2就是最后的获利

二. 通解 --- 可衍生到只能交易k次
需要一个三维dp数组 dp[i日][可交易次数][交易或不交易]
dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k-1][1] - price)
dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k][0] + price)
return dp[len-1][k][1] 这就是最后得到的获利值
```

## 通用解法

```java
public class Solution {
  public int maxProfit(int k, int[] prices) {
    int len = prices.length;
    if (len == 0)
      return 0;
    int[][][] dp = new int[len][k + 1][2];
    for (int i = 0; i < len; i++) {
      for (int t = k; t >= 1; t--) {
        if (i - 1 == -1) {
          dp[0][t][0] = -prices[0];
          dp[0][t][1] = 0;
          continue;
        }
        dp[i][t][0] = Math.max(dp[i - 1][t][0], dp[i - 1][t - 1][1] - prices[i]);
        dp[i][t][1] = Math.max(dp[i - 1][t][1], dp[i - 1][t][0] + prices[i]);
      }
    }
    return dp[len - 1][k][1];
  }
}
```
