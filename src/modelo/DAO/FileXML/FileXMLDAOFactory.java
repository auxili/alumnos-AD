/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO.FileXML;

import modelo.DAO.DAOFactory;
import modelo.DAO.POJODAO;

/**
 *
 * @author KiKe
 */
public class FileXMLDAOFactory extends DAOFactory {

    private AlumnoDAO alumnoDAO = null;

    public synchronized static FileXMLDAOFactory getInstance() {
        // si no existe la instancia lo crea caso contrario retorna el que ya existe
        if (instancia == null) {
            instancia = new FileXMLDAOFactory();
        }
        return (FileXMLDAOFactory) instancia;
    }

    @Override
    public void openDAOFactory() throws Exception {
        try {
            alumnoDAO.open();
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void closeDAOFactory() throws Exception {
        alumnoDAO.close();
    }

    @Override
    public POJODAO getAlumnoDAO() {
        if (alumnoDAO == null) {
            alumnoDAO = new AlumnoDAO();
        }
        return alumnoDAO;
    }

}
