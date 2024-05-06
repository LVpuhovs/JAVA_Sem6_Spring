package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Grade;

public interface IGradeRepo extends CrudRepository<Grade, Long>{

	ArrayList<Grade> findByStudentIds(long id);
	
	@Query(nativeQuery = true, value = "SELECT AVG(grvalue) FROM grade_table WHERE idc=?1")
	float CalculateAVGForCourse(long id);
	
	
	ArrayList<Grade> findByGrvalueLessThan(int i);
	

}
