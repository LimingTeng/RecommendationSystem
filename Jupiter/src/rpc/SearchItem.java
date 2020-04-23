package rpc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class SearchItem
 */
@WebServlet("/search")	//@notation: 明确哪个URL对应哪个servlet
public class SearchItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchItem() {
        super();
        // TODO Auto-generated constructor stub
    }

    //怎么处理request和response：根据传来的request返回特定的response
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //doGet(): some practice
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.Handle a GET request and return a response
//		PrintWriter out = response.getWriter();	//PrinterWriter类似一个指针指向response，getWriter()得到输出流
//		if (request.getParameter("username") != null) {	//得到输入的request
//			String username = request.getParameter("username");
//			out.println("Hello " + username);
//		}
//		if (request.getParameter("password") != null) {
//			String password = request.getParameter("password");
//			out.print("Your password is : " + password);
//		}
//		out.close();
		
		//2.return a HTML page
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.print("<html><body>");
//		out.print("<h1>This is a HTML page</h1>");
//		out.print("</body></html>");
//		out.close();
		
		//3.return a JSON object in response body. JSON是一个structure的数据，前端parse的时候可以更好解决
//		response.setContentType("application/json");
//		PrintWriter out = response.getWriter();
//		String username = "";
//		if (request.getParameter("username") != null) {
//			username = request.getParameter("username");
//		}
//		JSONObject obj = new JSONObject();
//		try {
//			obj.put("username", username);
//		} catch(JSONException e) {	//可能出现JSON Exception
//			e.printStackTrace();
//		}
//		out.print(obj);
//		out.close();
		
		//4.JSON array
//		response.setContentType("application/json");
//		PrintWriter out = response.getWriter();
//		JSONArray array = new JSONArray();
//		try {
//			array.put(new JSONObject().put("username", "Lacey"));
//			array.put(new JSONObject().put("password", "123456"));
//		} catch(JSONException e) {	
//			e.printStackTrace();
//		}
//		out.print(array);
//		out.close();
		
		//5.Update after using RpcHelper
		response.setContentType("application/json");
		JSONArray array = new JSONArray();
		try {
			array.put(new JSONObject().put("username", "Lacey"));
			array.put(new JSONObject().put("password", "123456"));
		} catch(JSONException e) {	
			e.printStackTrace();
		}
		RpcHelper.writeJsonArray(response, array);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
