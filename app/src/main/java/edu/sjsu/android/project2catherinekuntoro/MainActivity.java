package edu.sjsu.android.project2catherinekuntoro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //generate data
        ArrayList<Villager> villagersList = new ArrayList<>();
        villagersList.add(new Villager("Joey", R.drawable.joey_nh));
        villagersList.add(new Villager("Ketchup", R.drawable.ketchup_nh));
        villagersList.add(new Villager("Maelle", R.drawable.maelle_nh));
        villagersList.add(new Villager("Pompom", R.drawable.pompom_nh));
        villagersList.add(new Villager("Scoot", R.drawable.scoot_nh));

        //Set adapter to the custom adapter with the data:

        // Instantiate RecyclerView + ensure each row has the same size
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        // Set layout manager so everything organized in linear fashion; as a list
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Set the adapter
        recyclerView.setAdapter(new MyAdapter(villagersList));
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
}