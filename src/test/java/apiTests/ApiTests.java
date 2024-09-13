package apiTests;
import com.github.dockerjava.transport.DockerHttpClient;
import io.restassured.RestAssured;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class ApiTests {
    @Test
    public void CreateUser(){
        RestAssured.baseURI = "https://demoqa.com";

    }
}