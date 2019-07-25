package c2.android_hw3;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

public class ViewAdapter extends BaseAdapter {

    private LayoutInflater mLayInf;
    List<Map<String, Object>> mItemList;
    public ViewAdapter(Context context,  List<Map<String, Object>> itemList)
    {
        mLayInf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mItemList = itemList;
    }

    @Override
    public int getCount()
    {
        //取得 ListView 列表 Item 的數量
        return mItemList.size();
    }

    @Override
    public Object getItem(int position)
    {
        //取得 ListView 列表於 position 位置上的 Item
        return position;
    }

    @Override
    public long getItemId(int position)
    {
        //取得 ListView 列表於 position 位置上的 Item 的 ID
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        //設定與回傳 convertView 作為顯示在這個 position 位置的 Item 的 View。
        View v = mLayInf.inflate(R.layout.adapter, parent, false);

        ImageView imgView = (ImageView) v.findViewById(R.id.image);
        TextView txtView = (TextView) v.findViewById(R.id.name);

        Context context = imgView.getContext();

        int resId = context.getResources()
                .getIdentifier(
                        mItemList.get(position).get("image").toString()
                        ,"drawable"
                        ,context.getPackageName());

        imgView.setImageResource(resId);
        txtView.setText(mItemList.get(position).get("object").toString());

        return v;
    }

}



