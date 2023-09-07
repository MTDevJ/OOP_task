package core.service.payment;

import core.person.client.Client;
import core.service.board.Board;

public class PaymentService {
    public static Order makePayment(Client client, Board board){
        board.setPaid(true);
        return new Order(
                client,
                board.getTotalPrice(),
                board
        );
    }
}
