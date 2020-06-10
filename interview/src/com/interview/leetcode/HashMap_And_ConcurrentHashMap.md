```
ConcurrentHashMap
table : Node<K,V>[] table

putVal: if table.length < 1 -> initTable
        if current.hash == -1 -> resize
        add element -> synchronized
        if linkedList.size > 8 -> toTree


get: hash(key) -> in bucket -> return val -> tree.find(key) (O(logn)) -> find in LinkedList

LinkedHashMap extends HashMap implement Map
put() == HashMap.put()

Overwrite get()
if first Node is matched -> return first Node
if typeof Node == TreeNode -> find element in Tree
if typeof Node == LinkedNode -> find element in ListNode

```
