package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;

/**
 * Servlet implementation class ProductCounting
 */
@WebServlet("/ProductCounting")
public class ProductLogic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductLogic() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파라미터 수집 가공
		// 데이터 로직
		// setAttribute
		// forward

		String sql = "SELECT ProductName, Price FROM Products ORDER BY ProductName";
		ServletContext application = request.getServletContext();

		String url = application.getAttribute("jdbc.url").toString();
		String user = application.getAttribute("jdbc.username").toString();
		String pw = application.getAttribute("jdbc.password").toString();

		// List에 domain/Product클래스 객체를 담기
		List<Product> list = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(url, user, pw);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql); // db를 가리킴

		) {
			// 어떻게 비지니스 로직을 계획할까? 상품명, 가격을 얻어와서 조회하기.
			while (rs.next()) { // rs.next() 사용
				Product product = new Product();
				product.setProductName(rs.getString("ProductName"));
				product.setPrice(rs.getDouble("Price")); //getDouble

				list.add(product);

			}
			request.setAttribute("productList", list);

		} catch (Exception e) {
			e.printStackTrace();
		}

		String path = "\\WEB-INF\\view\\view1.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
