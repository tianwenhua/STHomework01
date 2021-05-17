package studentManagerSystem;

public class Student {
	private int id;
	private String name;
	private String birDate;
	private boolean isMan;
	public Student(int id, String name, String birDate, boolean isMan) {
		this.id = id;
		this.name = name;
		this.birDate = birDate;
		this.isMan = isMan;
	}
	public Student() {
		
	}
	public int getId() {
		return id;
	}
	public void setMan(boolean isMan) {
		this.isMan = isMan;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirDate() {
		return birDate;
	}
	public void setBirDate(String birDate) {
		this.birDate = birDate;
	}
	/*
	 * ´íÎó±àÂë 2 
	 * public boolean isGender() {
		return gender;
	}
	 * 
	 * */
	public boolean isMan() {
		return isMan;
	}
}
