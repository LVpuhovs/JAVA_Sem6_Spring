package lv.venta.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "GradeTable")
@Entity
public class Grade {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "idg")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idg;
	
	@Column(name = "Grvalue")
	@Min(0)
	@Max(10)
	private int grvalue;
	
	@ManyToOne
	@JoinColumn(name = "Idc")
	private Course course;
	
	@ManyToOne
	@JoinColumn(name = "Ids")
	private Student student;

	
	public Grade(Course course, Student student, int grvalue) {
		setCourse(course);
		setStudent(student);
		setGrvalue(grvalue);
	}
}
