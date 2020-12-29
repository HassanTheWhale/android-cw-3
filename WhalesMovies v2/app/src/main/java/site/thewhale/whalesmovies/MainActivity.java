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

        RecyclerView
                ParentRecyclerViewItem
                = findViewById(
                R.id.parent_recyclerview);

            LinearLayoutManager
                    layoutManager
                    = new LinearLayoutManager(
                    MainActivity.this);

            ParentItemAdapter
                    parentItemAdapter
                    = new ParentItemAdapter(
                    ParentItemList());

            ParentRecyclerViewItem
                    .setAdapter(parentItemAdapter);
            ParentRecyclerViewItem
                    .setLayoutManager(layoutManager);


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


        RecyclerView rView = findViewById(R.id.rView);

        rView.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rView.setLayoutManager(lm);

        MovieAdapter movieAdapter = new MovieAdapter(moviesArrayList, MainActivity.this);
        rView.setAdapter(movieAdapter);
    }

    private List<ParentItem> ParentItemList()
    {
        List<ParentItem> itemList
                = new ArrayList<>();

        ParentItem item
                = new ParentItem(
                "Movies Series",
                ChildItemList());
        itemList.add(item);


        return itemList;
    }

    private List<ChildItem> ChildItemList()
    {
        List<ChildItem> ChildItemList
                = new ArrayList<>();

        ChildItemList.add(new ChildItem("Harry Potter", R.drawable.hpa));
        ChildItemList.add(new ChildItem("Part 2", R.drawable.hpb));
        ChildItemList.add(new ChildItem("Part 3", R.drawable.hpc));
        ChildItemList.add(new ChildItem("Part 4",R.drawable.hpd));

        return ChildItemList;
    }
}