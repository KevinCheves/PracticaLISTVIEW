package com.appmovil.practicalistview.Item;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CovidPaises {
    private String pais;
    private String contagios;
    private String muertes;

    public CovidPaises(JSONObject a) throws JSONException {
        pais =  "Pais: "+ a.getString("Country").toString();
        contagios = "Total Confirmados: "+  a.getString("TotalConfirmed").toString() ;
        muertes =  "Total de muertes: "+ a.getString("TotalDeaths").toString() ;
    }
    public static  ArrayList<CovidPaises> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<CovidPaises> listapaises = new ArrayList<>();

        for (int i = 0; i < datos.length() && i<20; i++) {
            listapaises.add(new CovidPaises(datos.getJSONObject(i)));
        }
        return listapaises;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setContagios(String contagios) {
        this.contagios = contagios;
    }

    public void setMuertes(String muertes) {
        this.muertes = muertes;
    }

    public String getPais() {
        return pais;
    }

    public String getContagios() {
        return contagios;
    }

    public String getMuertes() {
        return muertes;
    }
}
