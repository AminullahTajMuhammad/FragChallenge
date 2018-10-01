package fragchallenge.com.fragchallenge;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    private ArrayList<Person> list;

    onItemClicked activity;

    public interface onItemClicked {
        void onClick(int index);
    }

    public PersonAdapter(Context context, ArrayList<Person> list) {
        this.list = list;
        activity = (onItemClicked) context;
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(list.get(i));
        viewHolder.tvCarName.setText(list.get(i).getModelName());
        viewHolder.tvOwnerName.setText(list.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCar;
        TextView tvCarName, tvOwnerName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCarName = itemView.findViewById(R.id.tvListCarName);
            tvOwnerName = itemView.findViewById(R.id.tvListOwnerName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onClick(list.indexOf(v.getTag()));
                }
            });
        }
    }
}
