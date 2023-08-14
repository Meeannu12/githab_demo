package com.example.api_intigration;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass {
    private static Retrofit retrofit;
    //    private static final String BASEURL = "https://jsonplaceholder.typicode.com/";
    private static final String BASEURL = "https://sky11.news/";//https://reqres.in/api/users?page=2

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit =new Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
