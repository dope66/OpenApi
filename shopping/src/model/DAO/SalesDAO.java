package model.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DTO.ClientSaleDTO;
import model.DTO.CustomerTotalDTO;
import model.DTO.DeliveryDTO;
import model.DTO.ProductTotalDTO;

public class SalesDAO extends DataBaseInfo {
	public List<ProductTotalDTO> productTotal() {
		List<ProductTotalDTO> list = new ArrayList<ProductTotalDTO>();
		sql = "	select p1.prod_num,p1.prod_name,sum(purchase_tot_price),count(*),avg(purchase_tot_price) "
				+ "	from products p1,purchase p2, purchase_list p3 "
				+ "	where p1.prod_num= p3.prod_num and p2.purchase_num=p3.purchase_num "
				+ "	group by p1.prod_num ,p1.prod_name ";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductTotalDTO dto = new ProductTotalDTO();
				dto.setAvgPrice(rs.getString(5));
				dto.setCount(rs.getString(4));
				dto.setProdName(rs.getString(2));
				dto.setProdNum(rs.getString(1));
				dto.setSumPrice(rs.getString(3));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public List<CustomerTotalDTO> customerTotal() {
		List<CustomerTotalDTO> list = new ArrayList<CustomerTotalDTO>();
		sql = " select  m.mem_Id, mem_name , sum(purchase_tot_price)," 
				+ "	count(*), avg(purchase_tot_price)"
				+ "    from member m, purchase pu" 
				+ "    where m.mem_id = pu.mem_id"
				+ "    group by m.mem_Id, m.mem_name";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CustomerTotalDTO dto = new CustomerTotalDTO();
				dto.setCount(rs.getString(4));
				dto.setMemId(rs.getString(1));
				dto.setMemName(rs.getString(2));
				dto.setSumPrice(rs.getString(3));
				dto.setAvg(rs.getString(5));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public void deliveryCreate(DeliveryDTO dto) {
		String delFree = "    select sum(prod_del_fee)	" 
				+ "    from purchase_list pl, products pr	"
				+ "    where pl.prod_num =pr.prod_num	" 
				+ "    and pl.purchase_num =? ";
		sql = " merge into delivery d " 
				+ "    using (select purchase_num from purchase where purchase_num=? ) p "
				+ "    on(d.PURCHASE_NUM= p.PURCHASE_NUM) "
				+ "    when matched then "
				+ "    update set delivery_com =?, delivery_num=?, "
				+ "                delivery_exp_date=?, arrival_exp_date=?, "
				+ "                DELIVERY_DEL_FREE=("+ delFree + ") " 
				+ "    when not matched then  "
				+ "    insert(DELIVERY_COM,DELIVERY_NUM ,DELIVERY_EXP_DATE, "
				+ "            ARRIVAL_EXP_DATE,DELIVERY_DEL_FREE,PURCHASE_NUM) "
				+ "            values(?,?,?,?,("+ delFree + "),?)";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPurchaseNum());
			pstmt.setString(2, dto.getDeliveryCom());
			pstmt.setString(3, dto.getDeliveryNum());
			pstmt.setString(4, dto.getDeliveryExpDate());
			pstmt.setString(5, dto.getArrivalExpDate());
			pstmt.setString(6, dto.getPurchaseNum());
			pstmt.setString(7, dto.getDeliveryCom());
			pstmt.setString(8, dto.getDeliveryNum());
			pstmt.setString(9, dto.getDeliveryExpDate());
			pstmt.setString(10, dto.getArrivalExpDate());
			pstmt.setString(11, dto.getPurchaseNum());
			pstmt.setString(12, dto.getPurchaseNum());

			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 입력되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public DeliveryDTO deliverySelect(String purchaseNum) {
		DeliveryDTO dto = null;
		sql = " select PURCHASE_NUM,DELIVERY_COM," + "		DELIVERY_NUM,DELIVERY_EXP_DATE,	"
				+ "		ARRIVAL_EXP_DATE,DELIVERY_DEL_FREE	" + "		from delivery "
				+ "		where PURCHASE_NUM = ?	";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, purchaseNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new DeliveryDTO();
				dto.setArrivalExpDate(rs.getString(5));
				dto.setDeliveryCom(rs.getString(2));
				dto.setDeliveryDelFee(rs.getString(6));
				dto.setDeliveryExpDate(rs.getString(4));
				dto.setDeliveryNum(rs.getString(3));
				dto.setPurchaseNum(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();

		}

		return dto;
	}

	public List<ClientSaleDTO> salesList(String memId) {
		List<ClientSaleDTO> list = new ArrayList<ClientSaleDTO>();
		sql = "select m.mem_id, mem_name, mem_phone," + "    pr.prod_num, prod_name,"
				+ "    pu.purchase_num, purchase_date, PURCHASE_ADDR ," + "    RECEIVER_NAME , RECEIVER_PHONE, "
				+ "    PURCHASE_QTY ,  PURCHASE_PRICE , DELIVERY_NUM" + "  from member m, purchase pu, products pr,  "
				+ "	     purchase_list pl ,delivery d" + "  where m.mem_id(+) = pu.mem_id "
				+ "    and pu.purchase_num = pl.purchase_num" + "    and pl.prod_num = pr.prod_num"
				+ "	and pu.purchase_num=d.purchase_num(+) ";
		if (memId != null) {
			sql += " and m.mem_id = ?";
		}
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			if (memId != null) {
				pstmt.setString(1, memId);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ClientSaleDTO dto = new ClientSaleDTO();
				dto.setMemId(rs.getString("mem_Id"));
				dto.setMemName(rs.getString("mem_Name"));
				dto.setMemPhone(rs.getString("mem_Phone"));
				dto.setProdName(rs.getString("prod_Name"));
				dto.setProdNum(rs.getString("prod_Num"));
				dto.setPurchaseAddr(rs.getString("purchase_Addr"));
				dto.setPurchaseDate(rs.getDate("purchase_Date"));
				dto.setPurchaseNum(rs.getString("purchase_Num"));
				dto.setPurchasePrice(rs.getString("purchase_Price"));
				dto.setPurchaseQty(rs.getString("purchase_Qty"));
				dto.setReceiverName(rs.getString("receiver_Name"));
				dto.setReceiverPhone(rs.getString("receiver_Phone"));
				dto.setDeliveryNum(rs.getString("delivery_Num"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
}