package spring5_mybatis_study.mapper;
import java.util.List;
import java.util.Map;

import spring5_mybatis_study.dto.Student;

public interface StudentMapper {
	Student selectStudentById(Student student);
	Student selectStudentByIdWithResultMap(Student student);
	List<Student> selectStudentByAll();
	
	int insertStudent(Student student);
	int deleteStudent(int id);
	int updateStudent(Student student);
	
	//Result - HashMap
	List<Map<String, Object>> selectStudentByAllForHashMap();

	Student selectStudentByMap(Map<String, String> map);
	List<Student> selectAllStudentByMap(Map<String, String> map);
	
	/* 내포된 결과매핑(ResultMap)을 사용한 일대일 매핑 */
	Student selectStudentByIdAssociation(Student student);
	
	/* enum 타입 다루기 */
	int insertEnumStudent(Student student);
	
	/* ResultSet 처리방식의 재정의*/
	Map<Integer, Student> selectStudentForMap(Student student);
	
	int updateSetStudent(Student student);
	
}