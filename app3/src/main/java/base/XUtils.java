package base;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import xlistview.bawei.com.xlistviewlibrary.XListView;

/**
 * Created by lichaohui on 2017/4/10.
 */

public class XUtils {
    public  void    addutis(String src, String pj , final XListView mXlistview, final Context context){

        RequestParams params = new RequestParams(src);
        params.addQueryStringParameter("uri",pj);
        x.http().get(params, new Callback.CommonCallback<String>() {


            @Override
            public void onSuccess(String result) {
                Gson g=new Gson();
                User user = g.fromJson(result, User.class);
                List<User.ResultBean.DataBean> data = user.getResult().getData();

                Mylistadapter mylistadapter = new Mylistadapter(context,data);
                mXlistview.setAdapter(mylistadapter);
                Log.d("zzz",result);
            }
            //请求异常后的回调方法
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }
            //主动调用取消请求的回调方法
            @Override
            public void onCancelled(CancelledException cex) {
            }
            @Override
            public void onFinished() {
            }
        });

    }


}
