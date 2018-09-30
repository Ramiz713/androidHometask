package com.homework.hometask1;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, EditDialog.OnFieldsFill {

    private TextView tvLogin;
    private TextView tvEmail;
    private TextView headerLogin;
    private TextView headerEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);
        else if (getFragmentManager().getBackStackEntryCount() > 0)
            getFragmentManager().popBackStack();
        else super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            ChangeFragment(ProfileFragment.newInstance());
        } else if (id == R.id.nav_gallery) {
            ChangeFragment(GalleryFragment.newInstance());
        } else if (id == R.id.nav_message) {
            ChangeFragment(MessageFragment.newInstance());
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void ChangeFragment(Fragment fragment) {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.drawer_container, fragment)
                .addToBackStack("")
                .commit();
    }

    @Override
    public void onOkClick(String login, String email) {
        tvLogin = findViewById(R.id.tv_login);
        tvEmail = findViewById(R.id.tv_email);
        headerLogin = findViewById(R.id.header_tv_login);
        headerEmail = findViewById(R.id.header_tv_email);
        tvLogin.setText(login);
        tvEmail.setText(email);
        headerLogin.setText(login);
        headerEmail.setText(email);
    }
}
