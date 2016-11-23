package project.dao;


import project.model.Project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 19.11.2016.
 */
public class ProjectDao implements AbstructDao {
    private static SessionObject sObj = new SessionObject();

    public void add(Object object) {
        if(!(object instanceof Project))
            return;
        Project project = (Project) object;
        String sql = "INSERT INTO DEVELOPER_MANAGER.projects" +
                " (project_id, project_title, client_id, company_id, cost) VALUES ("
                + project.getId() + ", " + project.getprojectTitle()+", " +project.getClientId()
                +", "+ project.getCompanyId()+", "+ project.getCost()+ ");";
        sObj.executUpdate(sql);
    }


    public void update(Object object) {
        if(!(object instanceof Project))
            return;
        Project project = (Project) object;
        String sql = "UPDATE DEVELOPER_MANAGER.projects SET project_title="
                +  project.getprojectTitle() +", client_id="+project.getClientId()
                +", company_id="+project.getCompanyId() +", cost="+project.getCost()
                +" WHERE id = "+project.getId()+";";
        sObj.executUpdate(sql);
    }


    public void remove(int id) {
        String sql = "DELETE FROM DEVELOPER_MANAGER.projects WHERE project_id="+id+";";
        sObj.executUpdate(sql);
    }


    public Project getById(int id) {
        String sql = "SELECT * FROM DEVELOPER_MANAGER.projects WHERE project_id="+id+";";
        sObj.executQuery(sql);
        ResultSet rs = SessionObject.getResultSet();
        try {
            while (rs.next()) {
                return new Project(rs.getInt("project_id"),rs.getString("project_title"),rs.getInt("client_id"),rs.getInt("company_id"),rs.getInt("cost"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Object> getList() {
        String sql = "SELECT * FROM DEVELOPER_MANAGER.projects;";
        sObj.executQuery(sql);
        ResultSet rs = SessionObject.getResultSet();
        List<Object> projectList = new ArrayList<Object>();
        try {
            while (rs.next()) {
                projectList.add(new Project(rs.getInt("project_id"),rs.getString("project_title"),rs.getInt("client_id"),rs.getInt("company_id"),rs.getInt("cost")));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  projectList;
    }
}
