package edu.sjsu.android.project2catherinekuntoro;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        ImageView villager_detail_imageView = findViewById(R.id.villager_detail_imageView);
        TextView name_detail_textView = findViewById(R.id.name_detail_textView);
        TextView description_detail_textView = findViewById(R.id.description_detail_textView);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            int resId = bundle.getInt("pictureID");
            villager_detail_imageView.setImageResource(resId);

            String name = bundle.getString("NAME");
            name_detail_textView.setText(name);

            String desc = bundle.getString("DESCRIPTION");
            description_detail_textView.setText(desc);
        }
    }

    // Override the default options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu); // Inflate the my_menu UI that was created
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.info_dropdown:
                Intent intent = new Intent(this, InformationActivity.class);
                this.startActivity(intent);
                return true;

            case R.id.uninstall_dropdown:
                Intent delete = new Intent(Intent.ACTION_DELETE, Uri.parse("package:" + getPackageName()));
                startActivity(delete);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    @Override // when start an activity for a result. if send smth, and send smth back, need to implement. getting back from smth
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        Bundle extras = getIntent().getExtras();
//
//        if(extras != null){
//
//            String strVillagerPosition = extras.getString("POSITION_VILLAGER");
//            villagerPosition = Integer.parseInt(strVillagerPosition);
//
//            Log.d("myTag", "in detail activity. villager position: " + villagerPosition);
//            System.out.println("in detail activity. villager position: " + villagerPosition);
//
//            ImageView villager_detail_imageView = findViewById(R.id.villager_detail_imageView);
//            TextView name_detail_textView = findViewById(R.id.name_detail_textView);
//            TextView description_detail_textView = findViewById(R.id.description_detail_textView);
//
//            //position 0 == Joey; default
//            if(villagerPosition == 1){ // Ketchup
//                villager_detail_imageView.setImageResource(R.drawable.ketchup_nh);
//                name_detail_textView.setText("Ketchup");
//            } else if (villagerPosition == 2){
//                villager_detail_imageView.setImageResource(R.drawable.maelle_nh);
//                name_detail_textView.setText("Maelle");
//            } else if(villagerPosition == 3){
//                villager_detail_imageView.setImageResource(R.drawable.pompom_nh);
//                name_detail_textView.setText("Pompom");
//            } else if(villagerPosition == 4){
//                villager_detail_imageView.setImageResource(R.drawable.scoot_nh);
//                name_detail_textView.setText("Scoot");
//            }
//        } else {
//            Log.d("myTag", "NULL VALUE " );
//            System.out.println("NULL VALUE");
//        }
//
//    }
}
