package com.example.myapplication.Fragments;

import com.example.myapplication.Notifications.MyResponse;
import com.example.myapplication.Notifications.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAAzQmG_LE:APA91bEj1dvsWN5xeND2FHhvIEK5QZrx5wVL3mEBcciZ-GNddcazhAa3lb7AntZ2wS1OZRxMEkPvxzAZADywPRQooZlCh9r03csupcAi59tXu52A5vX6cFV29gBDBmr-o-Aeud6SerkW"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
