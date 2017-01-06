import manager.*;
import detail.*;
import worker.*;
import java.util.*;


public class Main{

	public static void main(String[] args){
		ArrayList allworker = new ArrayList();

		Scanner scanIn = new Scanner(System.in);
		
		while (true){
			System.out.println("-------------------------------");
			System.out.println("Nhap so tuong ung voi chuc nang:");
			System.out.println("> Nhap 1 de them nhan vien");
			System.out.println("> nhap 2 de tim kiem nhan vien");
			System.out.println("> Nhap 3 de in ra danh sach giang vien");
			System.out.println("-------------------------------");

			int input = scanIn.nextInt();
			switch(input){
				case 1:
					inputWorker(allworker);
					break;
				case 2:
					listEmployees(allworker);
					break;
				case 3:
					listTeacher(allworker);
					break;
				default:
					System.out.println("Chi chon 1 2 hoac 3");
					break;
			}
			
		}

	}

	public static void inputWorker(ArrayList allworker){

		Scanner scanIn = new Scanner(System.in);
		Boolean check = true;
		
		while (check){
			System.out.println("-------------------------------");
			System.out.println("> Chon 1 de nhap giang vien");
			System.out.println("> Chon 2 de nhap nhan vien hanh chinh");
			System.out.println("> Chon 3 de quay lai");
			System.out.println("-------------------------------");

			int input = scanIn.nextInt();
			switch(input){
				case 1:
					Teacher teacher = new Teacher();
					teacher = Manager.inTeacher();
					if (teacher == null){
						System.out.println("Nhap sai,nhap lai");
					}
					else{
						allworker.add(teacher);
					}
					break;
				case 2:
					Employees employees = new Employees();
					employees = Manager.inEmployees();
					if (employees == null){
						System.out.println("Nhap sai, nhap lai");
					}
					else{
						allworker.add(employees);
					}
					break;
				case 3:
					check = false;
					break;
				default:
					System.out.println("Nhap sai, nhap lai");
					break;
			}
		}
	
	}
	public static void listEmployees(ArrayList allworker){
		Scanner scanIn = new Scanner(System.in);
		Boolean check = true;
		while(check){
			System.out.println("-------------------------------");
			System.out.println("> Nhap ho ten cua nhan vien");
			String name = scanIn.nextLine();
			System.out.println("> Nhap phong ban cua nhan vien");
			System.out.println("-------------------------------");
			
			String branch = scanIn.nextLine();
			ArrayList<Employees> employeesfound = new ArrayList<Employees>();
			employeesfound = Manager.findEmployees(allworker,name,branch);
			if (employeesfound.size() == 0){
				System.out.println("Khong tim thay nhan vien nao");
				break;
			}
			else{
				String format = "%-15s%-15s%-15s%-15s%-15s%-15s%-15s%n";
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				
				System.out.printf(format,"HO TEN","PHONG BAN","SO NGAY CONG","HE SO LUONG","PHU CAP","CHUC VU","LUONG");
				for (int i = 0; i < employeesfound.size(); i++){
					Employees employees = (Employees) employeesfound.get(i);
					System.out.printf(format,employees.getName(),employees.getBranch(),employees.getWorkingCount(),employees.getSalaryIndex(),employees.getAllowance(),employees.getLevel(),employees.getSalary());
				}
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

				break;
			}
		}
	}

	public static void listTeacher(ArrayList allworker){
		ArrayList<Teacher> teacherfound = new ArrayList<Teacher>();
		teacherfound = Manager.findTeacher(allworker);
		if (teacherfound.size() == 0){
			System.out.println("Khong tim thay giao vien nao trong danh sach");
		}
		else{
			Manager.sortTeacher(teacherfound);
			String format = "%-15s%-15s%-15s%-15s%-15s%-15s%-15s%n";
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.printf(format,"HO TEN","KHOA","TRINH DO","PHU CAP","SO TIET DAY","HE SO LUONG","LUONG");
			for (int i = 0; i < teacherfound.size(); i++){
				Teacher teacher = (Teacher) teacherfound.get(i);
				System.out.printf(format,teacher.getName(),teacher.getBranch(),teacher.getLevel(),teacher.getAllowance(),teacher.getWorkingCount(),teacher.getSalaryIndex(),teacher.getSalary());
			}
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");


		}
		
	}
}