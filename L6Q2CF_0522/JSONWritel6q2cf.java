package neptunkod;

import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONWriteNeptunkod {
    public static void main(String[] args) {
        JSONObject root = new JSONObject();
        JSONObject orarend = new JSONObject();
        JSONArray orak = new JSONArray();

        JSONObject ora1 = new JSONObject();
        ora1.put("targy", "Web-es adatkezelő környezetek");
        ora1.put("idopont", "Hétfő 10:00");
        ora1.put("helyszin", "A1/101");
        ora1.put("oktato", "Dr. Kovács János");
        orak.add(ora1);

        JSONObject ora2 = new JSONObject();
        ora2.put("targy", "Adatbázis rendszerek");
        ora2.put("idopont", "Kedd 12:00");
        ora2.put("helyszin", "Info/202");
        ora2.put("oktato", "Kiss Péter");
        orak.add(ora2);

        orarend.put("ora", orak);
        root.put("orarend", orarend);

        System.out.println("JSON Blokk:");
        System.out.println(root.toJSONString());

        try (FileWriter file = new FileWriter("orarendNeptunkod1.json")) {
            file.write(root.toJSONString());
            file.flush();
            System.out.println("\nFajl sikeresen letrehozva: orarendNeptunkod1.json");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}