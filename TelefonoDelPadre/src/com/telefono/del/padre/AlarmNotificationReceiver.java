package com.telefono.del.padre;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class AlarmNotificationReceiver extends BroadcastReceiver {
	// Notification ID to allow for future updates
	private static final int MY_NOTIFICATION_ID = 1;
	private static final String TAG = "AlarmNotificationReceiver";
	private static int last_frase_selected_index = 0;
	
	// Notification Text Elements
	private final CharSequence contentTitle = "El Padre hoy quiere decirte...";

	// Notification Action Elements
	private Intent mNotificationIntent;
	private PendingIntent mContentIntent;


	@Override
	public void onReceive(Context context, Intent intent) {
		if(last_frase_selected_index >= Frases_Activity.frases.size()) {
			last_frase_selected_index = 0;
		}
		CharSequence frase = Frases_Activity.frases.get(last_frase_selected_index);
		last_frase_selected_index++;
		
		mNotificationIntent = new Intent(context, FraseDetailActivity.class);
		mNotificationIntent.putExtra("FRASE", frase);
		mContentIntent = PendingIntent.getActivity(context, 0,
				mNotificationIntent, Intent.FLAG_ACTIVITY_NEW_TASK);

		Notification.Builder notificationBuilder = new Notification.Builder(
				context).setTicker(frase)
				.setSmallIcon(android.R.drawable.stat_sys_speakerphone)
				.setAutoCancel(true).setContentTitle(contentTitle)
				.setContentText(frase).setContentIntent(mContentIntent);

		// Pass the Notification to the NotificationManager:
		NotificationManager mNotificationManager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.notify(MY_NOTIFICATION_ID,
				notificationBuilder.build());
		
		Log.i(TAG,"Sending notification at:" + DateFormat.getDateTimeInstance().format(new Date()));

	}
}
