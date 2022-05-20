package model;

import dto.SaleAdoptVO;
import dto.SaleVO;

import java.util.List;

public class SaleService {
	SaleDAO dao = new SaleDAO();
	public List<SaleVO> selectAll(String userid){
		return dao.selectAll(userid);
	}
	public int insertSale(SaleVO sale) {
		return dao.insertSale(sale);
	}
	public List<SaleAdoptVO> selectAdopt(String userid) {
		return dao.selectAdopt(userid);
	}
}
