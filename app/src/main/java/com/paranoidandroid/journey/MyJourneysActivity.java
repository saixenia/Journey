package com.paranoidandroid.journey;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.paranoidandroid.journey.databinding.ActivityMyJourneysBinding;
import com.paranoidandroid.journey.models.Journey;
import com.parse.ParseUser;

import java.util.List;

public class MyJourneysActivity extends AppCompatActivity
        implements LogoutConfirmationDialogFragment.OnLogoutListener {

    private ActivityMyJourneysBinding binding;
    private List<Journey> journeys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViews();
        setupListeners();

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content, MyJourneysListFragment.newInstance());
            transaction.commit();
        }
    }

    private void setupViews() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_journeys);
        setSupportActionBar(binding.toolbar);
    }

    private void setupListeners() {
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewJourney(view);
            }
        });
    }

    private void createNewJourney(View view) {
        Snackbar.make(view, "Create a new journey", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                confirmLogout();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void confirmLogout() {
        LogoutConfirmationDialogFragment fragment =
                LogoutConfirmationDialogFragment.newInstance();
        fragment.show(getSupportFragmentManager(), "confirm_logout");
    }

    @Override
    public void onLogout() {
        ParseUser.logOut();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}