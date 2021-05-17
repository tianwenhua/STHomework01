package studentManagerSystem;


//�������26  import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
	//������� 4  ѧ���б����ڴ洢ѧ����Ϣ
	ArrayList<Student> stuList = new ArrayList<Student>();
	//�������26	 Scanner in = new Scanner(System.in);
	Scanner in = new Scanner(System.in);
	//������� 4  ���캯������ʼ��ѧ���б�
	public StudentManager() {
		Student stu = new Student(2018012559, "twh", "19990115", true);
		stuList.add(stu);
	}
	//������� 4  ��������
	public void insert() {
		//�������26	 Scanner in = new Scanner(System.in);
		Student stu = new Student();
		int id = 0;
		String name = null;
		String birDate = null;
		boolean gender = false;
		System.out.println("������ѧ�ţ�");
		id = in.nextInt();
		System.out.println("������������");
		name = in.next();
		System.out.println("���������գ�");
		birDate = in.next();
		System.out.println("�Ա��У�(true/false)");
		gender = in.nextBoolean();
		stu.setId(id);
		stu.setName(name);
		stu.setBirDate(birDate);
		stu.setMan(gender);
		stuList.add(stu);
	}
	//������� 4  ��ӡѧ���б���Ϣ
	public void printInfo(Student stu) {
		int id = stu.getId();
		String name = stu.getName();
		String birDate = stu.getBirDate();
		String gender = stu.isMan() ? "��" : "Ů";
		System.out.println(id + "\t" + name + " \t" + birDate + "\t" + gender);
	}
	//������� 4  ����ѧ����Ϣ, �� ����Ϊ�ؼ���
	public Student find(String name) {
		for(Student student : stuList) {
			if(name.equals(student.getName())) {
				printInfo(student);
				return student;
			}
		}
		return null;
	}
	//������� 4  ɾ��ѧ����Ϣ
	public boolean delete(String name) {
		// ������� 5 
		//����ѧ���������Ҳ���ѧ����Ϣ
		Student stu = find(name);
		if(stu != null) 
		{
			//��ȡ������Ϣ���±�
			 int index = stuList.indexOf(stu);
			 //ɾ�����±�
			 stuList.remove(index);
			 return true;
		}
		return false;
	}
	//������� 4  ��ӡѧ���б�
	public void printList() {
		if(stuList.size() == 0){
			System.out.println("û������");
			return;
		}
		for(Student stu : stuList) {
			printInfo(stu);
		}
	}
	//������� 4  �˳�ѧ������ϵͳ
	public void exist() {
		System.out.println("�˳��ɹ�");
	}
	//������� 4  չʾ�ܵĲ˵�
	public void showMenu() {
		System.out.println(" ********************************");
		System.out.println("*             1  ����                        *");
		System.out.println("*             2  ����                        *");
		System.out.println("*             3  ɾ��                        *");
		System.out.println("*             4  �޸�                        *");
		System.out.println("*             5  ���                        *");
		System.out.println("*             6  �˳�                        *");
		System.out.println(" ********************************");
	}
	//������� 4  չʾ����ѧ����Ϣ�Ĳ˵�
	public void showUpdateMenu() {
		System.out.println(" ********************************");
		System.out.println("*             1  ѧ��                        *");
		System.out.println("*             2  ����                        *");
		System.out.println("*             3  ����                        *");
		System.out.println("*             4  �Ա�                        *");
		System.out.println("*             5  ����                        *");
		System.out.println(" ********************************");
	}
	//������� 4  ������Ϣ
	public boolean update() {
		//�������26	 Scanner in = new Scanner(System.in);
			System.out.println("������Ҫ�޸ĵ�ѧ����������");
			String name = in.next();
			Student stu = find(name);
			if(stu == null) {
				System.out.println("������");
				return false;
			}
			showUpdateMenu();
			while(true) {
				int number = in.nextInt();
				switch(number) {
				case 1: 
						System.out.println("�������µ�ѧ��:");
						int id = in.nextInt();
						stu.setId(id);
						showUpdateMenu();
						break;
				case 2: 
						System.out.println("�������µ�name:");
						String name1 = in.next();
						stu.setName(name1);
						showUpdateMenu();
						break;
				case 3: 
						System.out.println("�������µ�birDate:");
						String birDate = in.next();
						stu.setBirDate(birDate);
						showUpdateMenu();
						break;
				case 4:
						System.out.println("�������µ�gender(��(true)/Ů(false)):");
						boolean gender = in.nextBoolean();
						stu.setMan(gender);
						showUpdateMenu();
						break;
				case 5: 
						System.out.println("������һ��");
						return true;
				default: 
						break;
				}
				System.out.println("�����������ţ�");
			}
	}
	
	public void App() {
		showMenu();
		//�������26	 Scanner in = new Scanner(System.in);
		try {
			while(true) {
				int number = in.nextInt();
				switch(number) {
				case 1: 
						insert();
						showMenu();
						System.out.println("�����������ţ�");
						break;
				case 2: 
						System.out.println("��������ҵ�����");
						String name = in.next();
						find(name);
						showMenu();
						System.out.println("�����������ţ�");
						break;
				case 3: 
						System.out.println("��������ҵ�����:");
						String birDate = in.next();
						delete(birDate);
						showMenu();
						System.out.println("�����������ţ�");
						break;
				case 4: 
						update();
						showMenu();
						System.out.println("�����������ţ�");
						break;
				case 5: 
						printList();
						showMenu();
						System.out.println("�����������ţ�");
						break;
				case 6:
						exist();
						return;
				default: 
						showMenu();
						System.out.println("�����������ţ�");
						break;
				}
		}
		}finally {
			in.close();
		}
		
		
	}
}
