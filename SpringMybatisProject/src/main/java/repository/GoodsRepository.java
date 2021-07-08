package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.GoodsDTO;

public class GoodsRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace ="mappers.goodsMapper";
	String statement;
	public void goodsWrite(GoodsDTO dto) {
		statement=namespace+".goodsWrite";
		sqlSession.insert(statement,dto);
	}
	public String goodsNum() {
		statement=namespace+".goodsNum";
		return sqlSession.selectOne(statement);
	}
	
}
