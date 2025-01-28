package stateObserver;

public abstract class BatchStatus {
    public abstract String getStatus();

    public boolean analyze(FoodBatch batch){
        return false;
    }

    public boolean discard(FoodBatch batch){
        return false;
    }

    public boolean pack(FoodBatch batch){
        return false;
    }

    public boolean reanalyze(FoodBatch batch){
        return false;
    }

    public boolean transport(FoodBatch batch){
        return false;
    }

    public boolean confirmDelivery(FoodBatch batch){
        return false;
    }
}
