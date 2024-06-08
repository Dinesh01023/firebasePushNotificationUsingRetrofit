package pcn.action.sunichith.developer.firebasepushnotification.Retrofit;

import android.util.Log;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import pcn.action.sunichith.developer.firebasepushnotification.Accesstoken;

public class AuthInterceptor implements Interceptor {


    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
       Request.Builder request= chain.request().newBuilder();
        Accesstoken accesstoken=new Accesstoken();
        String accesskey= accesstoken.getAccessToken();
        Log.e("ACCESSkEY",accesskey);

        request.addHeader("authorization","Bearer " + accesskey );
        request.addHeader("content-Type","application/json");

        return chain.proceed(request.build());
    }

}
