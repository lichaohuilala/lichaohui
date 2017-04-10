package base;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;


/**
 * Created by lichaohui on 2017/4/10.
 */

public class Myapp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        initimagerLoader();

        x.Ext.init(this);
        x.Ext.setDebug(false);
    }

    private  void initimagerLoader(){

        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(getApplicationContext()).memoryCacheExtraOptions(480,800).build();
        ImageLoader.getInstance().init(configuration);

    }
}

