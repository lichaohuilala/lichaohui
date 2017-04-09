package com.example.zhoukao1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import bean.Myadpter;
import bean.User;

public class MainActivity extends AppCompatActivity {

    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        listview = (ListView) findViewById(R.id.listview);
        mystype mystype = new mystype();
    mystype.execute("http://result.eolinker.com/KLn5hSP9f6fed196f92ec0148255a48aebb2c6cc5f97f0e?uri=user");
    }


    class  mystype extends AsyncTask<String ,Integer ,String>{

        private Myadpter mMyadpter;

        @Override
        protected String doInBackground(String... params) {

                StringBuffer sb=new StringBuffer();
                try {
                    URL url=new URL(params[0]);
                    HttpURLConnection conn= (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(3000);
                    if(conn.getResponseCode()==200){
                        InputStream inputStream = conn.getInputStream();
                        BufferedReader br=new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
                        String line=null;
                        while((line=br.readLine())!=null){
                            sb.append(line);
                        }
                    }
                    Log.d("zzz",sb.toString()+"zzz");
                    return sb.toString();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson=new Gson();
            User user = gson.fromJson(s, User.class);
            final List<User.ListBean> list = user.getList();
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(MainActivity.this,""+list.get(position).getId(),Toast.LENGTH_SHORT).show();

                }
            });
            listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    list.remove(position);
                        mMyadpter.notifyDataSetChanged();
                    return false;
                }
            });
            mMyadpter = new Myadpter(list, MainActivity.this);
            listview.setAdapter(mMyadpter);


        }


    }}
