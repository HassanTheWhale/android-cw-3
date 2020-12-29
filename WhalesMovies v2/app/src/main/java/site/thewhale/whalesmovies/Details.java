package site.thewhale.whalesmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView name = findViewById(R.id.movieName);
        TextView plot = findViewById(R.id.plot);
        ImageView img = findViewById(R.id.movieImg);
        ImageView imdb = findViewById(R.id.imdb);
        TextView year = findViewById(R.id.year);
        TextView duration = findViewById(R.id.duration);
        TextView rate = findViewById(R.id.rate);

        Movies movie = (Movies) getIntent().getExtras().getSerializable("movie");

        name.setText(movie.getName());
        plot.setText(movie.getPlot());
        img.setImageResource(movie.getImg());
        year.setText(movie.getYear());
        duration.setText(movie.getDuration());
        rate.setText(movie.getRate());

        imdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(movie.getImdb()));
                startActivity(browserIntent);
            }
        });
    }
}