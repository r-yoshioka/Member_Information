package jp.co.aforce.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.Bean;
import jp.co.aforce.dao.UpdateDao;

@WebServlet(urlPatterns = { "/jp.co.aforce.main/Update" })
public class Update extends HttpServlet {

	public void doPost(
			 HttpServletRequest request,HttpServletResponse response
			 ) throws ServletException, IOException {

		 String LastName=request.getParameter("last_name");
	   	 System.out.println(LastName);
		 String FirstName=request.getParameter("first_name");
		 System.out.println( FirstName);
		 String Sex = request.getParameter("sex");
		 System.out.println( Sex);
		 int Year = Integer.parseInt(request.getParameter("birth_year"));
		 System.out.println( Year);
		 int Month = Integer.parseInt(request.getParameter("birth_month"));
		 System.out.println( Month);
		 int Day = Integer.parseInt(request.getParameter("birth_day"));
		 System.out.println( Day);
		 String Job=request.getParameter("job");
		 System.out.println( Job);
		 String Phone=request.getParameter("phone_number");
		 System.out.println( Phone);
		 String Mail=request.getParameter("mail_address");
		 System.out.println( Mail);

		 Bean b = new Bean();

		 b.setLastName(LastName);
		 b.setFirstName(FirstName);
		 b.setSex(Sex);
		 b.setYear(Year);
		 b.setMonth(Month);
		 b.setDay(Day);
		 b.setJob(Job);
		 b.setPhone(Phone);
		 b.setMail(Mail);

		try {

			 UpdateDao ud = new UpdateDao();
			 int line = ud.update(b);

			 if(line > 0) {
				 request.setAttribute("message2", "会員情報の更新が完了しました。");
				 request.getRequestDispatcher("../views/update.jsp").forward(request, response);
			 }
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
