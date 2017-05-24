package github.jake.com.githubtest.ui;

import android.content.Intent;
import android.os.Bundle;

import github.jake.com.githubtest.R;

public class SplashActivity extends ParentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getDefaultHandler().postDelayed(new Runnable(){
            @Override
            public void run() {
                startActivity();
            }
        }, 2000);
    }

    private void startActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.abc_fade_in, android.R.anim.fade_out);
        this.finish();
    }
}
