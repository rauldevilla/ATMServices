package com.techandsolve.atm.test.functional;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.techandsolve.atm.core.InvalidAccountException;

import io.restassured.RestAssured;

@SuppressWarnings("unused")
public class FunctionalTestATM {

	private static String baseHost;
	private static String basePath;
	private static String port;
	
	@BeforeClass
	public static void beforeClass() {
		port = System.getProperty("server.port");
        if (port == null) {
            port = "8889";
        }

        basePath = System.getProperty("server.base");
        if(basePath == null){
            basePath = "/ATM";
        }
        RestAssured.basePath = basePath;

        baseHost = System.getProperty("server.host");
        if(baseHost == null){
            baseHost = "http://localhost";
        }
        
	}
	
	private static String getHostURL() {
		return baseHost + ":" + port + basePath; 
	}
	
	//@Test
	public void testInitializeTestData() {
		get("/init-testing-data").then().assertThat().statusCode(200);
	}
	
	@Test(timeout = 3000)
	public void testDepositForActiveAccount() throws InvalidAccountException {
		System.out.println(getHostURL());
		get(getHostURL() + "/deposit?a=1234567890&m=10")
			.then()
				.statusCode(200)
				.body("transactionId", greaterThan(0));
	}
}
