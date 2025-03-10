/*
 *  SIGES
 *  Desarrollado por Sofis Solutions
 */
package sv.gob.mined.siges.web.beans;

import java.io.Serializable;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import sv.gob.mined.siges.web.constantes.ConstantesOperaciones;
import sv.gob.mined.siges.web.constantes.ConstantesPaginas;
import sv.gob.mined.siges.web.mensajes.Etiquetas;

@Named
@SessionScoped
public class MenuViewBean implements Serializable {

    private Locale locale;
    private MenuModel model;

    @Inject
    private SessionBean sessionBean;

    public MenuViewBean() {
    }

    @PostConstruct
    public void init() {
        try {

            locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
            model = new DefaultMenuModel();

            DefaultMenuItem item2;
            DefaultSubMenu submenu;

            // Menú de Inicio
            item2 = new DefaultMenuItem(Etiquetas.getValue("inicio", locale), null, ConstantesPaginas.IR_A_INICIO);
            model.addElement(item2);


            // Menú de Registro Académico
            submenu = new DefaultSubMenu(Etiquetas.getValue("registroAcademico", locale));

            // Submenú para Cuadro de Notas
            item2 = new DefaultMenuItem(Etiquetas.getValue("cuadroNotas", locale), null, ConstantesPaginas.CUADRO_NOTAS);
            submenu.addElement(item2);

            // Submenú para Certificaciones
            item2 = new DefaultMenuItem(Etiquetas.getValue("certificaciones", locale), null, ConstantesPaginas.CERTIFICACIONES);
            submenu.addElement(item2);

            if (submenu.getElements().size() > 0) {
                submenu.setExpanded(true);
                model.addElement(submenu);
            }

            // Otros menús (ejemplo: gestión de etiquetas, páginas, incorporaciones, etc.)
            item2 = new DefaultMenuItem(Etiquetas.getValue("gestionEtiqueta", locale), null, ConstantesPaginas.GESTION_ETIQUETAS);
            model.addElement(item2);

            item2 = new DefaultMenuItem(Etiquetas.getValue("gestionPagina", locale), null, ConstantesPaginas.GESTION_PAGINAS);
            model.addElement(item2);

            item2 = new DefaultMenuItem(Etiquetas.getValue("gestionIncorporacion", locale), null, ConstantesPaginas.INCORPORACIONES);
            model.addElement(item2);

            item2 = new DefaultMenuItem(Etiquetas.getValue("gestionEquivalencia", locale), null, ConstantesPaginas.EQUIVALENCIAS);
            model.addElement(item2);

            item2 = new DefaultMenuItem(Etiquetas.getValue("gestionMarginacion", locale), null, ConstantesPaginas.MARGINACIONES);
            model.addElement(item2);

            model.generateUniqueIds();

        } catch (Exception ex) {
            // Manejo de excepciones
        }
    }

    public MenuModel getModel() {
        return model;
    }
}