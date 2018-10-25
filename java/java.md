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

4. [变量设置为null之后,引用并不会释放](Reference.java)(*如果是可达对象*)

5. java的四种引用类型
    1. 强引用,  只要引用存在, 就不会gc
    2. 软引用,  非必须引用，内存溢出之前进行回收, 软引用主要用户实现类似缓存的功能，在内存足够的情况下直接通过软引用取值，无需从繁忙的真实来源查询数据，提升速度；当内存不足时，自动删除这部分缓存数据，从真正的来源查询这些数据
    3. 弱引用,  第二次垃圾回收时回收, 弱引用是在第二次垃圾回收时回收，短时间内通过弱引用取对应的数据，可以取到，当执行过第二次垃圾回收时，将返回null, 弱引用主要用于监控对象是否已经被垃圾回收器标记为即将回收的垃圾，可以通过弱引用的isEnQueued方法返回对象是否被垃圾回收器标记
    4. 虚引用,  虚引用是每次垃圾回收的时候都会被回收，通过虚引用的get方法永远获取到的数据为null，因此也被成为幽灵引用。 虚引用主要用于检测对象是否已经从内存中删除

6. 关于clone()
    1. clone() 是一个protect方法,所以只能在类内部中调用
    2. [Cloneable](Clone.java)接口只是起一个标识作用,如果调用clone()方法必须要有,否则会抛出CloneNotSupportedException
    3. 基本数据类型能自动实现深度克隆

7. 包装类和String都是final类
8. [String的细节研究](StringLearn.java)
    1. 使用intern()会在字符常量区寻找字符串的引用,然后返回,没有会创建一个
    2. 有变量时的字符串`+`和`"a" + "b"`不是同一个引用,前者放在堆区

9. 父类静态域——>子类静态域——>父类成员初始化——>父类构造块——>父类构造方法——>子类成员初始化——>子类构造块——>子类构造方法
    1. 考虑到方法重写和多态的特性,所以这种题目很多坑

10. 数组空间分配在堆上
11. 定义在同一个包内的类可以不经过import而直接相互使用
12. 在为Integer赋值的时候,会默认调用Integer.valueOf(int) 方法
    ```java
    public static Integer valueOf(int i) {
        static final int low = -128;
        static final int 127;   // java.lang.Integer.IntegerCache.high
        if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);
    }
    ```
    在-128到127之间的数字直接从cache中获取,对Integer的对象地址是不变的
13. 真数组: 数组元素在内存中是连续顺序存放的
14. Java中常见的锁类型([并发编程网](http://ifeve.com/java_lock_see/))
    1. 自旋锁
    2. 自旋锁的其它种类
    3. 阻塞锁
    4. 可重入锁
    5. 读写锁
    6. 互斥锁
    7. 悲观锁
    8. 乐观锁
    9. 公平锁
    10. 非公平锁
    11. 偏向锁
    12. 对象锁
    13. 线程锁
    14. 锁粗化
    15. 轻量级锁
    16. 锁消除
    17. 锁膨胀
    18. 信号量
15. struts1和struts2的区别
    1. 从action类上分析
        1. Struts1要求Action类继承一个抽象基类.Struts1的一个普遍问题是使用抽象类编程而不是接口
        2. Struts 2 Action类可以实现一个Action接口,也可实现其他接口,使可选和定制的服务成为可能.Struts2提供一个ActionSupport基类去实现常用的接口.Action接口不是必须的,任何有execute标识的POJO对象都可以用作Struts2的Action对象
    2. 从Servlet 依赖分析
        1. Struts1 Action 依赖于`Servlet API` ,因为当一个Action被调用时`HttpServletRequest` 和 `HttpServletResponse` 被传递给execute方法
        2. Struts 2 Action不依赖于容器，允许Action脱离容器单独被测试。如果需要，Struts2 Action仍然可以访问初始的request和response. 但是,其他的元素减少或者消除了直接访问HttpServetRequest 和 HttpServletResponse的必要性
    3. 从action线程模式分析
        1. **Struts1 Action是单例模式**并且必须是线程安全的,因为仅有Action的一个实例来处理所有的请求.单例策略限制了Struts1 Action能作的事,并且要在开发时特别小心.Action资源必须是线程安全的或同步的.
        2. Struts2 Action对象为每一个请求产生一个实例，因此没有线程安全问题
16. 抽象类方法的默认访问权限:
    1. JDK 1.8以前，抽象类的方法默认访问权限为`protected`
    2. JDK 1.8时，抽象类的方法默认访问权限变为default
17. 接口的方法的默认访问权限:
    1. JDK 1.8以前，接口中的方法必须是`publi`c的
    2. JDK 1.8时，接口中的方法可以是`public`的，也可以是default的
    3. JDK 1.9时，接口中的方法可以是private的
18. Struts框架中如果要使用Validation作验证的话,要使用`DynaValidatorActionForm`(动态验证表单)
19. 面向对象5大基本原则:(立方体(solid))
    1. 单一职责原则（SRP）
        一个类，最好只做一件事，只有一个引起它的变化
        单一职责原则可以看做是低耦合、高内聚在面向对象原则上的引申，将职责定义为引起变化的原因，以提高内聚性来减少引起变化的原因
    2. 开放封闭原则（OCP）
        软件实体应该是可扩展的，而不可修改的。也就是，对扩展开放，对修改封闭的
    3. 里氏替换原则（LSP）
        子类必须能够替换其基类。这一思想体现为对继承机制的约束规范，只有子类能够替换基类时，才能保证系统在运行期内识别子类，这是保证继承复用的基础
    4. 依赖倒置原则（DIP）
        依赖于抽象。具体而言就是高层模块不依赖于底层模块，二者都同依赖于抽象；*抽象不依赖于具体，具体依赖于抽象*
    5. 接口隔离原则（ISP）
        使用多个小的专门的接口，而不要使用一个大的总接口
20. String.replaceAll(String ragex, String str) // 正则匹配,需要尤其注意 //. * 等坑
21. `ResultSet`的索引是从**1**开始的
22. Java I/O 概述:
    1. 磁盘操作: File
    2. 字节操作: InputStream和OutputStream
    3. 字符操作: Reader和Writer
    4. 对象操作: Serializable
    5. 网络操作: Socket
    6. 新的输入输出: NIO