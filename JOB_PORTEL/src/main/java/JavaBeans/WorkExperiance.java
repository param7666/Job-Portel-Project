package JavaBeans;

import java.io.Serializable;

public class WorkExperiance implements Serializable {
	
	private long id;
	private String title;
	private String company;
	private String joinYear;
	private String endYear;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getJoinYear() {
		return joinYear;
	}
	public void setJoinYear(String joinYear) {
		this.joinYear = joinYear;
	}
	public String getEndYear() {
		return endYear;
	}
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
	
	
}
