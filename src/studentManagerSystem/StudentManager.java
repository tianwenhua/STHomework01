package studentManagerSystem;


//错误号码26  import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
	//错误号码 4  学生列表，用于存储学生信息
	ArrayList<Student> stuList = new ArrayList<Student>();
	//错误号码26	 Scanner in = new Scanner(System.in);
	Scanner in = new Scanner(System.in);
	//错误号码 4  构造函数，初始化学生列表
	public StudentManager() {
		Student stu = new Student(2018012559, "twh", "19990115", true);
		stuList.add(stu);
	}
	//错误号码 4  插入数据
	public void insert() {
		//错误号码26	 Scanner in = new Scanner(System.in);
		Student stu = new Student();
		int id = 0;
		String name = null;
		String birDate = null;
		boolean gender = false;
		System.out.println("请输入学号：");
		id = in.nextInt();
		System.out.println("请输入姓名：");
		name = in.next();
		System.out.println("请输入生日：");
		birDate = in.next();
		System.out.println("性别男？(true/false)");
		gender = in.nextBoolean();
		stu.setId(id);
		stu.setName(name);
		stu.setBirDate(birDate);
		stu.setMan(gender);
		stuList.add(stu);
	}
	//错误号码 4  打印学生列表信息
	public void printInfo(Student stu) {
		int id = stu.getId();
		String name = stu.getName();
		String birDate = stu.getBirDate();
		String gender = stu.isMan() ? "男" : "女";
		System.out.println(id + "\t" + name + " \t" + birDate + "\t" + gender);
	}
	//错误号码 4  查找学生信息, 以 姓名为关键字
	public Student find(String name) {
		for(Student student : stuList) {
			if(name.equals(student.getName())) {
				printInfo(student);
				return student;
			}
		}
		return null;
	}
	//错误号码 4  删除学生信息
	public boolean delete(String name) {
		// 错误号码 5 
		//按照学生姓名查找并该学生信息
		Student stu = find(name);
		if(stu != null) 
		{
			//获取该条信息的下标
			 int index = stuList.indexOf(stu);
			 //删除该下标
			 stuList.remove(index);
			 return true;
		}
		return false;
	}
	//错误号码 4  打印学生列表
	public void printList() {
		if(stuList.size() == 0){
			System.out.println("没有数据");
			return;
		}
		for(Student stu : stuList) {
			printInfo(stu);
		}
	}
	//错误号码 4  退出学生管理系统
	public void exist() {
		System.out.println("退出成功");
	}
	//错误号码 4  展示总的菜单
	public void showMenu() {
		System.out.println(" ********************************");
		System.out.println("*             1  插入                        *");
		System.out.println("*             2  查找                        *");
		System.out.println("*             3  删除                        *");
		System.out.println("*             4  修改                        *");
		System.out.println("*             5  输出                        *");
		System.out.println("*             6  退出                        *");
		System.out.println(" ********************************");
	}
	//错误号码 4  展示更新学生信息的菜单
	public void showUpdateMenu() {
		System.out.println(" ********************************");
		System.out.println("*             1  学号                        *");
		System.out.println("*             2  姓名                        *");
		System.out.println("*             3  生日                        *");
		System.out.println("*             4  性别                        *");
		System.out.println("*             5  返回                        *");
		System.out.println(" ********************************");
	}
	//错误号码 4  更新信息
	public boolean update() {
		//错误号码26	 Scanner in = new Scanner(System.in);
			System.out.println("请输入要修改的学生的姓名：");
			String name = in.next();
			Student stu = find(name);
			if(stu == null) {
				System.out.println("不存在");
				return false;
			}
			showUpdateMenu();
			while(true) {
				int number = in.nextInt();
				switch(number) {
				case 1: 
						System.out.println("请输入新的学号:");
						int id = in.nextInt();
						stu.setId(id);
						showUpdateMenu();
						break;
				case 2: 
						System.out.println("请输入新的name:");
						String name1 = in.next();
						stu.setName(name1);
						showUpdateMenu();
						break;
				case 3: 
						System.out.println("请输入新的birDate:");
						String birDate = in.next();
						stu.setBirDate(birDate);
						showUpdateMenu();
						break;
				case 4:
						System.out.println("请输入新的gender(男(true)/女(false)):");
						boolean gender = in.nextBoolean();
						stu.setMan(gender);
						showUpdateMenu();
						break;
				case 5: 
						System.out.println("返回上一级");
						return true;
				default: 
						break;
				}
				System.out.println("请输入操作编号：");
			}
	}
	
	public void App() {
		showMenu();
		//错误号码26	 Scanner in = new Scanner(System.in);
		try {
			while(true) {
				int number = in.nextInt();
				switch(number) {
				case 1: 
						insert();
						showMenu();
						System.out.println("请输入操作编号：");
						break;
				case 2: 
						System.out.println("请输入查找的名字");
						String name = in.next();
						find(name);
						showMenu();
						System.out.println("请输入操作编号：");
						break;
				case 3: 
						System.out.println("请输入查找的名字:");
						String birDate = in.next();
						delete(birDate);
						showMenu();
						System.out.println("请输入操作编号：");
						break;
				case 4: 
						update();
						showMenu();
						System.out.println("请输入操作编号：");
						break;
				case 5: 
						printList();
						showMenu();
						System.out.println("请输入操作编号：");
						break;
				case 6:
						exist();
						return;
				default: 
						showMenu();
						System.out.println("请输入操作编号：");
						break;
				}
		}
		}finally {
			in.close();
		}
		
		
	}
}
