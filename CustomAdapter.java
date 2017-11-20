package info.App.VaniteaPOS.m_GridView;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import info.App.VaniteaPOS.R;
import info.App.VaniteaPOS.m_DataObject.Menus;
import info.App.VaniteaPOS.m_Listview.CustomAdapterList;

import java.util.ArrayList;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.Toast;

import static info.App.VaniteaPOS.R.id.lv;


public class CustomAdapter extends BaseAdapter{

    Context c;
    ArrayList<Menus> menuses;

    LayoutInflater inflater;
    ListView orderlv;
  //  private ArrayAdapter<String> orderadapter;
   // private ArrayList<String> orderlist = new ArrayList<>();

    public CustomAdapter(Context c, ArrayList<Menus> menuses) {
        this.c = c;
        this.menuses = menuses;


        inflater = ( LayoutInflater ) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


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

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.model, parent, false);
        }

        TextView nameTxt = ( TextView ) convertView.findViewById(R.id.prodname);
        TextView price = ( TextView ) convertView.findViewById(R.id.prodprice);

        ImageButton img = ( ImageButton ) convertView.findViewById(R.id.prodimg);

        //BIND DATA

        final Menus menus = menuses.get(position);
        nameTxt.setText(menus.getProd_name());
        price.setText(String.valueOf(menus.getQcost()));

        //IMG
        PicassoClient.downloadImage(c, menus.getImage_url(), img);


        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



           //  orderadapter = new ArrayAdapter<>(c, R.layout.mlist, orderlist);

                String ordername = menus.getProd_name().toString();
                String price = String.valueOf(menus.getQcost());


                CustomAdapterList orderadapter = new CustomAdapterList(c, menuses);
                orderlv.setAdapter(orderadapter);
                // orderlist.add(Integer.parseInt(ordername),price);
               orderadapter.notifyDataSetChanged();


                Toast.makeText(c, String.valueOf(menus.getQcost()), Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

}