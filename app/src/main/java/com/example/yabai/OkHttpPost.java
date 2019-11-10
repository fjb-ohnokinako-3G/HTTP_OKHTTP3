package com.example.yabai;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpPost extends AsyncTask<String,String,String> {

    //public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    String json = "{\"name\":\"名前\", \"taxis\":\"分類\"}";

    @Override
    protected String doInBackground(String... strings) {

        OkHttpClient client = new OkHttpClient();

        String url = "https://kinako.cf/api/pass_check.php";

        //Map<String, String> formParamMap = new HashMap<>();
        //formParamMap.put("word", "abc");
        final FormBody.Builder formBuilder = new FormBody.Builder();
        //formParamMap.forEach(formBuilder::add);
        formBuilder.add("word", "abc");
        RequestBody body = formBuilder.build();

        //RequestBody body = RequestBody.create(JSON, json);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String str) {
        Log.d("Debug",str);
    }
}