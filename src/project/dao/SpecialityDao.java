package project.dao;

import project.model.Specialty;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 19.11.2016.
 */
public class SpecialityDao implements AbstructDao {
    private static SessionObject sObj = new SessionObject();

    public void add(Object object) {
        if(!(object instanceof Specialty))
            return;
        Specialty specialty= (Specialty) object;
        String sql = "INSERT INTO DEVELOPER_MANAGER.specialty" +
                " (specialty_id, specialty_title) VALUES ('"
                + specialty.getKeyid() + "', '" + specialty.getSpecialtyTitle() + "'"  + ");";
        sObj.executUpdate(sql);
    }



    public void update(Object object) {
        if(!(object instanceof Specialty))
            return;
        Specialty specialty= (Specialty) object;
        String sql = "UPDATE DEVELOPER_MANAGER.specialty SET specialty_title='"
                + specialty.getSpecialtyTitle() +"'"
                +" WHERE  specialty_id="+ specialty.getKeyid()+";";
        sObj.executUpdate(sql);
    }


    public void remove(int id) {
        String sql = "DELETE FROM DEVELOPER_MANAGER.specialty WHERE specialty_id="+id+";";
        sObj.executUpdate(sql);
    }


    public Specialty getById(int id) {
        String sql = "SELECT * FROM DEVELOPER_MANAGER.speciality WHERE specialty_id="+id+";";
        sObj.executQuery(sql);
        ResultSet rs = SessionObject.getResultSet();
        try {
            while (rs.next()) {
                return new Specialty(rs.getInt("specialty_id"), rs.getString("specialty_title"));
            }
            rs.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Object> getList() {
        String sql = "SELECT * FROM DEVELOPER_MANAGER.specialty;";
        sObj.executQuery(sql);
        ResultSet rs = SessionObject.getResultSet();
        List<Object> specialtyList = new ArrayList<Object>();
        try {
            while (rs.next()) {
                specialtyList.add((Object)new Specialty(rs.getInt("specialty_id"), rs.getString("specialty_title")));
            }
            rs.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  specialtyList;
    }
}
