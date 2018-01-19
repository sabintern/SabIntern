package application.example.com.sabintern.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import application.example.com.sabintern.Model.CourseContent;
import application.example.com.sabintern.R;

/**
 * Created by Dell on 23-12-2017.
 */

public class CourseContentAdapter extends RecyclerView.Adapter<CourseContentAdapter.CourseContentViewHolder>{
    ArrayList<CourseContent> courseContentArrayList;
    Context mContext;
    private final ListItemClickListener mListItemClickListener;
    public interface ListItemClickListener {
        void onListItemClick(int clickItemIndex);

    }

    public CourseContentAdapter(ArrayList<CourseContent> courseContentArrayList, Context mContext, ListItemClickListener mListItemClickListener){
        this.courseContentArrayList = courseContentArrayList;
        this.mContext = mContext;
        this.mListItemClickListener = mListItemClickListener;
    }
    @Override
    public CourseContentAdapter.CourseContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.course_content_items, parent, false);
        return new CourseContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CourseContentAdapter.CourseContentViewHolder holder, int position) {
        holder.onBind(position);

    }

    @Override
    public int getItemCount() {
        if(courseContentArrayList!=null){
            return courseContentArrayList.size();
        }
        else {
            return 0;
        }
    }

    class CourseContentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public  final ImageView courseContentImage;

        public CourseContentViewHolder(View itemView) {
            super(itemView);
            courseContentImage = itemView.findViewById(R.id.course_content_image);
            itemView.setOnClickListener(this);
        }

        void onBind(int position){
            if(!courseContentArrayList.isEmpty()){
                Picasso.with(itemView.getContext()).load(courseContentArrayList.get(position).getCourseContentImage()).into(courseContentImage);
            }
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mListItemClickListener.onListItemClick(clickedPosition);
        }
    }
}
