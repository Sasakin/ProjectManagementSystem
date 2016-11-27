package project.dao;

import project.model.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClientDao implements  AbstructDao {
    private static SessionObject sObj = new SessionObject();

    public void add(Object object) {
        Client client = (Client) object;
        String sql = "INSERT INTO DEVELOPER_MANAGER.clients" +
                " (client_id, client_name) VALUES ("
        + client.getId() + ", '" + client.getName() + "');";
      sObj.executUpdate(sql);
    }


    public void update(Object object) {
        Client client = (Client) object;
        String sql = "UPDATE DEVELOPER_MANAGER.clients SET client_name='"
        + client.getName()+"' WHERE client_id = "+client.getId()+";";
        sObj.executUpdate(sql);
    }


    public void remove(int id) {
        String sql = "DELETE FROM DEVELOPER_MANAGER.clients WHERE client_id="+id+";";
        sObj.executUpdate(sql);
    }


    public Client getById(int id) {
        String sql = "SELECT * FROM DEVELOPER_MANAGER.clients WHERE client_id="+id+";";
        sObj.executQuery(sql);
        ResultSet rs = SessionObject.getResultSet();
        try {
            while (rs.next()) {
                return new Client(rs.getInt("client_id"),rs.getString("client_name"));
            }
            rs.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Object> getList() {
        String sql = "SELECT * FROM DEVELOPER_MANAGER.clients;";
        sObj.executQuery(sql);
        ResultSet rs = SessionObject.getResultSet();
        List<Object> clientList = new ArrayList<Object>();
        try {
            while (rs.next()) {
                clientList.add(new Client(rs.getInt("client_id"),rs.getString("client_name")));
            }
            rs.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return clientList;
    }
}
