package github.jake.com.githubtest;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by PAK on 2017-04-28.
 */

public class ParentActivity extends AppCompatActivity{

    protected Handler mHandler;

    protected Handler getDefaultHandler() {
        if (mHandler == null) mHandler = new Handler();
        return mHandler;
    }
}
