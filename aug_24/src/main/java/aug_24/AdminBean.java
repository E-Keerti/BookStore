package aug_24;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AdminBean implements Serializable
{
	private String adminName;
	private String adminPass;
	private String adminFName;
	private String adminLName;
	private String adminMailId;
	private long adminPhNo;
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPass() {
		return adminPass;
	}
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	public String getAdminFName() {
		return adminFName;
	}
	public void setAdminFName(String adminFName) {
		this.adminFName = adminFName;
	}
	public String getAdminLName() {
		return adminLName;
	}
	public void setAdminLName(String adminLName) {
		this.adminLName = adminLName;
	}
	public String getAdminMailId() {
		return adminMailId;
	}
	public void setAdminMailId(String adminMailId) {
		this.adminMailId = adminMailId;
	}
	public long getAdminPhNo() {
		return adminPhNo;
	}
	public void setAdminPhNo(long adminPhNo) {
		this.adminPhNo = adminPhNo;
	}
}
