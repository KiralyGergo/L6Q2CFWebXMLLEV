package neptunkod;

import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONReadNeptunkod {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("orarendNeptunkod.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject orarend = (JSONObject) jsonObject.get("orarend");
            JSONArray orak = (JSONArray) orarend.get("ora");

            System.out.println("Orarend adatok (mezo: ertek):");
            for (Object o : orak) {
                JSONObject ora = (JSONObject) o;
                System.out.println("------------------------------------");
                for (Object key : ora.keySet()) {
                    System.out.println(key + ": " + ora.get(key));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}