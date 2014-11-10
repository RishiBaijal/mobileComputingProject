package com.example.flightsofangels;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ListFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pManager.PeerListListener;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DeviceListFragment extends ListFragment implements
		PeerListListener {

	private WifiP2pDevice device;
	private List<WifiP2pDevice> peers=new ArrayList<WifiP2pDevice>();
	public interface DeviceActionListener {

		void showDetails(WifiP2pDevice device);

		void cancelDisconnect();

		void connect(WifiP2pConfig config);

		void disconnect();
	}

	// @Override
	// protected void onCreate(Bundle savedInstanceState) {
	// super.onCreate(savedInstanceState);
	// setContentView(R.layout.activity_device_list_fragment);
	// }

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		this.setListAdapter(new WiFiPeerListAdapter(getActivity(), R.layout.row_devices, peers));
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public WifiP2pDevice getDevice() {
		return device;
	}

	@Override
	public void onPeersAvailable(WifiP2pDeviceList peers) {
		// TODO Auto-generated method stub

	}
	
	private class WiFiPeerListAdapter extends ArrayAdapter<WifiP2pDevice>
	{

		
		private List<WifiP2pDevice> items;
		public WiFiPeerListAdapter(Context context, int resource, List<WifiP2pDevice> items) {
			super(context, resource, items);
			this.items=items;
			
		}
		
		
		
	}
}
