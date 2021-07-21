package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.NoticeDTO;

public class NoticeRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace  = "mappers.noticeMapper";
	String statement; 
	public int count() {
		statement = namespace +".count";
		return sqlSession.selectOne(statement);
	}
	public void noticeDel(String noticeNo) {
		statement = namespace +".noticeDel";
		sqlSession.delete(statement, noticeNo);
	}
	public void noticeModify(NoticeDTO dto)
	{
		statement=namespace+".noticeModify";
		sqlSession.update(statement,dto);
	}
	public void noticeReadUpdate(String noticeNo)
	{
		statement=namespace+".noticeCount";
		sqlSession.update(statement,noticeNo);
	}
	public NoticeDTO noticeDetail(String noticeNo) {
		statement=namespace+".noticeDetail";
		return sqlSession.selectOne(statement,noticeNo);
	}
	public List<NoticeDTO> noticeList(NoticeDTO dto){
		statement=namespace+".noticeList";
		return sqlSession.selectList(statement,dto);
	}
	public void noticeWrite(NoticeDTO dto) {
		statement=namespace+".noticeWrite";
		sqlSession.insert(statement,dto);
		
	}
	
	
}
