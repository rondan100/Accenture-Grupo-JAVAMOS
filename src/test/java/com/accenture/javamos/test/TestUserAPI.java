package com.accenture.javamos.test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.junit.Test;

import io.restassured.RestAssured;

public class TestUserAPI {
	
	private String url = "http://localhost:8080/user/signup";
	
	@Test
	public void createUserTest() {
		given()
		.contentType("application/json")
		.body("{ \n"
				+ "		\"firstName\":\"John\",\n"
				+ "		\"lastName\": \"Doe\",\n"
				+ "		\"password\":\"1234\",\n"
				+ "		\"email\":\"john.doe@anonymous.org\"\n"
				+ "	}")
		.when()
			.post(url)
		.then()
			.statusCode(201)
			.log().all();
	}
	
	@Test
	public void createUserWihOutNameTest() {
		given()
			.contentType("application/json")
			.body("{ \n"
					+ "		\"firstName\":\"\",\n"
					+ "		\"lastName\": \"Doe\",\n"
					+ "		\"password\":\"1234\",\n"
					+ "		\"email\":\"john.doe@anonymous.org\"\n"
					+ "	}")
		.when()
			.post(url)
		.then()
			.statusCode(400)
			.log().all();
	}
	
	@Test
	public void createUserWihOutLastNameTest() {
		given()
			.contentType("application/json")
			.body("{ \n"
					+ "		\"firstName\":\"John\",\n"
					+ "		\"lastName\": \"\",\n"
					+ "		\"password\":\"1234\",\n"
					+ "		\"email\":\"john.doe@anonymous.org\"\n"
					+ "	}")
		.when()
			.post(url)
		.then()
			.statusCode(400)
			.log().all();
	}
	
	@Test
	public void createUserWihOutPasswordTest() {
		given()
			.contentType("application/json")
			.body("{ \n"
					+ "		\"firstName\":\"John\",\n"
					+ "		\"lastName\": \"Doe\",\n"
					+ "		\"password\":\"\",\n"
					+ "		\"email\":\"john.doe@anonymous.org\"\n"
					+ "	}")
		.when()
			.post(url)
		.then()
			.statusCode(401)
			.log().all();
	}
	
	@Test
	public void createUserTestWithOutEmail() {
		given()
			.contentType("application/json")
			.body("{ \n"
					+ "		\"firstName\":\"John\",\n"
					+ "		\"lastName\": \"Doe\",\n"
					+ "		\"password\":\"1234\",\n"
					+ "		\"email\":\"\"\n"
					+ "	}")
		.when()
			.post(url)
		.then()
			.statusCode(401)
			.log().all();
	}
	
	
}
