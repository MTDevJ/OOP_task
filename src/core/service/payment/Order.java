package core.service.payment;

import core.person.client.Client;
import core.service.board.Board;

import java.util.Date;

public class Order {
    Client patient;
    Integer price;

    Board board;

    Date payDate;

    Boolean isPaid;

    public Order(Client patient, Integer price, Board board) {
        this.patient = patient;
        this.price = price;
        this.board = board;
        this.payDate = new Date();
        isPaid = true;
    }

    public Boolean isPaid() {
        return isPaid;
    }
}
