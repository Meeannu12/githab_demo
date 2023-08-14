package com.example.api_intigration;




import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API_Interface {  //https://sky11.news/wp-json/wp/v2/posts

   @GET("wp-json/wp/v2/posts")
   Call<List<Example>> getModel();
}
