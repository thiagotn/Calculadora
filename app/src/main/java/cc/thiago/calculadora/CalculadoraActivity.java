package cc.thiago.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculadoraActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String SUBTRAIR = "-";
    private static final String SOMAR = "+";
    private static final String MULTIPLICAR = "*";
    private static final String DIVIDIR = "/";

    private Button btMenos;
    private Button btMais;
    private Button btVezes;
    private Button btDividir;
    private Button btCalcular;
    private EditText etCampo1;
    private EditText etCampo2;
    private TextView tvCampoMeio;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        btMenos = (Button) findViewById(R.id.bt_menos);
        btMenos.setOnClickListener(this);

        btMais = (Button) findViewById(R.id.bt_mais);
        btMais.setOnClickListener(this);

        btVezes = (Button) findViewById(R.id.bt_vezes);
        btVezes.setOnClickListener(this);

        btDividir = (Button) findViewById(R.id.bt_dividir);
        btDividir.setOnClickListener(this);

        btCalcular = (Button) findViewById(R.id.bt_calcular);
        btCalcular.setOnClickListener(this);

        etCampo1 = (EditText) findViewById(R.id.et_campo1);
        etCampo2 = (EditText) findViewById(R.id.et_campo2);
        tvCampoMeio = (TextView) findViewById(R.id.et_campoMeio);
        tvResultado = (TextView) findViewById(R.id.tv_resultado);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_menos) {
            tvCampoMeio.setText(SUBTRAIR);
        }

        if (v.getId() == R.id.bt_mais) {
            tvCampoMeio.setText(SOMAR);
        }

        if (v.getId() == R.id.bt_vezes) {
            tvCampoMeio.setText(MULTIPLICAR);
        }

        if (v.getId() == R.id.bt_dividir) {
            tvCampoMeio.setText(DIVIDIR);
        }

        if (v.getId() == R.id.bt_calcular) {
            if (TextUtils.isEmpty(etCampo1.getText().toString()) || TextUtils.isEmpty(etCampo2.getText().toString())) {
                Toast.makeText(this, "Preenchar os campos antes de calcular!", Toast.LENGTH_LONG).show();
                return;
            }

            Double valor1 = Double.parseDouble(etCampo1.getText().toString());
            Double valor2 = Double.parseDouble(etCampo2.getText().toString());

            String operacaoSelecionada = tvCampoMeio.getText().toString();

            calcular(valor1, valor2, operacaoSelecionada);
        }
    }

    private void calcular(Double valor1, Double valor2, String operacao) {
        if (operacao.equals(SUBTRAIR)) {
            Double resultado = valor1 - valor2;
            tvResultado.setText(String.valueOf(resultado));
        } else if (operacao.equals(SOMAR)) {
            Double resultado = valor1 + valor2;
            tvResultado.setText(String.valueOf(resultado));
        } else if (operacao.equals(MULTIPLICAR)) {
            Double resultado = valor1 * valor2;
            tvResultado.setText(String.valueOf(resultado));
        } else if (operacao.equals(DIVIDIR)) {
            Double resultado = valor1 / valor2;
            tvResultado.setText(String.valueOf(resultado));
        }
    }
}
