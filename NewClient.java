package pcn.action.sunichith.developer.firebasepushnotification.Retrofit;

import com.google.android.datatransport.runtime.dagger.Provides;

import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewClient {
    private static Retrofit retrofit=null;

  /*  public static Retrofit getClient(String url){

        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;
    }*/

    @Singleton
    @Provides
   public static OkHttpClient provideOkHttpClient(AuthInterceptor authInterceptor){
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(authInterceptor)
                .build();
        return client;
    }

    public static Retrofit getClientwithInterceptor(String url,OkHttpClient okHttpClient){
        if(retrofit==null){
            retrofit=new Retrofit.Builder().client(okHttpClient).baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }


    UpdateApi provideNoteApi(Retrofit retrofit){
          return  retrofit.create(UpdateApi.class);
    }

}
