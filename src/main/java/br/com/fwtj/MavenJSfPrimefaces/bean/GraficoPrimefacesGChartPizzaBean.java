/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwtj.MavenJSfPrimefaces.bean;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.primefaces.event.SelectEvent;
import org.primefaces.extensions.component.gchart.model.GChartModel;
import org.primefaces.extensions.component.gchart.model.GChartModelBuilder;
import org.primefaces.extensions.component.gchart.model.GChartModelRow;
import org.primefaces.extensions.component.gchart.model.GChartType;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Junior
 */
@Named
@RequestScoped
public class GraficoPrimefacesGChartPizzaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private int valorVendas = 1000;
    private int valorDespesas = 2000;
    private GChartType tipoGrafico = GChartType.PIE;
    private GChartModel dadosGrafico = null;

    public int getValorVendas() {
        return valorVendas;
    }

    public void setValorVendas(int valorVendas) {
        this.valorVendas = valorVendas;
    }

    public int getValorDespesas() {
        return valorDespesas;
    }

    public void setValorDespesas(int valorDespesas) {
        this.valorDespesas = valorDespesas;
    }

    public GChartType getTipoGrafico() {
        return tipoGrafico;
    }

    public void setTipoGrafico(GChartType tipoGrafico) {
        this.tipoGrafico = tipoGrafico;
    }

    public GChartModel getDadosGrafico() {
        return dadosGrafico;
    }

    public void setDadosGrafico(GChartModel dadosGrafico) {
        this.dadosGrafico = dadosGrafico;
    }

    public List<GChartType> getTiposGrafico() {
        return Arrays.asList(new GChartType[] { GChartType.AREA, GChartType.BAR, GChartType.COLUMN, GChartType.PIE, GChartType.LINE });
    }

    public GChartModel getGrafico() {
        return dadosGrafico;
    }

    @PostConstruct
    public void generateModel() {

        GChartModelBuilder gChartModelBuilder = new GChartModelBuilder().setChartType(getTipoGrafico()).addColumns("Titulos", "Valores").addRow("Vendas", valorVendas).addRow("Despesas", valorDespesas);

        Map<String, Object> animation = new HashMap<String, Object>();
        animation.put("duration", 1000);
        animation.put("startup", true);
        gChartModelBuilder.addOption("animation", animation);

        gChartModelBuilder.addOption("is3D", true);

        dadosGrafico = gChartModelBuilder.build();
    }

    public void onSelect(final SelectEvent event) {
        final JsonArray value = (JsonArray) event.getObject();
        if (value.size() > 0) {
            final JsonElement element = value.get(0);
            final String label = new ArrayList<GChartModelRow>(getGrafico().getRows()).get(element.getAsJsonObject().get("row").getAsInt()).getLabel();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "You have selected: " + label, null));
        }
    }


}
