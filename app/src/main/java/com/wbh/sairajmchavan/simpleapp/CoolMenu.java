package com.wbh.sairajmchavan.simpleapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.facebook.stetho.Stetho;

public class CoolMenu extends ListActivity {

	String classes[] = {"StartingPoint","TextPlay","Email",
			"Camera","NewCamera","Data","GFX","GFXSurface", "SoundStuff",
			"Slider", "Tabs", "SimpleBrowser", "Flipper","SharedPrefs",
			"InternalData", "ExternalData", "SQLiteExample", "Accelerate",
			"HttpExample", "WeatherXMLParsing", "GLExample","GLCubeEx",
			"Voice","TextVoice","StatusBar","SeekBarVolume"};

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		String cheese = classes[position];
		try {
			Class<?> ourClass = Class.forName("com.wbh.sairajmchavan.simpleapp." + cheese);
			Intent ourIntent = new Intent(CoolMenu.this, ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			Log.d("Error","" + e.toString());
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Stetho.initialize(
				Stetho.newInitializerBuilder(this)
						.enableDumpapp(
								Stetho.defaultDumperPluginsProvider(this))
						.enableWebKitInspector(
								Stetho.defaultInspectorModulesProvider(this))
						.build());

		setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, classes));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.cool_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch(item.getItemId()){
		
			case R.id.aboutUs:
				Intent i = new Intent("com.wbh.sairajmchavan.simpleapp.ABOUT");
				startActivity(i);
				break;
			case R.id.preferences:
				Intent pIntent = new Intent("com.wbh.sairajmchavan.simpleapp.PREFS");
				startActivity(pIntent);
				break;
			case R.id.exit:
				finish();
				break;
		}
		
		return false;
	}
	
}