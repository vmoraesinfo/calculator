package br.vinicius.moraes.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<View> allButtons;
        allButtons = ((LinearLayout) findViewById(R.id.frame)).getTouchables();
        for(View v: allButtons){
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String acao = ((TextView) view).getText().toString();
                    if(acao.equals("=")){
                        calccula();
                    }else {
                        adicionarNumero(view);
                    }
                }
            });
        }


    }

    public void adicionarNumero(View view) {
        String numero = ((TextView) view).getText().toString();
        TextView resultado = ((TextView) findViewById(R.id.resultado));
        resultado.setText(resultado.getText() + numero);
    }

    public void calccula(){
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("javascript");
        TextView resultado = ((TextView) findViewById(R.id.resultado));
        try {
            resultado.setText(engine.eval(resultado.getText().toString()).toString());
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
