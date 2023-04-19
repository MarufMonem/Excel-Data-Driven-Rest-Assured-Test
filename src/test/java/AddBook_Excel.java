import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class AddBook_Excel {
    public static void main(String[] args) {

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", "Marufs Book 1");
        jsonAsMap.put("isbn", "isbnn");
        jsonAsMap.put("aisle", "98761");
        jsonAsMap.put("author", "Maruf Monem");

        RestAssured.baseURI= "http://216.10.245.166";
        Response response = given().header("Content-Type", "application/json")
                .body(jsonAsMap)
                .when().post("Library/Addbook.php")
                .then().assertThat().statusCode(200).extract().response();
        JsonPath js = new JsonPath(response.asString());
        String id = js.get("ID");
        System.out.println(id);

    }
}
