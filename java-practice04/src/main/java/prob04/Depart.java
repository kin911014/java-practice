package prob04;

public class Depart extends Employee{
	String department;
	
	public Depart(String name, int salary, String department){
		// 명시하지않으면 super가 자동으로 생성됨 아래 경우는 명시해서 파라미터 변경 필요
		super(name, salary);
		this.department = department;
		
	}
	
	@Override
	public void getInformation() {
		System.out.println( "이름:" + getName() + " 연봉:" + getSalary() + " 부서:" + department );
	}
	
}
