package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
 * Servlet implementation class 특정상품조회Servlet
 */
@WebServlet("/특정상품조회Servlet")
public class 특정상품조회Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public 특정상품조회Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request param 수집
		String idStr = request.getParameter("id");

		// request param 가공
		idStr = idStr == null ? "0" : idStr;
		int id = Integer.parseInt(idStr);// numberFormatException 처리

		// 로직
		String sql = "SELECT ProductId, ProductName, Price FROM Products WHERE ProductId = ? "; // ? 파라미터 넣기. sql
																								// injection (해커공격)을 
																								// 방어하기 위해
		ServletContext application = request.getServletContext();
		String url = application.getAttribute("jdbc.url").toString();
		String user = application.getAttribute("jdbc.username").toString();
		String pw = application.getAttribute("jdbc.password").toString();

		try (Connection con = DriverManager.getConnection(url, user, pw);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, id); // 쿼리의 첫번째 물음표에 int id 값 추가

			try (ResultSet rs = pstmt.executeQuery();) {
				// setAttribute 추가
				List<Product> list = new ArrayList<>();

				while (rs.next()) {
					Product product = new Product();

					product.setProductId(rs.getString("productId"));
					product.setProductName(rs.getString("productName"));
					product.setPrice(rs.getDouble("price"));

					list.add(product);
				}
				request.setAttribute("productList", list);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		String path = "\\WEB-INF\\view\\특정상품조회.jsp";
		request.getRequestDispatcher(path).forward(request, response);

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
