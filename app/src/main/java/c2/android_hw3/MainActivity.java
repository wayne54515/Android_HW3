package c2.android_hw3;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
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
                TableRow tr = new TableRow(MainActivity.this);
//                tr.setLayoutParams(row_layout);
//                tr.setGravity(Gravity.CENTER_HORIZONTAL);

//                TextView user_acc = new TextView(MainActivity.this);
//                user_acc.setText(jsonData.getString("acc"));
//                user_acc.setLayoutParams(view_layout);

//                TextView user_pwd = new TextView(MainActivity.this);
//                user_pwd.setText(jsonData.getString("pwd"));
//                user_pwd.setLayoutParams(view_layout);
//
//                tr.addView(user_acc);
//                tr.addView(user_pwd);
//                user_list.addView(tr);
            }
        } catch(Exception e) {
            // Log.e("log_tag", e.toString());
        }

        final String[] json_list = {"u1", "u2", "u3", "u4", "u5"};
        String[] json_list2 = {"a1", "a2", "a3", "a4", "a5"};

        for(int i=0 ; i<json_list.length ; i++){
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("object", json_list[i]);
            item.put("image", json_list2[i]);

            arr_list.add(item);
        }

        mListView.setAdapter(new ViewAdapter(MainActivity.this, arr_list));

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, json_list[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void toast_user_name(View v){
        Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
    }

}
