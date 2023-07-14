package Core;

import Core.Person.Patient;
import Core.Service.Board.Board;

import java.util.Date;

public class Order {
    Patient patient;
    Integer price;

    Board board;

    Date payDate;

    Boolean isPaid;

    public Order(Patient patient, Integer price, Board board) {
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
