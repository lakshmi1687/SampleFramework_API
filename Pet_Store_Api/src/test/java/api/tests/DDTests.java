package api.tests;

import org.testng.annotations.Test;
import api.endpoints.StoreEndPoints;
import api.payload.Store;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	
	@Test(priority=1,dataProvider="Data", dataProviderClass= DataProviders.class)
	public void testPostStoreData(String StoreId,String PetId,String Quantity,String Status,String Complete) {
		
		Store storePayload = new Store();
		storePayload.setId(Integer.parseInt(StoreId));
		storePayload.setPetId(Integer.parseInt(PetId));
		storePayload.setQuantity(Integer.parseInt(Quantity));
		storePayload.setStatus(Status);
		storePayload.setComplete(Boolean.parseBoolean(Complete));
		
		Response response = StoreEndPoints.createStore(storePayload);
		response.then().assertThat().statusCode(200);

	}
	
}	
	
