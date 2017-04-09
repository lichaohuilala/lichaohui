package bean;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.zhoukao1.R;

import java.util.List;

/**
 * Created by lichaohui on 2017/4/8.
 */

public class Myadpter extends BaseAdapter {
    List<User.ListBean> list;
    private Context mContext;

    public Myadpter(List<User.ListBean> list, Context context) {
        this.list = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            viewHolder=new ViewHolder();
        convertView=View.inflate(mContext, R.layout.layout_item,null);
            viewHolder.mTextView= (TextView) convertView.findViewById(R.id.textView);
            viewHolder.text= (TextView) convertView.findViewById(R.id.textView2);
            convertView.setTag(viewHolder);
    }else {
            viewHolder  = (ViewHolder) convertView.getTag();
        }
        viewHolder.text.setText(list.get(position).getAddress());
        viewHolder.mTextView.setText(list.get(position).getEndTimeForWork());
        return convertView;
    }
    class  ViewHolder{
        TextView mTextView,text;
    }
}
