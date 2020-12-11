package com.appmovil.practicalistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.appmovil.practicalistview.Adapter.adapterpaises;
import com.appmovil.practicalistview.Item.CovidPaises;
import com.appmovil.practicalistview.WebService.Asynchtask;
import com.appmovil.practicalistview.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask {
 public ListView lstOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = this.getIntent().getExtras();
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://api.covid19api.com/summary",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {

        JSONObject JSONlista =  new JSONObject(result);
        JSONArray JSONlistaUsuarios=  JSONlista.getJSONArray("Countries");
        ArrayList<CovidPaises> lstUsuarios = CovidPaises.JsonObjectsBuild(JSONlistaUsuarios);
        lstOpciones = (ListView)findViewById(R.id.list2);
       adapterpaises adaptadorpaises = new adapterpaises(this, lstUsuarios);
        lstOpciones.setAdapter(adaptadorpaises);

    }
}