package br.com.fwtj.MavenJSfPrimefaces.bean;

/**
 * Autor: Fred William Torno Junior
 * E-Mail: fredwilliam@gmail.com / fredwilliam@outlook.com
 * Site: www.fwtj.com.br
 * Telefone: (22) 9-8136-5786
 * Data: 20/04/2018
 * Hora: 10:54
 * Copyright©Fwtj Sistemas. Todos os direitos reservados.
 */
public class LinhaGraficoColuna {

    private String hora;
    private String valor;

    public LinhaGraficoColuna(String hora, String valor) {
        this.hora = hora;
        this.valor = valor;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }


}
