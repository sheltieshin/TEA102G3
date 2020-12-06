package com.member.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MemberLogin")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected boolean loginAccess(String account, String password) {
		if ("xxx".equals(account) && "xxx".equals(password))
			return true;
		else
			return false;
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("Big5");
		res.setContentType("text/html; charset=Big5");

		PrintWriter out = res.getWriter();
		String account = req.getParameter("account");
		String password = req.getParameter("password");
		if (!loginAccess(account, password)) {
			out.println("<HTML><HEAD><TITLE>Access Denied</TITLE></HEAD>");
			out.println("<BODY>帳號或密碼有誤，請重新輸入!<BR>");
			out.println("請重新登入 <A HREF=" + req.getContextPath() + "/login.html>重新登入</A>");
			out.println("</BODY></HTML>");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("account", account);
			try {
				String location = (String) session.getAttribute("location");
				if (location != null) {
					session.removeAttribute("location");
					res.sendRedirect(location);
					return;
				}
			} catch (Exception ignored) {
			}
			res.sendRedirect(req.getContextPath() + "/loginSuccess.jsp");

		}

	}

}
