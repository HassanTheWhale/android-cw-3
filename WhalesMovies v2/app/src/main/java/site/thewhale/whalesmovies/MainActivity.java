package site.thewhale.whalesmovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        ArrayList<Movies> moviesArrayList = new ArrayList<Movies>();
        moviesArrayList.add(
                new Movies("Harry Potter and the Sorcerer's Stone", R.drawable.hpa,
                        "An orphaned boy enrolls in a school of wizardry, where he learns the truth about himself, his family and the terrible evil that haunts the magical world.",
                        "2001", "152 min",
                        "7.6", "https://www.imdb.com/title/tt0241527/?ref_=ttls_li_tt"));
        moviesArrayList.add(
                new Movies("Harry Potter and the Chamber of Secrets", R.drawable.hpb,
                        "An ancient prophecy seems to be coming true when a mysterious presence begins stalking the corridors of a school of magic and leaving its victims paralyzed.",
                        "2002", "161 min",
                        "7.4", "https://www.imdb.com/title/tt0295297/?ref_=ttls_li_tt"));
        moviesArrayList.add(
                new Movies("Harry Potter and the Prisoner of Azkaban", R.drawable.hpc,
                        "Harry Potter, Ron and Hermione return to Hogwarts School of Witchcraft and Wizardry for their third year of study, where they delve into the mystery surrounding an escaped prisoner who poses a dangerous threat to the young wizard.",
                        "2004", "142 min",
                        "7.9", "https://www.imdb.com/title/tt0304141/?ref_=ttls_li_tt"));
        moviesArrayList.add(
                new Movies("Harry Potter and the Goblet of Fire", R.drawable.hpd,
                        "Harry Potter finds himself competing in a hazardous tournament between rival schools of magic, but he is distracted by recurring nightmares.",
                        "2005", "157 min",
                        "7.7", "https://www.imdb.com/title/tt0330373/?ref_=ttls_li_tt"));

        ArrayList<Movies> moviesArrayList2 = new ArrayList<Movies>();
        moviesArrayList2.add(
                new Movies("The Avengers ", R.drawable.aven,
                        "Earth's mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and his alien army from enslaving humanity.",
                        "2012", "143 min",
                        "8", "https://www.imdb.com/title/tt0848228/?ref_=ttls_li_i"));
        moviesArrayList2.add(
                new Movies("Avengers: Age of Ultron", R.drawable.avenb,
                        "When Tony Stark and Bruce Banner try to jump-start a dormant peacekeeping program called Ultron, things go horribly wrong and it's up to Earth's mightiest heroes to stop the villainous Ultron from enacting his terrible plan.",
                        "2015", "141 min",
                        "7.3", "https://www.imdb.com/title/tt2395427/?ref_=ttls_li_i"));
        moviesArrayList2.add(
                new Movies("Avengers: Infinity War", R.drawable.avenc,
                        "The Avengers and their allies must be willing to sacrifice all in an attempt to defeat the powerful Thanos before his blitz of devastation and ruin puts an end to the universe.",
                        "2018", "149 min",
                        "8.4", "https://www.imdb.com/title/tt4154756/?ref_=ttls_li_i"));
        moviesArrayList2.add(
                new Movies("Avengers: Endgame", R.drawable.avend,
                        "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe.",
                        "2019", "181 min",
                        "8.4", "https://www.imdb.com/title/tt4154796/?ref_=ttls_li_i"));


        RecyclerView rView = findViewById(R.id.rView);

        rView.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rView.setLayoutManager(lm);

        ArrayList<MovieAdapter> moviesAdapterList = new ArrayList<MovieAdapter>();

        MovieAdapter movieAdapter = new MovieAdapter(moviesArrayList, MainActivity.this);
        MovieAdapter movieAdapter2 = new MovieAdapter(moviesArrayList2, MainActivity.this);

        moviesAdapterList.add(movieAdapter);
        moviesAdapterList.add(movieAdapter2);

        rView.setAdapter(movieAdapter);

        //---------------

        ParentItemAdapter
                parentItemAdapter
                = new ParentItemAdapter( ParentItemList(moviesAdapterList), MainActivity.this);


        RecyclerView
                ParentRecyclerViewItem
                = findViewById(
                R.id.parent_recyclerview);

        LinearLayoutManager
                layoutManager
                = new LinearLayoutManager(
                MainActivity.this);

        ParentRecyclerViewItem
                .setAdapter(parentItemAdapter);
        ParentRecyclerViewItem
                .setLayoutManager(layoutManager);
    }

    private List<ParentItem> ParentItemList(ArrayList<MovieAdapter> list)
    {
        List<ParentItem> itemList
                = new ArrayList<>();

        ParentItem item
                = new ParentItem(
                "Movies Series",
                ChildItemList(list));
        itemList.add(item);


        return itemList;
    }

    private List<ChildItem> ChildItemList(ArrayList<MovieAdapter> list)
    {
        List<ChildItem> ChildItemList
                = new ArrayList<>();

        ChildItemList.add(new ChildItem("Harry Potter", R.drawable.hpa, list.get(0)));
        ChildItemList.add(new ChildItem("The Avengers", R.drawable.aven, list.get(1)));

        return ChildItemList;
    }
}