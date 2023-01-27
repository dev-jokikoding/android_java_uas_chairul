package com.example.uaschairulfatihnasution2110031806049;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.uaschairulfatihnasution2110031806049.adapter.BarangAdapter;
import com.example.uaschairulfatihnasution2110031806049.api.ApiConnection;
import com.example.uaschairulfatihnasution2110031806049.api.ApiInterface;
import com.example.uaschairulfatihnasution2110031806049.model.Barang;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements BarangAdapter.OnBarangListener {

//    FloatingActionButton fabAdd;
    RecyclerView rvBarang;
    ArrayList<Barang> barangArrayList = new ArrayList<>();
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = ApiConnection.Connection().create(ApiInterface.class);

        rvBarang = findViewById(R.id.rv_barang);
//        fabAdd = findViewById(R.id.fab_add);
//
//        fabAdd.setOnClickListener(v -> {
//            Intent intent = new Intent(this, EntryActivity.class);
//            startActivity(intent);
//        });

        rvBarang.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_entry) {
            Intent intent = new Intent(this, EntryActivity.class);
            startActivity(intent);
        } else if(item.getItemId() == R.id.menu_exit) {
            finishAndRemoveTask();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        Call<List<Barang>> tampilBarang = apiInterface.listBarang();
        tampilBarang.enqueue(new Callback<List<Barang>>() {
            @Override
            public void onResponse(Call<List<Barang>> call, Response<List<Barang>> response) {
                barangArrayList = (ArrayList<Barang>) response.body();
                BarangAdapter barangAdapter = new BarangAdapter(barangArrayList, MainActivity.this);
                rvBarang.setAdapter(barangAdapter);
            }

            @Override
            public void onFailure(Call<List<Barang>> call, Throwable t) {
                // TODO
            }
        });
        super.onResume();
    }

    @Override
    public void onBarangListener(int position) {
        Toast.makeText(this, barangArrayList.get(position).getNama(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}