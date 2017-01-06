package detail;

import worker.Worker;
import worker.Workerinterface;

public class Teacher extends Worker implements Workerinterface{

	public float calcSalary(){
		return this.getSalaryIndex() * 730 + this.getAllowance() + this.getWorkingCount() *45;
	}

}