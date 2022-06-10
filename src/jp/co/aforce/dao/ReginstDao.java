package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jp.co.aforce.bean.Bean;

public class ReginstDao extends Dao {

	public int insert(Bean bean) throws Exception {

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"INSERT INTO member_info VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ? )" );

		st.setString(1, bean.getId());
		st.setString(2, bean.getLastName());
		st.setString(3, bean.getFirstName());
		st.setString(4, bean.getSex());
		st.setInt(5, bean.getYear());
		st.setInt(6, bean.getMonth());
		st.setInt(7, bean.getDay());
		st.setString(8, bean.getJob());
		st.setString(9, bean.getPhone());
		st.setString(10, bean.getMail());

		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}

}
