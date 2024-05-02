package lv.venta.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "CourseTable")
@Entity
public class Course {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "idc")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idc;

	@NotNull
	@Size(min = 4, max = 50)
	@Pattern(regexp = "[A-za-z ]+")//TODO nokopet no ieprieksejiem ar mikstinajuma zimem
	@Column(name = "Title")
	private String title;
	
	@Min(0)
	@Max(20)
	@Column(name = "Cp")
	private int cp;
	
	@OneToOne
	@JoinColumn(name = "Idp")
	private Professor professor;
	
	@OneToMany(mappedBy = "course")
	@ToString.Exclude
	private Collection<Grade> grade;
	
	public Course(String title, int cp, Professor professor) {
		setTitle(title);
		setCp(cp);
		setProfessor(professor);
	}
}
