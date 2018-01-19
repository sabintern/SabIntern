package application.example.com.sabintern.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import application.example.com.sabintern.Model.Courses;
import application.example.com.sabintern.R;

/**
 * Created by Dell on 11-12-2017.
 */

public class MainDashboardAdapter extends RecyclerView.Adapter<MainDashboardAdapter.DashboardViewHolder> {
    private ArrayList<Courses> coursesArrayList;
    private static ListItemClickListener listItemClickListener;
    public interface ListItemClickListener {
        void onListItemClick(int clickItemIndex);

    }

    public MainDashboardAdapter(ArrayList<Courses> coursesArrayList, ListItemClickListener listItemClickListener) {
        this.coursesArrayList = coursesArrayList;
        this.listItemClickListener = listItemClickListener;
    }

    @Override
    public MainDashboardAdapter.DashboardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutForListItem = R.layout.main_list_items;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(layoutForListItem, parent, false);
        return new DashboardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainDashboardAdapter.DashboardViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if(coursesArrayList!=null) {
            return coursesArrayList.size();
        }
        else{
            return 0;
        }
    }


    class DashboardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final ImageView courseImage;
        public final TextView courseName;
        public final ProgressBar progressBar;
        public DashboardViewHolder(View itemView) {
            super(itemView);
            courseImage = itemView.findViewById(R.id.course_image);
            courseName = itemView.findViewById(R.id.course_title);
            progressBar = itemView.findViewById(R.id.complete_progressBar);
            itemView.setOnClickListener(this);
        }
        void onBind(int position){
            if(!coursesArrayList.isEmpty()){

                Picasso.with(itemView.getContext()).load(coursesArrayList.get(position).getCourseImage()).into(courseImage);
                courseName.setText(coursesArrayList.get(position).getCourseName());
                progressBar.setMax(100);
                progressBar.setProgress(50);
            }
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            listItemClickListener.onListItemClick(clickedPosition);

        }
    }
}
