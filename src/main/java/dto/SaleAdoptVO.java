package dto;

public class SaleAdoptVO {
	int sid;
	String sdesc;
	String sgender;
	int sage;
	String auserid;
	int aid;
	public SaleAdoptVO(int sid, String sdesc, String sgender, int sage, String auserid, int aid) {
		super();
		this.sid = sid;
		this.sdesc = sdesc;
		this.sgender = sgender;
		this.sage = sage;
		this.auserid = auserid;
		this.aid = aid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSdesc() {
		return sdesc;
	}
	public void setSdesc(String sdesc) {
		this.sdesc = sdesc;
	}
	public String getSgender() {
		return sgender;
	}
	public void setSgender(String sgender) {
		this.sgender = sgender;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getAuserid() {
		return auserid;
	}
	public void setAuserid(String auserid) {
		this.auserid = auserid;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SaleAdoptVO [sid=").append(sid).append(", sdesc=").append(sdesc).append(", sgender=")
				.append(sgender).append(", sage=").append(sage).append(", auserid=").append(auserid).append(", aid=")
				.append(aid).append("]");
		return builder.toString();
	}
	
	
	
	
}
