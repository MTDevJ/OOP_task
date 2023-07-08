package Core;

import Core.Service.Board.Board;

public class PaymentService {

    public static Order makePayment(Board board){
        board.setPaid(true);
        return new Order(
                board.getPatient(),
                board.getPrice(),
                board
        );
    }
}
