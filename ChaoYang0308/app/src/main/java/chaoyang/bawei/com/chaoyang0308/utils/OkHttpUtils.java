package chaoyang.bawei.com.chaoyang0308.utils;

import android.util.Log;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpUtils {
    private OkHttpUtils okHttpUtils;
    private HttpLoggingInterceptor loggingInterceptor;

    private OkHttpUtils okHttpUtils() {
        if (okHttpUtils != null) {
            synchronized (OkHttpUtils.class) {
                okHttpUtils = new OkHttpUtils();
            }
        }
        return okHttpUtils;
    }
    public static OkHttpClient okHttpClient=null;
    public static synchronized  OkHttpClient getOkHttpClient(){
        if (okHttpClient==null){
            HttpLoggingInterceptor loggingInterceptor= new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.i("xxx", "log: "+message);
                }
            });
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
             okHttpClient=new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request().newBuilder().addHeader("source", "android").build();
                            return chain.proceed(request);
                        }
                    })
                    .build();

        }

        return okHttpClient;
    }
    public void doGet(String url, Callback callback) {
        okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)

                .build();
        okHttpClient.newCall(request).enqueue(callback);
    }

    public void doPost(String url, Callback callback) {
        okHttpClient = new OkHttpClient();
        FormBody body = new FormBody.Builder()
                .build();
        Request request = new Request.Builder()
                .post(body)
                .url(url)
                .build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
