package com.example.mysofra.data.api;


import android.widget.ScrollView;

import com.example.mysofra.data.model.changPasswordClient.ChangPasswordClient;
import com.example.mysofra.data.model.changPasswordRestaurant.ChangPasswordRestaurant;
import com.example.mysofra.data.model.city.City;
import com.example.mysofra.data.model.cityAndRegion.CitiesAndRegion;
import com.example.mysofra.data.model.clientAddCommit.ClientAddCommit;
import com.example.mysofra.data.model.clientConfirmOreder.ClientConfirmOreder;
import com.example.mysofra.data.model.clientDeclineOreder.ClientDeclineOreder;
import com.example.mysofra.data.model.clientModel.clientMyOrder.ClientMyOrder;
import com.example.mysofra.data.model.clientNewOrder.ClientNewOrder;
import com.example.mysofra.data.model.clientNotification.ClientNotification;
import com.example.mysofra.data.model.clientOfferDetails.ClientOfferDetails;
import com.example.mysofra.data.model.clientOffers.ClientOffers;
import com.example.mysofra.data.model.clientOrderById.ClientOrderById;
import com.example.mysofra.data.model.clientRegister.ClientRegister;
import com.example.mysofra.data.model.clientlogin.Clientlogin;

import com.example.mysofra.data.model.contactWithUs.ContactWithUs;
import com.example.mysofra.data.model.contactWithUs.ContactWithUsData;
import com.example.mysofra.data.model.creatNewPassword.CreatNewPassword;
import com.example.mysofra.data.model.editProfileClient.EditProfileClient;
import com.example.mysofra.data.model.listOfRestaurants.ListOfRestaurants;
import com.example.mysofra.data.model.regionByCityId.RegionByCityId;
import com.example.mysofra.data.model.resetPassword.ResetPassword;
import com.example.mysofra.data.model.restaurantAcceptOreder.RestaurantAcceptOreder;
import com.example.mysofra.data.model.restaurantCommissions.RestaurantCommissions;
import com.example.mysofra.data.model.restaurantConfiremOreder.RestaurantConfirmDeliveryOreder;
import com.example.mysofra.data.model.restaurantDeleteCategory.RestaurantDeleteCategory;
import com.example.mysofra.data.model.restaurantDeleteItem.RestauranDeleteItem;
import com.example.mysofra.data.model.restaurantDeleteOffer.RestauranDeleteOffer;
import com.example.mysofra.data.model.restaurantEditProfile.RestaurantEditProfile;
import com.example.mysofra.data.model.restaurantMYCategories.RestaurantMYCategories;
import com.example.mysofra.data.model.restaurantMyItem.RestaurantMyItem;
import com.example.mysofra.data.model.restaurantMyOffer.RestaurantMyOffer;
import com.example.mysofra.data.model.restaurantNewCategory.RestauranNewCategory;
import com.example.mysofra.data.model.restaurantNewItem.RestaurantNewItem;
import com.example.mysofra.data.model.restaurantNewOffer.RestauranNewOffer;
import com.example.mysofra.data.model.restaurantNewOrder.RestaurantNewOrder;
import com.example.mysofra.data.model.restaurantNotification.RestaurantNotification;
import com.example.mysofra.data.model.restaurantRejectOreder.RestaurantRejectOreder;
import com.example.mysofra.data.model.restaurantUpdateCategory.RestaurantUpdateCategory;
import com.example.mysofra.data.model.restaurantUpdateItem.RestaurantUdateItem;
import com.example.mysofra.data.model.restaurantUpdateOffer.RestauranUpdateOffer;
import com.example.mysofra.data.model.restaurantsWithFiltre.RestaurantsWithFiltre;
import com.example.mysofra.data.model.restaurntCategories.RestaurntCategories;
import com.example.mysofra.data.model.restaurntDetails.RestaurntDetails;
import com.example.mysofra.data.model.restaurntItem.RestaurntItem;
import com.example.mysofra.data.model.restaurntLogin.RestaurntLogin;
import com.example.mysofra.data.model.restaurntRegister.RestaurntRegister;
import com.example.mysofra.data.model.restaurntreviewe.RestaurntReviewe;

