package com.e.marvelapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.e.marvelapp.R;
import com.e.marvelapp.model.Result;
import com.squareup.picasso.Picasso;

import static com.e.marvelapp.view.activity.MainActivity.Comics_KEY;

public class DetalheActivity extends AppCompatActivity {
    private ImageView imgFundo;
    private ImageView imgFrente;
    private TextView txtDescricao;
    private TextView txtPreco;
    private TextView txtPublicacao;
    private TextView txtPaginas;
    private TextView txtTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        txtDescricao = findViewById(R.id.text_descrecaoDetalhe);
        imgFrente = findViewById(R.id.imageFrenteDetalhe);
        imgFundo = findViewById(R.id.imageFundoDetalhe);
        txtPublicacao = findViewById(R.id.text_publicacaoDetalhe);
        txtPreco = findViewById(R.id.text_precoDetalhe);
        txtPaginas = findViewById(R.id.text_paginasDetalhe);
        txtTitulo = findViewById(R.id.text_titulo_descricaoDetalhe);

        if (getIntent() != null){
            Result result = getIntent().getParcelableExtra(Comics_KEY);

            Picasso.get().load(result.getThumbnail().getPath()+".jpg").into(imgFrente);
            Picasso.get().load(result.getThumbnail().getPath()+ ".jpg").into(imgFundo);

            txtDescricao.setText(result.getDescription());
            //txtPublicacao.setText(result.getModified());
            //txtPreco.setText(result.getPrices().get(0).getType());
            txtPaginas.setText("Tipo de Revista: " + result.getFormat());
            txtTitulo.setText(result.getTitle());


        }
    }
}
