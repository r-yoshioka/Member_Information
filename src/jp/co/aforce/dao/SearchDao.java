package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.bean.Bean;

public class SearchDao extends Dao {

	public int search(Bean bean) throws Exception {

        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement(
                "SELECT * FROM member_info WHERE "
                + " LAST_NAME =  ? AND  FIRST_NAME = ? AND SEX = ? AND BIRTH_YEAR = ? AND BIRTH_MONTH = ? AND BIRTH_DAY = ? AND JOB = ? AND PHONE_NUMBER = ? AND MAIL_ADDRESS = ?");

        st.setString(1, bean.getLastName());
        st.setString(2, bean.getFirstName());
        st.setString(3, bean.getSex());
        st.setInt(4, bean.getYear());
        st.setInt(5, bean.getMonth());
        st.setInt(6, bean.getDay());
        st.setString(7, bean.getJob());
        st.setString(8, bean.getPhone());
        st.setString(9, bean.getMail());

        ResultSet rs = st.executeQuery();

        int line = 0;
        while (rs.next()) {
            line++;
        }
        return line;
    }

}
