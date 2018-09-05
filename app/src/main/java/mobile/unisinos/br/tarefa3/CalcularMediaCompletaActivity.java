package mobile.unisinos.br.tarefa3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalcularMediaCompletaActivity extends BaseActivity {

    private EditText edKmInicial;
    private EditText edKmFinal;
    private EditText edAbastecimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_media_completa);

        bindCampos();

        Button btLimpar = (Button) findViewById(R.id.btLimpar);
        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limparCampos();
            }
        });

        Button btCalcular = (Button) findViewById(R.id.btCalcular);
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularResultado();
            }
        });

        Button btVoltar = (Button) findViewById(R.id.btVoltar);
        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void bindCampos() {
        edKmInicial = (EditText) findViewById(R.id.edKmInicial);
        edKmFinal = (EditText) findViewById(R.id.edKmFinal);
        edAbastecimento = (EditText) findViewById(R.id.edAbastecimento);
    }

    private void limparCampos() {
        edKmInicial.setText("");
        edKmFinal.setText("");
        edAbastecimento.setText("");
    }


    private boolean validaCampos() {
        boolean resultado = campoPreenchido(edKmInicial) &&
                campoPreenchido(edKmFinal) &&
                campoPreenchido(edAbastecimento);

        if (resultado) {
            resultado = Double.valueOf(edKmFinal.getText().toString()) >= Double.valueOf(edKmInicial.getText().toString());
            if (!resultado) {
                edKmFinal.setError("Km Final deve ser maior ou igual a Km Inicial.");
            }
        }

        return resultado;
    }


    private void calcularResultado() {
        escondeTeclado();
        if (validaCampos()) {
            CharSequence strMedia;
            //Calcula
            try {
                double vlrAbastecimento = Double.valueOf(edAbastecimento.getText().toString());
                double vlrDistancia = Double.valueOf(edKmFinal.getText().toString()) - Double.valueOf(edKmInicial.getText().toString());

                double resultado = vlrDistancia / vlrAbastecimento;
                strMedia = String.format("Consumo calculado: %.2f Km/L", resultado);
            } catch (Exception e) {
                //Erro de calculo por motivo aleatorio
                strMedia = "Ocorreu um erro ao calcular os valores.";
                e.printStackTrace();
            }

            exibeMensagem(strMedia);
        }
    }
}
