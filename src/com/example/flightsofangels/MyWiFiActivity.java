package com.example.flightsofangels;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager.Channel;
import android.net.wifi.p2p.WifiP2pManager.ChannelListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.flightsofangels.DeviceListFragment.DeviceActionListener;

@SuppressLint("NewApi")
public class MyWiFiActivity extends Activity implements ChannelListener,
		DeviceActionListener {

	WifiP2pManager mManager;
	Channel mChannel;
	BroadcastReceiver mReceiver;

	public static final String tag = "mywifiactivity";
	private WifiP2pManager manager;
	private boolean wifiP2pEnabled = true;
	public boolean retryChannel = false;
	private final IntentFilter intentFilter = new IntentFilter();
	private Channel channel;
	private BroadcastReceiver receiver = null;

	public boolean isWifiP2pEnabled() {
		return wifiP2pEnabled;
	}

	public void setWifiP2pEnabled(boolean wifiP2pEnabled) {
		this.wifiP2pEnabled = wifiP2pEnabled;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_wi_fi);
		intentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
		intentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
		intentFilter
				.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
		intentFilter
				.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);
		manager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
		channel = manager.initialize(this, getMainLooper(), null);

	}

	public void onResume() {
		super.onResume();
		receiver = new WiFiDirectBroadcastReceiver(manager, channel, this);
		registerReceiver(receiver, intentFilter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_wi_fi, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch(id)
		{
			
		}
//		if (id == R.id.action_settings) {
//			return true;
//		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void showDetails(WifiP2pDevice device) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelDisconnect() {
		// TODO Auto-generated method stub

	}

	@Override
	public void connect(WifiP2pConfig config) {
		// TODO Auto-generated method stub

	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onChannelDisconnected() {
		// TODO Auto-generated method stub

	}

}
