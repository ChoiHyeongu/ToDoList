package a.choi.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewBtnAdapter extends ArrayAdapter implements View.OnClickListener {

    public interface ListBtnClickListener {
        void onListBtnClick(int position);
    }

    // 생성자로부터 전달된 resource id 값을 저장.
    int resourceId;
    // 생성자로부터 전달된 ListBtnClickListener  저장.
    private ListBtnClickListener listBtnClickListener;


    // ListViewBtnAdapter 생성자. 마지막에 ListBtnClickListener 추가.
    ListViewBtnAdapter(Context context, int resource, ArrayList<ListViewBtnItem> list, ListBtnClickListener clickListener) {
        super(context, resource, list);

        // resource id 값 복사. (super로 전달된 resource를 참조할 방법이 없음.)
        this.resourceId = resource;

        this.listBtnClickListener = clickListener;
    }

    // 새롭게 만든 Layout을 위한 View를 생성하는 코드
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // 생성자로부터 저장된 resourceId(listview_btn_item)에 해당하는 Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(this.resourceId/*R.layout.listview_btn_item*/, parent, false);
        }


        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        final ListViewBtnItem listViewItem = (ListViewBtnItem) getItem(position);

        return convertView;
    }

    @Override
    public void onClick(View v){

    }
}