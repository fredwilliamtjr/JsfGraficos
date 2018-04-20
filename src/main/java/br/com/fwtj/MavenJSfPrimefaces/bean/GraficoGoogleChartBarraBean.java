package br.com.fwtj.MavenJSfPrimefaces.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
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
public class GraficoGoogleChartBarraBean {

    private String dados = "";

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }


    private String abreDados() {
        return "[";
    }

    private String fechaDados() {
        return "]";
    }

    private String separadorDados() {
        return ",";
    }

    private String colunaDados(String nomeColula, String nomeValor) {
        return "[\"" + nomeColula + "\", \"" + nomeValor + "\", {role: \"style\"}]";
    }

    private String linhaDados(String nomeLinha, String valorLinha, String corLinha) {
        return "[\"" + nomeLinha + "\", " + valorLinha + ", \"" + corLinha + "\"]";
    }


    @PostConstruct
    private void init() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(abreDados());
        stringBuilder.append(colunaDados("Hora", "Valor"));
        stringBuilder.append(separadorDados());

        List<LinhaGraficoBarra> linhaGraficoBarraList = new ArrayList<>();
        linhaGraficoBarraList.add(new LinhaGraficoBarra("11h", "123.56", CorUtils.getCorRandonicaHex()));
        linhaGraficoBarraList.add(new LinhaGraficoBarra("12h", "193.56", CorUtils.getCorRandonicaHex()));
        linhaGraficoBarraList.add(new LinhaGraficoBarra("13h", "223.56", CorUtils.getCorRandonicaHex()));
        linhaGraficoBarraList.add(new LinhaGraficoBarra("14h", "23.56", CorUtils.getCorRandonicaHex()));

        linhaGraficoBarraList.forEach(linhaGraficoBarra -> {
            stringBuilder.append(linhaDados(linhaGraficoBarra.getHora(), linhaGraficoBarra.getValor(), linhaGraficoBarra.getCor()));
            stringBuilder.append(separadorDados());
        });

        stringBuilder.append(fechaDados());
        String toString = stringBuilder.toString();
        dados = toString;
    }

}
