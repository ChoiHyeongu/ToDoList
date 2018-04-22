package a.choi.todolist;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();

    public ListViewAdapter(){

    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        final int pos  = position;
        final Context context = parent.getContext();

        if(convertView == null){
            LayoutInflater inflater  = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.plan_textview,parent,false );
        }

        EditText planView = (EditText) convertView.findViewById(R.id.editbox);

        ListViewItem listViewItem = listViewItemList.get(position);

        planView.setText(listViewItem.getPlan());

        return convertView;
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public Object getItem(int position){
        return listViewItemList.get(position);
    }

    public void addItem(String planStr, Drawable deleteImage){

        ListViewItem item = new ListViewItem();

        item.setPlan(planStr);

        listViewItemList.add(item);
    }
}
