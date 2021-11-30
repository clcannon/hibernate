package a;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@Column(name = "id")
	@GeneratedValue
	protected int studentID;
	
	@Column(name = "name")
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "address") 
	private String address;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@OneToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "student_id")
	private Professor professor;

	public Professor getProfessors() {
		return professor;
	}

	public void setProfessors(Professor professor) {
		this.professor = professor;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = (professor);
	}
	
	
}
