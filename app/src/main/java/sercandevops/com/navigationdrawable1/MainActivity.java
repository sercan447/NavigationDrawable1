package sercandevops.com.navigationdrawable1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    private NavigationView nav_view;
    private Toolbar toolbar;
    private Fragment fragment;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment = new BirinciFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_tutucu,fragment).commit();

        nav_view = findViewById(R.id.nav_view);
        drawer = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle =  new ActionBarDrawerToggle(this,drawer,toolbar,
                            0,0);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

       View baslik = nav_view.inflateHeaderView(R.layout.nav_baslik);

        nav_view.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();

        if(id == R.id.action_bir){
            fragment = new BirinciFragment();
            Toast.makeText(getApplicationContext(),"bir",Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.action_iki)
        {
            fragment = new ikincifragment();
            Toast.makeText(getApplicationContext(),"ıkı",Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.action_uc)
        {
            Toast.makeText(getApplicationContext(),"uc",Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.action_dort)
        {
            Toast.makeText(getApplicationContext(),"dort",Toast.LENGTH_SHORT).show();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_tutucu,fragment).commit();

        drawer.closeDrawer(Gravity.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if(drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }else
        {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.addCategory(Intent.CATEGORY_HOME);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivity(i);
        }
    }
}
