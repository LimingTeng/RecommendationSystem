package external;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class TicketMasterAPI {
	private static final String URL = "https://app.ticketmaster.com/discovery/v2/events.json";
	private static final String DEFAULT_KEYWORD = "";	//no restriction
	private static final String API_KEY = "AFfzPAMsi6sC9kLSXCnE1m09jInCxvnU";	//验证身份，限制
	
	public JSONArray search(double latitude, double longitude, String keyword) {
		if (keyword == null) {
			keyword = DEFAULT_KEYWORD;
		}
		//encode keyword in URL since it may contain special characters
		try {
			keyword = java.net.URLEncoder.encode(keyword, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//convert latitude/longitude to geo hash
		String geoHash = GeoHash.encodeGeohash(latitude, longitude, 8);
		//make URL query
		String query = String.format("apikey=%s&geoPoint=%s&keyword=%s&radius=%s",
				API_KEY, geoHash, keyword, 50);
		//make connection
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(URL + "?" + query).openConnection();
			
			connection.setRequestMethod("GET");
			
			int responseCode = connection.getResponseCode();
			
			System.out.println("\nSending 'GET' request to URL : " + URL + "?" + query);
			System.out.println("Response Code : " + responseCode);
			
			if (responseCode != 200) {
				
			}
			
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			JSONObject obj = new JSONObject(response.toString());
			if (obj.isNull("_embedded")) {
				return new JSONArray();
			}
			JSONObject embedded = obj.getJSONObject("_embedded");
			JSONArray events = embedded.getJSONArray("events");
			
			return events;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JSONArray();
	}
	
	//debug : 检测search获取的结果是否正确
	private void queryAPI(double latitude, double longitude) {
		JSONArray events = search(latitude, longitude, null);
		try {
			for (int i = 0; i < events.length(); i++) {
				JSONObject event = events.getJSONObject(i);
				System.out.println(event);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		TicketMasterAPI tmApi = new TicketMasterAPI();
		tmApi.queryAPI(29.682684, -95.295410);
	}
}
