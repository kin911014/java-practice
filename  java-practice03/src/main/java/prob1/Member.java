package prob1;

public class Member {
	private String id;
	private String name;
	private int point;
	
	// Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	// Name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Point
	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}



	


public static void main(String[] args) {
	Member member = new Member();
	member.setId("douzone");
	member.setName("김동은");
	member.setPoint(5000);
	System.out.println(member.getId());
	System.out.println(member.getName());
	System.out.println(member.getPoint());
}
}