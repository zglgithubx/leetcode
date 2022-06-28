package unix;

import java.util.Objects;

/**
 * @ClassName Process
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/06/22 14:20
 */
public class Process {
	//定义成员变量
	private String jobName;     //作业名
	private String status;//状态
	private Float timeOfArrival;//到达时间
	private Float serviceHours;   //服务时间
	//前三个变量是需要我们自己传入的，后面是用过计算得到的
	private Float startExecutionTime;//开始执行时间
	private Float completeTime;   //完成时间
	private Float turnaroundTime; //周转时间
	private Float weightedTurnaroundTime;//带权周转时间
	private Float writTime;//等待时间
	//构造函数
	//空参
	public Process() {
	}
	//全参
	public Process(String jobName, String status, Float timeOfArrival, Float serviceHours, Float startExecutionTime, Float completeTime, Float turnaroundTime, Float weightedTurnaroundTime, Float writTime) {
		this.jobName = jobName;
		this.status = status;
		this.timeOfArrival = timeOfArrival;
		this.serviceHours = serviceHours;
		this.startExecutionTime = startExecutionTime;
		this.completeTime = completeTime;
		this.turnaroundTime = turnaroundTime;
		this.weightedTurnaroundTime = weightedTurnaroundTime;
		this.writTime = writTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public Float getTimeOfArrival() {
		return timeOfArrival;
	}
	public void setTimeOfArrival(Float timeOfArrival) {
		this.timeOfArrival = timeOfArrival;
	}
	public Float getServiceHours() {
		return serviceHours;
	}
	public void setServiceHours(Float serviceHours) {
		this.serviceHours = serviceHours;
	}
	public Float getStartExecutionTime() {
		return startExecutionTime;
	}
	public void setStartExecutionTime(Float startExecutionTime) {
		this.startExecutionTime = startExecutionTime;
	}
	public Float getCompleteTime() {
		return completeTime;
	}
	public void setCompleteTime(Float completeTime) {
		this.completeTime = completeTime;
	}
	public Float getTurnaroundTime() {
		return turnaroundTime;
	}
	public void setTurnaroundTime(Float turnaroundTime) {
		this.turnaroundTime = turnaroundTime;
	}
	public Float getWeightedTurnaroundTime() {
		return weightedTurnaroundTime;
	}
	public void setWeightedTurnaroundTime(Float weightedTurnaroundTime) {
		this.weightedTurnaroundTime = weightedTurnaroundTime;
	}
	public Float getWritTime() {
		return writTime;
	}
	public void setWritTime(Float writTime) {
		this.writTime = writTime;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Process process = (Process) o;
		return Objects.equals(jobName, process.jobName) && Objects.equals(status, process.status) && Objects.equals(timeOfArrival, process.timeOfArrival) && Objects.equals(serviceHours, process.serviceHours) && Objects.equals(startExecutionTime, process.startExecutionTime) && Objects.equals(completeTime, process.completeTime) && Objects.equals(turnaroundTime, process.turnaroundTime) && Objects.equals(weightedTurnaroundTime, process.weightedTurnaroundTime) && Objects.equals(writTime, process.writTime);
	}
	@Override
	public int hashCode() {
		return Objects.hash(jobName, status, timeOfArrival, serviceHours, startExecutionTime, completeTime, turnaroundTime, weightedTurnaroundTime, writTime);
	}
	@Override
	public String toString() {
		return "Process{" +
				"jobName='" + jobName + '\'' +
				", status='" + status + '\'' +
				", timeOfArrival=" + timeOfArrival +
				", serviceHours=" + serviceHours +
				", startExecutionTime=" + startExecutionTime +
				", completeTime=" + completeTime +
				", turnaroundTime=" + turnaroundTime +
				", weightedTurnaroundTime=" + weightedTurnaroundTime +
				", writTime=" + writTime +
				'}';
	}
}