import java.util.Date;
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
import retrofit2.http.Url;

public interface ApiService {
    @POST("client/login")
    @FormUrlEncoded
    Call<Clientlogin> getUserLogin(@Field("email") String email,
                                   @Field("password") String password);

    @POST("client/sign-up")
    @Multipart
    Call<ClientRegister> registerUser(@Part("name") RequestBody name,
                                      @Part("email")RequestBody email,
                                      @Part("password") RequestBody password,
                                      @Part("password_confirmation") RequestBody password_confirmation,
                                      @Part("phone") RequestBody phone,
                                      @Part("region_id") RequestBody regionId,
                                      @Part MultipartBody.Part profileImage);

    @GET("cities")
    Call<City> getCity();

    @GET("regions")
    Call<RegionByCityId> getRegionByCityId(@Query("city_id") int city_id);

    @POST("client/reset-password")
    @FormUrlEncoded
    Call<ResetPassword> resetPassword(@Field("email") String email);


    @POST("client/new-password")
    @FormUrlEncoded
    Call<CreatNewPassword> getNewPassword(@Field("code") String code,
                                          @Field("password") String password,
                                          @Field("password_confirmation") String password_confirmation);
    @POST("restaurant/reset-password")
    @FormUrlEncoded
    Call<ResetPassword> restaurantresetPassword(@Field("email") String email);


    @POST("restaurant/new-password")
    @FormUrlEncoded
    Call<CreatNewPassword> getNewPasswordRestaurant(@Field("code") String code,
                                          @Field("password") String password,
                                          @Field("password_confirmation") String password_confirmation);

    @POST("restaurant/sign-up")
    @FormUrlEncoded
    Call<RestaurntRegister> registerRestaurant(@Part("name") RequestBody name,
                                               @Part("email") RequestBody email,
                                               @Part("password") RequestBody password,
                                               @Part("password_confirmation") RequestBody password_confirmation,
                                               @Part("phone") RequestBody phone,
                                               @Part("whatsapp") RequestBody whatsapp,
                                               @Part("region_id") RequestBody regionId,
                                               @Part("delivery_cost") RequestBody deliveryCost,
                                               @Part("minimum_charger") RequestBody minimumCharger,
                                               @Part MultipartBody.Part  resProfileImage,
                                               @Part("delivery_time") RequestBody delivery_time);


    @POST("restaurant/login")
    @FormUrlEncoded
    Call<RestaurntLogin> restaurantLogin(@Field("email") String email,
                                         @Field("password") String password);

    @GET("restaurants")
    Call<ListOfRestaurants> getRestaurants(@Query("page") int page);

    @GET("restaurants")
    Call<RestaurantsWithFiltre> getRestaurantsWithfilter(@Query("keyword") String keyword,
                                                         @Query("region_id") String region_id);

    @GET("categories")
    Call<RestaurntCategories> getRestaurantCategories(@Query("restaurant_id") int restaurant_id);

    @GET("items")
    Call<RestaurntItem> getRestaurantsItems(@Query("restaurant_id") int restaurant_id,
                                            @Query("category_id") int category_id,
                                            @Query("page") int page);

    @GET("restaurant")
    Call<RestaurntDetails> getRestaurntDetails(@Query("restaurant_id") int restaurant_id);

    @GET("restaurant/reviews")
    Call<RestaurntReviewe> getRestaurnReviews(@Query("restaurant_id") int restaurant_id,
                                              @Query("page") int page);

    @GET("client/my-orders")
    Call<ClientMyOrder> getMyOredrClient(@Query("api_token") String api_token,
                                         @Query("state") String state,
                                         @Query("page") int page);

    @POST("contact")
    @FormUrlEncoded
    Call<ContactWithUs> contactUs(@Field("name") String name,
                                  @Field("email") String email,
                                  @Field("phone") String phone,
                                  @Field("type") String type,
                                  @Field("content") String content);


    @GET("restaurant/my-categories")
    Call<RestaurantMYCategories> getMyCategoriesRestauratn(@Query("api_token") String api_token,
                                                           @Query("page") int page);

