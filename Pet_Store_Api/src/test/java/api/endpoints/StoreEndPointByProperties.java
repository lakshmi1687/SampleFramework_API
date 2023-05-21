package api.endpoints;

import java.util.ResourceBundle;

import api.payload.Store;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPointByProperties {
	
	/**
	 * This method is used to read data from properties file
	 * 
	 */
	
	public static ResourceBundle getURL() {
		
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	
	public static Response createStoreId(Store payload) {
		
		String post_url = getURL().getString("postUrl");
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(post_url);
		return response;
		
	}
	
	public static Response getStoreId(int orderid) {
		
		String get_url = getURL().getString("getUrl");
		
		Response response = given().pathParam("orderid", orderid).when().get(get_url);
		
		return response;
	}
	
	public static Response deleteStoreId(int orderid) {
		
		String del_url = getURL().getString("deleteUrl");
		
		Response response = given()
                .pathParam("orderid", orderid)
              .when()
                 .delete(del_url);
		
		return response;
	}

}
