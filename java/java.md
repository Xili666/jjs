# Java #

1. HashMap
    1. java7中HashMap使用拉链法解决冲突,在hash碰撞严重的时候会导致个别位置链表长度过长,严重影响性能
    2. java8中当每个桶的链表长度超过8之后,会将链表转化成红黑树,从而提升增删改查的速度

2. HashMap死锁
    1. HashMap是线程不安全的
    2. HashMap的初始容量大小为16,如果超过的话需要增大Hash表的尺寸,需要将Hash表的数据都重算一遍(reHash)
    3. 如果一个线程在reHash的时候另一个线程突然闯入,也reHash一次,可能就会导致链表出现环形链表,导致死循环
    4. 可以使用HashTable,但是HashTable锁定的是整个表,效率较低,推荐使用ConcurrentHashMap,可以保证读的时候不加锁,写的时候锁粒度尽可能小

3. 局部内部类是放在代码块或方法中的,不能有访问控制修饰符,且不能用static