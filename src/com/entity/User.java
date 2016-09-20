package com.entity;

public class User {
	private int t_id;
	private String t_name;
	private String t_email;
	private String t_inip;
	private String t_outip;
	private String t_mac;
	private String t_dept;
	private String t_team;
		
	public User() {
		super();
	}
	public User(int t_id, String t_name, String t_email, String t_inip, String t_outip, String t_mac, String t_dept,
			String t_team) {
		super();
		this.t_id = t_id;
		this.t_name = t_name;
		this.t_email = t_email;
		this.t_inip = t_inip;
		this.t_outip = t_outip;
		this.t_mac = t_mac;
		this.t_dept = t_dept;
		this.t_team = t_team;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_email() {
		return t_email;
	}
	public void setT_email(String t_email) {
		this.t_email = t_email;
	}
	public String getT_inip() {
		return t_inip;
	}
	public void setT_inip(String t_inip) {
		this.t_inip = t_inip;
	}
	public String getT_outip() {
		return t_outip;
	}
	public void setT_outip(String t_outip) {
		this.t_outip = t_outip;
	}
	public String getT_mac() {
		return t_mac;
	}
	public void setT_mac(String t_mac) {
		this.t_mac = t_mac;
	}
	public String getT_dept() {
		return t_dept;
	}
	public void setT_dept(String t_dept) {
		this.t_dept = t_dept;
	}
	public String getT_team() {
		return t_team;
	}
	public void setT_team(String t_team) {
		this.t_team = t_team;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((t_dept == null) ? 0 : t_dept.hashCode());
		result = prime * result + ((t_email == null) ? 0 : t_email.hashCode());
		result = prime * result + t_id;
		result = prime * result + ((t_inip == null) ? 0 : t_inip.hashCode());
		result = prime * result + ((t_mac == null) ? 0 : t_mac.hashCode());
		result = prime * result + ((t_name == null) ? 0 : t_name.hashCode());
		result = prime * result + ((t_outip == null) ? 0 : t_outip.hashCode());
		result = prime * result + ((t_team == null) ? 0 : t_team.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (t_dept == null) {
			if (other.t_dept != null)
				return false;
		} else if (!t_dept.equals(other.t_dept))
			return false;
		if (t_email == null) {
			if (other.t_email != null)
				return false;
		} else if (!t_email.equals(other.t_email))
			return false;
		if (t_id != other.t_id)
			return false;
		if (t_inip == null) {
			if (other.t_inip != null)
				return false;
		} else if (!t_inip.equals(other.t_inip))
			return false;
		if (t_mac == null) {
			if (other.t_mac != null)
				return false;
		} else if (!t_mac.equals(other.t_mac))
			return false;
		if (t_name == null) {
			if (other.t_name != null)
				return false;
		} else if (!t_name.equals(other.t_name))
			return false;
		if (t_outip == null) {
			if (other.t_outip != null)
				return false;
		} else if (!t_outip.equals(other.t_outip))
			return false;
		if (t_team == null) {
			if (other.t_team != null)
				return false;
		} else if (!t_team.equals(other.t_team))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [t_id=" + t_id + ", t_name=" + t_name + ", t_email=" + t_email + ", t_inip=" + t_inip
				+ ", t_outip=" + t_outip + ", t_mac=" + t_mac + ", t_dept=" + t_dept + ", t_team=" + t_team + "]";
	}
}
