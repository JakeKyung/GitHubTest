package github.jake.com.githubtest;


import android.os.Handler;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends ParentTabActivity {

    private LinearLayout tab_layout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab_layout = (LinearLayout) findViewById(R.id.tab_layout);

    }

    @Override
    public void onBackPressed() {
        if (true) {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, R.string.App_finish, Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        }
    }

}
