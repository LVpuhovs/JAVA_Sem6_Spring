package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Professor {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "idp")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idp;
	
	@NotNull
	@Size(min = 2, max = 20)
	@Pattern(regexp = "[A-z]{1}[a-z ]+")//TODO nokopet no ieprieksejiem ar mikstinajuma zimem
	@Column(name = "Name")
	private String name;
	
	@NotNull
	@Size(min = 2, max = 40)
	@Pattern(regexp = "[A-z]{1}[a-z ]+")//TODO nokopet no ieprieksejiem ar mikstinajuma zimem
	@Column(name = "Surname")
	private String surname;
	
	@NotNull
	@Column(name = "Degree")
	private Degree degree;

}