    @GET("restaurant/my-orders")
    Call<RestaurantNewOrder> getMyOredrRestaurant(@Query("api_token") String api_token,
                                                  @Query("state") String state,
                                                  @Query("page") int page);

    @POST("client/decline-order")
    @FormUrlEncoded
    Call<ClientDeclineOreder> declineOrderClient(@Field("order_id") int order_id,
                                                 @Field("api_token") String api_token);

    @POST("client/confirm-order")
    @FormUrlEncoded
    Call<ClientConfirmOreder> confirmOrderClient(@Field("order_id") int order_id,
                                                 @Field("api_token") String api_token);

    @POST("restaurant/accept-order")
    @FormUrlEncoded
    Call<RestaurantAcceptOreder> acceptOrederRestaurant(@Field("api_token") String api_token,
                                                        @Field("order_id") int order_id);

    @POST("restaurant/reject-order")
    @FormUrlEncoded
    Call<RestaurantRejectOreder> rejectOrederRestaurant(@Field("api_token") String api_token,
                                                        @Field("order_id") int order_id,
                                                        @Field("refuse_reason") String refuse_reason);

    @POST("restaurant/confirm-order")
    @FormUrlEncoded
    Call<RestaurantConfirmDeliveryOreder> confirmOrderDeliveryRestaurant(@Field("order_id") int order_id,
                                                                         @Field("api_token") String api_token);

    @POST("restaurant/new-category")
    @Multipart
    Call<RestauranNewCategory> newCategoryRestaurnt(@Part("name") RequestBody name,
                                                    @Part MultipartBody.Part photo,
                                                    @Part("api_token") RequestBody api_token);

    @POST("restaurant/update-category")
    @FormUrlEncoded
    Call<RestaurantUpdateCategory> updateCategoryRestaurnt(@Field("name") String name,
                                                           @Field("photo") String photo,
                                                           @Field("api_token") String api_token,
                                                           @Field("category_id") int category_id);

    @POST("restaurant/delete-category")
    @FormUrlEncoded
    Call<RestaurantDeleteCategory> deleteCategoryRestaurant(@Field("api_token") String api_token,
                                                            @Field("category_id") int category_id);

    @POST("restaurant/new-offer")
    @Multipart
    Call<RestauranNewOffer> newOfferRestaurant(@Part("description") RequestBody description,
                                               @Part("price") RequestBody price,
                                               @Part("starting_at") RequestBody starting_at,
                                               @Part("name") RequestBody name,
                                               @Part MultipartBody.Part newOfferPhoto,
                                               @Part("ending_at") RequestBody ending_at,
                                               @Part("api_token") RequestBody api_token,
                                               @Part("offer_price") RequestBody offer_price);

    @POST("restaurant/update-offer")
    @FormUrlEncoded
    Call<RestauranUpdateOffer> updateOfferRestaurant(@Field("description") String description,
                                                     @Field("price") String price,
                                                     @Field("starting_at") String starting_at,
                                                     @Field("name") String name,
                                                     @Field("photo") String photo,
                                                     @Field("ending_at") String ending_at,
                                                     @Field("offer_id") int offer_id,
                                                     @Field("api_token") String api_token);

    @POST("restaurant/delete-offer")
    @FormUrlEncoded
    Call<RestauranDeleteOffer> deleteOfferRestaurant(@Field("offer_id") int offer_id,
                                                     @Field("api_token") String api_token);

    @POST("restaurant/profile")
    @FormUrlEncoded
    Call<RestaurantEditProfile> eidtProfileRestaurant(@Field("email") String email,
                                                      @Field("name") String name,
                                                      @Field("phone") String phone,
                                                      @Field("region_id") String regionId,
                                                      @Field("delivery_cost") String deliveryCost,
                                                      @Field("minimum_charger") String minimumCharger,
                                                      @Field("availability") String availability,
                                                      @Field("photo") String photo,
                                                      @Field("api_token") String api_token,
                                                      @Field("delivery_time") String delivery_time,
                                                      @Field("whatsapp") String whatsapp);

    @POST("client/change-password")
    @FormUrlEncoded
    Call<ChangPasswordClient> changPasswordClient(@Field("api_token") String api_token,
                                                  @Field("old_password") String old_password,
                                                  @Field("password") String password,
                                                  @Field("password_confirmation") String password_confirmation);


