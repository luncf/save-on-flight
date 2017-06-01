package ca.umanitoba.cs.comp3350.saveonflight.presentation;

/**
 * HomeFragment.java
 *
 * Fragment for the home page of the application.
 *
 * @author Andy Lun
 */

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import ca.umanitoba.cs.comp3350.saveonflight.R;
import ca.umanitoba.cs.comp3350.saveonflight.objects.Flight;
import ca.umanitoba.cs.comp3350.saveonflight.presentation.SearchFragment.ViewFlightsListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
		implements OnNavigationItemSelectedListener, ViewFlightsListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
				this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
			@Override
			public void onDrawerSlide(View drawerView, float slideOffset) {
				InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
			}
		};
		drawer.setDrawerListener(toggle);
		toggle.syncState();
		
		NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
		navigationView.setNavigationItemSelectedListener(this);
		
		displaySelectedScreen(R.id.nav_home);
	}
	
	@Override
	public void onBackPressed() {
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}
	
	private void displaySelectedScreen(int itemId) {
		Fragment fragment = null;
		
		switch (itemId) {
			case R.id.nav_home:
				fragment = new HomeFragment();
				break;
			case R.id.nav_search:
				fragment = new SearchFragment();
				break;
		}
		
		if (fragment != null) {
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.content_frame, fragment)
					.commit();
		}
		
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawer.closeDrawer(GravityCompat.START);
	}
	
	@SuppressWarnings("StatementWithEmptyBody")
	@Override
	public boolean onNavigationItemSelected(MenuItem item) {
		// Handle navigation view item clicks here.
		displaySelectedScreen(item.getItemId());
		return true;
	}
	
	@Override
	public void viewFlights(ArrayList<Flight> flights) {
		ViewFlightsFragment viewFragment = new ViewFlightsFragment();
		Bundle args = new Bundle();
		args.putParcelableArrayList("flights", flights);
		viewFragment.setArguments(args);
		getFragmentManager()
				.beginTransaction()
				.replace(R.id.content_frame, viewFragment)
				.commit();
	}
	
}
