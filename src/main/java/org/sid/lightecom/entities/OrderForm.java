package org.sid.lightecom.entities;

import java.util.ArrayList;
import java.util.List;

public class OrderForm {
    private Client client=new Client();
    private List<OrderProduct> products=new ArrayList<>();

    public OrderForm() {
    }

    public OrderForm(Client client, List<OrderProduct> products) {
        this.client = client;
        this.products = products;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderProduct> getProducts() {
        return products;
    }

    public void setProducts(List<OrderProduct> products) {
        this.products = products;
    }
}
