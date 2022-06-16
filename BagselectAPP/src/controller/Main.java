package controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bag;
import model.BagParser;


@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/main.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String feeling = request.getParameter("feeling");
		String encode = URLEncoder.encode(feeling, "UTF-8");

		String url =new String("http://192.168.2.113:8080/BAGS_API/Main?feeling="+encode);
		//String url =new String("http://192.168.2.113:8080/BAGS_API/Main?feeling=" + feeling);
		System.out.println(url);

		List<Bag> bag =new BagParser().getBag(url);
		request.setAttribute("bag", bag);
		doGet(request, response);
	}

}
