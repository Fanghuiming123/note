import java.math.BigDecimal;

public class Person {
	
	private String name;
	private String gender;
	private BigDecimal age;
	
	public Person(String name,String gender,BigDecimal age) {
		this.setName(name);
		this.setGender(gender);
		this.setAge(age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public BigDecimal getAge() {
		return age;
	}

	public void setAge(BigDecimal age) {
		this.age = age;
	}
	
}