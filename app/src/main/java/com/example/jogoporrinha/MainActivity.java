package com.example.jogoporrinha;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnPalito0, btnPalito1, btnPalito2, btnPalito3;
    Button btnPalpite0, btnPalpite1, btnPalpite2, btnPalpite3, btnPalpite4, btnPalpite5, btnPalpite6, btnNovaRodada;

    ImageView imgMinhaMao, imgMaoCpu;
    TextView txtMostraPalpiteCpu, txtMostraMeuPalpite, txtMostraResultado , txtContaVitoriaCPU, txtContaVitoriaEu;

    Integer palitosMinhaMao, meuPalpite, palitosMaoCpu, resultado;
    int cpu, Pcpu, contaVitoriaCPU = 0, contaVitoriaEU = 0;

    String result;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Porrinha Brasil");


        btnPalito0 = findViewById(R.id.btnPalito0);
        btnPalito1 = findViewById(R.id.btnPalito1);
        btnPalito2 = findViewById(R.id.btnPalito2);
        btnPalito3 = findViewById(R.id.btnPalito3);
        btnPalpite0 = findViewById(R.id.btnPalpite0);
        btnPalpite1 = findViewById(R.id.btnPalpite1);
        btnPalpite2 = findViewById(R.id.btnPalpite2);
        btnPalpite3 = findViewById(R.id.btnPalpite3);
        btnPalpite4 = findViewById(R.id.btnPalpite4);
        btnPalpite5 = findViewById(R.id.btnPalpite5);
        btnPalpite6 = findViewById(R.id.btnPalpite6);
        btnNovaRodada = findViewById(R.id.btnNovaRodada);

        txtMostraPalpiteCpu = findViewById(R.id.txtMostraPalpiteCpu);
        txtMostraResultado = findViewById(R.id.txtMostraResultado);
        txtMostraMeuPalpite = findViewById(R.id.txtMostraMeuPalpite);
        txtContaVitoriaCPU = findViewById(R.id.txtContaVitoriaCPU);
        txtContaVitoriaEu = findViewById(R.id.txtContaVitoriaEu);

        imgMinhaMao = findViewById(R.id.imgMinhaMao);
        imgMaoCpu = findViewById(R.id.imgMaoCpu);

        btnPalpite0.setEnabled(false);
        btnPalpite1.setEnabled(false);
        btnPalpite2.setEnabled(false);
        btnPalpite3.setEnabled(false);
        btnPalpite4.setEnabled(false);
        btnPalpite5.setEnabled(false);
        btnPalpite6.setEnabled(false);

        r = new Random();


        //VALIDAÇÃO DOS BOTÕES DE ESCOLHA DOS PALITOS********************

        btnPalito0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                palitosMinhaMao = 0;
                btnPalito0.setTextColor(Color.RED);
                btnPalito1.setTextColor(Color.BLACK);
                btnPalito2.setTextColor(Color.BLACK);
                btnPalito3.setTextColor(Color.BLACK);
                btnPalpite0.setEnabled(true);
                btnPalpite1.setEnabled(true);
                btnPalpite2.setEnabled(true);
                btnPalpite3.setEnabled(true);
                btnPalpite4.setEnabled(false);
                btnPalpite5.setEnabled(false);
                btnPalpite6.setEnabled(false);

            }
        });

        btnPalito1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                palitosMinhaMao = 1;
                btnPalito0.setTextColor(Color.BLACK);
                btnPalito1.setTextColor(Color.RED);
                btnPalito2.setTextColor(Color.BLACK);
                btnPalito3.setTextColor(Color.BLACK);
                btnPalpite1.setEnabled(true);
                btnPalpite2.setEnabled(true);
                btnPalpite3.setEnabled(true);
                btnPalpite4.setEnabled(true);
                btnPalpite5.setEnabled(false);
                btnPalpite6.setEnabled(false);

            }
        });
        btnPalito2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                palitosMinhaMao = 2;
                btnPalito0.setTextColor(Color.BLACK);
                btnPalito1.setTextColor(Color.BLACK);
                btnPalito2.setTextColor(Color.RED);
                btnPalito3.setTextColor(Color.BLACK);
                btnPalpite0.setEnabled(false);
                btnPalpite1.setEnabled(false);
                btnPalpite2.setEnabled(true);
                btnPalpite3.setEnabled(true);
                btnPalpite4.setEnabled(true);
                btnPalpite5.setEnabled(true);
                btnPalpite6.setEnabled(false);

            }
        });
        btnPalito3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                palitosMinhaMao = 3;
                btnPalito1.setTextColor(Color.BLACK);
                btnPalito0.setTextColor(Color.BLACK);
                btnPalito2.setTextColor(Color.BLACK);
                btnPalito3.setTextColor(Color.RED);
                btnPalpite0.setEnabled(false);
                btnPalpite1.setEnabled(false);
                btnPalpite2.setEnabled(false);
                btnPalpite3.setEnabled(true);
                btnPalpite4.setEnabled(true);
                btnPalpite5.setEnabled(true);
                btnPalpite6.setEnabled(true);
            }
        });

        //VALIDAÇÃO DOS BOTÕES DE ESCOLHAS DOS PALPITES*******************

        btnPalpite0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                meuPalpite = 0;

                 if (palitosMinhaMao == 0) {
                    imgMinhaMao.setImageResource(R.drawable.lona);
                    calcular();
                }
            }

        });

        btnPalpite1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                meuPalpite = 1;

                switch (palitosMinhaMao) {

                    case 0:
                        imgMinhaMao.setImageResource(R.drawable.lona);
                        calcular();
                        break;
                    case 1:
                        imgMinhaMao.setImageResource(R.drawable.um);
                        calcular();
                        break;
                }}
        });

        btnPalpite2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                meuPalpite = 2;

                switch (palitosMinhaMao) {

                    case 0:
                        imgMinhaMao.setImageResource(R.drawable.lona);
                        calcular();
                        break;
                    case 1:
                        imgMinhaMao.setImageResource(R.drawable.um);
                        calcular();
                        break;
                    case 2:
                        imgMinhaMao.setImageResource(R.drawable.dois);
                        calcular();
                        break;
                }}
        });

        btnPalpite3.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       meuPalpite = 3;
                       switch (palitosMinhaMao) {

                           case 0:
                               imgMinhaMao.setImageResource(R.drawable.lona);
                               calcular();
                               break;
                           case 1:
                               imgMinhaMao.setImageResource(R.drawable.um);
                               calcular();
                               break;
                           case 2:
                               imgMinhaMao.setImageResource(R.drawable.dois);
                               calcular();
                               break;
                           case 3:
                               imgMinhaMao.setImageResource(R.drawable.tres);
                               calcular();
                               break;
                   } }
        });

        btnPalpite4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                meuPalpite = 4;
                switch (palitosMinhaMao) {

                    case 1:
                        imgMinhaMao.setImageResource(R.drawable.um);
                        calcular();
                        break;
                    case 2:
                        imgMinhaMao.setImageResource(R.drawable.dois);
                        calcular();
                        break;
                    case 3:
                        imgMinhaMao.setImageResource(R.drawable.tres);
                        calcular();
                        break;
                }
            }
        });


        btnPalpite5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                meuPalpite = 5;
                switch (palitosMinhaMao) {

                    case 2:
                        imgMinhaMao.setImageResource(R.drawable.dois);
                        calcular();
                        break;
                    case 3:
                        imgMinhaMao.setImageResource(R.drawable.tres);
                        calcular();
                        break;
                }
            }
        });

        btnPalpite6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                meuPalpite = 6;

                if (palitosMinhaMao == 3) {
                    imgMinhaMao.setImageResource(R.drawable.tres);
                    calcular();
                }
            }

        });

        //BOTÃO QUE INICIA NOVA RODADA
        btnNovaRodada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                iniciaRodada();
            }
        });
    }

    //CALCULO DO VENCEDOR************************************************
    public void calcular() {

        validaCPU();

        if (cpu == 0) {
            palitosMaoCpu = 0;
            imgMaoCpu.setImageResource(R.drawable.lona);

            if (meuPalpite == palitosMaoCpu + palitosMinhaMao) {
                result = " PARABÉNS, Você venceu !!";
                contaVitoriaEU++;
            } else if (Pcpu == palitosMaoCpu + palitosMinhaMao) {
                result = " A CPU venceu !!";
                contaVitoriaCPU++;
            } else if ((meuPalpite != palitosMaoCpu + palitosMinhaMao) && (Pcpu != palitosMaoCpu + palitosMinhaMao)) {
                result = " Não houve vencedor.";
            }
        }

        if (cpu == 1) {
            palitosMaoCpu = 1;
            imgMaoCpu.setImageResource(R.drawable.um);
            if (meuPalpite == palitosMaoCpu + palitosMinhaMao) {
                result = " PARABÉNS, Você venceu !!";
                contaVitoriaEU++;
            } else if (Pcpu == palitosMaoCpu + palitosMinhaMao) {
                result = " A CPU venceu !!";
                contaVitoriaCPU++;
            } else if ((meuPalpite != palitosMaoCpu + palitosMinhaMao) && (Pcpu != palitosMaoCpu + palitosMinhaMao)) {
                result = " Não houve vencedor.";
            }
        }

        if (cpu == 2) {
            palitosMaoCpu = 2;
            imgMaoCpu.setImageResource(R.drawable.dois);
            if (meuPalpite == (palitosMaoCpu + palitosMinhaMao)) {
                result =" PARABÉNS, Você venceu !!";
                contaVitoriaEU++;
            } else if (Pcpu == (palitosMaoCpu + palitosMinhaMao)) {
                result = " A CPU venceu !!";
                contaVitoriaCPU++;
            } else if ((meuPalpite != (palitosMaoCpu + palitosMinhaMao)) && (Pcpu != (palitosMaoCpu + palitosMinhaMao))) {
                result = " Não houve vencedor.";
            }
        }

        if (cpu == 3) {
            palitosMaoCpu = 3;
            imgMaoCpu.setImageResource(R.drawable.tres);
            if (meuPalpite == palitosMaoCpu + palitosMinhaMao) {
                result = " PARABÉNS, Você venceu !!";
                contaVitoriaEU++;
            } else if (Pcpu == palitosMaoCpu + palitosMinhaMao) {
                result = " A CPU venceu !!";
                contaVitoriaCPU++;
            } else if ((meuPalpite != palitosMaoCpu + palitosMinhaMao) && (Pcpu != palitosMaoCpu + palitosMinhaMao)) {
                result = " Não houve vencedor.";
            }
        }
            encerraRodada();
            mostraResultado();
    }

    public void validaCPU(){


         cpu = r.nextInt(4);
         do{
             //O palpite pode ser o numero de palitinhos até o numero de palitinhos + 3?
             Pcpu = numeroAleatorioEntreOIntervalo(cpu, cpu + 3);
         }while(Pcpu == meuPalpite);

    }

    private int numeroAleatorioEntreOIntervalo(int min, int max) {

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public void iniciaRodada (){

        imgMinhaMao.setImageResource(R.drawable.fechada);
        imgMaoCpu.setImageResource(R.drawable.fechada);
        txtMostraMeuPalpite.setText("");
        txtMostraPalpiteCpu.setText("");
        txtMostraResultado.setText("Resultado");
        btnPalito0.setAlpha(1.0f);
        btnPalito1.setAlpha(1.0f);
        btnPalito2.setAlpha(1.0f);
        btnPalito3.setAlpha(1.0f);
        btnPalito0.setEnabled(true);
        btnPalito1.setEnabled(true);
        btnPalito2.setEnabled(true);
        btnPalito3.setEnabled(true);
        btnPalpite0.setEnabled(false);
        btnPalpite1.setEnabled(false);
        btnPalpite2.setEnabled(false);
        btnPalpite3.setEnabled(false);
        btnPalpite4.setEnabled(false);
        btnPalpite5.setEnabled(false);
        btnPalpite6.setEnabled(false);
        btnPalito0.setTextColor(Color.BLACK);
        btnPalito1.setTextColor(Color.BLACK);
        btnPalito2.setTextColor(Color.BLACK);
        btnPalito3.setTextColor(Color.BLACK);



    }

    public void encerraRodada() {

        btnPalito0.setAlpha(0.5f);
        btnPalito1.setAlpha(0.5f);
        btnPalito2.setAlpha(0.5f);
        btnPalito3.setAlpha(0.5f);
        btnPalito0.setEnabled(false);
        btnPalito1.setEnabled(false);
        btnPalito2.setEnabled(false);
        btnPalito3.setEnabled(false);
        btnPalpite0.setEnabled(false);
        btnPalpite1.setEnabled(false);
        btnPalpite2.setEnabled(false);
        btnPalpite3.setEnabled(false);
        btnPalpite4.setEnabled(false);
        btnPalpite5.setEnabled(false);
        btnPalpite6.setEnabled(false);

    }

    public void mostraResultado(){

        Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
        resultado = cpu + palitosMinhaMao;
        txtMostraResultado.setText(String.valueOf(resultado));
        txtMostraMeuPalpite.setText(String.valueOf(meuPalpite));
        txtMostraPalpiteCpu.setText(String.valueOf(Pcpu));
        txtContaVitoriaCPU.setText(String.valueOf(contaVitoriaCPU));
        txtContaVitoriaEu.setText(String.valueOf(contaVitoriaEU));
    }

}

