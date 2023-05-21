package api.tests;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.StoreEndPoints;
import api.endpoints.StoreEndPointByProperties;
import api.payload.Store;
import io.restassured.response.Response;

public class StoreTests {
	
	
	Faker faker = new Faker();
	Store storePayload = new Store();
	public Logger logger;
	
	@BeforeClass
	public void setupData() {
		
		storePayload.setId(faker.number().hashCode());
		storePayload.setPetId(faker.number().randomDigitNotZero());
		storePayload.setQuantity(faker.number().numberBetween(1, 10));
		storePayload.setStatus("placed");
		storePayload.setComplete(true);
		
		logger =  LogManager.getLogger(this.getClass());
		
		
	}
	@Test(priority=1)
	public void postTest() {
		logger.info("Creating store id");
		
//		Response response = StoreEndPoints.createStore(storePayload);
		
		Response response = StoreEndPointByProperties.createStoreId(storePayload);
		
		
		  response.then()
		  .assertThat().statusCode(200)
		  .assertThat().log().all();
		  logger.info("------store id is created along with other params------");
	}
	
	@Test(priority=2)
	public void getTest() {
		logger.info("-----store id is fetching from created payload-----");
		
		/**
		 * data is fetching using store end points class
		 */
//		Response response = StoreEndPoints.getStore(this.storePayload.getId());
		
		/**
		 * data is fetching using properties file
		 */
		Response response = StoreEndPointByProperties.getStoreId(this.storePayload.getId());
		
		response.then().statusCode(200)
		.assertThat().log().all();
	}
	
    @Test(priority=3)
	public void deleteTest() {
		
    	logger.info("-----deleting created store id-----");
    	
//		Response response = StoreEndPoints.deleteStore(this.storePayload.getId());
		
		Response response = StoreEndPointByProperties.deleteStoreId(this.storePayload.getId());
		
		response.then().assertThat().log().all()
		.assertThat().statusCode(200);
	}
}

