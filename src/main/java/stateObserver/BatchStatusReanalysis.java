package stateObserver;

public class BatchStatusReanalysis extends BatchStatus {

    private BatchStatusReanalysis() {}

    private static BatchStatusReanalysis instance = new BatchStatusReanalysis();

    public static BatchStatusReanalysis getInstance(){
        return instance;
    }

    public String getStatus(){
        return "Reanálise.";
    }

    public boolean analyze(FoodBatch batch){
        batch.setStatus(BatchStatusUnderAnalysis.getInstance());
        return true;
    }

    public boolean discard(FoodBatch batch){
        batch.setStatus(BatchStatusDiscarded.getInstance());
        return true;
    }

}
