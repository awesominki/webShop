package dto;

public class AdoptVO {
	private int aid;
	private int asid;
	private String auserid;
	private int astatus;
	
	public AdoptVO() {
		
	}

	public AdoptVO(int asid, String auserid) {
		super();
		this.asid = asid;
		this.auserid = auserid;
	}



	public AdoptVO(int aid, int asid, String auserid, int astatus) {
		super();
		this.aid = aid;
		this.asid = asid;
		this.auserid = auserid;
		this.astatus = astatus;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getAsid() {
		return asid;
	}

	public void setAsid(int asid) {
		this.asid = asid;
	}

	public String getAuserid() {
		return auserid;
	}

	public void setAuserid(String auserid) {
		this.auserid = auserid;
	}

	public int getAstatus() {
		return astatus;
	}

	public void setAstatus(int astatus) {
		this.astatus = astatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdoptVO [aid=").append(aid).append(", asid=").append(asid).append(", auserid=").append(auserid)
				.append(", astatus=").append(astatus).append("]");
		return builder.toString();
	}
	
	
	
}
