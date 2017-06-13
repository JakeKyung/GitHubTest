package github.jake.com.githubtest.ui;


import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import github.jake.com.githubtest.CircularProgress;
import github.jake.com.githubtest.Fragment.CartFragment;
import github.jake.com.githubtest.Fragment.MainContentFragment;
import github.jake.com.githubtest.Fragment.MyPageFragment;
import github.jake.com.githubtest.Fragment.RequestFragment;
import github.jake.com.githubtest.Fragment.ShoppingFragment;
import github.jake.com.githubtest.R;

public class MainActivity extends ParentTabActivity implements View.OnClickListener{

    private int TABNUMBER = 1;

    private LinearLayout tab_layout;
    private TextView home_tab, request_tab, shopping_tab, cart_tab, my_page_tab;

    private FragmentManager fragmentManager;
    private Fragment mainContentFragment, requestFragment , shoppingFragment , cartFragment , mypageFragment;

    private CircularProgress progressBar;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab_layout = (LinearLayout) findViewById(R.id.tab_layout);

        progressBar = new CircularProgress(this);
        if (mHandler == null) mHandler = new Handler();

        fragmentManager =getSupportFragmentManager();

        View view = tab_layout.getRootView();

        home_tab = (TextView) view.findViewById(R.id.home_tab);
        request_tab = (TextView) view.findViewById(R.id.request_tab);
        shopping_tab = (TextView) view.findViewById(R.id.shopping_tab);
        cart_tab = (TextView) view.findViewById(R.id.cart_tab);
        my_page_tab = (TextView) view.findViewById(R.id.my_page_tab);

        home_tab.setOnClickListener(this);
        request_tab.setOnClickListener(this);
        shopping_tab.setOnClickListener(this);
        cart_tab.setOnClickListener(this);
        my_page_tab.setOnClickListener(this);

        display(TABNUMBER);

    }

    private void display(int TABNUMBER) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (TABNUMBER) {
            case 1 :
                mainContentFragment =fragmentManager.findFragmentByTag("main");
                if (mainContentFragment == null) {
                    mainContentFragment = new MainContentFragment();
                    fragmentTransaction
                            .add(R.id.activity_main_fragment, mainContentFragment, "main")
                            .commit();
                }
                else {
                    fragmentTransaction
                            .show(mainContentFragment)
                            .commit();
                }
                home_tab.setSelected(true);
                setProgressable(false);
                break;

            case 2 :
                requestFragment = fragmentManager.findFragmentByTag("request");
                if (requestFragment == null) {
                    requestFragment = new RequestFragment();
                    fragmentTransaction
                            .add(R.id.activity_main_fragment, requestFragment, "request")
                            .commit();
                }
                else {
                    fragmentTransaction
                            .show(requestFragment)
                            .commit();
                }
                request_tab.setSelected(true);
                setProgressable(false);
                break;


            case 3 :
                shoppingFragment = fragmentManager.findFragmentByTag("shopping");
                if (shoppingFragment == null) {
                    shoppingFragment = new ShoppingFragment();
                    fragmentTransaction
                            .add(R.id.activity_main_fragment, shoppingFragment, "shopping")
                            .commit();
                }
                else {
                    fragmentTransaction
                            .show(shoppingFragment)
                            .commit();
                }
                shopping_tab.setSelected(true);
                setProgressable(false);
                break;
            case 4 :
                cartFragment = fragmentManager.findFragmentByTag("cart");
                if (cartFragment == null) {
                    cartFragment = new CartFragment();
                    fragmentTransaction
                            .add(R.id.activity_main_fragment, cartFragment, "cart")
                            .commit();
                }
                else {
                    fragmentTransaction
                            .show(cartFragment)
                            .commit();
                }
                cart_tab.setSelected(true);
                setProgressable(false);
                break;
            case 5 :
                mypageFragment = fragmentManager.findFragmentByTag("mypage");
                if (mypageFragment == null) {
                    mypageFragment = new MyPageFragment();
                    fragmentTransaction
                            .add(R.id.activity_main_fragment, mypageFragment, "mypage")
                            .commit();
                }
                else {
                    fragmentTransaction
                            .show(mypageFragment)
                            .commit();
                }
                my_page_tab.setSelected(true);
                setProgressable(false);
                break;
        }
    }


    @Override
    public void onClick(View v) {
        switch (TABNUMBER) {
            case 1 :
                fragmentManager.beginTransaction().hide(mainContentFragment).commit();
                break;
            case 2 :
                fragmentManager.beginTransaction().hide(requestFragment).commit();
                break;
            case 3 :
                fragmentManager.beginTransaction().hide(shoppingFragment).commit();
                break;
            case 4 :
                fragmentManager.beginTransaction().hide(cartFragment).commit();
                break;
            case 5 :
                fragmentManager.beginTransaction().hide(mypageFragment).commit();
                break;
        }

        switch (v.getId()) {
            case R.id.home_tab:
                setProgressable(true);
                home_tab.setSelected(true);
                request_tab.setSelected(false);
                shopping_tab.setSelected(false);
                cart_tab.setSelected(false);
                my_page_tab.setSelected(false);
                TABNUMBER =1;
                break;
            case R.id.request_tab:
                setProgressable(true);
                home_tab.setSelected(false);
                request_tab.setSelected(true);
                shopping_tab.setSelected(false);
                cart_tab.setSelected(false);
                my_page_tab.setSelected(false);
                TABNUMBER =2;
                break;
            case R.id.shopping_tab:
                setProgressable(true);
                home_tab.setSelected(false);
                request_tab.setSelected(false);
                shopping_tab.setSelected(true);
                cart_tab.setSelected(false);
                my_page_tab.setSelected(false);
                TABNUMBER =3;
                break;
            case R.id.cart_tab:
                setProgressable(true);
                home_tab.setSelected(false);
                request_tab.setSelected(false);
                shopping_tab.setSelected(false);
                cart_tab.setSelected(true);
                my_page_tab.setSelected(false);
                TABNUMBER =4;
                break;
            case R.id.my_page_tab:
                setProgressable(true);
                home_tab.setSelected(false);
                request_tab.setSelected(false);
                shopping_tab.setSelected(false);
                cart_tab.setSelected(false);
                my_page_tab.setSelected(true);
                TABNUMBER =5;
                break;
        }

        display(TABNUMBER);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (progressBar != null) {
            progressBar.dismiss();
            progressBar = null;
        }
    }


    public void setProgressable(boolean enable) {
        if (enable) {
            if (progressBar != null) progressBar.show();
        } else {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (progressBar != null) progressBar.dismiss();
                }
            }, 500);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onResume() {
        super.onResume();
        display(TABNUMBER);
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
