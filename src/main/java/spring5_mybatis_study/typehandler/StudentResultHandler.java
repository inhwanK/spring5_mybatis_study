package spring5_mybatis_study.typehandler;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import spring5_mybatis_study.dto.Student;


public class StudentResultHandler implements ResultHandler<Student>{
	private Map<Integer, String> map = new HashMap<>();

	public StudentResultHandler(Map<Integer, String> map) {
		this.map = map;
	}

	// 이 핸들러는 결과값이 인자로 들어가면 map으로 바꿔서 다시 집어넣어주는 핸들러
	// 즉 데이터를 맵 형태로 받아서 다루고 싶을 때 사용하면 됨.
	@Override
	public void handleResult(ResultContext<? extends Student> resultContext) {
		Student student = resultContext.getResultObject();
		map.put(student.getStudId(), student.getName());
	}

	
}
