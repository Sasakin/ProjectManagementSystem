package project.dao;

import project.model.Client;
import project.model.ProjectDeveloper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 19.11.2016.
 */
public class ProjectDeveloperDao implements AbstructDao {
    private static SessionObject sObj = new SessionObject();

    public void add(Object object) {
        if(!(object instanceof ProjectDeveloper))
            return;
        ProjectDeveloper projectDeveloper = (ProjectDeveloper) object;
        String sql = "INSERT INTO DEVELOPER_MANAGER.project_developers" +
                " (keyid, project_id, developer_id) VALUES ("
                + projectDeveloper.getId() + ", " + projectDeveloper.getProjectId() + ", "
                 + projectDeveloper.getDeveloperId() + ""  + ");";
        sObj.executUpdate(sql);
    }


    public void update(Object object) {
        if(!(object instanceof ProjectDeveloper))
            return;
        ProjectDeveloper projectDeveloper = (ProjectDeveloper) object;
        String sql = "UPDATE DEVELOPER_MANAGER.project_developers SET project_id="
                + projectDeveloper.getProjectId()+", developer_id="+ projectDeveloper.getDeveloperId()
                +" WHERE keyid = "+projectDeveloper.getId()+";";
        sObj.executUpdate(sql);
    }


    public void remove(int id) {
        String sql = "DELETE FROM DEVELOPER_MANAGER.project_developers WHERE keyid="+id+";";
        sObj.executUpdate(sql);
    }


    public ProjectDeveloper getById(int id) {
        String sql = "SELECT * FROM DEVELOPER_MANAGER.project_developers WHERE keyid="+id+";";
        sObj.executQuery(sql);
        ResultSet rs = SessionObject.getResultSet();
        try {
            while (rs.next()) {
                return new ProjectDeveloper(rs.getInt("keyid"),rs.getInt("project_id"),rs.getInt("developer_id"));
            }
            rs.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Object> getList() {
        String sql = "SELECT * FROM DEVELOPER_MANAGER.project_developers;";
        sObj.executQuery(sql);
        ResultSet rs = SessionObject.getResultSet();
        List<Object> projectDeveloperList = new ArrayList<Object>();
        try {
            while (rs.next()) {
                projectDeveloperList.add(new ProjectDeveloper(rs.getInt("keyid"),rs.getInt("project_id"),rs.getInt("developer_id")));
            }
            rs.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  projectDeveloperList;
    }
}
