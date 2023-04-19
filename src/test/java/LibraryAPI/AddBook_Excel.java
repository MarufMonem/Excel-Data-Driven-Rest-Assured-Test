package LibraryAPI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resources.dataDriven;

import static io.restassured.RestAssured.given;

public class AddBook_Excel {
    public static void main(String[] args) throws IOException {

        dataDriven d =new dataDriven();
        ArrayList<String> data =  d.getData("AddBook");

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", data.get(1));
        jsonAsMap.put("isbn", data.get(2));
        jsonAsMap.put("aisle", data.get(3));
        jsonAsMap.put("author", data.get(4));

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
