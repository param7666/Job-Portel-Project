package JavaBeans;

import java.io.Serializable;

public class Skill implements Serializable{
	private long id;
	private String skill;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	
}
