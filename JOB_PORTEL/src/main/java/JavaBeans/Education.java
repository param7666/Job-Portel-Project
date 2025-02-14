package JavaBeans;

import java.io.Serializable;

public class Education implements Serializable{
	private long id;
	private String degree;
	private String institute;
	private String sYear;
	private String eYear;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getInstitute() {
		return institute;
	}
	public void setInstitute(String institute) {
		this.institute = institute;
	}
	public String getsYear() {
		return sYear;
	}
	public void setsYear(String sYear) {
		this.sYear = sYear;
	}
	public String geteYear() {
		return eYear;
	}
	public void seteYear(String eYear) {
		this.eYear = eYear;
	}
	
	
}
