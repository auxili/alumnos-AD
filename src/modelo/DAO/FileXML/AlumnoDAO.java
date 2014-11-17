/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO.FileXML;

import POJO.Alumno;
import java.util.ArrayList;
import modelo.DAO.POJODAO;

/**
 *
 * @author KiKe
 */
public class AlumnoDAO implements POJODAO {

    private ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();

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
return listaAlumnos;    }

    @Override
    public void open() throws Exception {
        throw new UnsupportedOperationException("sin implementar."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yetxxxx."); //To change body of generated methods, choose Tools | Templates.
    }
}
