package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.bean.Bean;

public class UpdateDao extends Dao {

	public List<Bean> search(String mumber_id ) throws Exception {
		List<Bean> list = new ArrayList<>();

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"SELECT * FROM member_info WHERE member_id = ?" );

		st.setString(1, mumber_id);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			Bean b = new Bean();
			b.setLastName(rs.getString("last_name"));
			b.setFirstName(rs.getString("first_name"));
			b.setSex(rs.getString("sex"));
			b.setYear(rs.getInt("birth_year"));
			b.setMonth(rs.getInt("birth_month"));
			b.setDay(rs.getInt("birth_day"));
			b.setJob(rs.getString("job"));
			b.setPhone(rs.getString("phone_number"));
			b.setMail(rs.getString("mail_address"));
			list.add(b);
		}
		st.close();
		con.close();

		return list;
	}

	public int update(Bean bean) throws Exception {

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"UPDATE member_info SET "
				 + " LAST_NAME =  ?,  FIRST_NAME = ?, SEX = ?, BIRTH_YEAR = ?, BIRTH_MONTH = ?, BIRTH_DAY = ?, JOB = ?, PHONE_NUMBER = ?, MAIL_NUMBER = ?"
				 + "WHERE MEMBER_ID = ?" );

		st.setString(1, bean.getLastName());
		st.setString(2, bean.getFirstName());
		st.setString(3, bean.getSex());
		st.setInt(4, bean.getYear());
		st.setInt(5, bean.getMonth());
		st.setInt(6, bean.getDay());
		st.setString(7, bean.getJob());
		st.setString(8, bean.getPhone());
		st.setString(9, bean.getMail());
		st.setString(10, bean.getId());

		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}

}
