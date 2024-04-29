package lv.venta.model;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Professor {
	
	@Setter(value = AccessLevel.NONE)
	private long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String surname;
	private Degree degree;

}
