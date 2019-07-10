package com.ipda3.newsofraapp.data.rest;


import com.ipda3.newsofraapp.data.model.categories.Categories;
import com.ipda3.newsofraapp.data.model.cities.Cities;
import com.ipda3.newsofraapp.data.model.clientRegister.ClientRegister;
import com.ipda3.newsofraapp.data.model.contactUs.ContactUs;
import com.ipda3.newsofraapp.data.model.listOfRestaurants.ListOfRestaurants;
import com.ipda3.newsofraapp.data.model.offers.Offers;
import com.ipda3.newsofraapp.data.model.order.Order;
import com.ipda3.newsofraapp.data.model.regions.Regions;
import com.ipda3.newsofraapp.data.model.resetPassword.ResetPassword;
import com.ipda3.newsofraapp.data.model.restaurantDetails.RestaurantDetails;
import com.ipda3.newsofraapp.data.model.restaurantItems.RestaurantItems;
import com.ipda3.newsofraapp.data.model.restaurantLogin.RestaurantLogin;
import com.ipda3.newsofraapp.data.model.restaurantRegister.RestaurantRegister;
import com.ipda3.newsofraapp.data.model.restaurantReviews.RestaurantReviews;
import com.ipda3.newsofraapp.data.model.userLogin.UserLogin;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiServices {

    @POST("client/login")
    @FormUrlEncoded
    Call<UserLogin> sendUserLoginRequest(@Field("email") String email,
                                         @Field("password") String password);

    @POST("client/register")
    @FormUrlEncoded
    Call<ClientRegister> addClientRegister(@Field("name") String name,
                                           @Field("email") String email,
                                           @Field("password") String password,
                                           @Field("password_confirmation") String password_confirmation,
                                           @Field("phone") String phone,
                                           @Field("address") String address,
                                           @Field("region_id") int region_id);

    @POST("restaurant/login")
    @FormUrlEncoded
    Call<RestaurantLogin> sendRestaurantLoginRequest(@Field("email") String email,
                                                     @Field("password") String password);

    @Multipart
    @POST("restaurant/register")
    Call<RestaurantRegister> addRestaurantRegister(@Part("name") RequestBody name,
                                                   @Part("email") RequestBody email,
                                                   @Part("password") RequestBody password,
                                                   @Part("password_confirmation") RequestBody password_confirmation,
                                                   @Part("phone") RequestBody phone,
                                                   @Part("whatsapp") RequestBody whatsapp,
                                                   @Part("region_id") RequestBody region_id,
                                                   @Part("categories[]") List<RequestBody> categories,
                                                   @Part("delivery_cost") RequestBody delivery_cost,
                                                   @Part("minimum_charger") RequestBody minimum_charger,
                                                   @Part MultipartBody.Part File,
                                                   @Part("availability") RequestBody availability);

    @POST("client/reset-password")
    @FormUrlEncoded
    Call<ResetPassword> sendResetPasswordRequest(@Field("email") String email);

    @GET("cities")
    Call<Cities> getCities();

    @GET("regions")
    Call<Regions> getRegions(@Query("city_id") int city_id);

    @GET("categories")
    Call<Categories> getCategories();

    @GET("restaurants")
    Call<ListOfRestaurants> getRestaurants(@Query("page") Integer page);

    @GET("restaurant")
    Call<RestaurantDetails> getRestaurantDetails(@Query("restaurant_id") int restaurant_id);

    @GET("items")
    Call<RestaurantItems> getRestaurantItems(@Query("restaurant_id") int restaurant_id,
                                             @Query("page") int page);

    @GET("restaurant/reviews")
    Call<RestaurantReviews> getRestaurantReviews(@Query("api_token") String api_token,
                                                 @Query("restaurant_id") int restaurant_id,
                                                 @Query("page") int page);

    @GET("client/my-orders")
    Call<Order> getOrder(@Query("api_token") String api_token,
                         @Query("state") String state,
                         @Query("page") int page);

    @GET("offers")
    Call<Offers> getOffers(@Query("page") int page);

    @POST("contact")
    @FormUrlEncoded
    Call<ContactUs> addContact(@Field("name") String name,
                               @Field("email") String email,
                               @Field("phone") String phone,
                               @Field("type") String type,
                               @Field("content") String content);

}
