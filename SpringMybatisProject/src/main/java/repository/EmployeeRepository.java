package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace= "mappers.employeeMapper";
	String statment;
	
	public String empNo() {
	statment="mappers.employeeMapper.empNo";
		return sqlSession.selectOne(statment);
	}
}
