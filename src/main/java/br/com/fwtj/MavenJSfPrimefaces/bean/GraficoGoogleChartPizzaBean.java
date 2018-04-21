package br.com.fwtj.MavenJSfPrimefaces.bean;

import br.com.fwtj.MavenJSfPrimefaces.modelo.LinhaGoogleChartsUmaColuna;
import br.com.fwtj.MavenJSfPrimefaces.util.GoogleChartsUtils;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Autor: Fred William Torno Junior
 * E-Mail: fredwilliam@gmail.com / fredwilliam@outlook.com
 * Site: www.fwtj.com.br
 * Telefone: (22) 9-8136-5786
 * Data: 20/04/2018
 * Hora: 15:23
 * Copyright©Fwtj Sistemas. Todos os direitos reservados.
 */
@Named
@RequestScoped
public class GraficoGoogleChartPizzaBean {

    private String dados = "";

    public String getDados() {
        return dados;
    }

    @PostConstruct
    private void init() {

        List<LinhaGoogleChartsUmaColuna> linhaGoogleChartsUmaColunaList = new ArrayList<>();
        linhaGoogleChartsUmaColunaList.add(new LinhaGoogleChartsUmaColuna("Dinheiro - " + NumberFormat.getCurrencyInstance().format(4123.56), "4123.56"));
        linhaGoogleChartsUmaColunaList.add(new LinhaGoogleChartsUmaColuna("Cheque - " + NumberFormat.getCurrencyInstance().format(2123.56), "2123.56"));
        linhaGoogleChartsUmaColunaList.add(new LinhaGoogleChartsUmaColuna("Ticket - " + NumberFormat.getCurrencyInstance().format(1123.56), "1123.56"));
        linhaGoogleChartsUmaColunaList.add(new LinhaGoogleChartsUmaColuna("Cartão - " + NumberFormat.getCurrencyInstance().format(7123.56), "7123.56"));

        dados = GoogleChartsUtils.dadosGraficoUmaColuna("Finalizadora", "Valor", linhaGoogleChartsUmaColunaList);

    }


}
