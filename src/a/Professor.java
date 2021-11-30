package a;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "professor")
public class Professor {

	@Id
	@Column(name = "id")
	protected int professorID;
	
	public int getProfessorID() {
		return professorID;
	}

	public void setProfessorID(int professorID) {
		this.professorID = professorID;
	}

	@Column(name  = "office_number")
	protected String officeNumber;
	
	public String getOfficeNumber() {
		return officeNumber;
	}

	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}

	@Column(name  = "research_area")
	protected String researchArea;
	
	public String getResearchArea() {
		return researchArea;
	}

	public void setResearchArea(String researchArea) {
		this.researchArea = researchArea;
	}

	@OneToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "professor_id")
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
