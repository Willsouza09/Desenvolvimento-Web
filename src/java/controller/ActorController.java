/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ActorHelper;
import dvdrental.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import jdk.nashorn.internal.runtime.ListAdapter;
import model.Actor;

/**
 *
 * @author William
 */
@Named(value = "actorController")
@SessionScoped
public class ActorController implements Serializable {

    DataModel actorTitles;
    ActorHelper helper;
    private List<Actor> listActor;
    private int recordCount = 1000;
    private int pageSize = 10;
    private Actor current;
    private Actor actor;
    private int selectedItemIndex;
    private Integer codigo;

    public List<Actor> getListActor() {
        return listActor;
    }

    public void setListActor(List<Actor> listActor) {
        this.listActor = listActor;
    }
    

    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Actor getActor() {
        if (actor == null) {
            actor = new Actor();
        }
        return actor;
    }

    public void setActor(Actor actor) {

        this.actor = actor;
    }

    public List<Actor> getListaActor() {
        return listActor;
    }

    public void setListaActor(List<Actor> listaActor) {
        this.listActor = listaActor;
    }

    public ActorController() {
        helper = new ActorHelper();

    }

    public Actor getSelected() {
        if (current == null) {
            current = new Actor();
            selectedItemIndex = -1;
        }
        return current;
    }

    public DataModel getactorTitles() {
        if (actorTitles == null) {
            actorTitles = new ListDataModel(helper.getActor());
        }
        return actorTitles;
    }

    public void carregarPesquisa() {
        ActorHelper actorHelper = new ActorHelper();
        listActor = actorHelper.getActor();

    }

    void recreateModel() {
        actorTitles = null;
    }

    public void salvar() {
        try {
            ActorHelper actorHelper = new ActorHelper();
            actorHelper.salvar(actor);
            FacesUtil.adicionarMsgInfo("Actor salva com ucesso");

        } catch (Exception e) {
            FacesUtil.adicionarMsgErro("Erro ao cadastrar Actor");
        }

    }

    public void editar() {
        try {
            ActorHelper actorHelper = new ActorHelper();
            actorHelper.editar(actor);
            FacesUtil.adicionarMsgInfo("Actor salva com ucesso");

        } catch (Exception e) {
            FacesUtil.adicionarMsgErro("Erro ao cadastrar Actor");
        }

    }

    public void excluir() {
        try {
            ActorHelper actorHelper = new ActorHelper();
            actorHelper.excluir(actor);
            FacesUtil.adicionarMsgInfo("Actor excluido com ucesso");

        } catch (Exception e) {
            FacesUtil.adicionarMsgErro("Erro ao excluir Actor");
        }

    }

    public void carregarDados() {

        if (codigo != null) {
            ActorHelper actorHelper = new ActorHelper();
            actor = (Actor) actorHelper.getActorByID(codigo);

        } else {
            actor = new Actor();
        }

    }

}
