package mobile.unisinos.br.tarefa3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GastoEstimadoActivity extends BaseActivity {

    private EditText edConsumo;
    private EditText edDistancia;
    private EditText edValorCombustivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gasto_estimado);

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
        edConsumo = (EditText) findViewById(R.id.edConsumo);
        edDistancia = (EditText) findViewById(R.id.edDistancia);
        edValorCombustivel = (EditText) findViewById(R.id.edValorCombustivel);
    }

    private void limparCampos() {
        edConsumo.setText("");
        edDistancia.setText("");
        edValorCombustivel.setText("");
    }


    private boolean validaCampos() {
        return campoPreenchido(edConsumo) &&
                campoPreenchido(edDistancia) &&
                campoPreenchido(edValorCombustivel);
    }


    private void calcularResultado() {
        escondeTeclado();
        if (validaCampos()) {
            CharSequence strMedia;
            //Calcula
            try {
                double vlrAbastecimento = Double.valueOf(edValorCombustivel.getText().toString());
                double vlrDistancia = Double.valueOf(edDistancia.getText().toString());
                double vlrConsumo = Double.valueOf(edConsumo.getText().toString());

                double resultado = (vlrDistancia / vlrConsumo) * vlrAbastecimento;
                strMedia = String.format("Gasto estimado: R$ %.2f", resultado);
            } catch (Exception e) {
                //Erro de calculo por motivo aleatorio
                strMedia = "Ocorreu um erro ao calcular os valores.";
                e.printStackTrace();
            }

            exibeMensagem(strMedia);
        }
    }
}
