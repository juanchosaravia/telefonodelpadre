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

				Toast.makeText(getApplicationContext(), "El Padre te va a llamar cada un día.",
						Toast.LENGTH_LONG).show();
			}
		});
		
		cancelarButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mAlarmManager.cancel(mNotificationReceiverPendingIntent);
				
				Toast.makeText(getApplicationContext(), "El Padre ya no te llamará  :(",
						Toast.LENGTH_LONG).show();
			}
		});
	}

	private void loadFrases() {
		if (frases.size() <= 0) {
			frases.add("El que mantiene siempre abiertos el corazón y los sentidos para lo que le agrada a Dios, permanece joven hasta edad avanzada, porque nunca le falta la fuerza del amor.");		
			frases.add("Adorar significa, en el sentido más amplio, cumplir por amor la voluntad de Dios.");
			frases.add("La alegría debe irradiarse en nuestro propio  rostro.");
			frases.add("Padre en la simplicidad de mi corazón, te entrego hoy todo con alegría.");
			frases.add("Nada me quitará la alegría.");
			frases.add("Creo firmemente que nunca perecerá quien permanece fiel a su Alianza de amor.");
			frases.add("El amor de Dios es la ley básica universal.");
			frases.add("No hay nada mejor que el amor, nada más grande que el amor, nada más hermoso que el amor.");
			frases.add("El amor verdadero no se aísla nunca.");
			frases.add("El que ama hace lo que le da alegría al amado.");
			frases.add("Quien quiera conquistar los corazones, debe dar a cambio su propio corazón.");
			frases.add("En la humildad, por debajo de todos! ¡En el amor, por encima de todos!");
			frases.add("El amor exige amor recíproco, por eso es incansable en pruebas de amor.");
			frases.add("La verdadera vida consiste en amar.");
			frases.add("¡El amor lleva y sobrelleva, es arriesgado y reflexivo, el amor vence todo!");
			frases.add("Mi profesión principal, mi deber principal y mi oración principal, es y seguirá siendo: ¡Amar!");
			frases.add("¡El amor vive del sufrimiento!");
			frases.add("¡Es el sufrimiento quien alimenta y acrisola el amor!");
			frases.add("Amor y humildad es estar vinculado y ser libre de sí mismo.");
			frases.add("La cruz descifra todos los enigmas de la vida.");
			frases.add("La cruz bendice al mundo.");
			frases.add("Lleve Usted, su cruz tranquilo, humilde, valiente. ¡Así ayuda Ud. a salvar el mundo!");
			frases.add("¡El Padre me ama!");
			frases.add("¡El Padre y yo somos uno!");
			frases.add("¡Qué hermoso es poder decir que en el plan de Dios todo está previsto desde la eternidad!");
			frases.add("Dios  es amor y por eso alegría eterna. Por lo tanto quien vive en Dios o quien quiere reflejarlo, debe ser al mismo tiempo  un reflejo  de la alegría eterna…");
			frases.add("Tú sabes que te amo.");
			frases.add(" ¡Dios es Padre, Dios es bueno y bueno es todo lo que Él hace!");
			frases.add("¡Estoy cobijado en el Padre!");
			frases.add("Sus ángeles contemplan permanentemente el rostro del Padre.");
			frases.add("Cada ser humano es un pensamiento y un deseo de Dios.");
			frases.add("¡El padre ama y protege a su hijo como la pupila de sus ojos!");
			frases.add("Sí, Padre, sí. Que se haga siempre tu voluntad, ya sea que me traiga alegría, sufrimiento o dolor.");
			frases.add("¡De la mano del Padre hacia la Patria!");
			frases.add("Dios gobierna el mundo también cuando pareciera que no se preocupa de él");
			frases.add("¡El Padre y yo somos uno!");
			frases.add("¡Guíame según tus sabios planes y se cumplirá mi único anhelo!");
			frases.add("Hay que arrancar toda fibra del alma que no pertenezca a Dios.");
			frases.add("El hijo es la riqueza de su Padre.");
			frases.add("Hoy comenzaré, hoy nuevamente quisiera consagrar toda mi vida al buen Dios.");
			frases.add("¡Déjame ser tu corona!");
			frases.add("Señor, despréndeme de mí mismo: Entonces habrás vencido la batalla en mí.");
			frases.add("¡El hijo no es nada, el Padre es todo!");
			frases.add("A los hijos más pequeños es a quienes más ama el Padre del cielo.");
			frases.add("¡Ascender con los hombres y por encima de las debilidades humanas al corazón de Dios!");
			frases.add("¡Todo lo puedo en aquel que me conforta!");
			frases.add("¡Permanezco Hijo!");
			frases.add("Nuestro honor puede ser pisoteado, podemos ser triturados y desterrados, sólo Dios tiene que vivir.");
			frases.add("¡Haced lo que Él os diga!");
			frases.add("Debo estar en las cosas de mi ¡Padre!");
			frases.add("¡El hijo es la riqueza del Padre cuando aspira al infinitismo de la pequeñez!");
			frases.add("Lo que hace el Padre siempre es bueno.");
			frases.add("¡Caminar siempre, en el corazón del Padre, hacia el cielo!");
			frases.add("Quien hace la voluntad de mi Padre, es el que me ama.");
			frases.add("¡Hago siempre lo que le da alegría al Padre!");
			frases.add("¡Amemos profundamente a Dios, el Norte de nuestra vida!");
			frases.add("El que desea agradar a Dios, ha de aspirar a la pureza conforme a su estado.");
			frases.add("¡Enséñame a vivir cada día!");
			frases.add("No podemos considerarnos importantes, sólo Dios es importante");
			frases.add("Padre, hágase en cada instante lo que para nosotros tienes previsto.");
			frases.add("Guíanos según tus sabios planes y se cumplirá nuestro único anhelo.");
			frases.add("El buen Dios me ama a pesar de mi pequeñez, es más, a causa de mi pequeñez y miseria.");
			frases.add("Si queremos convertirnos, en gran medida, en personas espiritualizadas, debemos estar atentos a lo que Dios nos dice.");
			frases.add("¡Yo sé que Tú eres mi Padre y que estoy cobijado en tu corazón!");
			frases.add("Quien por amor a Dios pierde su vida, la ganará.");
			frases.add("Es la voluntad e Dios, ¡calla!");
			frases.add("¡Todo proviene de la bondad de Dios!");
			frases.add("Mi destino y el de los míos, descansa en las manos del Padre.");
			frases.add("Señor, permíteme servir. Esta es mi mayor recompensa.");
			frases.add("Tú eres el que realiza las obras más grandes sólo por medio de los más pequeños Dios ama  a los pequeños y puros.");
			frases.add("Dios es un Dios de la alegría y de la paz.");
			frases.add("Sí Padre, Sí Madre. Para siempre.");
			frases.add("El Padre purifica la vida para que dé más fruto.");
			frases.add("Cuándo más desamparados estemos, tanto mayor debe ser nuestra confianza.");
			frases.add("Todo hombre necesita un nido, pero jamás tendrá total tranquilidad mientras no haya hallado su nido fundamental en el corazón de Dios.");
			frases.add("Ser héroe es responder siempre: ¡Sí, Padre! A las pequeñas cosas de la vida diaria.");
			frases.add("Que pueda sufrir en silencio tu voluntad, Señor.");
			frases.add("Ponme la corona de espinas,  sáciame con escarnios y burlas, ¡Nunca nada será demasiado difícil para mí cuando de TI  se trate, Señor!");
			frases.add("Te pido todas las cruces y sufrimientos que Tú, Padre, me tengas preparados.");
			frases.add("¡Déjame encontrar Padre, definitivamente el camino del retorno a Ti!");
			frases.add("¡Nada pasa por casualidad! todo viene de la bondad de Dios!");
			frases.add("Con la bendición del Padre ¡A través de tempestades y tormentas!");
			frases.add("Hazme Padre ser un milagro de misericordia, pues soy débil y pequeño.");
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.frases_, menu);
		return true;
	}

}
