package controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

public class EmpServlet extends HttpServlet {
	private EmpDao empDao = new EmpDao();
	private static final long serialVersionUID = 1L;

	public EmpServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String url = request.getRequestURI();
		String action = request.getRequestURI().substring(url.lastIndexOf('/') + 1, url.lastIndexOf('.'));
		if ("list".equals(action)) {
			List<Emp> listEmp = empDao.findAll();
			request.setAttribute("listEmp", listEmp);
			request.getRequestDispatcher("listEmp.jsp").forward(request, response);
		} else if ("add".equals(action)) {
			Emp emp = new Emp();
			emp.setName(request.getParameter("name"));
			emp.setSalary(Double.parseDouble(request.getParameter("salary")));
			emp.setAge(Integer.parseInt(request.getParameter("age")));
			empDao.addEmp(emp);
			response.sendRedirect("list.do");
		} else if ("delete".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			empDao.deleteEmp(id);
			response.sendRedirect("list.do");
		} else if ("load".equals(action)) {
			Emp emp = empDao.loadEmp(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("emp", emp);
			request.getRequestDispatcher("empInfo.jsp").forward(request, response);
		} else if ("update".equals(action)) {
			Emp emp = new Emp();
			emp.setId(Integer.parseInt(request.getParameter("id")));
			emp.setName(request.getParameter("name"));
			emp.setSalary(Double.parseDouble(request.getParameter("salary")));
			emp.setAge(Integer.parseInt(request.getParameter("age")));
			empDao.updateEmp(emp);
			response.sendRedirect("list.do");
		}

	}
}
