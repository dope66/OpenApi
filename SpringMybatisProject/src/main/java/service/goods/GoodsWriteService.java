package service.goods;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import command.GoodsCommand;
import model.AuthInfoDTO;
import model.GoodsDTO;
import repository.GoodsRepository;

public class GoodsWriteService {
	@Autowired
	GoodsRepository goodsRepository;

	// 굿즈 커맨드를 받아오는 이유는 홈페이지로부터 날라온값을 컨트롤러가 갖고잇기때문에 전달했다
	public void goodsWrite(GoodsCommand goodsCommand, HttpSession session) {
		GoodsDTO dto = new GoodsDTO();
		dto.setCtgr(goodsCommand.getCtgr());
		dto.setProdCapacity(goodsCommand.getProdCapacity());
		dto.setProdDelFee(goodsCommand.getProdDelFee());
		dto.setProdDetail(goodsCommand.getProdDetail());
		dto.setProdName(goodsCommand.getProdName());
		dto.setProdNum(goodsCommand.getProdNum());
		dto.setProdPrice(goodsCommand.getProdPrice());
		dto.setRecommend(goodsCommand.getRecommend());
		dto.setProdSupplyer(goodsCommand.getProdSupplyer());
		// employeeId는 로그인시 session에 저장
		AuthInfoDTO authInfo = (AuthInfoDTO) session.getAttribute("authInfo");
		
		dto.setEmployeeId(authInfo.getGrade());
		String prodImage = "";
		//디비에 파일명만 저장하기 위해서 오리지널 파일명을 가져와서 확장자를 ㅜ출
		for (MultipartFile mf : goodsCommand.getProdImage1()) {
			// 확장자를 알기위해서
			String original = mf.getOriginalFilename();
			// original에서 확장자만 추출
			String originalExt = original.substring(original.lastIndexOf("."));
			// uuid 전세계적으로 유니크한 아이디를부여
			String store = UUID.randomUUID().toString().replace("-", "") + originalExt;
			// 디비에 저장할 파일명을 추출하여 prodImage에저장
			prodImage += store + ",";
			// 파일을 ㅇ시스템에 저장
			String filePath = session.getServletContext().getRealPath("WEB-INF/view/goods/upload");
			File file = new File(filePath + "/" + store);
			// 파일저장
			try {
				mf.transferTo(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		dto.setProdImage(prodImage);
		goodsRepository.goodsWrite(dto);
		
	}
}
