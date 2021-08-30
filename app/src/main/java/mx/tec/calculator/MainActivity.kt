package mx.tec.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnCero: Button;
    lateinit var btnUno: Button;
    lateinit var btnDos: Button;
    lateinit var btnTres: Button;
    lateinit var btnCuatro: Button;
    lateinit var btnCinco: Button;
    lateinit var btnSeis: Button;
    lateinit var btnSiete: Button;
    lateinit var btnOcho: Button;
    lateinit var btnNueve: Button;
    lateinit var btnMas: Button;
    lateinit var btnMenos: Button;
    lateinit var btnEntre: Button;
    lateinit var btnPor: Button;
    lateinit var btnIgual: Button;
    lateinit var btnClear: Button;

    private var operacion: Char = ' ';
    private var num1: Double = 0.0;
    private var num2: Double = 0.0;
    private var num3: Double = 0.0;

    lateinit var txtResultado: TextView;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCero = findViewById(R.id.btnCero)
        btnUno = findViewById(R.id.btnUno)
        btnDos = findViewById(R.id.btnDos)
        btnTres = findViewById(R.id.btnTres)
        btnCuatro = findViewById(R.id.btnCuatro)
        btnCinco = findViewById(R.id.btnCinco)
        btnSeis = findViewById(R.id.btnSeis)
        btnSiete = findViewById(R.id.btnSiete)
        btnOcho = findViewById(R.id.btnOcho)
        btnNueve = findViewById(R.id.btnNueve)
        btnMas = findViewById(R.id.btnMas)
        btnMenos = findViewById(R.id.btnMenos)
        btnEntre = findViewById(R.id.btnEntre)
        btnPor = findViewById(R.id.btnPor)
        btnIgual = findViewById(R.id.btnIgual)
        btnClear = findViewById(R.id.btnClear)



        txtResultado = findViewById(R.id.txtResultado)

        btnCero.setOnClickListener(this)
        btnUno.setOnClickListener(this)
        btnDos.setOnClickListener(this)
        btnTres.setOnClickListener(this)
        btnCuatro.setOnClickListener(this)
        btnCinco.setOnClickListener(this)
        btnSeis.setOnClickListener(this)
        btnSiete.setOnClickListener(this)
        btnOcho.setOnClickListener(this)
        btnNueve.setOnClickListener(this)
        btnMas.setOnClickListener(this)
        btnMenos.setOnClickListener(this)
        btnEntre.setOnClickListener(this)
        btnPor.setOnClickListener(this)
        btnIgual.setOnClickListener(this)
        btnClear.setOnClickListener(this)
    }

    private fun realizarOperacion(n1: Double, n2: Double, op: Char){
        num3 = when (op){
            '+' -> num1 + num2
            '-' -> num1 - num2
            '*' -> num1 * num2
            '/' -> num1 / num2
            else -> 0.0
        }
        txtResultado.text = num3.toString()
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.btnCero ->{
                txtResultado.text = txtResultado.text.toString() + "0"
            }
            R.id.btnUno ->{
                txtResultado.text = txtResultado.text.toString() + "1"
            }
            R.id.btnDos ->{
                txtResultado.text = txtResultado.text.toString() + "2"
            }
            R.id.btnTres ->{
                txtResultado.text = txtResultado.text.toString() + "3"
            }
            R.id.btnCuatro ->{
                txtResultado.text = txtResultado.text.toString() + "4"
            }
            R.id.btnCinco ->{
                txtResultado.text = txtResultado.text.toString() + "5"
            }
            R.id.btnSeis ->{
                txtResultado.text = txtResultado.text.toString() + "6"
            }
            R.id.btnSiete ->{
                txtResultado.text = txtResultado.text.toString() + "7"
            }
            R.id.btnOcho ->{
                txtResultado.text = txtResultado.text.toString() + "8"
            }
            R.id.btnNueve ->{
                txtResultado.text = txtResultado.text.toString() + "9"
            }
            R.id.btnClear -> {
                num1 = 0.0
                num2 = 0.0
                num3 = 0.0
                operacion = ' '
                txtResultado.text = ""
            }

            R.id.btnMas -> {
                val myString = txtResultado.text.toString()
                if(myString.length > 0){
                    num1 = myString.toDouble()
                    operacion = '+'
                    txtResultado.text = ""
                }else {
                    num1  = 0.0
                    operacion = '+'
                    txtResultado.text = ""
                }
                println("---> num1: $num1")
                println("---> operator: $operacion")
                println("---> num2: $num2")
                println("---> res: $txtResultado")
            }
            R.id.btnPor-> {
                val myString = txtResultado.text.toString()
                if(myString.length > 0){
                    num1 = myString.toDouble()
                    operacion = '*'
                    txtResultado.text = ""
                }else {
                    num1  = 0.0
                    operacion = '*'
                    txtResultado.text = ""
                }
                println("---> num1: $num1")
                println("---> operator: $operacion")
                println("---> num2: $num2")
            }
            R.id.btnMenos -> {
                val myString = txtResultado.text.toString()
                if(myString.length > 0){
                    num1 = myString.toDouble()
                    operacion = '-'
                    txtResultado.text = ""
                }else {
                    num1  = 0.0
                    operacion = '-'
                    txtResultado.text = ""
                }
                println("---> num1: $num1")
            }
            R.id.btnEntre -> {
                val myString = txtResultado.text.toString()
                if(myString.length > 0){
                    num1 = myString.toDouble()
                    operacion = '/'
                    txtResultado.text = ""
                }else {
                    num1  = 0.0
                    operacion = '/'
                    txtResultado.text = ""
                }
                println("---> num1: $num1")
            }
            R.id.btnIgual -> {
                if (num1 != 0.0 && operacion != ' '){
                    val myString = txtResultado.text.toString()
                    num2 = myString.toDouble()
                    if (num2 == 0.0) {
                        txtResultado.text = "0.0"
                    }
                    else {
                        realizarOperacion(num1,num2,operacion)
                    }

                } else {
                    txtResultado.text = ""
                }

            }
        }
    }
}

