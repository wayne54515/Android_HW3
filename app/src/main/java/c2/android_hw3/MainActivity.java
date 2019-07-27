package c2.android_hw3;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {

    private ListView mListView;
    private ArrayList<Map<String, Object>> arr_list = new ArrayList<Map<String, Object>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.list);
        String[] user_name;
        mListView.setAdapter(new ViewAdapter(MainActivity.this, arr_list));
//        final JSONArray jsonArray;

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()
                .penaltyLog()
                .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .penaltyLog()
                .penaltyDeath()
                .build());

        try {
            String result = db.executeQuery("SELECT * FROM user");

            JSONArray jsonArray = new JSONArray(result);

            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonData = jsonArray.getJSONObject(i);
                String name = jsonData.getString("name");
                String src = jsonData.getString("src");
                Map<String, Object> item = new HashMap<String, Object>();
                item.put("object", name);
                item.put("image", src);

                arr_list.add(item);

            }
//            Map<String, Object> item = new HashMap<String, Object>();
//            item.put("object", result);
//            item.put("image", "a1");
//
//            arr_list.add(item);
        } catch(Exception e) {
             Log.e("log_tag", e.toString());
        }

//        Map<String, Object> item = new HashMap<String, Object>();
//        item.put("object", "name");
//        item.put("image", "a1");
//
//        arr_list.add(item);

        mListView.setAdapter(new ViewAdapter(MainActivity.this, arr_list));

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
