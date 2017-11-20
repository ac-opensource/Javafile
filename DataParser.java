package info.App.VaniteaPOS.m_MySQL;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.GridView;
import android.widget.Toast;
import info.App.VaniteaPOS.m_DataObject.Menus;
import info.App.VaniteaPOS.m_GridView.CustomAdapter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class DataParser extends AsyncTask<Void,Void,Integer> {


    Context c;
    String jsonData;
    GridView gv;

    ProgressDialog pd;
    ArrayList<Menus> menuses =new ArrayList<>();

    public DataParser(Context c, String jsonData, GridView gv) {
        this.c = c;
        this.jsonData = jsonData;
        this.gv = gv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("Parse");
        pd.setMessage("Parsing...Please Wait");
        pd.show();

    }

    @Override
    protected Integer doInBackground(Void... params)      {
        return this.parseData();
    }

    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);

        pd.dismiss();

        if(result==0)
        {
            Toast.makeText(c,"Unable To Parse",Toast.LENGTH_SHORT).show();
        }else {
            //BIND DATA TO GRIDVIEW
            CustomAdapter adapter=new CustomAdapter(c, menuses);
            gv.setAdapter(adapter);



        }
    }

    private int parseData()
    {
        try
        {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;

            menuses.clear();
            Menus menus;

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);

                int id=jo.getInt("id");
                String name=jo.getString("prod_name");
                String description=jo.getString("prod_desc");
                String imageUrl=jo.getString("image_url");
                int qcost=jo.getInt("Qcost");



                menus =new Menus();

                menus.setId(id);
                menus.setProd_name(name);
                menus.setProd_desc(description);
                menus.setImage_url(imageUrl);
                menus.setQcost(qcost);


                menuses.add(menus);
            }


            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