    @POST("restaurant/change-password")
    @FormUrlEncoded
    Call<ChangPasswordRestaurant> changPasswordCRestaurant(@Field("api_token") String api_token,
                                                           @Field("old_password") String old_password,
                                                           @Field("password") String password,
                                                           @Field("password_confirmation") String password_confirmation);

    @POST("client/profile")
    @FormUrlEncoded
    Call<EditProfileClient> eidtProfileClient(@Field("api_token") String api_token,
                                              @Field("name") String name,
                                              @Field("phone") String phone,
                                              @Field("email") String email,
                                              @Field("region_id") String regionId,
                                              @Field("profile_image") String profileImage);

    @GET("client/notifications")
    Call<ClientNotification> getNotificationClient(@Query("api_token") String api_token,
                                                   @Query("page") int page);

    @GET("restaurant/my-offers")
    Call<RestaurantMyOffer> getMyOfferRestaurant(@Query("api_token") String api_token,
                                                 @Query("page") int page);

    @GET("restaurant/my-items")
    Call<RestaurantMyItem> getMyItemRestaurant(@Query("api_token") String api_token,
                                               @Query("category_id") int category_id,
                                               @Query("page") int page);

    @POST("restaurant/delete-item")
    @FormUrlEncoded
    Call<RestauranDeleteItem> deleteItemRestaurant(@Field("item_id") int item_id,
                                                   @Field("api_token") String api_token);

    @POST("restaurant/new-item")
    @Multipart
    Call<RestaurantNewItem> newItemRestaurant(@Part("description") RequestBody description,
                                              @Part("price") RequestBody price,
                                              @Part("name") RequestBody name,
                                              @Part MultipartBody.Part newItemPhoto,
                                              @Part("api_token") RequestBody api_token,
                                              @Part("offer_price") RequestBody offer_price,
                                              @Part("category_id") RequestBody category_id);

    @POST("restaurant/update-item")
    @FormUrlEncoded
    Call<RestaurantUdateItem> updateItemRestaurant(@Field("description") String description,
                                                   @Field("price") String price,
                                                   @Field("name") String name,
                                                   @Field("photo") String photo,
                                                   @Field("item_id") int item_id,
                                                   @Field("api_token") String api_token,
                                                   @Field("offer_price") String offer_price,
                                                   @Field("category_id") int category_id);

    @GET("restaurant/notifications")
    Call<RestaurantNotification> getNotificationRestaurant(@Query("api_token") String api_token,
                                                           @Query("page") int page);

    @GET("offer")
    Call<ClientOfferDetails> getOfferDetailsClient(@Query("offer_id") int offer_id);

    @GET("offers")
    Call<ClientOffers> getOffersClient(@Query("page") int page);

    @POST("client/new-order")
    @FormUrlEncoded
    Call<ClientNewOrder> newOrderClient(@Field("restaurant_id") int restaurant_id,
                                        @Field("note") String note,
                                        @Field("address") String address,
                                        @Field("payment_method_id") int payment_method_id,
                                        @Field("phone") String phone,
                                        @Field("name") String name,
                                        @Field("api_token") String api_token,
                                        @Field("items[]") List<Integer> items,
                                        @Field("quantities[]") List<Integer> quantities,
                                        @Field("notes[]") List<String> notes);

    @POST("client/restaurant/review")
    @FormUrlEncoded
    Call<ClientAddCommit> addCommit(@Field("rate") int rate,
                                    @Field("comment") String comment,
                                    @Field("restaurant_id") int restaurant_id,
                                    @Field("api_token") String api_token);


    @GET("restaurant/commissions")
    Call<RestaurantCommissions> getCommissions(@Query("api_token") String api_token);

    @GET("cities-not-paginated")
    Call<CitiesAndRegion> getCity1();

    @GET("regions-not-paginated")
    Call<CitiesAndRegion> getRegoin(@Query("city_id") int city_id);

    @GET("client/show-order")
    Call<ClientOrderById>getClientOrderById(@Query("api_token") String api_token,
                                            @Query("order_id") int order_id);
}
