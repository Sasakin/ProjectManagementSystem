package project.dao;

import project.model.SpecialtyDeveloper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpecialityDeveloperDao implements AbstructDao {
    private static SessionObject sObj = new SessionObject();

    public void add(Object object) {
        if(!(object instanceof SpecialtyDeveloper))
            return;
        SpecialtyDeveloper specialtyDeveloper= (SpecialtyDeveloper) object;
        String sql = "INSERT INTO DEVELOPER_MANAGER.specialty_developers" +
                " (keyid, specialty_id, developer_id) VALUES (" + specialtyDeveloper.getId() + ", "
                + specialtyDeveloper.getSpecialtyId() + ", " + specialtyDeveloper.getDeveloperId() + ""  + ");";
        sObj.executUpdate(sql);
    }
    /*`keyid`
    `speciality_id
    `developer_id` */



    public void update(Object object) {
        if(!(object instanceof SpecialtyDeveloper))
            return;
        SpecialtyDeveloper specialtyDeveloper= (SpecialtyDeveloper) object;
        String sql = "UPDATE DEVELOPER_MANAGER.speciality_developers SET speciality_id="
                + specialtyDeveloper.getSpecialtyId() +", developer_id="+specialtyDeveloper.getDeveloperId()
                +" WHERE  keyid="+ specialtyDeveloper.getId()+";";
        sObj.executUpdate(sql);
    }


    public void remove(int id) {
        String sql = "DELETE FROM DEVELOPER_MANAGER.speciality_developers WHERE keyid="+id+";";
        sObj.executUpdate(sql);
    }


    public SpecialtyDeveloper getById(int id) {
        String sql = "SELECT * FROM DEVELOPER_MANAGER.speciality_developers WHERE keyid="+id+";";
        sObj.executQuery(sql);
        ResultSet rs = SessionObject.getResultSet();
        try {
            while (rs.next()) {
                return new SpecialtyDeveloper(rs.getInt("keyid"), rs.getInt("specialty_id"), rs.getInt("developer_id"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Object> getList() {
        String sql = "SELECT * FROM DEVELOPER_MANAGER.speciality_developers;";
        sObj.executQuery(sql);
        ResultSet rs = SessionObject.getResultSet();
        List<Object> specialityDevelopersList = new ArrayList<Object>();
        try {
            while (rs.next()) {
                specialityDevelopersList.add((Object)new SpecialtyDeveloper(rs.getInt("keyid"), rs.getInt("specialty_id"), rs.getInt("developer_id")));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  specialityDevelopersList;
    }
}
