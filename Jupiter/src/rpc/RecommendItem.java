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
 * Servlet implementation class RecommendItem
 */
@WebServlet("/recommendation")
public class RecommendItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.JSON Array
//		PrintWriter out = response.getWriter();
//		JSONArray array = new JSONArray();
//		try {
//			array.put(new JSONObject().put("name", "Lacey")			//这个put()方法put完会返回Object,所以可以连续put; 打印出来address在最上面,内部顺序他自己确定我们没法改变
//										.put("address", "Seattle")
//										.put("time", "04/20/2020"));
//			array.put(new JSONObject().put("name", "Eason")
//										.put("address", "Bellevue")
//										.put("time", "04/20/2020"));
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		out.print(array);
//		out.close();
		
		//2.After using RpcHelper
		JSONArray array = new JSONArray();
		try {
			array.put(new JSONObject().put("name", "Lacey")			//这个put()方法put完会返回Object,所以可以连续put; 打印出来address在最上面,内部顺序他自己确定我们没法改变
										.put("address", "Seattle")
										.put("time", "04/20/2020"));
			array.put(new JSONObject().put("name", "Eason")
										.put("address", "Bellevue")
										.put("time", "04/20/2020"));
		} catch (JSONException e) {
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
