package com.example.l3a1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Button btnSheet;
    BottomNavigationView bottomNavigationView;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSheet = findViewById(R.id.btn_sheet);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        imageView = findViewById(R.id.image_capture);

        FragmentManager manager = getSupportFragmentManager();

        manager.beginTransaction().replace(R.id.contayner_main, HomeFrogment.newInstance("value 2", "value3")).commit();
        btnSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog dialog = new BottomSheetDialog();
                View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_bottom_sheet,(LinearLayout)findViewById(R.id.bottom_sheet_contayner));
                dialog.show(getSupportFragmentManager(),"data");

            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.item_home:
                        break;

                    case R.id.item_camera:
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent,100);


                        break;

                    case R.id.item_profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.contayner_main,new ProfileFragment()).commit();
                }
                return false;
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        }
    }

}