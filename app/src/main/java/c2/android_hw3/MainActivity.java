package c2.android_hw3;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.list);
        mListView.setAdapter(new ViewAdapter());
    }

    public class ViewAdapter extends BaseAdapter {

        //取得數量
        @Override
        public int getCount() {
            return 3;
        }
        //取得Item
        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            Holder holder;
            if(v == null){
                v = getLayoutInflater().inflate(R.layout.adapter, null);
                holder = new Holder();
                holder.image = (ImageView) v.findViewById(R.id.image);
                holder.text = (TextView) v.findViewById(R.id.name);

                v.setTag(holder);
            }
            else{
                holder = (Holder) v.getTag();
            }
            switch(position) {
                case 0:
                    holder.image.setImageResource(R.drawable.a1);
                    holder.text.setText("cat");
                    break;
                case 1:
                    holder.image.setImageResource(R.drawable.a2);
                    holder.text.setText("monkey");
                    break;
                case 2:
                    holder.image.setImageResource(R.drawable.a3);
                    holder.text.setText("panda");
                    break;
            }
            return v;
        }

        class Holder{
            ImageView image;
            TextView text;
        }
    }
}
