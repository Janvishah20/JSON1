package com.janvi.hp.json1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String json="{" +
                "        \"glossary\": {\n" +
                "      \"title\": \"example glossary\",\n" +
                "  \t\t\t\"GlossDiv\": {\n" +
                "        \"title\": \"S\",\n" +
                "  \t\t\t\"GlossList\": {\n" +
                "           \"GlossEntry\": {\n" +
                "                  \"ID\": \"SGML\",\n" +
                "  \t\t\t\t\t\t\t\t\"SortAs\": \"SGML\",\n" +
                "  \t\t\t\t\t\t\t\t\"GlossTerm\": \"Standard Generalized Markup Language\",\n" +
                "  \t\t\t\t\t\t\t\t\"Acronym\": \"SGML\",\n" +
                "  \t\t\t\t\t\t\t\t\"Abbrev\": \"ISO 8879:1986\",\n" +
                "  \t\t\tt\t\t\t\t\t\"GlossDef\": {\n" +
                "             \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n" +
                " \t\t\t\t\t\"GlossSeeAlso\": [\"GML\", \"XML\"]\n" +
                "                },\n" +
                "\t\t\t\t\t\t\t\"GlossSee\": \"markup\"\n" +
                "            }" +
                "        }" +
                "   }" +
                "}" +
                "}";
        try {
            JsonDemo(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void JsonDemo(String json)throws JSONException {


        JSONObject rootobj = new JSONObject(json);
        JSONObject subject = rootobj.getJSONObject("glossary");

        String title = subject.getString("title");
        Log.d("myapplication", "title:" + title);

        JSONObject SubObj = subject.getJSONObject("GlossDiv");
        String subtitle = SubObj.getString("title");
        Log.d("myapplication", "subtitle:" + subtitle);

        JSONObject listObj = SubObj.getJSONObject("GlossList");
        JSONObject entryObj = listObj.getJSONObject("GlossEntry");
        String id = entryObj.getString("ID");
        Log.d("myapplication", "id:" + id);

        String sortAs = entryObj.getString("SortAs");
        Log.d("myapplication", "sortAs:" + sortAs);

        String glossTerm = entryObj.getString("GlossTerm");
        Log.d("myapplication", "glossTerm:" + glossTerm);

        String acronym = entryObj.getString("Acronym");
        Log.d("myapplication", "acronym:" + acronym);
        String abbrev = entryObj.getString("Abbrev");
        Log.d("myapplication", "abbrev:" + abbrev);

        JSONObject defObj = entryObj.getJSONObject("GlossDef");
        String para = defObj.getString("para");
        Log.d("myapplication", "para:" + para);

        JSONArray seeAlso = defObj.getJSONArray("GlossSeeAlso");
        for (int i = 0; i < seeAlso.length(); i++) {
            String temp = seeAlso.getString(i);
            Log.d("myapplication", "seeAlso" + temp);
        }


        String glossSeeObj = entryObj.getString("GlossSee");
        Log.d("myapplication", "glossSeeObj:" + glossSeeObj);

        rootobj.get("glossary");


    }
}
