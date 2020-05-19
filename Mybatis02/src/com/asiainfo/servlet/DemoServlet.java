package com.asiainfo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asiainfo.pojo.PageInfo;
import com.asiainfo.service.PeopleService;
import com.asiainfo.service.PeopleServiceImpl;

@WebServlet("/page")
public class DemoServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pageNumberStr = req.getParameter("pageNumber");
		String pageSizeStr = req.getParameter("pageSize");
		int pageNumber = 1;
		int pageSize = 2;
		if (pageNumberStr!= null && !"".endsWith(pageNumberStr)) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		if (pageSizeStr!= null && !"".endsWith(pageSizeStr)) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		PeopleService service = new PeopleServiceImpl();
		PageInfo pageInfo = service.showPage(pageSize, pageNumber);
		req.setAttribute("PageInfo", pageInfo);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
