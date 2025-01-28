package stateObserver;

public class BatchStatusDelivered extends BatchStatus{

    private BatchStatusDelivered() {}

    private static BatchStatusDelivered instance = new BatchStatusDelivered();

    public static BatchStatusDelivered getInstance() {
        return instance;
    }

    public String getStatus(){
        return "Entregue.";
    }

}
