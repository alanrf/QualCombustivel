package mobile.unisinos.br.tarefa3;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Valida se o campo está vazio
     * @return boolean
     */
    protected boolean campoPreenchido(EditText ed) {
        if (ed.getText() == null || "".equals(ed.getText().toString().trim())) {
            ed.setError("Este campo deve estar preenchido com um valor.");
            return false;
        }
        return true;
    }

    /**
     * Método para ocultar o teclado virtual que fica sobre o texto.
     */
    protected void escondeTeclado() {
        try {
            View view = this.getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (Exception e) {
            // esconder exceção, caso ocorra, esse código é apenas para tentar ocultar o teclado
            // para a mensagem ficar mais visivel
        }
    }

    /**
     * Exibe uma mensagem na tela (Toast)
     */
    protected void exibeMensagem(CharSequence strMensagem) {
        Toast toast = Toast.makeText(getApplicationContext(), strMensagem, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }
}
