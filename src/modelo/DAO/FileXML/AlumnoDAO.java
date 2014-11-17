/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO.FileXML;

import POJO.Alumno;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import modelo.DAO.POJODAO;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author KiKe
 */
public class AlumnoDAO implements POJODAO {

    private ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
    private Alumno a;
    private String dondeEstoy;

    @Override
    public void add(Object object) {
        listaAlumnos.add((Alumno) object);
    }

    @Override
    public Object find(Object object) {
        Alumno a = (Alumno) object;
        for (int i = 0; i < this.listaAlumnos.size(); i++) {
            if (listaAlumnos.get(i).getId() == a.getId()) {
                return listaAlumnos.get(i);
            }
        }
        return null;
    }

    @Override
    public void update(Object object) {
        int i = 0;
        Alumno a = (Alumno) object;
        boolean enc = false;
        while ((i < this.listaAlumnos.size()) && (enc == false)) {
            if (this.listaAlumnos.get(i).getId() == a.getId()) {
                this.listaAlumnos.set(i, a);
                enc = true;
            } else {
                i++;
            }
        }
    }

    @Override
    public void delete(Object object) {
        Alumno a = (Alumno) object;
        int i = 0;
        while (i < this.listaAlumnos.size()) {
            if (this.listaAlumnos.get(i).getId() == a.getId()) {
                this.listaAlumnos.remove(i);
            } else {
                i++;
            }
        }
    }

    @Override
    public ArrayList list() {
        return listaAlumnos;
    }

    @Override
    //usamos sax para leer
    public void open() throws FileNotFoundException, IOException, SAXException {
        XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
        GestionContenido gestor= new GestionContenido();
        procesadorXML.setContentHandler(gestor);
        InputSource fileXML = new InputSource("alumnos.xml");
        procesadorXML.parse(fileXML);
        //ArrayList<Alumno> listaAlumnos = gestor.getListaAlumnos();
    }

    @Override
    //usamos XStream para escribir
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yetxxxx."); //To change body of generated methods, choose Tools | Templates.
    }
}
