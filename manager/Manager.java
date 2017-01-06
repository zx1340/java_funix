package manager;

import detail.Teacher;
import detail.Employees;
import worker.Worker;
import java.util.*;


public class Manager{

	public static Teacher inTeacher(){
		Teacher teacher = new Teacher();
		Scanner reader = new Scanner(System.in);
		
		System.out.print("Ho ten giang vien: ");
		String name = reader.nextLine();

		System.out.print("Khoa: ");
		String branch = reader.nextLine();

		System.out.print("He So luong: ");
		float salaryindex = reader.nextFloat();

		System.out.print("So Tiet Day: ");
		int workingcount = reader.nextInt();


		System.out.println("Nhap 1, 2 hoac 3 tuong ung voi trinh do:");
		System.out.println("1 = Cu Nhan, 2 = Thac Si, 3 = Tien Si");
		int level  = reader.nextInt();

		teacher.setName(name);
		teacher.setBranch(branch);
		teacher.setSalaryIndex(salaryindex);
		switch(level){
			case 1:
				teacher.setLevel("Cu Nhan");
				teacher.setAllowance(300);
				break;
			case 2:
				teacher.setLevel("Thac Si");
				teacher.setAllowance(500);
				break;
			case 3:
				teacher.setLevel("Tien Si");
				teacher.setAllowance(1000);
				break;
			default:
				return null;
		}
		teacher.setWorkingCount(workingcount);
		teacher.setSalary(teacher.calcSalary());
		return teacher;
	}

	public static Employees inEmployees(){
		Employees employees = new Employees();
		Scanner reader = new Scanner(System.in);

		System.out.print("Ho ten Nhan Vien: ");
		String name = reader.nextLine();

		System.out.print("Phong Ban: ");
		String branch = reader.nextLine();

		System.out.print("He So luong: ");
		float salaryindex = reader.nextFloat();
		
		System.out.print("So Ngay Cong: ");
		int workingcount = reader.nextInt();

		System.out.println("Nhap 1, 2 hoac 3 tuong ung voi chuc vu:");
		System.out.println("1 = truong phong, 2 = pho phong, 3 = nhan vien");
		int level  = reader.nextInt();
		
		employees.setName(name);
		employees.setBranch(branch);
		employees.setSalaryIndex(salaryindex);
		employees.setWorkingCount(workingcount);

		switch(level){
			case 1:
				employees.setLevel("Truong Phong");
				employees.setAllowance(2000);
				break;
			case 2:
				employees.setLevel("Pho Phong");
				employees.setAllowance(1000);
				break;
			case 3:
				employees.setLevel("Nhan Vien");
				employees.setAllowance(500);
				break;
			default:
				return null;
		}

		employees.setSalary(employees.calcSalary());
		return employees;
	}	


	public static ArrayList findEmployees(ArrayList allworker,String name, String branch){
		
		ArrayList employeesfound = new ArrayList();
		for (int i = 0; i < allworker.size(); i++) {
			if (allworker.get(i).getClass() == Worker.class){
				Employees employees = (Employees) allworker.get(i);
				String employees_name = employees.getName().toLowerCase();
				String employees_branch = employees.getBranch().toLowerCase();
				if (employees_name.contains(name.toLowerCase()) && employees_branch.equals(branch.toLowerCase())) {
					employeesfound.add(employees);
				}
			}
		}
		return employeesfound;

	}

	public static ArrayList findTeacher(ArrayList allworker){
		ArrayList teacherfound  = new ArrayList();
		for (int i = 0; i < allworker.size(); i++ ){
			if(allworker.get(i).getClass() == Teacher.class){
				Teacher teacher = (Teacher) allworker.get(i);
				teacherfound.add(teacher);
			}
		}
		return teacherfound;
	}

	public static void sortTeacher(ArrayList allteacher){
		Collections.sort(allteacher, new Comparator<Teacher>(){
			public int compare(Teacher t1, Teacher t2){
				if(t1.getName().compareTo(t2.getName()) > 0){
					return 1;
				}
				else {
					if (t1.getName().compareTo(t2.getName()) == 0){
						if(t1.getSalary() < t2.getSalary()){
							return 1;
						}
						else if(t1.getSalary() > t2.getSalary()){
							return -1;
						}
						else{
							return 0;
						}
					}
					else{
						return -1;
					}
				}
			}
		});

	}

}