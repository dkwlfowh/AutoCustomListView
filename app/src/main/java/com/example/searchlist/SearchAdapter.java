package com.example.searchlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-08-07.
 */

public class SearchAdapter extends BaseAdapter {

   private ArrayList<ListVO>listVO = new ArrayList<ListVO>();
    private List<ListVO> list;
    private LayoutInflater inflate;
    private Context context;
    private  ViewHolder viewHolder;
    public SearchAdapter(List<ListVO> list,Context context){
        this.list=list;
        this.context=context;
        this.inflate=LayoutInflater.from(context);

    }
    @Override
    public int getCount() {
       return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
       final Context context = viewGroup.getContext();

        if(convertView == null){
            convertView = inflate.inflate(R.layout.row_listview,null);

            viewHolder = new ViewHolder();
            viewHolder.Name = (TextView) convertView.findViewById(R.id.Name);
            viewHolder.Mutual=(TextView)convertView.findViewById(R.id.Mutual);
            viewHolder.image=(ImageView)convertView.findViewById(R.id.img);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        // 리스트에 있는 데이터를 리스트뷰 셀에 뿌린다.
        viewHolder.Name.setText(list.get(position).getTitle());
        viewHolder.Mutual.setText(list.get(position).getContext());
        viewHolder.image.setImageDrawable(list.get(position).getImg());

        return convertView;
    }

    class ViewHolder{
        public TextView Name;
        public TextView Mutual;
        public ImageView image;
    }
}