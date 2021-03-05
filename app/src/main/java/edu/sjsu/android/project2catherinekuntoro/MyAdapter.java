package edu.sjsu.android.project2catherinekuntoro;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private ArrayList<Villager> villagers;

    public MyAdapter(ArrayList<Villager> villagers){
        this.villagers = villagers;

    }

    //Create new views (invoked by layout manager). To initializing the whole things. like a container
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_layout, parent, false);
        return new ViewHolder(view);
    }

    // Displays the view holder’s layout using the corresponding data at the specified position.
    // When it is called, the ViewHolder is bound to specific data
    // parameter of position is final = won't change if the list changed later

    //assign the values to the container
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //Get the specific duck from the list
        final Villager duck = villagers.get(position);

        //Set the duck's name and picture
        holder.name_textView.setText(duck.getDuckName());
        holder.villager_imageView.setImageResource(duck.getDrawableImage());

    }

    @Override
    public int getItemCount() {
        return villagers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView villager_imageView;
        public TextView name_textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            villager_imageView = itemView.findViewById(R.id.villager_imageView);
            name_textView = itemView.findViewById(R.id.name_textView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    Intent intent = new Intent(v.getContext(), DetailActivity.class);
                    //position == 0 joey, default
                    if(position == 0){
                        v.getContext().startActivity(intent);
                    }
                    if(position == 1){
                        intent.putExtra("pictureID", R.drawable.ketchup_nh);
                        intent.putExtra("NAME", "Ketchup");
                        intent.putExtra("DESCRIPTION", "Ketchup (ケチャップ, Kechappu, Ketchup) is a peppy duck villager in the Animal Crossing series, originally exclusive to Animal Forest e+. She can only move into a village if the player has her E-Reader card. Her name comes from the food, tomato ketchup, due to her tomato-like appearance. She has the play hobby. She appears on the cover of Steep Hill.");
                        v.getContext().startActivity(intent);
                    } else if(position == 2){
                        intent.putExtra("pictureID", R.drawable.maelle_nh);
                        intent.putExtra("NAME", "Maelle");
                        intent.putExtra("DESCRIPTION", "Maelle (アンヌ, Annu, Anne), is a snooty duck from the Animal Crossing series. In Animal Crossing and Animal Forest e+, she is an islander. She reappears in Wild World, City Folk, and New Leaf as a villager. The name \"Maelle\" means \"ambitious,\" a trait known among snooty villagers whom wish to become famous or rich. It also translates to \"princess\" in Breton, once again suiting her snooty personality. Her name may also be referencing the mallard duck. Her catchphrase, \"duckling,\" is inspired by her species. Her picture quote in Wild World may relate to when she lived on the island.");
                        v.getContext().startActivity(intent);
                    } else if(position == 3){
                        intent.putExtra("pictureID", R.drawable.pompom_nh);
                        intent.putExtra("NAME", "Pompom");
                        intent.putExtra("DESCRIPTION", "Pompom (のりっぺ, Norippe) is a peppy duck villager who has appeared in every Animal Crossing series game to date. Her name does not relate to her species, but her initial phrase, \"rah rah\", relates to cheerleading, and because peppy villagers aspire to become cheerleaders. It is likely her name and initial phrase make direct relation to the peppy personality. She also appears on the GameCube e-Reader card for K.K. Lullaby, rocking K.K. Slider to sleep. She has the music hobby.");
                        v.getContext().startActivity(intent);
                    } else if(position == 4){
                        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                        builder.setMessage("Are you sure you want to proceed?");

                        builder.setPositiveButton("Yes", (dialog, id) ->{
                            intent.putExtra("pictureID", R.drawable.scoot_nh);
                            intent.putExtra("NAME", "Scoot");
                            intent.putExtra("DESCRIPTION", "Scoot (マモル, Mamoru) is a jock duck villager in the Animal Crossing series. He appeared in Animal Crossing, was absent in Wild World, and reappeared in City Folk. His name may relate to the fact he wears a helmet, like the rider of a scooter, and his initial catchphrase is a possible reference to how young children imitate the sounds of motorcycles and/or scooters. He has the fitness hobby.");
                            v.getContext().startActivity(intent);
                        });
                        builder.setNegativeButton("No", (dialog, id) ->{
                            //dialog, NOT builder
                            dialog.dismiss();
                        });

                        builder.create().show();

                    }

                }
            });

        }

    }
}
