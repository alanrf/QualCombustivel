package mobile.unisinos.br.tarefa3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class QualCombustivelActivity extends BaseActivity {

    private EditText edAlcoolConsumo;
    private EditText edAlcoolValor;
    private EditText edGasolinaConsumo;
    private EditText edGasolinaValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qual_combustivel);

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

        /**
         * Atribui os campos de tela aos atributos internos da activity (para facilitar rotinas de
         * validação e limpeza de campos.
         */
    private void bindCampos() {
        edAlcoolConsumo = (EditText) findViewById(R.id.edAlcoolConsumo);
        edAlcoolValor = (EditText) findViewById(R.id.edAlcoolValor);
        edGasolinaConsumo = (EditText) findViewById(R.id.edGasolinaConsumo);
        edGasolinaValor = (EditText) findViewById(R.id.edGasolinaValor);
    }

    /**
     * Limpa o conteúdo dos campos
     */
    private void limparCampos() {
        edAlcoolConsumo.setText("");
        edAlcoolValor.setText("");
        edGasolinaConsumo.setText("");
        edGasolinaValor.setText("");
    }

    /**
     * Valida se os campos estão preenchidos
     * @return boolean
     */
    private boolean validaCampos() {
        return  campoPreenchido(edGasolinaValor) &&
                campoPreenchido(edGasolinaConsumo) &&
                campoPreenchido(edAlcoolValor) &&
                campoPreenchido(edAlcoolConsumo);
    }



    /**
     * Realiza o calculo para ver qual vale mais a pena.
     */
    private void calcularResultado() {
        escondeTeclado();

        if (validaCampos()) {
            CharSequence strValeMais;
            //Calcula
            try {
                double vlrAlcool = Double.valueOf(edAlcoolValor.getText().toString()) / Double.valueOf(edAlcoolConsumo.getText().toString());
                double vlrGasolina = Double.valueOf(edGasolinaValor.getText().toString()) / Double.valueOf(edGasolinaConsumo.getText().toString());
                if (vlrAlcool < vlrGasolina) {
                    strValeMais = "Álcool é mais recomendado.";
                } else {
                    strValeMais = "Gasolina é mais recomendado.";
                }
            } catch (Exception e) {
                //Erro de calculo por motivo aleatorio
                strValeMais = "Ocorreu um erro ao calcular os valores, então recomendamos que " +
                        "você deixe o carro em casa e pegue um meio de transporte alternativo " +
                        "como Ônibus, Bicicleta, Carona, Taxi, Uber ou vá a pé.";

                e.printStackTrace();
            }

            exibeMensagem(strValeMais);
        }
    }
}
