package project.model;

public class Project {
    private int id;
    private String progectTitle;
    private int clientId;
    private int companyId;
    private int cost;

    public Project(int id, String progectTitle, int clientId, int companyId, int cost) {
        this.id = id;
        this.progectTitle = progectTitle;
        this.clientId = clientId;
        this.companyId = companyId;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProgectTitle() {
        return progectTitle;
    }

    public void setProgectTitle(String progectTitle) {
        this.progectTitle = progectTitle;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", progectTitle='" + progectTitle + '\'' +
                ", clientId=" + clientId +
                ", companyId=" + companyId +
                ", cost=" + cost +
                '}';
    }
}
