package com.droderino.racingtracker;

import com.droderino.mappositioning.Positioning;
import com.droderino.mappositioning.PositioningImpl;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	private GoogleMap map;
	private Positioning posManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		map = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();

		posManager = new PositioningImpl(this, map);
	}

	@Override
	protected void onStart()
	{
		super.onStart();
		posManager.start();
	}
	
	@Override
	protected void onStop()
	{
		super.onStop();
		posManager.stop();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
