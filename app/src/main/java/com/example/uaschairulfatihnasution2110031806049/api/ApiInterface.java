package com.example.uaschairulfatihnasution2110031806049.api;

import com.example.uaschairulfatihnasution2110031806049.model.Barang;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("uas049/")
    Call<List<Barang>> listBarang();

    @FormUrlEncoded
    @POST("uas049/")
    Call<Barang> simpanBarang(
            @Field("nama") String nama,
            @Field("alamat") String alamat,
            @Field("no_penjual") String no_penjual,
            @Field("kode_barang") String kode_barang,
            @Field("jumlah_penjualan") String jumlah_penjualan,
            @Field("harga_satuan") String harga_satuan,
            @Field("diskon") String diskon,
            @Field("total_harga") String total_harga
    );

    @PUT("uas049/")
    Call<Barang> editBarang(
            @Query("id") String id,
            @Query("nama") String nama,
            @Query("alamat") String alamat,
            @Query("no_penjual") String no_penjual,
            @Query("kode_barang") String kode_barang,
            @Query("jumlah_penjualan") String jumlah_penjualan,
            @Query("harga_satuan") String harga_satuan,
            @Query("diskon") String diskon,
            @Query("total_harga") String total_harga
    );

    @DELETE("uas049/")
    Call<Barang> deleteBarang(
            @Query("id") String id
    );
}
