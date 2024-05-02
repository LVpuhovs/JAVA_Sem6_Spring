package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Course;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.ICourseFilterService;

@Service
public class CourseFilterServiceImpl implements ICourseFilterService{
	
	@Autowired
	private ICourseRepo courseRepo;
	
	@Autowired
	private IStudentRepo studentRepo;
	
	@Autowired
	private IProfessorRepo professorRepo;

	@Override
	public ArrayList<Course> selectCoursesByStudentId(long id) throws Exception {
		// TODO Auto-generated method stub
		if(id <= 0 ) throw new Exception("id nav");
		
		if(!studentRepo.existsById(id)) throw new Exception("No student with id " + id);
		
		ArrayList<Course> result = courseRepo.findByGradeStudentIds(id);
		
		if(result.isEmpty()) throw new Exception("There is no course linked to student");
		return result;
	}

	@Override
	public ArrayList<Course> selectCoursesByProfessorId(long id) throws Exception {
		// TODO Auto-generated method stub
		if(id <= 0 ) throw new Exception("id nav");
		
		if(!professorRepo.existsById(id)) throw new Exception("No professor with id " + id);
		
		ArrayList<Course> result = courseRepo.findByProfessorIdp(id);
		
		if(result.isEmpty()) throw new Exception("There is no course linked to professor");
		return result;
	}

	@Override
	public ArrayList<Course> selectCoursesByCp(int cp) throws Exception {
		// TODO Auto-generated method stub
		if(cp < 0 || cp > 20) throw new Exception("cp nav");

		ArrayList<Course> result = courseRepo.findByCp(cp);
		
		if(result.isEmpty()) throw new Exception("There is no course with cp " + cp);
		return result;
	}

}
