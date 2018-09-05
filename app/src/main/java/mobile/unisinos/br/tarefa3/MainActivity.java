package mobile.unisinos.br.tarefa3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindBotoes();
    }

    private void bindBotoes() {
        TextView btOpcao1 = (TextView) findViewById(R.id.lbOpcao1);
        btOpcao1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, QualCombustivelActivity.class);
                startActivity(it);
            }
        });

        TextView btOpcao2 = (TextView) findViewById(R.id.lbOpcao2);
        btOpcao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, CalcularMediaSimplesActivity.class);
                startActivity(it);
            }
        });

        TextView btOpcao3 = (TextView) findViewById(R.id.lbOpcao3);
        btOpcao3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, CalcularMediaCompletaActivity.class);
                startActivity(it);
            }
        });

        TextView btOpcao4 = (TextView) findViewById(R.id.lbOpcao4);
        btOpcao4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, GastoEstimadoActivity.class);
                startActivity(it);
            }
        });
    }
}
