package modelo.DAO.FileBuffered;
import modelo.DAO.DAOFactory;

public class FileBufferedDAOFactory  extends DAOFactory {
    
    private AlumnoDAO alumnoDAO = null;
    public synchronized static FileBufferedDAOFactory getInstance() {
        if (instancia == null){
            instancia = new FileBufferedDAOFactory();
        }
        return (FileBufferedDAOFactory) instancia;
    } 
    
    @Override
    public AlumnoDAO getAlumnoDAO() {
        if(alumnoDAO == null){
            alumnoDAO = new AlumnoDAO();        
        }
        return alumnoDAO;
    }    
    
    @Override
    public void closeDAOFactory() throws Exception{
        alumnoDAO.close();
    }
    
    @Override
    public void openDAOFactory() throws Exception{
        try {
            alumnoDAO.open();
        } catch (Exception ex) {
            throw ex;
        }
    }
   
}
