package application.example.com.sabintern.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Dell on 23-12-2017.
 */

public class CourseContent implements Parcelable {

    public int courseContentImage;
    public CourseContent(){

    }
    public CourseContent(int courseContentImage){
        this.courseContentImage = courseContentImage;
    }
    public int getCourseContentImage() {
        return courseContentImage;
    }

    public void setCourseContentImage(int courseImage) {
        this.courseContentImage = courseContentImage;
    }



    protected CourseContent(Parcel in) {
        courseContentImage = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(courseContentImage);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<CourseContent> CREATOR = new Parcelable.Creator<CourseContent>() {
        @Override
        public CourseContent createFromParcel(Parcel in) {
            return new CourseContent(in);
        }

        @Override
        public CourseContent[] newArray(int size) {
            return new CourseContent[size];
        }
    };
}