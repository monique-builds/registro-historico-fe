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
            DefaultSubMenu submenu2;

            // Menú de Inicio
            item2 = new DefaultMenuItem(Etiquetas.getValue("inicio", locale), null, ConstantesPaginas.IR_A_INICIO);
            model.addElement(item2);

            // Menú de Registro de notas TDR 52
            submenu = new DefaultSubMenu(Etiquetas.getValue("certificacionDeRegistroDeNotas", locale));

            // Submenú para Cuadro de Notas
            item2 = new DefaultMenuItem(Etiquetas.getValue("cuadroNotas", locale), null, ConstantesPaginas.CUADRO_NOTAS);
            submenu.addElement(item2);

            // Submenú para Certificaciones
            item2 = new DefaultMenuItem(Etiquetas.getValue("gestionCertificaciones", locale), null, ConstantesPaginas.CERTIFICACIONES);
            submenu.addElement(item2);

            // Menú de Certificacion de titulos TDR 53
            submenu2 = new DefaultSubMenu(Etiquetas.getValue("certificacionDeTitulosEducacionMedia", locale));

            // Submenú para Cuadro de Notas
            item2 = new DefaultMenuItem(Etiquetas.getValue("cuadroNotasEducacionMedia", locale), null, ConstantesPaginas.CUADRO_NOTAS_EDUCACION_MEDIA);
            submenu2.addElement(item2);

            // Submenú para Certificaciones
            item2 = new DefaultMenuItem(Etiquetas.getValue("certificacionDeTitulo", locale), null, ConstantesPaginas.CERTIFICACION_TITULO);
            submenu2.addElement(item2);

            if (submenu.getElements().size() > 0) {
                submenu.setExpanded(true);
                model.addElement(submenu);
            }

            if (submenu2.getElements().size() > 0) {
                submenu2.setExpanded(true);
                model.addElement(submenu2);
            }

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

            item2 = new DefaultMenuItem(Etiquetas.getValue("autenticaDeDocumentos", locale), null, ConstantesPaginas.AUTENTICA);
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
