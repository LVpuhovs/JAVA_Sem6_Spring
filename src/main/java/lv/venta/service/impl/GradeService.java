package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Grade;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IGradeFilterService;

@Service
public class GradeService implements IGradeFilterService{
	
	@Autowired
	private IGradeRepo gradeRepo;

	@Autowired
	private IStudentRepo studentRepo;
	
	@Autowired
	private ICourseRepo courseRepo;
	
	@Override
	public ArrayList<Grade> selectGradesByStudentId(long id) throws Exception {
		// TODO Auto-generated method stub
		if(id <= 0 ) throw new Exception("id nav");
		
		if(!studentRepo.existsById(id)) throw new Exception("No student with id " + id);
		
		ArrayList<Grade> result = gradeRepo.findByStudentIds(id);
		
		if(result.isEmpty()) throw new Exception("There is no grades to student");
		return result;
	}

	@Override
	public float calculateAVGGradeInCourseId(long id) throws Exception {
		// TODO Auto-generated method stub
		if(id <= 0 ) throw new Exception("id nav");
		
		if(!courseRepo.existsById(id)) throw new Exception("No course with id " + id);
		
		float result = gradeRepo.CalculateAVGForCourse(id);
		
		
		return result;
	}

	@Override
	public ArrayList<Grade> selectFailedGrades() throws Exception {
		// TODO Auto-generated method stub
		
		if(gradeRepo.count() == 0) throw new Exception("No grades");
		
		ArrayList<Grade> result = gradeRepo.findByGrvalueLessThan(4);
		
		if(result.isEmpty()) throw new Exception("There are no failed grades");
		return result;
	}

}
