package dto;

public class SaleVO {
	int sid;
	String suserid;
	String sdesc;
	String sgender;
	int sage;
	int sstatus;
	public SaleVO() {
		
	}
	public SaleVO(int sid, String suserid, String sdesc, String sgender, int sage, int sstatus) {
		super();
		this.sid = sid;
		this.suserid = suserid;
		this.sdesc = sdesc;
		this.sgender = sgender;
		this.sage = sage;
		this.sstatus = sstatus;
	}
	
	public SaleVO(String suserid, String sdesc, String sgender, int sage) {
		super();
		this.suserid = suserid;
		this.sdesc = sdesc;
		this.sgender = sgender;
		this.sage = sage;
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSuserid() {
		return suserid;
	}
	public void setSuserid(String suserid) {
		this.suserid = suserid;
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
	public int getSstatus() {
		return sstatus;
	}
	public void setSstatus(int sstatus) {
		this.sstatus = sstatus;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SaleVO [sid=").append(sid).append(", suserid=").append(suserid).append(", sdesc=").append(sdesc)
				.append(", sgender=").append(sgender).append(", sage=").append(sage).append(", sstatus=")
				.append(sstatus).append("]");
		return builder.toString();
	}
	
	
}
