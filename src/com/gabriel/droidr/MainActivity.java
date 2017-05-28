package com.gabriel.droidr;

import com.gabriel.droidr.core.Activity;
import com.gabriel.droidr.core.Intent;

public class MainActivity extends Activity{

	@Override
	public void onCreate() {
		
		System.out.println("Calling another activity...");
		
		Intent intent = new Intent(this, Test2Activity.class);
		startActivity(intent);
		
	}

}
