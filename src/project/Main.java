package project;


import project.dao.ClientDao;
import project.model.Client;

public class Main {

    public static  void main(String[] args) {
        ClientDao clientDao = new ClientDao();

        System.out.println(clientDao.getList());

    }
}
