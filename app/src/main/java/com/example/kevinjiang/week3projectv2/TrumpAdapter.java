package com.example.kevinjiang.week3projectv2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class TrumpAdapter extends RecyclerView.Adapter<TrumpAdapter.CustomViewHolder> {

    private Context context;
    private ArrayList<TrumpCard> trumpCards;

    public TrumpAdapter(Context context, ArrayList<TrumpCard> trumpcards) {
        this.context = context;
        trumpCards = trumpcards;
    }

    /* In simplified terms, a ViewHolder is an object that holds the pointers to the views in each
    each row. What does that mean? Every row has a TextView, ImageView, and CheckBox. Each row has
    a ViewHolder, and that ViewHolder holder these 3 views in it (hence "view holder").
    This function returns a single ViewHolder; it is called once for every row.
    */
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        This "inflates" the views, using the layout R.layout.row_view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_view, parent, false);
        return new CustomViewHolder(view);
    }

    /* This function takes the previously made ViewHolder and uses it to actually display the
    data on the screen. Remember how the holder contains (pointers to) the 3 views? By doing, for
    example, "holder.imageView" we are accessing the imageView for that row and setting the
    ImageResource to be the corresponding image for that subject.
     */
    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        TrumpCard trumpCard = trumpCards.get(position);

        holder.memeName.setText(trumpCard.meme);
        holder.imageView.setImageResource(trumpCard.imageId);
        holder.descriptionMeme.setText(trumpCard.description);
    }

    @Override
    public int getItemCount() {
        return trumpCards.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView memeName;
        ImageView imageView;
        TextView descriptionMeme;

        public CustomViewHolder (View view) {
            super(view);
            this.memeName = (TextView) view.findViewById(R.id.memeName);
            this.imageView = (ImageView) view.findViewById(R.id.iconImageView);
            this.descriptionMeme = (TextView) view.findViewById(R.id.descriptionMeme);

            /*Think about what we said in the comment above onCreateViewHolder to determine the
            purpose of the ViewHolder. Does it make sense why we are doing this in the constructor?
            */

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*Get adapter position is getting the number of the row that was clicked,
                    starting at 0
                    */
//                    Hint: Use getAdapterPosition();
                    Toast.makeText(context, trumpCards.get(getAdapterPosition()).meme, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
