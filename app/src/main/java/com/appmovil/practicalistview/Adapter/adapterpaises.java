package com.appmovil.practicalistview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.appmovil.practicalistview.Item.CovidPaises;
import com.appmovil.practicalistview.R;

import java.util.ArrayList;


public class adapterpaises extends ArrayAdapter<CovidPaises> {

    public adapterpaises(Context context, ArrayList<CovidPaises> datos) {
        super(context, R.layout.ly_paisescovid,datos);
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.ly_paisescovid, null);
        TextView lblPais = (TextView)item.findViewById(R.id.lblPais);
        lblPais.setText(getItem(position).getPais());
        TextView lblContagios = (TextView)item.findViewById(R.id.lblContagios);
        lblContagios.setText(getItem(position).getContagios());
        TextView lblMuertes = (TextView)item.findViewById(R.id.lblMuertes);
        lblMuertes.setText(getItem(position).getMuertes());
        return(item);
    }
}


