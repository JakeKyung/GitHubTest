package github.jake.com.githubtest.ui;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Jake on 2017-04-28.
 */

public class ParentActivity extends AppCompatActivity{

    protected Handler mHandler;

    protected Handler getDefaultHandler() {
        if (mHandler == null) mHandler = new Handler();
        return mHandler;
    }
}
