package spring5_mybatis_study.mapper;

import java.util.List;
import java.util.Map;

import spring5_mybatis_study.dto.Course;

public interface CourseMapper {
	/* 동적SQL if조건 */
	List<Course> selectCoursesByCondition(Map<String, Object> map);

	/* 동적SQL - choose 조건 */
	List<Course> selectCaseCourses(Map<String, Object> map);

	/* 동적SQL - where 조건 */
	List<Course> selectWhereCourses(Map<String, Object> map);

	/* 동적SQL - trim 조건 */
	List<Course> selectTrimCourses(Map<String, Object> map);

	/* 동적SQL - foreach 루프 */
	List<Course> selectCoursesForeachByTutors(Map<String, Object> map);

	int insertCourses(Map<String, Object> map);

	int deleteCourses(Map<String, Object> map);

	/* set 조건 */
	int updateCourse(Course course);

	/* Transaction */
	Course selectCourseById(int courseId);

	int insertCourse(Course course);

	int deleteCourse(int courseId);

}