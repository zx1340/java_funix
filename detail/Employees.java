package detail;

import worker.Worker;
import worker.Workerinterface;


public class Employees extends Worker implements Workerinterface{

	public float calcSalary(){
		return this.getSalaryIndex() * 730 + this.getAllowance() + this.getWorkingCount() * 30;
	}


}