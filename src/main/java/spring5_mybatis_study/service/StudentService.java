package spring5_mybatis_study.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_mybatis_study.dto.Student;
import spring5_mybatis_study.typehandler.StudentResultHandler;

@Service
public class StudentService {
	private final String namespace = "spring5_mybatis_study.mapper.StudentMapper";

	@Autowired
	private SqlSession sqlSession;

	public Map<Integer, String> selectStudentForMap(int studId) {
		Map<Integer, String> map = new HashMap<>();
		// 미리 만들어놓은 핸들러 사용
		StudentResultHandler resultHandler = new StudentResultHandler(map);

		sqlSession.select(namespace + ".selectStudentForMap", studId, resultHandler);
		return map;
	}
	
	public Map<Integer, Student> selectStudentForMap2(int studId){
		Map<Integer, Student> map = new HashMap<>();
		
		// 핸들러 일회용으로 정의해서 사용
		ResultHandler<Student> resultHandler = new ResultHandler<Student>() {

			@Override
			public void handleResult(ResultContext<? extends Student> resultContext) {
				Student student = resultContext.getResultObject();
				map.put(student.getStudId(), student);
			}
		};
		sqlSession.select(namespace + ".selectStudentForMap", studId, resultHandler);
		return map;
	}

	
}
