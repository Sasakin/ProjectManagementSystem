package project.dao;

import project.model.Company;
import project.model.Developer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 19.11.2016.
 */
public class DeveloperDao implements AbstructDao {
    private static SessionObject sObj = new SessionObject();

    public void add(Object object) {
        if(!(object instanceof Developer))
            return;
        Developer developer = (Developer) object;
        String sql = "INSERT INTO DEVELOPER_MANAGER.developers" +
                " (developer_id, name, salary) VALUES ("
                + developer.getId() + ", '" + developer.getName()+"', " +developer.getSalary() + ");";
        sObj.executUpdate(sql);
    }


    public void update(Object object) {
        if(!(object instanceof Developer))
            return;
        Developer developer = (Developer) object;
        String sql = "UPDATE DEVELOPER_MANAGER.developers SET name='"
                +  developer.getName() +"', salary="+developer.getSalary()
                +" WHERE id = "+developer.getId()+";";
        sObj.executUpdate(sql);
    }


    public void remove(int id) {
        String sql = "DELETE FROM DEVELOPER_MANAGER.developers WHERE developer_id="+id+";";
        sObj.executUpdate(sql);
    }


    public Developer getById(int id) {
        String sql = "SELECT * FROM DEVELOPER_MANAGER.developers WHERE developer_id="+id+";";
        sObj.executQuery(sql);
        ResultSet rs = SessionObject.getResultSet();
        try {
            while (rs.next()) {
                return new Developer(rs.getString("name"),rs.getInt("developer_id"),rs.getString("salary"));
            }
            rs.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Object> getList() {
        String sql = "SELECT * FROM DEVELOPER_MANAGER.developers;";
        sObj.executQuery(sql);
        ResultSet rs = SessionObject.getResultSet();
        List<Object> developerList = new ArrayList<Object>();
        try {
            while (rs.next()) {
                developerList.add(new Developer(rs.getString("name"),rs.getInt("developer_id"),rs.getString("salary")));
            }
            rs.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  developerList;
    }
}
