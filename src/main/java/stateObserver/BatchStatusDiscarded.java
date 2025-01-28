package stateObserver;

public class BatchStatusDiscarded extends BatchStatus{

    private BatchStatusDiscarded() {}

    private static BatchStatusDiscarded instance = new BatchStatusDiscarded();

    public static BatchStatusDiscarded getInstance() {
        return instance;
    }

    public String getStatus(){
        return "Descartado.";
    }

}