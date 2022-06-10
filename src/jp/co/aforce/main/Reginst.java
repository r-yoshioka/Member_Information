package jp.co.aforce.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.Bean;
import jp.co.aforce.dao.ReginstDao;
import jp.co.aforce.dao.SearchDao;
import jp.co.aforce.set.Message;
import jp.co.aforce.tool.Page;

@WebServlet(urlPatterns = { "/jp.co.aforce.main/Reginst" })
public class Reginst extends HttpServlet {

	public void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		Page.header(out);

		try {

			String LastName = request.getParameter("last_name");
			System.out.println(LastName);
			String FirstName = request.getParameter("first_name");
			System.out.println(FirstName);
			String Sex = request.getParameter("sex");
			System.out.println(Sex);
			int Year = Integer.parseInt(request.getParameter("birth_year"));
			System.out.println(Year);
			int Month = Integer.parseInt(request.getParameter("birth_month"));
			System.out.println(Month);
			int Day = Integer.parseInt(request.getParameter("birth_day"));
			System.out.println(Day);
			String Job = request.getParameter("job");
			System.out.println(Job);
			String Phone = request.getParameter("phone_number");
			System.out.println(Phone);
			String Mail = request.getParameter("mail_address");
			System.out.println(Mail);

			Bean b = new Bean();

			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyMMddHHmmss");
			LocalDateTime ld = LocalDateTime.now();
			String date = ld.format(format);

			b.setId("A" + date);
			b.setLastName(LastName);
			b.setFirstName(FirstName);
			b.setSex(Sex);
			b.setYear(Year);
			b.setMonth(Month);
			b.setDay(Day);
			b.setJob(Job);
			b.setPhone(Phone);
			b.setMail(Mail);

			SearchDao sd = new SearchDao();

			int line = sd.search(b);

			if(request.getParameter("last_name") == "" ||
				request.getParameter("first_name") == "" ||
				request.getParameter("sex") == null ||
				request.getParameter("birth_year") == null||
				request.getParameter("birth_month") == null||
				request.getParameter("birth_day") == null||
				request.getParameter("phone_number") == ""||
				request.getParameter("mail_address") == ""||
				request.getParameter("job") == null) {

				request.setAttribute("messageW1", Message.W_01);
				request.setAttribute("line", line);
				request.getRequestDispatcher("../views/reginst.jsp").forward(request, response);
			}

			if(line > 0) {
				request.setAttribute("messageE1", Message.E_01);
				request.getRequestDispatcher("../views/reginst.jsp").forward(request, response);
			}else {
				ReginstDao rd = new ReginstDao();

				line = rd.insert(b);

				request.setAttribute("messageI1", Message.I_01);
				request.getRequestDispatcher("../views/reginst.jsp").forward(request, response);
			}

		} catch (Exception e) {
			request.setAttribute("messageE2", Message.E_02);
			request.getRequestDispatcher("../views/reginst.jsp").forward(request, response);
			e.printStackTrace();

		}
		Page.footer(out);
	}
}


