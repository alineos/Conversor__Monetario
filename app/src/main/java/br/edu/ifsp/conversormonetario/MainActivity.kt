package br.edu.ifsp.conversormonetario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {

  //ATRIBUTOS

    //Variavel que representa o valor para conversão do dolar.
    private val DOLLAR_VALUE = 5.50

    //Atributos da Classe: Aqui estão os objetos qye serãi vinculados à tela do aplicativo.
    private lateinit var inputEditText: EditText
    private lateinit var toDollarButton: Button
    private lateinit var toRealButton: Button
    private lateinit var outputTextView: TextView

    //MÉTODOS DE CALLBACK (cliclo de vida da activity)

    /*
    *Implementação dos métodos callback
    *(métodos que são invocados pelo sistema operacional android que altera o estado da activity)
    */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findById()
        configClickListener()
    }

    //MÉTODOS DA INTERFACE

    /*
    * Implementação do método da Interface OnClickListener.
    * O método onClick() é responsável por identificar o elemento que foi clicado na interface.
    * A view clicada é passada pelo SO como argumento do método.
    */

    override fun onClick(v: View){
        if(v == toDollarButton){
            dollarConversion()
        }else if (v == toRealButton){
            realConversion()
        }
    }

    //MÉTODOS PÚBLICOS DA CLASSE

    //MÉTODOS PRIVADOS DA CLASSE

    /*
    * O método findById() é responsável por recuperar a referencia dos elementos de interface
    * e vinculá-los aos objetos da classe.
    */
    private fun findById(){
        inputEditText = findViewById(R.id.edittext_value)
        toDollarButton = findViewById(R.id.button_convert_to_dollar)
        toRealButton = findViewById(R.id.button_convert_to_real)
        outputTextView = findViewById(R.id.textview_output)
    }

    //Configurar como será tratado o clique no botão.
    private fun configClickListener(){
        toRealButton.setOnClickListener(this)
        toDollarButton.setOnClickListener(this)
    }
    private fun getValue(): Double{
        return try {
            inputEditText.text.toString().toDouble()
        }catch (e: java.lang.NumberFormatException){
            0.0
        }
    }

    private fun dollarConversion(){
        var value = getValue()
        value = value / DOLLAR_VALUE
        outputTextView.text = "U$ $value"
    }

    private fun realConversion(){
        var value = getValue()
        value = value * DOLLAR_VALUE
        outputTextView.text = " U$ $value"
    }






























}