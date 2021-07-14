package com.ingrid.api_jsonplaceholder

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import api.DataService
import model.Foto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private lateinit var btnRecupera: Button
private lateinit var txtResultado: TextView
private lateinit var retrofit: Retrofit
private lateinit var  listaFoto: List<Foto>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindView()
        recuperarListaRetrofit()

      retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun recuperarListaRetrofit() {
        val service:DataService = retrofit.create(DataService::class.java)
        val edtDados = findViewById<EditText>(R.id.edtDados)
        val call: Call<List<Foto>> = service.recuperDados(edtDados.toString())
        call.enqueue(object : Callback<List<Foto?>> {

                override fun onResponse(call: Call<List<Foto?>>, response: Response<List<Foto?>>) {
                if (response.isSuccessful) {
                    listaFoto = response.body() as List<Foto>

                    for (i in 0..listaFoto.size) {
                        val foto = listaFoto.get(i)
                        txtResultado.text = foto.albumId()
                    }
                }
            }

            override fun onFailure(call: Call<List<Foto?>>, t: Throwable) {
                txtResultado.text = "Erro no sistema. Alguém me desconfigurou"
            }
        })
            /* val dataService:DataService = retrofit.create(DataService::class.java)
            var edtCep = findViewById<EditText>(R.id.edtDados)
            dataService.recuperDados(edtCep.text.toString()).enqueue(object: Callback<List<Foto?>> {

                override fun onResponse(
                    call: Call<Foto>,
                    response: Response<Foto?>,
                ) {
                    if (response.isSuccessful()){
                        var cep = response.body()
                     /*  txtResultado.text=(( cep?.getCep()  ) +'-'+  cep?.getLogradouro() + '-'+ (cep?.getBairro()+ '-'
                                + (cep?.getComplemento() +'-'
                                + cep?.getLocalidade() +'/'+ cep?.getUf() )))*/
                    }
                }

                override fun onFailure(call: Call<Foto>, t: Throwable) {
                    Log.e("EnderecoRepository", "onFailure: falha ao buscar o endereço", t)
                }

            })
        }*/
    }
    private fun bindView() {
        btnRecupera = findViewById(R.id.btnRecupera)
        txtResultado = findViewById(R.id.txtResultado)
    }
}

private fun <T> Call<T>.enqueue(callback: Callback<List<Foto?>>) {

}
