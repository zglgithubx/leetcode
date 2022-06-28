package unix;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;

/**
 * @ClassName MultiThread
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/06/23 10:50
 */
public class MultiThread {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(args));
		// 获取 Java 线程管理 MXBean
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		// 不需要获取同步的 monitor 和 synchronizer 信息，仅获取线程和线程堆栈信息
		ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
		// 遍历线程信息，仅打印线程 ID 和线程名称信息
		for (ThreadInfo threadInfo : threadInfos) {
			System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
		}
		/*结果：
		 [6] Monitor Ctrl-Break //监听线程转储或“线程堆栈跟踪”的线程
		 [5] Attach Listener //负责接收到外部的命令，而对该命令进行执行的并且把结果返回给发送者
		 [4] Signal Dispatcher // 分发处理给 JVM 信号的线程
		 [3] Finalizer //在垃圾收集前，调用对象 finalize 方法的线程
		 [2] Reference Handler //用于处理引用对象本身（软引用、弱引用、虚引用）的垃圾回收的线程
		 [1] main //main 线程,程序入口
		 */
	}
}
