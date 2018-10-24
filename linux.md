# Linux #

1. 查看中断 `cat /proc/interrupts`
2. 查看CPU信息 `cat /proc/cpuinfo`
3. 查看内存信息 `cat /proc/meminfo`
4. 查看硬盘信息命令 `fdisk -l`
5. 查看当前目录下所有目录以及子目录的大小 `du -h`
6. nginx进程数设置为CPU总核心数最佳, 设置工作模式与连接数上限时，应考虑单个进程最大连接数(最大连接数=连接数*进程数）
7. Linux进程间通讯方式:
    1. UNIX套接字
    2. 信号量
    3. 管道/无名管道
    4. 消息队列
    5. 共享内存
    6. Socket
    7. 文件锁