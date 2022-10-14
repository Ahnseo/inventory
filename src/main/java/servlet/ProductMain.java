package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;

/**
 * Servlet implementation class ProductMain
 */
@WebServlet("/ProductMain")
public class ProductMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductMain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request param(수집, 가공), businessLogic, setAttribute, forward
		String sql = "SELECT ProductName, Price FROM Products ORDER BY ProductId"; //상품브랜드로 오른차순 정렬 예정 (농심,롯데,오리온 ...)
		ServletContext application = request.getServletContext();
		String url = application.getAttribute("jdbc.url").toString();
		String user = application.getAttribute("jdbc.username").toString();
		String pw = application.getAttribute("jdbc.password").toString();
		
		String productName = request.getParameter("productName");
		String productBrand = request.getParameter("productBrand");
		String productId = request.getParameter("productId");
		

		// #1.상품 재고 현황 전체 조회
		List<Product> list = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(url, user, pw);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql); // db를 가리킴
			){
			// 
			while (rs.next()) { // rs.next() 사용
				Product product = new Product();
//				product.setProductId(rs.getString("ProductId")); NullFormat Exception 오류생기네..
//				product.setProductBrand(rs.getString("ProductBrand"));
				product.setProductName(rs.getString("ProductName"));
//				product.setBoxUnit(); //박스 단위의 개수 기록. (ex. 칸쵸 1box= 24ea )
//				product.setBoxEA() //박스 개수 기록
//				product.setMainStorage(rs.getInt("MainStorage"));
//				product.setSubStorage1(rs.getInt("SubStorage1"));
//				product.setSubStorage2(rs.getInt("SubStorage2"));
//				product.setPosStorage(rs.getInt("PosStorage"));
//				product.setDrinkStorage(rs.getInt("DrinkStorage"));
				product.setPrice(rs.getDouble("Price")); //getDouble

				list.add(product);

			}
			request.setAttribute("productList", list);

		} catch (Exception e) {
			e.printStackTrace();
		}

		String path = "\\WEB-INF\\view\\viewMain.jsp";
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
