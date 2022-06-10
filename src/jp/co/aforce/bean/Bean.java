package jp.co.aforce.bean;

public class Bean implements java.io.Serializable {

	private String mumber_id;
	private String last_name;
	private String first_name;
	private String sex;
	private int birth_year;
	private int birth_month;
	private int birth_day;
	private String job;
	private String phone_number;
	private String mail_address;

	public String getId() {
		return mumber_id;
	}

	public String getLastName() {
		return last_name;
	}

	public String getFirstName() {
		return first_name;
	}

	public String getSex() {
		return sex;
	}

	public int getYear() {
		return birth_year;
	}

	public int getMonth() {
		return birth_month;
	}

	public int getDay() {
		return birth_day;
	}

	public String getJob() {
		return job;
	}

	public String getPhone() {
		return phone_number;
	}

	public String getMail() {
		return mail_address;
	}



	public void setId(String mumber_id) {
		this.mumber_id = mumber_id;
	}

	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setYear(int birth_year) {
		this.birth_year = birth_year;
	}

	public void setMonth(int birth_month) {
		this.birth_month = birth_month;
	}

	public void setDay(int birth_day) {
		this.birth_day = birth_day;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public void setPhone(String phone_number) {
		this.phone_number = phone_number;
	}

	public void setMail(String mail_address) {
		this.mail_address = mail_address;
	}



}
