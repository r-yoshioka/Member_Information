package jp.co.aforce.set;

public class Check {

	public String nullCheck(
			String last_name, String first_name, String sex, String birth_year,
			String birth_month, String birth_day, String job, String phone_number, String mail_address) {

		if(last_name.equals("")) {
			return "姓";
		}

		if(first_name.equals("")){
			return "名";
		}

		try {
			if(sex.equals("")) {
				return "性別";
			}
		}catch(Exception e) {
			return "性別";
		}

		if(birth_year.equals("")) {
			return "年";
		}

		if(birth_month.equals("")){
			return "月";
		}

		if(birth_year.equals("")) {
			return "日";
		}

		if(birth_month.equals("")){
			return "職業";
		}

		if(birth_year.equals("")) {
			return "電話番号";
		}

		if(birth_month.equals("")){
			return "メールアドレス";
		}
		return "";
	}



}
