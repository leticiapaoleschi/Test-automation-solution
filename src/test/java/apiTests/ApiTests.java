package apiTests;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;

import static org.junit.Assert.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApiTests {

    private static HttpClient client;
    private static String baseUrl;
    private static String userID;
    private static String token;
    private final String userName = "Pedro9";
    private final String password = "#Root@123";

    @Before
    public void setup() throws Exception {
        client = HttpClient.newHttpClient();
        baseUrl = "https://demoqa.com";
    }

    private URI buildUri(String endpoint) throws Exception {
        return new URI(baseUrl + endpoint);
    }

    private String buildJson(String userName, String password) {
        return "{"
                + "\"userName\": \"" + userName + "\","
                + "\"password\": \"" + password + "\""
                + "}";
    }

    private HttpResponse<String> sendPostRequest(URI uri, String json) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(json))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private HttpResponse<String> sendGetRequest(URI uri) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/json")
                .GET()
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private HttpResponse<String> sendAuthorizedPostRequest(URI uri, String json, String token) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .POST(BodyPublishers.ofString(json))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    @Test
    public void test1_CreateUser() throws Exception {
        String json = buildJson(userName, password);
        URI uri = buildUri("/Account/v1/User");
        HttpResponse<String> response = sendPostRequest(uri, json);

        assertEquals(201, response.statusCode());
        assertNotNull(response.body());

        String responseBody = response.body();
        userID = responseBody.split("\"userID\":\"")[1].split("\"")[0];
    }

    @Test
    public void test2_GenerateToken() throws Exception {
        String json = buildJson(userName, password);
        URI uri = buildUri("/Account/v1/GenerateToken");
        HttpResponse<String> response = sendPostRequest(uri, json);

        assertEquals(200, response.statusCode());
        assertNotNull(response.body());

        String responseBody = response.body();
        token = responseBody.split("\"token\":\"")[1].split("\"")[0];
    }

    @Test
    public void test3_AuthorizeUser() throws Exception {
        String json = buildJson(userName, password);
        URI uri = buildUri("/Account/v1/Authorized");
        HttpResponse<String> response = sendPostRequest(uri, json);

        assertEquals(200, response.statusCode());
        assertNotNull(response.body());
    }

    @Test
    public void test4_GetBooks() throws Exception {
        URI uri = buildUri("/BookStore/v1/Books");
        HttpResponse<String> response = sendGetRequest(uri);

        assertEquals(200, response.statusCode());
        assertNotNull(response.body());

        String responseBody = response.body();
        System.out.println("Books: " + responseBody);
    }

    @Test
    public void test5_RentBooks() throws Exception {
        assertNotNull(userID);
        assertNotNull(token);

        String json = "{"
                + "\"userId\": \"" + userID + "\","
                + "\"collectionOfIsbns\": ["
                + "{ \"isbn\": \"9781449331818\" },"
                + "{ \"isbn\": \"9781449325862\" }"
                + "]"
                + "}";

        URI uri = buildUri("/BookStore/v1/Books");
        HttpResponse<String> response = sendAuthorizedPostRequest(uri, json, token);

        assertEquals(201, response.statusCode());
        assertNotNull(response.body());
    }
}