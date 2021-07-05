package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.MemberDTO;

public class MemberRepository {
 @Autowired
 SqlSession sqlSession;
 String namespace ="mappers.memberMapper";
 String statement;
 
 public void memJoin(MemberDTO dto) {
	 statement=namespace+".memJoin";
	 int i=sqlSession.insert(statement,dto);
	 System.out.println(i+"개가 저장되었습니다.");
 }
}
