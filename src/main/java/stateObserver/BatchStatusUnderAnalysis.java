package stateObserver;

public class BatchStatusUnderAnalysis extends BatchStatus {

    private BatchStatusUnderAnalysis() {};

    private static BatchStatusUnderAnalysis instance = new BatchStatusUnderAnalysis();

    public static BatchStatusUnderAnalysis getInstance() {
        return instance;
    }

    public String getStatus(){
        return "Em análise.";
    }

    public boolean pack(FoodBatch batch){
        batch.setStatus(BatchStatusPackaged.getInstance());
        return true;
    }

    public boolean discard(FoodBatch batch){
        batch.setStatus(BatchStatusDiscarded.getInstance());
        return true;
    }


}
