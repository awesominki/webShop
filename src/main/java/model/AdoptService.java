package model;

import dto.AdoptVO;

public class AdoptService {
	AdoptDAO dao = new AdoptDAO();
	public int insertAdopt(AdoptVO adopt) {
		return dao.insertAdopt(adopt);
	}
	public int acceptAdopt(AdoptVO adopt) {
		return dao.acceptAdopt(adopt);
	}
}
