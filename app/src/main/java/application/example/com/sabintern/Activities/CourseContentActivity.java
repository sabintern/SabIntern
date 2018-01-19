package application.example.com.sabintern.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import application.example.com.sabintern.Adapters.CourseContentAdapter;
import application.example.com.sabintern.Model.CourseContent;
import application.example.com.sabintern.Model.Courses;
import application.example.com.sabintern.R;

/**
 * Created by Dell on 21-12-2017.
 */

public class CourseContentActivity extends AppCompatActivity implements CourseContentAdapter.ListItemClickListener{
    Courses coursesList;
    Toolbar toolbar;
    CourseContentAdapter mAdapter;
    ArrayList<CourseContent> courseContentArrayList;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_content);
        coursesList = getIntent().getParcelableExtra("items");
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.back_button_image);


        toolbar.setLogo(R.drawable.logo_bar);
        recyclerView = findViewById(R.id.list_course_content);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        courseContentArrayList = new ArrayList<CourseContent>();
        mAdapter = new CourseContentAdapter(courseContentArrayList, this, this);
        prepareImages();
        recyclerView.setAdapter(mAdapter);


    }

    private void prepareImages(){
        int[] covers =new int[]{
                R.drawable.java,
                R.drawable.scrim_gradient,
                R.drawable.scrim_gradient
        };
        CourseContent a = new CourseContent(covers[0]);
        courseContentArrayList.add(a);
        CourseContent b = new CourseContent(covers[1]);
        courseContentArrayList.add(b);
        CourseContent c = new CourseContent(covers[2]);
        courseContentArrayList.add(c);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == android.R.id.home){
            onBackPressed();
            return true;
        }
        return true;

    }

    @Override
    public void onListItemClick(int clickItemIndex) {
        Intent intent = new Intent(CourseContentActivity.this, ViewPagerActivity.class);
        intent.putExtra("contents",courseContentArrayList.get(clickItemIndex));
        Log.d("--->", String.valueOf(clickItemIndex));
        startActivity(intent);

    }
}
