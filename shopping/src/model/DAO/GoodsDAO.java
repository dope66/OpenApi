package model.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DTO.CartDTO;
import model.DTO.ProductDTO;

public class GoodsDAO extends DataBaseInfo{
	final String COLUMNS=" PROD_NUM,PROD_NAME,PROD_PRICE, "
			+ " PROD_IMAGE, PROD_DETAIL, PROD_CAPACITY, PRUD_SUPPLYER, "
			+ " PROD_DEL_FEE,RECOMMEND, EMPLOYEE_ID, CTGR ";
	public void prodInsert(ProductDTO dto) {
		sql= " insert into products ("+COLUMNS+") "
				+ "values(?,?,?,?,?,?,?,?,?,?,?)";
		getConnect();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getProdNum());
			pstmt.setString(2, dto.getProdName());
			pstmt.setInt(3, dto.getProdPrice());
			pstmt.setString(4, dto.getProdImage());
			pstmt.setString(5, dto.getProdDetail());
			pstmt.setString(6, dto.getProdCapacity());
			pstmt.setString(7, dto.getProdSupplyer());
			pstmt.setString(8, dto.getProdDelFee());
			pstmt.setString(9, dto.getRecommend());
			pstmt.setString(10, dto.getEmployeeId());
			pstmt.setString(11, dto.getCtgr());
			int i =pstmt.executeUpdate();
			System.out.println(i+"개가 입력 되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public void prodDel(String prodNum)
	{
		sql=" delete from products"
				+ " where  PROD_NUM= ? ";
		getConnect();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, prodNum);
			int i= pstmt.executeUpdate();
			System.out.println(i+"개가 삭제 되엇습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	public void cartInsert(CartDTO dto) {
		sql=" insert into cart (MEM_ID, PROD_NUM,CART_QTY,CART_PRICE) "
				+ "	values (?,?,?,?)";
				
		getConnect();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMemId());
			pstmt.setString(2, dto.getProdNum());
			pstmt.setString(3, dto.getCartQty());
			pstmt.setInt(4, dto.getCartPrice());
			int i= pstmt.executeUpdate();
			System.out.println(i+"개가 저장되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	public void goodsUpdate(ProductDTO dto) {
		sql=" update products "
				+ " set PROD_NAME=?, PROD_PRICE=?,"
				+ "	PROD_DETAIL=?, PROD_CAPACITY=?,"
				+ " PRUD_SUPPLYER=?, PROD_DEL_FEE=?,"
				+ " RECOMMEND=?"
				+ " where PROD_NUM=?";
		getConnect();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getProdName());
			pstmt.setInt(2, dto.getProdPrice());
			pstmt.setString(3, dto.getProdDetail());
			pstmt.setString(4, dto.getProdCapacity());
			pstmt.setString(5, dto.getProdSupplyer());
			pstmt.setString(6, dto.getProdDelFee());
			pstmt.setString(7, dto.getRecommend());
			pstmt.setString(8, dto.getProdNum());
			int i=pstmt.executeUpdate();
			System.out.println(i+"개가 수정 되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
				
				
		
	}
	public ProductDTO GoodsOne(String prodNum) {
		ProductDTO dto=null;
		sql=" select "+COLUMNS+",  case CTGR when 'wear' then '의류' "
				+ "					when 'cosmetic' then '화장품'"
				+ "			 		when 'food' then '음식' "
				+ " 				when 'car' then '자동차 용품'"
				+ "					end CTGR1 "
				+ " from products "
				+" where PROD_NUM= ?";
		getConnect();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, prodNum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto= new ProductDTO();
				dto.setCtgr(rs.getString("CTGR1"));
				dto.setEmployeeId(rs.getString("employee_Id"));
				dto.setProdCapacity(rs.getString("prod_Capacity"));
				dto.setProdDelFee(rs.getString("prod_Del_Fee"));
				dto.setProdDetail(rs.getString("prod_Detail"));
				dto.setProdImage(rs.getString("prod_Image"));
				dto.setProdName(rs.getString("prod_Name"));
				dto.setProdNum(rs.getString("prod_Num"));
				dto.setProdPrice(rs.getInt("prod_Price"));
				dto.setProdSupplyer(rs.getString("PRUD_SUPPLYER"));
				dto.setRecommend(rs.getString("recommend"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
				return dto;
		
	}
	public List<ProductDTO> goodsList() {
		List<ProductDTO> list=new ArrayList<ProductDTO>();
		sql=" select "+COLUMNS+",  case CTGR when 'wear' then '의류' "
				+ "					when 'cosmetic' then '화장품'"
				+ "			 		when 'food' then '음식' "
				+ " 				when 'car' then '자동차 용품'"
				+ "					end CTGR1 "
				+ " from products";
		getConnect();
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ProductDTO dto= new ProductDTO();
				dto.setCtgr(rs.getString("CTGR1"));
				dto.setEmployeeId(rs.getString("employee_Id"));
				dto.setProdCapacity(rs.getString("prod_Capacity"));
				dto.setProdDelFee(rs.getString("prod_Del_Fee"));
				dto.setProdDetail(rs.getString("prod_Detail"));
				dto.setProdImage(rs.getString("prod_Image"));
				dto.setProdName(rs.getString("prod_Name"));
				dto.setProdNum(rs.getString("prod_Num"));
				dto.setProdPrice(rs.getInt("prod_Price"));
				dto.setProdSupplyer(rs.getString("PRUD_SUPPLYER"));
				dto.setRecommend(rs.getString("recommend"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	public String goodsNum() {
		String prodNum=null;
		sql=" select prod_seq.nextval from dual";
		getConnect();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.next();
			prodNum=rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return prodNum;
	}
}
