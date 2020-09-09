package com.psss.registro.ui.segretario.components.classi;

import com.psss.registro.backend.models.Classe;
import com.psss.registro.backend.models.Docente;
import com.psss.registro.backend.models.Insegnamento;
import com.psss.registro.backend.models.Materia;
import com.psss.registro.backend.services.DocenteService;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.data.binder.Binder;

public class InsegnamentoForm extends FormLayout {

    private final ComboBox<Docente> docente = new ComboBox<>();
    private final ComboBox<Materia> materia = new ComboBox<>();

    private final Binder<Insegnamento> binder = new Binder<>(Insegnamento.class);

    private DocenteService docenteService;

    public InsegnamentoForm(DocenteService docenteService) {

        this.docenteService = docenteService;

        docente.setItems(docenteService.findAll());
        docente.setItemLabelGenerator(Docente::getDocente);
        docente.addValueChangeListener(event -> {
            if(event.getValue()!= null) {
                materia.setEnabled(true);
                materia.setItems(event.getValue().getMaterie());
            }
        });

        materia.setEnabled(false);
        materia.setItemLabelGenerator(Materia::getNome);

        add(docente, materia);
        binder.bindInstanceFields(this);
    }

    public Binder<Insegnamento> getBinder() {
        return binder;
    }

    public ComboBox<Docente> getDocente() {
        return docente;
    }
}