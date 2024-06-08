package pcn.action.sunichith.developer.firebasepushnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

import pcn.action.sunichith.developer.firebasepushnotification.Retrofit.AuthInterceptor;
import pcn.action.sunichith.developer.firebasepushnotification.Retrofit.ModelClass.MainObj;
import pcn.action.sunichith.developer.firebasepushnotification.Retrofit.ModelClass.MessageObject;
import pcn.action.sunichith.developer.firebasepushnotification.Retrofit.ModelClass.NotificationObj;
import pcn.action.sunichith.developer.firebasepushnotification.Retrofit.MyResponse;
import pcn.action.sunichith.developer.firebasepushnotification.Retrofit.NewClient;
import pcn.action.sunichith.developer.firebasepushnotification.Retrofit.UpdateApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String TAG="MainActivity";
    Button sendNotification;
    String token;

    UpdateApi updateApi;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(MainActivity.this);
        setContentView(R.layout.activity_main);

        java.util.concurrent.ExecutorService service= Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                updateApi= NewClient.getClientwithInterceptor("https://fcm.googleapis.com/v1/projects/",NewClient.provideOkHttpClient(new AuthInterceptor())).create(UpdateApi.class);
            }
        });

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.TIRAMISU)
        {
            if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.POST_NOTIFICATIONS)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{android.Manifest.permission.POST_NOTIFICATIONS},101);
            }
        }


        sendNotification=findViewById(R.id.sendnotification_btn);
        sendNotification.setOnClickListener(this);

        FirebaseMessaging.getInstance().setAutoInitEnabled(true);
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@androidx.annotation.NonNull Task<String> task) {
                if (!task.isSuccessful()) {
                    Log.w("main send noti", "getInstanceId failed", task.getException());
                    return;
                }
                // Get new FCM registration token
                token = task.getResult();
            }
        });


        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sendnotification_btn:
                //here we send Notification using Volley
              //  SendNotifications();

                //here we send Notification using Retrofit
                SendNotificationsusingRetrofit();
                break;
            default:
                break;
        }
    }

    private void SendNotificationsusingRetrofit() {
        NotificationObj notificationObj=new NotificationObj("Sunischit Developers","97876876");
        MessageObject messageObject=new MessageObject(token,notificationObj);
        MainObj mainObj=new MainObj(messageObject);
        updateApi.sendNotification23(mainObj).enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                Log.e(TAG,response.toString());
                if (response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "sended", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Not Sended", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {
                Log.e(TAG,t.getMessage());
                Toast.makeText(MainActivity.this, t.toString()+"failure in sending Notification", Toast.LENGTH_SHORT).show();

            }
        });

    }


    public void SendNotifications(){

        String postUrl= "https://fcm.googleapis.com/v1/projects/videoplayer-e7669/messages:send";

        String userFcmToken=token;
        String title="Hitesh ";
        String body="Sunichith Developer ";

        RequestQueue requestQueue= Volley.newRequestQueue(MainActivity.this);
        JSONObject mainObj=new JSONObject();
        try {
            JSONObject messageObject=new  JSONObject ();
            JSONObject notificationObject=new JSONObject();
            notificationObject.put("title",title);
            notificationObject.put("body",body);
            messageObject.put("token",userFcmToken);
            messageObject.put("notification",notificationObject);
            mainObj.put("message",messageObject);
            JsonObjectRequest request=new JsonObjectRequest(Request.Method.POST,postUrl,mainObj, response -> {
                Toast.makeText(MainActivity.this, "sended", Toast.LENGTH_SHORT).show();
            },volleyError->{
                Toast.makeText(MainActivity.this, "on error", Toast.LENGTH_SHORT).show();
            }){
                @NonNull
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Accesstoken accesstoken=new Accesstoken();
                    String accesskey= accesstoken.getAccessToken();

                    if (accesskey!=null){
                        Log.e(TAG,accesskey);
                    }else {
                        Log.e(TAG,"failed");
                    }
                    Map<String,String> header=new HashMap<>();
                    header.put("content-Type","application/json");
                    header.put("authorization","Bearer " + accesskey );
                    return header;
                }
            };
            requestQueue.add(request);
        } catch (JSONException e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}