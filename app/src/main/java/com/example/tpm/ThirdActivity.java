package com.example.tpm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {

     RecyclerView recyclerView;

     public static List<PDFModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

      recyclerView = findViewById(R.id.RV);

      list = new ArrayList<>();

      list.add(new PDFModel("PDF" , "https://www.tutorialspoint.com/android/android_tutorial.pdf"));

      recyclerView.setLayoutManager(new GridLayoutManager(this , 1));

      ItemClickListener itemClickListener = new ItemClickListener() {
          @Override
          public void onClick(View view, int position, boolean isLongClick) {

              Intent intent = new Intent(ThirdActivity.this , PDFActivity.class);

              intent.putExtra("position", position);

              startActivity(intent);
          }
      };

      PDFAdapter adapter = new PDFAdapter(list , ThirdActivity.this , itemClickListener);

      recyclerView.setAdapter(adapter);

    }
}