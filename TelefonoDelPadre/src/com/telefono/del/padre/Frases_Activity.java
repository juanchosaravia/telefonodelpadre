package com.telefono.del.padre;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Frases_Activity extends Activity {

	protected static final ArrayList<CharSequence> frases = new ArrayList<CharSequence>();
	
	private AlarmManager mAlarmManager;
	private Intent mNotificationReceiverIntent;
	private PendingIntent mNotificationReceiverPendingIntent;
	private static final long INITIAL_ALARM_DELAY = 1 * 60 * 1000L;
	protected static final long JITTER = 5000L;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frases);
		
		loadFrases();
		
		// Get the AlarmManager Service
		mAlarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
		// Create PendingIntent to start the AlarmNotificationReceiver
		mNotificationReceiverIntent = new Intent(Frases_Activity.this,
				AlarmNotificationReceiver.class);
		mNotificationReceiverPendingIntent = PendingIntent.getBroadcast(
				Frases_Activity.this, 0, mNotificationReceiverIntent, 0);
		
		Button iniciarButton = (Button) findViewById(R.id.iniciar);
		Button cancelarButton = (Button) findViewById(R.id.cancelar);
		
		iniciarButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mAlarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME,
						SystemClock.elapsedRealtime() + 10L,
						AlarmManager.INTERVAL_DAY,
						mNotificationReceiverPendingIntent);

				Toast.makeText(getApplicationContext(), "El Padre te va a llamar cada un d�a.",
						Toast.LENGTH_LONG).show();
			}
		});
		
		cancelarButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mAlarmManager.cancel(mNotificationReceiverPendingIntent);
				
				Toast.makeText(getApplicationContext(), "El Padre ya no te llamar�  :(",
						Toast.LENGTH_LONG).show();
			}
		});
	}

	private void loadFrases() {
		if (frases.size() <= 0) {
			frases.add("El que mantiene siempre abiertos el coraz�n y los sentidos para lo que le agrada a Dios, permanece joven hasta edad avanzada, porque nunca le falta la fuerza del amor.");		
			frases.add("Adorar significa, en el sentido m�s amplio, cumplir por amor la voluntad de Dios.");
			frases.add("La alegr�a debe irradiarse en nuestro propio  rostro.");
			frases.add("Padre en la simplicidad de mi coraz�n, te entrego hoy todo con alegr�a.");
			frases.add("Nada me quitar� la alegr�a.");
			frases.add("Creo firmemente que nunca perecer� quien permanece fiel a su Alianza de amor.");
			frases.add("El amor de Dios es la ley b�sica universal.");
			frases.add("No hay nada mejor que el amor, nada m�s grande que el amor, nada m�s hermoso que el amor.");
			frases.add("El amor verdadero no se a�sla nunca.");
			frases.add("El que ama hace lo que le da alegr�a al amado.");
			frases.add("Quien quiera conquistar los corazones, debe dar a cambio su propio coraz�n.");
			frases.add("En la humildad, por debajo de todos! �En el amor, por encima de todos!");
			frases.add("El amor exige amor rec�proco, por eso es incansable en pruebas de amor.");
			frases.add("La verdadera vida consiste en amar.");
			frases.add("�El amor lleva y sobrelleva, es arriesgado y reflexivo, el amor vence todo!");
			frases.add("Mi profesi�n principal, mi deber principal y mi oraci�n principal, es y seguir� siendo: �Amar!");
			frases.add("�El amor vive del sufrimiento!");
			frases.add("�Es el sufrimiento quien alimenta y acrisola el amor!");
			frases.add("Amor y humildad es estar vinculado y ser libre de s� mismo.");
			frases.add("La cruz descifra todos los enigmas de la vida.");
			frases.add("La cruz bendice al mundo.");
			frases.add("Lleve Usted, su cruz tranquilo, humilde, valiente. �As� ayuda Ud. a salvar el mundo!");
			frases.add("�El Padre me ama!");
			frases.add("�El Padre y yo somos uno!");
			frases.add("�Qu� hermoso es poder decir que en el plan de Dios todo est� previsto desde la eternidad!");
			frases.add("Dios  es amor y por eso alegr�a eterna. Por lo tanto quien vive en Dios o quien quiere reflejarlo, debe ser al mismo tiempo  un reflejo  de la alegr�a eterna�");
			frases.add("T� sabes que te amo.");
			frases.add(" �Dios es Padre, Dios es bueno y bueno es todo lo que �l hace!");
			frases.add("�Estoy cobijado en el Padre!");
			frases.add("Sus �ngeles contemplan permanentemente el rostro del Padre.");
			frases.add("Cada ser humano es un pensamiento y un deseo de Dios.");
			frases.add("�El padre ama y protege a su hijo como la pupila de sus ojos!");
			frases.add("S�, Padre, s�. Que se haga siempre tu voluntad, ya sea que me traiga alegr�a, sufrimiento o dolor.");
			frases.add("�De la mano del Padre hacia la Patria!");
			frases.add("Dios gobierna el mundo tambi�n cuando pareciera que no se preocupa de �l");
			frases.add("�El Padre y yo somos uno!");
			frases.add("�Gu�ame seg�n tus sabios planes y se cumplir� mi �nico anhelo!");
			frases.add("Hay que arrancar toda fibra del alma que no pertenezca a Dios.");
			frases.add("El hijo es la riqueza de su Padre.");
			frases.add("Hoy comenzar�, hoy nuevamente quisiera consagrar toda mi vida al buen Dios.");
			frases.add("�D�jame ser tu corona!");
			frases.add("Se�or, despr�ndeme de m� mismo: Entonces habr�s vencido la batalla en m�.");
			frases.add("�El hijo no es nada, el Padre es todo!");
			frases.add("A los hijos m�s peque�os es a quienes m�s ama el Padre del cielo.");
			frases.add("�Ascender con los hombres y por encima de las debilidades humanas al coraz�n de Dios!");
			frases.add("�Todo lo puedo en aquel que me conforta!");
			frases.add("�Permanezco Hijo!");
			frases.add("Nuestro honor puede ser pisoteado, podemos ser triturados y desterrados, s�lo Dios tiene que vivir.");
			frases.add("�Haced lo que �l os diga!");
			frases.add("Debo estar en las cosas de mi �Padre!");
			frases.add("�El hijo es la riqueza del Padre cuando aspira al infinitismo de la peque�ez!");
			frases.add("Lo que hace el Padre siempre es bueno.");
			frases.add("�Caminar siempre, en el coraz�n del Padre, hacia el cielo!");
			frases.add("Quien hace la voluntad de mi Padre, es el que me ama.");
			frases.add("�Hago siempre lo que le da alegr�a al Padre!");
			frases.add("�Amemos profundamente a Dios, el Norte de nuestra vida!");
			frases.add("El que desea agradar a Dios, ha de aspirar a la pureza conforme a su estado.");
			frases.add("�Ens��ame a vivir cada d�a!");
			frases.add("No podemos considerarnos importantes, s�lo Dios es importante");
			frases.add("Padre, h�gase en cada instante lo que para nosotros tienes previsto.");
			frases.add("Gu�anos seg�n tus sabios planes y se cumplir� nuestro �nico anhelo.");
			frases.add("El buen Dios me ama a pesar de mi peque�ez, es m�s, a causa de mi peque�ez y miseria.");
			frases.add("Si queremos convertirnos, en gran medida, en personas espiritualizadas, debemos estar atentos a lo que Dios nos dice.");
			frases.add("�Yo s� que T� eres mi Padre y que estoy cobijado en tu coraz�n!");
			frases.add("Quien por amor a Dios pierde su vida, la ganar�.");
			frases.add("Es la voluntad e Dios, �calla!");
			frases.add("�Todo proviene de la bondad de Dios!");
			frases.add("Mi destino y el de los m�os, descansa en las manos del Padre.");
			frases.add("Se�or, perm�teme servir. Esta es mi mayor recompensa.");
			frases.add("T� eres el que realiza las obras m�s grandes s�lo por medio de los m�s peque�os Dios ama  a los peque�os y puros.");
			frases.add("Dios es un Dios de la alegr�a y de la paz.");
			frases.add("S� Padre, S� Madre. Para siempre.");
			frases.add("El Padre purifica la vida para que d� m�s fruto.");
			frases.add("Cu�ndo m�s desamparados estemos, tanto mayor debe ser nuestra confianza.");
			frases.add("Todo hombre necesita un nido, pero jam�s tendr� total tranquilidad mientras no haya hallado su nido fundamental en el coraz�n de Dios.");
			frases.add("Ser h�roe es responder siempre: �S�, Padre! A las peque�as cosas de la vida diaria.");
			frases.add("Que pueda sufrir en silencio tu voluntad, Se�or.");
			frases.add("Ponme la corona de espinas,  s�ciame con escarnios y burlas, �Nunca nada ser� demasiado dif�cil para m� cuando de TI  se trate, Se�or!");
			frases.add("Te pido todas las cruces y sufrimientos que T�, Padre, me tengas preparados.");
			frases.add("�D�jame encontrar Padre, definitivamente el camino del retorno a Ti!");
			frases.add("�Nada pasa por casualidad! todo viene de la bondad de Dios!");
			frases.add("Con la bendici�n del Padre �A trav�s de tempestades y tormentas!");
			frases.add("Hazme Padre ser un milagro de misericordia, pues soy d�bil y peque�o.");
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.frases_, menu);
		return true;
	}

}
