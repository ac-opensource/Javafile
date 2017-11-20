package info.App.VaniteaPOS.m_Listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import info.App.VaniteaPOS.R;
import info.App.VaniteaPOS.m_DataObject.Menus;
import info.App.VaniteaPOS.m_GridView.PicassoClient;


public class CustomAdapterList extends BaseAdapter {

    Context c;
    ArrayList<Menus> menuses;

    LayoutInflater inflater;

    public CustomAdapterList(Context c, ArrayList<Menus> menuses) {
        this.c = c;
        this.menuses = menuses;

        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return menuses.size();
    }

    @Override
    public Object getItem(int position) {
        return menuses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.mlist,parent,false);
        }

        TextView ordername= (TextView) convertView.findViewById(R.id.prodname);
        ImageView img= (ImageView ) convertView.findViewById(R.id.prodimg);
        TextView orderprice= (TextView) convertView.findViewById(R.id.prodprice);


        //BIND DATA

        Menus menus = menuses.get(position);

        ordername.setText(menus.getProd_name());
        orderprice.setText(menus.getQcost());



        //IMG
        PicassoClient.downloadImage(c, menus.getImage_url(),img);


        return convertView;
    }
}
