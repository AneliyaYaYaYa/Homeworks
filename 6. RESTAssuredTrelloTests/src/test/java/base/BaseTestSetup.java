package base;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

import static com.telerikacademy.api.tests.Constants.API_KEY;
import static com.telerikacademy.api.tests.Constants.API_TOKEN;
import static io.restassured.RestAssured.given;

public class BaseTestSetup {

    @BeforeMethod
    public void setup() {
        EncoderConfig encoderConfig = RestAssured.config().getEncoderConfig()
                .appendDefaultContentCharsetToContentTypeIfUndefined(false);

        RestAssured.config = RestAssured.config().encoderConfig(encoderConfig);
    }

    public RequestSpecification authorization_via_queryParam() {

        return given()
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .contentType("application/json");
    }

}
