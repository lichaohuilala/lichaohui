package base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app3.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by lichaohui on 2017/4/10.
 */

public class Mylistadapter extends BaseAdapter {
     private   List<User.ResultBean.DataBean> data;
    private Context mContext;
    public Mylistadapter(Context context, List<User.ResultBean.DataBean> data) {
        mContext = context;
        this.data = data;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
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
        convertView=View.inflate(mContext, R.layout.item,null);
        viewHolder.texttitle= (TextView) convertView.findViewById(R.id.textView);
        viewHolder.textContent= (TextView) convertView.findViewById(R.id.textView2);
        viewHolder.mImageView= (ImageView) convertView.findViewById(R.id.imageView);
        convertView.setTag(viewHolder);
    }else {
        viewHolder = (ViewHolder) convertView.getTag();
    }
        viewHolder.texttitle.setText(data.get(position).getTitle());
        viewHolder.textContent.setText(data.get(position).getCategory());
        ImageLoader.getInstance().displayImage(data.get(position).getThumbnail_pic_s02(),viewHolder.mImageView);

        return convertView;
    }
    class  ViewHolder{
        TextView texttitle,textContent;
        ImageView mImageView;
    }
}
