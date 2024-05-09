package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import lv.venta.service.ICourseFilterService;

@Controller
@RequestMapping("/course/filter")
public class CourseFilterController {
	@Autowired
	private ICourseFilterService courseService;
	
	
	@GetMapping("/student") //localhost:8080/course/filter/student?id=2
	public String getCourseFilterStudentById(@RequestParam("id") int id, Model model) {
		try {
			model.addAttribute("myobj", courseService.selectCoursesByStudentId(id));
			model.addAttribute("title", "Courses by Student id");
			return "show-all-course-page";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/professor") //localhost:8080/course/filter/professor?id=2
	public String getCourseFilterProfessorById(@RequestParam("id") int id, Model model) {
		try {
			model.addAttribute("myobj", courseService.selectCoursesByProfessorsIdp(id));
			model.addAttribute("title", "Courses by Professor id");
			return "show-all-course-page";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
	}
	
	
	@GetMapping("/cp") //localhost:8080/course/filter/cp?id=2
	public String getCourseFilterByCp(@RequestParam("id") int id, Model model) {
		try {
			model.addAttribute("myobj", courseService.selectCoursesByCp(id));
			model.addAttribute("title", "Courses by CP");
			return "show-all-course-page";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
	}
	
}
