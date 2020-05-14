package com.rkdroidlabs.kcetagritest;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class BloggerAPI {

    private static final String key = "AIzaSyDG_7eYA8Cg9fwKJdvj3yUkK25_nd0YTH4";
    private static final String url = "https://www.googleapis.com/blogger/v3/blogs/2776836406430670191/posts/";

    public static PostService postService = null;
    public static PostService getService()
    {
        if (postService == null)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            postService = retrofit.create(PostService.class);
        }
        return postService;
    }

    public interface PostService
    {
        @GET ("?key="+key)
        Call<PostList> getPostList();
    }
}
