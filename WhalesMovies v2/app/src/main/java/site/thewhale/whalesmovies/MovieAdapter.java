package site.thewhale.whalesmovies;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter {

    ArrayList<Movies> movieList;
    Context contect;

    public MovieAdapter(ArrayList<Movies> movieList, Context contect) {
        this.movieList = movieList;
        this.contect = contect;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Connecting to special recycle view xml file;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movies_recycle_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).rate.setText(movieList.get(position).getRate());
        ((ViewHolder) holder).name.setText(movieList.get(position).getName());
        ((ViewHolder) holder).duration.setText(movieList.get(position).getDuration());
        ((ViewHolder) holder).img.setImageResource(movieList.get(position).getImg());
        ((ViewHolder) holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(contect, Details.class);
                i.putExtra("movie", movieList.get(position));
                contect.startActivity(i);
            }
        });

        final AlertDialog.Builder builder = new AlertDialog.Builder(contect);

        ((ViewHolder) holder).delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("Delete Confirmation");
                builder.setMessage("Are you sure that you want to delete?");
                builder.setCancelable(false).setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        movieList.remove(position);
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No :D", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(contect, "I am really happy that u didn't delete me!", Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView name;
        public TextView rate;
        public TextView duration;
        public ImageView delete;
        public View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            img = itemView.findViewById(R.id.moviePic);
            name = itemView.findViewById(R.id.movieName);
            rate = itemView.findViewById(R.id.rate);
            duration = itemView.findViewById(R.id.duration);
            delete = itemView.findViewById(R.id.delete);
        }
    }
}
