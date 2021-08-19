### algorithm interview

#### Ebay

- 链表是否有环: 快慢指针
- 环在哪个位置: 当 ^ 快慢指针相遇时，记录相遇位置。 然后设置两个指针一个头，一个在相遇点。同时向前走，步长一致，两者相遇便是环出现的位置。
- 环的长度: 当^^ 快慢指针相遇，在相遇点继续进行快慢指针，计数，再次相遇时退出，得到环的长度。
- 整个链表的长度: 计算 head 到环的位置 + 环的长度
- 两个链表相加: 翻转链表 —> 从头开始加 -> 进位 -> 再把链表串起来。

#### ByteDance

- Meeting Room II: (prime) 时间区间问题：根据 `时间` 排序， 开始会议为正，结束会议为负。取 遇到 正数 room++，负数 room--。取 Max(room)

- 给定一个数组 [1,2,3,0] 求从左到右的最大差值

#### Trips

- 有序数组中找出给出元素首次出现的位置
- 场景题: mq 的限速问题

```
| topic | --> onMessage()
onMessage(Msg msg){
  ... 添加限速条件
  callRpcService();  // 一次可查询100条id，一分钟只能call 10次
}
```

```
思路
1. topic 的速度 正常/快/慢
2. callRpcService的限制
3. 在快的时候把速度降下来，在慢的时候保持速率
4.1 queue -> 在快的时候把速度降下来
4.2 定时器 -> 当queue不为空时，最多取100个id，每0.1秒请求一次。 -> 慢的时候不影响
```

### 一致性 Hash

### introduce in english

From September 2018 to July 2020, I worked as a back-end developer at Airwallex. Now I am working for Pingan asset as a Java developor.
For me, the most proud project is to set up Campaign Service. I built it from zero to one. I choose nodejs as the backend language, redis as the middleware and store the data in mysql. In Business Logic, when a user registers from our website or mini-app, the user will join our latest activity, which is configured by our colleagues in the management service. Our colleagues can configure some awards for the campaign. After users complete the campaign, we will reward them. For me, this project is the first project I designed the framework and successfully built. Now we can also find it in our weixin mini-app.
Finally, let me introduce my spare time. I like to read some technical books and watch football matches.
Yes, nothing more.

### citi

HashMap 和 HashTable 的区别

1. 线程安全
2. Map 的 key val 可以为 null
3. Hashtable 计算 hash 是直接使用 key 的 hashcode 对 table 数组的长度直接进行取模。HashMap 计算 hash 对 key 的 hashcode 进行了二次 hash，以获得更好的散列值，然后对 table 数组长度取模
4. HashMap 继承了 AbstractMap，HashTable 继承 Dictionary 抽象类，两者均实现 Map 接口

TreeMap

1. Map 接口实现
2. TreeMap 无容量限制
3. key 值不能为 null
4. 排序使用 compare 方法或者是直接比较 key 值（compareTo）
5. O(logn)

B 树
B 树也称 B-树,它是一颗多路平衡查找树。二叉树我想大家都不陌生，其实，B 树和后面讲到的 B+树也是从最简单的二叉树变换而来的，并没有什么神秘的地方，下面我们来看看 B 树的定义。

每个节点最多有 m-1 个关键字（可以存有的键值对）。
根节点最少可以只有 1 个关键字。
非根节点至少有 m/2 个关键字。
每个节点中的关键字都按照从小到大的顺序排列，每个关键字的左子树中的所有关键字都小于它，而右子树中的所有关键字都大于它。
所有叶子节点都位于同一层，或者说根节点到每个叶子节点的长度都相同。
每个节点都存有索引和数据，也就是对应的 key 和 value。

B+树
B+树有两种类型的节点：内部结点（也称索引结点）和叶子结点。内部节点就是非叶子节点，内部节点不存储数据，只存储索引，数据都存储在叶子节点。
内部结点中的 key 都按照从小到大的顺序排列，对于内部结点中的一个 key，左树中的所有 key 都小于它，右子树中的 key 都大于等于它。叶子结点中的记录也按照 key 的大小排列。
每个叶子结点都存有相邻叶子结点的指针，叶子结点本身依关键字的大小自小而大顺序链接。
父节点存有右孩子的第一个元素的索引。
