package pcn.action.sunichith.developer.firebasepushnotification.Retrofit;


import pcn.action.sunichith.developer.firebasepushnotification.Retrofit.ModelClass.MainObj;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UpdateApi {

  //  @Headers({"Authorization: Bearer  ya29.c.c0AY_VpZjm4rtzdFam-nuRW9IejBBGwCsMLzDFQI18SIXyYBA3_0l4ebIM5py2Af0wakFJ7Xo8f8ESSsaCzqqUo9JZDv_7n3MKuQVtKj7umV9Rho7UFNR70t2FCELNQciIM-bWfZsEcBPoNDiv6wPG8EEx0fuyMRhDm-1mPEgB1HGrc_0z6eOg0pm6_8Q65NB8pHIXgruMy6DjsmdYiKNtQ-1NGa0AOd_k0qpKakZ_AmrJ09pXdxfMfXF3eUP7HY08a4zPs7jvhJR9c5bsKkxW2Z1hKE-9vqj6Gs2z5jwKiCBdk-i4f4Re8_KjZWFoW4AU3BlNquQA2nsVeRhu_juuBj9bKlBaxX0giPwJ1wG1OVc5yPZyU39t0ZB2E385K_3d7IYg2gUbm-omlY-gjV7Za95OjuRck6lz0iFzSXhO5lb5JfZcSFYpJ40F9MtUgqhMW2SiyRXVVg33xeOduFcwldpQSR3avZB1MewSWz2MsrQ_Yh6W0XMkz-BJlYOF1V-rhsk_4ZWOUVZ-mdlgms1BBdokx5h5w5rdzBnF5bOizbfMR-Fg0vnizi9Q38iO0-ekQ8nFpojBX5zV0jcU7g_oiue41Xx8tbmsUUJZYrnS1vutcity1t4eaWVRtU-3ylRyQMeBcaXx8YZlj7dOUFgygbjjnc3rhozg8IaWimeo-_Ot2Szk2x9JMpwxrtS4rSZwJ7h0rapn9RYqSMVRb2d_fbozrlfMYWnj1wjMps-9JpfkS0VBmkQ1_bonJBgB7_JZ79Wb725mh5sF6ol4zdRv4oOs-nR_leM9t3ak8Sd8J0rdcX539sFIoz8RnyZqqIpSVYYUsfYxo8XWRglB62kYUWw42Uec1VSz-iSVe4gbcl8vYdJ7m-9nzhqkrqmwjVOzi7IzlvSz9kXripVJUjZvR0-FORvgkVW1om1rX9Rx9ul7aFvUJRmy17IeIS_dMOS4lBu_Z1YpuaI0qQZhBF80pY6pfyFWchsqQQahj6tJcg2cxjixur38e5V",
  //          "Content-Type:application/json"})
    // @POST("https://fcm.googleapis.com/v1/projects/videoplayer-e7669/messages:send")
   // @POST("v1/projects/videoplayer-e7669/messages:send")

    @POST("videoplayer-e7669/messages:send")
    Call<MyResponse> sendNotification23(@Body MainObj body);

}
