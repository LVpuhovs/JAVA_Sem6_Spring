package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Grade;
import lv.venta.model.Student;

public interface IGradeFilterService {
	public abstract ArrayList<Grade> selectGradesByStudentId(long id);
}
