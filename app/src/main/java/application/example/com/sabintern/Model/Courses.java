package application.example.com.sabintern.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Dell on 12-12-2017.
 */

public class Courses implements Parcelable {

    private String courseName;
    private int courseImage;
    private int progressBar;
    private String id;


    public Courses(){

    }

    public Courses(String courseName, int courseImage){
        this.courseName = courseName;
        this.courseImage = courseImage;


    }
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(int courseImage) {
        this.courseImage = courseImage;
    }

    public int getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(int progressBar) {
        this.progressBar = progressBar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    protected Courses(Parcel in) {
        courseName = in.readString();
        courseImage = in.readInt();
        progressBar = in.readInt();
        id = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(courseName);
        dest.writeInt(courseImage);
        dest.writeInt(progressBar);
        dest.writeString(id);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Courses> CREATOR = new Parcelable.Creator<Courses>() {
        @Override
        public Courses createFromParcel(Parcel in) {
            return new Courses(in);
        }

        @Override
        public Courses[] newArray(int size) {
            return new Courses[size];
        }
    };
}