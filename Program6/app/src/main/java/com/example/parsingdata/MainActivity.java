package com.example.parsingdata;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {

    Button parse_XML, parse_JSON;
    TextView text_XML, text_JSON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parse_XML = (Button) findViewById(R.id.buttonXML);
        parse_JSON = (Button) findViewById(R.id.buttonJSON);
        text_XML = (TextView) findViewById(R.id.textXML);
        text_JSON = (TextView) findViewById(R.id.textJSON);

        parse_XML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputStream inputStream = getAssets().open("test.xml");
                    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                    Document document = documentBuilder.parse(inputStream);
                    StringBuilder xmlData = new StringBuilder();
                    xmlData.append("Data From XML");
                    xmlData.append("\n------------------");
                    NodeList nodeList = document.getElementsByTagName("place");
                    for(int i = 0; i < nodeList.getLength(); i++)
                    {
                        Node node = nodeList.item(i);
                        if(node.getNodeType()== Node.ELEMENT_NODE)
                        {
                            Element element = (Element) node;
                            xmlData.append("\nCity_Name: ").append(getValue("name",element));
                            xmlData.append("\nLatitude: ").append(getValue("lat",element));
                            xmlData.append("\nLongitude: ").append(getValue("long",element));
                            xmlData.append("\nTemperature: ").append(getValue("temperature",element));
                            xmlData.append("\nHumidity: ").append(getValue("humidity",element));
                            xmlData.append("\n------------------");
                        }
                        text_XML.setText(xmlData.toString());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Error Parsing XML Data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        parse_JSON.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    InputStream inputStream = getAssets().open("sample.json");
                    int size = inputStream.available();
                    byte[] buffer = new byte[size];
                    inputStream.read(buffer);
                    String jsonString = new String(buffer, Charset.defaultCharset());
                    JSONArray jsonArray = new JSONArray(jsonString);
                    StringBuilder jsonData = new StringBuilder();
                    jsonData.append("Data From JSON");
                    jsonData.append("\n-------------------");
                    for(int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        jsonData.append("\nCity_Name: ").append(jsonObject.getString("name"));
                        jsonData.append("\nLatitude: ").append(jsonObject.getString("lat"));
                        jsonData.append("\nLongitude: ").append(jsonObject.getString("long"));
                        jsonData.append("\nTemperature: ").append(jsonObject.getString("temperature"));
                        jsonData.append("\nHumidity: ").append(jsonObject.getString("humidity"));
                        jsonData.append("\n-------------------");
                    }
                    text_JSON.setText(jsonData.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Error Parsing JSON Data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private String getValue(String tag, Element element)
    {
        return element.getElementsByTagName(tag).item(0).getChildNodes().item(0).getNodeValue();
    }
}