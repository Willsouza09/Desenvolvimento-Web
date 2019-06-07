/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoryHelper;
import dvdrental.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.view.ViewScoped;
import model.Category;
import javax.inject.Named;

/**
 *
 * @author William
 */
@ViewScoped
@Named(value = "categoryController")
public class CategoryController implements Serializable {


    DataModel categoryName;
    CategoryHelper helper;
    private List<Category> listaCategory;
    private int recordCount = 1000;
    private int pageSize = 10;
    private Category category;
    private Category current;
    private int selectedItemIndex;
    private Integer codigo;
   

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Category getCategory() {
        if (category == null) {
            category = new Category();
        }
        return category;
    }

    public void setCategory(Category category) {

        this.category = category;
    }

    public List<Category> getListaCategory() {
        return listaCategory;
    }

    public void setListaCategory(List<Category> listaCategory) {
        this.listaCategory = listaCategory;
    }

    public CategoryController() {
        helper = new CategoryHelper();

    }

    public Category getSelected() {
        if (current == null) {
            current = new Category();
            selectedItemIndex = -1;
        }
        return current;
    }

    public DataModel getCategoryName() {
        if (categoryName == null) {
            categoryName = new ListDataModel(helper.getCategoryName());
        }
        return categoryName;
    }

    public void carregarPesquisa() {
        CategoryHelper categoryHelper = new CategoryHelper();
        listaCategory = categoryHelper.getCategoryName();

    }

    void recreateModel() {
        categoryName = null;
    }

    public void salvar() {
        try {
            CategoryHelper categoryHelper = new CategoryHelper();
            categoryHelper.salvar(category);
            FacesUtil.adicionarMsgInfo("Categoria salva com ucesso");
          
        } catch (Exception e) {
            FacesUtil.adicionarMsgErro("Erro ao cadastrar categoria");
        }

    }

    public void editar() {

        try {
            CategoryHelper categoryHelper = new CategoryHelper();
            categoryHelper.editar(category);
            FacesUtil.adicionarMsgInfo("Categoria editada com ucesso");
           

        } catch (Exception e) {
            FacesUtil.adicionarMsgErro("Erro ao editar categoria");
        }

    }

    public void excluir() {
        try {
            CategoryHelper categoryHelper = new CategoryHelper();
            categoryHelper.excluir(category);
            FacesUtil.adicionarMsgInfo("Categoria excluida com ucesso");
        } catch (Exception e) {
            FacesUtil.adicionarMsgErro("Erro ao excluir categoria");

        }

    }

    public void carregarDados() {

        if (codigo != null) {
            CategoryHelper categoryHelper = new CategoryHelper();
            category = categoryHelper.getCategoryByID(codigo);

        } else {
            category = new Category();
        }

    }


}
