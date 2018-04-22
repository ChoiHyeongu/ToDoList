package a.choi.todolist;

import android.graphics.drawable.Drawable;

public class ListViewItem {

    private String planStr;

    public void setPlan(String plan){
        planStr = plan;
    }

    public String getPlan(){
        return this.planStr;
    }
}
