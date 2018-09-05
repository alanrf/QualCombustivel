package mobile.unisinos.br.tarefa3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalcularMediaSimplesActivity extends BaseActivity {

    private EditText edAbastecimento;
    private EditText edKmRodados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_media_simples);

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
        edAbastecimento = (EditText) findViewById(R.id.edAbastecimento);
        edKmRodados = (EditText) findViewById(R.id.edKmRodados);
    }

    private void limparCampos() {
        edAbastecimento.setText("");
        edKmRodados.setText("");
    }


    private boolean validaCampos() {
        return  campoPreenchido(edKmRodados) &&
                campoPreenchido(edAbastecimento);
    }


    private void calcularResultado() {
        escondeTeclado();
        if (validaCampos()) {
            CharSequence strMedia;
            //Calcula
            try {
                double vlrAbastecimento = Double.valueOf(edAbastecimento.getText().toString());
                double vlrDistancia = Double.valueOf(edKmRodados.getText().toString());

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
