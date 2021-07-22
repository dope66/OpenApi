package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.LibraryDTO;

public class LibraryRepository {

	@Autowired
	SqlSession sqlSession;
	String namespace = "mappers.libraryMapper";
	String statement;

	public void libWrite(LibraryDTO dto) {
		statement = namespace + ".libWrite";
		sqlSession.insert(statement, dto);
	}
	public List<LibraryDTO> libSelect(){
		statement = namespace + ".libSelect";
		return sqlSession.selectList(statement);
	}
	public LibraryDTO libraryInfo(String noticeNo) {
		statement = namespace + ".libraryInfo";
		return sqlSession.selectOne(statement, noticeNo);
	}
	public void libCount(String noticeNo) {
		statement = namespace + ".libCount";
		sqlSession.update(statement,noticeNo);
	}
	public void libModify(LibraryDTO libraryDTO) {
		statement = namespace + ".libModify";
		sqlSession.update(statement,libraryDTO);
	}
	public void libDel(String noticeNo) {
		statement = namespace + ".libDel";
		sqlSession.delete(statement,noticeNo);
		}
	
}
