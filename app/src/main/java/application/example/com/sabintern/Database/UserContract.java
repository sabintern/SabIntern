package application.example.com.sabintern.Database;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Dell on 10-01-2018.
 */

public class UserContract {
    public static final String CONTENT_AUTHORITY = "application.example.com.sabintern";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_FAVORITES = "user";

    public static final class UserEntry implements BaseColumns {
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_FAVORITES).build();

        public static final String CONTENT_ALL_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY
                + "/" + PATH_FAVORITES;
        public static final String CONTENT_ITEMS_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY
                + "/" + PATH_FAVORITES;

        public static final String TABLE_NAME = "user";
        public static final String USER_ID = "user_id";
        public static final String COLUMN_NAME = "user_name";
        public static final String COLUMN_EMAIL = "user_email";
        public static final String COLUMN_MOBILE = "user_mobile";

        public static Uri builtFavoriteUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }


    }

}
