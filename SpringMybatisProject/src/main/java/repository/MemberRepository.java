package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.MemberDTO;

public class MemberRepository {
 @Autowired
 SqlSession sqlSession;
 String namespace ="mappers.memberMapper";
 String statement;
 public List<MemberDTO> memList(String memId){
	 statement=namespace+".memlist";
	 return sqlSession.selectList(statement,memId);
 }
 public void memJoin(MemberDTO dto) {
	 statement=namespace+".memJoin";
	 int i=sqlSession.insert(statement,dto);
	 System.out.println(i+"개가 저장되었습니다.");
 }
 public void memUpdate(MemberDTO dto)
 {
	 statement=namespace+".memUpdate";
	 sqlSession.update(statement,dto);
	 
 }
 public void memDel(String memId) {
	 statement=namespace+".memDel";
	 sqlSession.delete(statement,memId);
	 
 }
 
}
