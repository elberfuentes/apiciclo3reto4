package co.usa.ciclo3.ciclo3.model.Reportes;

import co.usa.ciclo3.ciclo3.model.Client;

public class ReportsClient {
    private Long total;
    private Client client;
    public ReportsClient(Long total, Client client) {
        super();
        this.total = total;
        this.client = client;
    }
    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    
}
