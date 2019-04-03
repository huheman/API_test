package javabean;


import java.sql.Date;

public class Account {
    private int balance;
    private String name;
    private long id;
    private Date create_date;
    private double cost;

    public Account(int balance, String name, long id, Date create_date, double cost) {
        this.balance = balance;
        this.name = name;
        this.id = id;
        this.create_date = create_date;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", create_date=" + create_date +
                ", cost=" + cost +
                '}';
    }

    public Account() {
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
