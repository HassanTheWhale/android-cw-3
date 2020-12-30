package site.thewhale.whalesmovies;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

class ChildItemAdapter
        extends RecyclerView
        .Adapter<ChildItemAdapter.ChildViewHolder> {

    private List<ChildItem> ChildItemList;
    private Context context;

    // Constuctor
    ChildItemAdapter(List<ChildItem> childItemList, Context context)
    {
        this.ChildItemList = childItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(
            @NonNull ViewGroup viewGroup,
            int i)
    {

        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(
                        R.layout.child_item,
                        viewGroup, false);

        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ChildViewHolder childViewHolder,
            int position)
    {

        ChildItem childItem
                = ChildItemList.get(position);

        childViewHolder
                .ChildItemTitle
                .setText(childItem.getChildItemTitle());

        childViewHolder
                .ChildItemPic
                .setImageResource(childItem.getChildItemPic());

        ((ChildItemAdapter.ChildViewHolder) childViewHolder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerView rView = (RecyclerView) ((Activity)context).findViewById(R.id.rView);
                rView.setAdapter(ChildItemList.get(position).getMovie());
            }
        });

    }

    @Override
    public int getItemCount()
    {

        return ChildItemList.size();
    }

    class ChildViewHolder
            extends RecyclerView.ViewHolder {

        TextView ChildItemTitle;
        ImageView ChildItemPic;
        public View view;


        ChildViewHolder(View itemView)
        {
            super(itemView);
            view = itemView;
            ChildItemTitle
                    = itemView.findViewById(
                    R.id.child_item_title);
            ChildItemPic
                    = itemView.findViewById(
                    R.id.img_child_item);
        }
    }
}
