package unix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Fcfs
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/06/22 14:22
 */
public class Fcfs {
	//进程队列
	private static List<Process> processList=new ArrayList<>();
	//系统处理线程的总耗时
	private static Float time;
	//平均周转时间
	private static float averageTurnaroundTime;
	//平均等待时间
	private static float averageWaitingTime;
	//平均带权周转时间
	private static float averageWeightedTurnaroundTime;
	//运行的主函数
	public static void main(String[] args) {
		init();
		input();
		List<Process> list = FSFC();
		for (Process process: list) {
			System.out.println("进程名："+process.getJobName()+
					"，到达时间："+process.getTimeOfArrival()+
					"，运行时间："+process.getServiceHours()+
					"，开始执行时间：" + process.getStartExecutionTime()+
					"，完成时间："+process.getCompleteTime()+
					"，周转时间："+process.getTurnaroundTime()+
					"，带权周转时时间："+process.getWeightedTurnaroundTime()+
					"，等待时间："+process.getWritTime());
		}
		calculateTheAverage(list);
		System.out.println("处理总时间为："+time+
				"，平均周转时间："+averageTurnaroundTime+
				"，平均带权周转时间："+averageWaitingTime+
				"，平均等待时间："+averageWeightedTurnaroundTime);
	}

	/**
	 * 初始化链表
	 */
	public static void init(){
		System.out.println("请输入要处理的线程数");
		Scanner scanner = new Scanner(System.in);
		int length = scanner.nextInt();
		for(int i =0 ;i<length;i++){
			processList.add(new Process());
		}
	}

	/**
	 * 输入线程名和到达时间和服务时间
	 */
	public static void input(){
		for (int i =0;i<processList.size();i++){
			Process process = processList.get(i);
			System.out.println("请输入第"+(i+1)+"个线程名：");
			Scanner scanner = new Scanner(System.in);
			process.setJobName(scanner.next());
			System.out.println("请输入第"+(i+1)+"个线程的到达时间：");
			process.setTimeOfArrival(scanner.nextFloat());
			System.out.println("请输入第"+(i+1)+"个线程的服务时间");
			process.setServiceHours(scanner.nextFloat());
		}
	}

	/**
	 * 发现集合中的最小值，并返回其对应的下标
	 * @return
	 */
	public static int findMin(){
		//获得第一个进程的到达时间
		float min = processList.get(0).getTimeOfArrival();
		for (int i =0 ;i<processList.size();i++){
			if(min > processList.get(i).getTimeOfArrival()){
				min = processList.get(i).getTimeOfArrival();
			}
		}
		for(int i = 0;i<processList.size();i++){
			if(min == processList.get(i).getTimeOfArrival()){
				return i;
			}
		}
		return -1;
	}

	public static List<Process> FSFC(){
		List<Process> completionQueue = new ArrayList<>();//完成队列
		int index = 0;
		while (processList.size() != 0){
			//发现集合中的进程到达时间最小的下标
			index = findMin();
			//判断进程处理总时间是否为空，为空说明PCB刚刚开始
			//获得对应下标的对象
			Process process = processList.get(index);
			if(time == null){   //系统开始为第一个进程服务
				//第一个进程，开始执行时间 = 进程到达时间
				process.setStartExecutionTime(process.getTimeOfArrival());  //计算开始执行时间
				//完成时间 = 开始执行时间 + 服务时间
				process.setCompleteTime(process.getStartExecutionTime()+process.getServiceHours());
				//周转时间 = 完成时间 - 达到时间
				process.setTurnaroundTime(process.getCompleteTime() - process.getTimeOfArrival());
				//带权周转时间 = 周转时间 / 运行时间（服务时间）
				process.setWeightedTurnaroundTime(process.getTurnaroundTime() / process.getServiceHours());
				//等待时间 = 周转时间 - 运行时间
				process.setWritTime(process.getTurnaroundTime() - process.getServiceHours());
				//此时系统时间 = 该进程的完成时间
				time = process.getCompleteTime();

			}else {
				//如果前一个完成时间 ，小于到达时间，系统有空闲
				if(time < process.getTimeOfArrival()){
					float idle = process.getTimeOfArrival() - time;//空闲出来的时间
					time += idle;
				}
				//排除第一个进程 开始执行时间 = 系统时间
				process.setStartExecutionTime(time);
				//完成时间 = 开始执行时间 + 服务时间（运行时间）
				process.setCompleteTime(process.getStartExecutionTime() + process.getServiceHours());
				//周转时间 = 完成时间 - 到达时间
				process.setTurnaroundTime(process.getCompleteTime() - process.getTimeOfArrival());
				//带权周转时间 = 周转时间 / 运行时间（服务时间）
				process.setWeightedTurnaroundTime(process.getTurnaroundTime() / process.getServiceHours());
				//等待时间 = 周转时间 - 运行时间
				process.setWritTime(process.getTurnaroundTime() - process.getServiceHours());
				//修正系统时间  此时系统时间 = 原来系统时间 + 此进程的完成时间(服务时间)
				time += process.getServiceHours();
			}
			//将处理完成的进程添加到完成队列中
			completionQueue.add(process);
			//将进程移出原先队列
			processList.remove(index);

		}
		return completionQueue;
	}

	/**
	 * 根据传入的集合
	 * 计算平均周转时间、平均带权周转时间、平均等待时间
	 */
	public static void calculateTheAverage(List<Process> processList){
		float turnaroundTime = 0;//总周转时间
		float weightedTurnaroundTime = 0;//总带权周转时间
		float waitingTime = 0;//总等待时间
		for (Process process: processList) {
			turnaroundTime += process.getTurnaroundTime();
			weightedTurnaroundTime += process.getWeightedTurnaroundTime();
			waitingTime += process.getWritTime();
		}
		averageTurnaroundTime = turnaroundTime / processList.size();
		averageWaitingTime = waitingTime / processList.size();
		averageWeightedTurnaroundTime = weightedTurnaroundTime / processList.size();
	}//计算平均

}
