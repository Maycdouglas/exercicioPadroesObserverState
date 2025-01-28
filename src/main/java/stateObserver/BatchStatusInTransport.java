package stateObserver;

public class BatchStatusInTransport extends BatchStatus{
    private BatchStatusInTransport() {}

    private static BatchStatusInTransport instance = new BatchStatusInTransport();

    public static BatchStatusInTransport getInstance() {
        return instance;
    }

    public String getStatus(){
        return "Em transporte.";
    }

    public boolean confirmDelivery(FoodBatch batch){
        batch.setStatus(BatchStatusDelivered.getInstance());
        return true;
    }

}
