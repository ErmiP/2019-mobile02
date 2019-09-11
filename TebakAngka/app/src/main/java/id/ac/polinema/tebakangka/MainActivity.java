package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	private TextView tvInput;
	private Button btTebak, btReset;
	private int angkaRandom;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		tvInput = findViewById(R.id.number_input);
		btTebak = findViewById(R.id.guess_button);
		btReset = findViewById(R.id.reset_button);
		initRandomNumber();
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
	Random random = new Random();
	int min = 1;
	int max = 100;
	angkaRandom = random.nextInt(max-min)+min;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		int inputan = Integer.parseInt(tvInput.getText().toString());
		final AlertDialog.Builder builder = new AlertDialog.Builder(this);
		if(inputan==angkaRandom){
			builder.setMessage("Tebakan Anda Benar!");
			btTebak.setEnabled(false);
		}
		else if(inputan > angkaRandom){
			builder.setMessage("Tebakan Anda Terlalu Besar!");
		}
		else if (inputan < angkaRandom){
			builder.setMessage("Tebakan Anda Terlalu Kecil!");
		}
		AlertDialog dialog = builder.create();
		dialog.show();

	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		tvInput.setText("");
		btTebak.setEnabled(true);
		initRandomNumber();
	}
}
