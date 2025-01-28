package stateObserver;

public class BatchStatusPackaged extends BatchStatus{

    private BatchStatusPackaged() {};

    private static BatchStatusPackaged instance = new BatchStatusPackaged();

    public static BatchStatusPackaged getInstance() {
        return instance;
    }

    public String getStatus(){
        return "Empacotado.";
    }

    public boolean transport(FoodBatch batch){
        batch.setStatus(BatchStatusInTransport.getInstance());
        return true;
    }

    public boolean reanalyze(FoodBatch batch){
        batch.setStatus(BatchStatusReanalysis.getInstance());
        return true;
    }

}
