package project.dao;

import project.model.Company;
import project.model.ProjectDeveloper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 19.11.2016.
 */
public class CompanyDao implements AbstructDao {

    private static SessionObject sObj = new SessionObject();

    public void add(Object object) {
        if(!(object instanceof Company))
            return;
        Company company = (Company) object;
        String sql = "INSERT INTO DEVELOPER_MANAGER.company" +
                " (company_id, company_name) VALUES ("
                + company.getId() + ", " + company.getName()  + ");";
        sObj.executUpdate(sql);
    }


    public void update(Object object) {
        if(!(object instanceof Company))
            return;
        Company company = (Company) object;
        String sql = "UPDATE DEVELOPER_MANAGER.company SET company_name="
                +  company.getName()
                +" WHERE id = "+company.getId()+";";
        sObj.executUpdate(sql);
    }


    public void remove(int id) {
        String sql = "DELETE FROM DEVELOPER_MANAGER.company WHERE company_id="+id+";";
        sObj.executUpdate(sql);
    }


    public Company getById(int id) {
        String sql = "SELECT * FROM DEVELOPER_MANAGER.company WHERE company_id="+id+";";
        sObj.executQuery(sql);
        ResultSet rs = SessionObject.getResultSet();
        try {
            while (rs.next()) {
                return new Company(rs.getInt("company_id"),rs.getString("company_name"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Object> getList() {
        String sql = "SELECT * FROM DEVELOPER_MANAGER.company;";
        sObj.executQuery(sql);
        ResultSet rs = SessionObject.getResultSet();
        List<Object> companyList = new ArrayList<Object>();
        try {
            while (rs.next()) {
                companyList.add(new Company(rs.getInt("company_id"),rs.getString("company_name")));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  companyList;
    }
}
