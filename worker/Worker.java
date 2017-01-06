package worker;

public abstract class Worker{

	private String name;
	private float salaryindex;
	private float salary;
	private float allowance;
	private String branch;
	private int workingcount;
	private String level;


	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	public float getSalary(){
		return this.salary;
	}

	public void setSalary(float salary){
		this.salary = salary;
	}

	public float getAllowance(){
		return this.allowance;
	}

	public void setAllowance(float allowance){
		this.allowance = allowance;
	}

	public float getSalaryIndex(){
		return this.salaryindex;
	}

	public void setSalaryIndex(float salaryindex){
		this.salaryindex = salaryindex;
	}	


	public String getBranch(){
		return this.branch;
	}
	
	public void setBranch(String branch){
		this.branch = branch;
	}

	public int getWorkingCount(){
		return this.workingcount;
	}

	public void setWorkingCount(int workingcount){
		this.workingcount = workingcount;
	}

	public String getLevel(){
		return this.level;
	}

	public void setLevel(String level){
		this.level = level;
	}


}