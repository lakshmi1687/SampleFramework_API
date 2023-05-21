package api.endpoints;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import api.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


//created to perform create,retrieve,update and delete operations

public class StoreEndPoints {
	
    @Test
	public static Response createStore(Store payload) {
	
				
		Response response = given()
		                     .contentType("application/json")
		                     .accept("application/json")
		                     .body(payload)
		
		                   .when()
		                       .post(Routes.postUrl);
		
		return response;
		                       
	}
	
	public static Response getStore(int orderid) {
		
		Response response = given()
		                      .pathParam("orderid", orderid)
		                    .when()
		                      .get(Routes.getUrl);
		
		        return response;
		  
	}
	
	public static Response deleteStore(int orderid) {
		
		Response response = given()
		                      .pathParam("orderid", orderid)
		                    .when()
		                       .delete(Routes.deleteUrl);
		
		        return response;
	}

}
