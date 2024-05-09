package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Table(name = "ProfessorTable")
@Entity
public class Professor extends Person{
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "idp")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idp;
	
	@NotNull
	@Column(name = "Degree")
	private Degree degree;
	
	@OneToOne(mappedBy = "professor")
	@ToString.Exclude
	private Course course;

	public Professor(String name, String surname, Degree degree) {
		super(name, surname);
		setDegree(degree);
	}
}
