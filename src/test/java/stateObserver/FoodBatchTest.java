package stateObserver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodBatchTest {
    FoodBatch foodBatch;

    @BeforeEach
    public void setUp() {
        foodBatch = new FoodBatch(1,"Biscoito");
    }

    // Alimento em análise
    @Test
    public void naoDeveAnalisarAlimentoEmAnalise(){
        foodBatch.setStatus(BatchStatusUnderAnalysis.getInstance());
        assertFalse(foodBatch.analyze());
    }

    @Test
    public void deveDescartarAlimentoEmAnalise(){
        foodBatch.setStatus(BatchStatusUnderAnalysis.getInstance());
        assertTrue(foodBatch.discard());
        assertEquals(BatchStatusDiscarded.getInstance(), foodBatch.getStatus());
    }

    @Test
    public void deveEmpacotarAlimentoEmAnalise(){
        foodBatch.setStatus(BatchStatusUnderAnalysis.getInstance());
        assertTrue(foodBatch.pack());
        assertEquals(BatchStatusPackaged.getInstance(), foodBatch.getStatus());
    }

    @Test
    public void naoDeveReanalisarAlimentoEmAnalise(){
        foodBatch.setStatus(BatchStatusUnderAnalysis.getInstance());
        assertFalse(foodBatch.reanalyze());
    }

    @Test
    public void naoDeveTransportarAlimentoEmAnalise(){
        foodBatch.setStatus(BatchStatusUnderAnalysis.getInstance());
        assertFalse(foodBatch.transport());
    }

    @Test
    public void naoDeveEntregarAlimentoEmAnalise(){
        foodBatch.setStatus(BatchStatusUnderAnalysis.getInstance());
        assertFalse(foodBatch.confirmDelivery());
    }

    // Alimento descartado
    @Test
    public void naoDeveAnalisarAlimentoDescartado(){
        foodBatch.setStatus(BatchStatusDiscarded.getInstance());
        assertFalse(foodBatch.analyze());
    }

    @Test
    public void naoDeveDescartarAlimentoDescartado(){
        foodBatch.setStatus(BatchStatusDiscarded.getInstance());
        assertFalse(foodBatch.discard());
    }

    @Test
    public void naoDeveEmpacotarAlimentoDescartado(){
        foodBatch.setStatus(BatchStatusDiscarded.getInstance());
        assertFalse(foodBatch.pack());
    }

    @Test
    public void naoDeveReanalisarAlimentoDescartado(){
        foodBatch.setStatus(BatchStatusDiscarded.getInstance());
        assertFalse(foodBatch.reanalyze());
    }

    @Test
    public void naoDeveTransportarAlimentoDescartado(){
        foodBatch.setStatus(BatchStatusDiscarded.getInstance());
        assertFalse(foodBatch.transport());
    }

    @Test
    public void naoDeveEntregarAlimentoDescartado(){
        foodBatch.setStatus(BatchStatusDiscarded.getInstance());
        assertFalse(foodBatch.confirmDelivery());
    }

    // Alimento empacotado
    @Test
    public void naoDeveAnalisarAlimentoEmpacotado(){
        foodBatch.setStatus(BatchStatusPackaged.getInstance());
        assertFalse(foodBatch.analyze());
    }

    @Test
    public void naoDeveDescartarAlimentoEmpacotado(){
        foodBatch.setStatus(BatchStatusPackaged.getInstance());
        assertFalse(foodBatch.discard());
    }

    @Test
    public void naoDeveEmpacotarAlimentoEmpacotado(){
        foodBatch.setStatus(BatchStatusPackaged.getInstance());
        assertFalse(foodBatch.pack());
    }

    @Test
    public void deveReanalisarAlimentoEmpacotado(){
        foodBatch.setStatus(BatchStatusPackaged.getInstance());
        assertTrue(foodBatch.reanalyze());
        assertEquals(BatchStatusReanalysis.getInstance(), foodBatch.getStatus());
    }

    @Test
    public void deveTransportarAlimentoEmpacotado(){
        foodBatch.setStatus(BatchStatusPackaged.getInstance());
        assertTrue(foodBatch.transport());
        assertEquals(BatchStatusInTransport.getInstance(), foodBatch.getStatus());
    }

    @Test
    public void naoDeveEntregarAlimentoEmpacotado(){
        foodBatch.setStatus(BatchStatusPackaged.getInstance());
        assertFalse(foodBatch.confirmDelivery());
    }

    // Alimento em reanálise
    @Test
    public void deveAnalisarAlimentoEmReanalise(){
        foodBatch.setStatus(BatchStatusReanalysis.getInstance());
        assertTrue(foodBatch.analyze());
        assertEquals(BatchStatusUnderAnalysis.getInstance(),foodBatch.getStatus());
    }

    @Test
    public void deveDescartarAlimentoEmReanalise(){
        foodBatch.setStatus(BatchStatusReanalysis.getInstance());
        assertTrue(foodBatch.discard());
        assertEquals(BatchStatusDiscarded.getInstance(),foodBatch.getStatus());
    }

    @Test
    public void naoDeveEmpacotarAlimentoEmReanalise(){
        foodBatch.setStatus(BatchStatusReanalysis.getInstance());
        assertFalse(foodBatch.pack());
    }

    @Test
    public void naoDeveReanalisarAlimentoEmReanalise(){
        foodBatch.setStatus(BatchStatusReanalysis.getInstance());
        assertFalse(foodBatch.reanalyze());
    }

    @Test
    public void naoDeveTransportarAlimentoEmReanalise(){
        foodBatch.setStatus(BatchStatusReanalysis.getInstance());
        assertFalse(foodBatch.transport());
    }

    @Test
    public void naoDeveEntregarAlimentoEmReanalise(){
        foodBatch.setStatus(BatchStatusReanalysis.getInstance());
        assertFalse(foodBatch.confirmDelivery());
    }

    // Alimento em transporte
    @Test
    public void naoDeveAnalisarAlimentoEmTransporte(){
        foodBatch.setStatus(BatchStatusInTransport.getInstance());
        assertFalse(foodBatch.analyze());
    }

    @Test
    public void naoDeveDescartarAlimentoEmTransporte(){
        foodBatch.setStatus(BatchStatusInTransport.getInstance());
        assertFalse(foodBatch.discard());
    }

    @Test
    public void naoDeveEmpacotarAlimentoEmTransporte(){
        foodBatch.setStatus(BatchStatusInTransport.getInstance());
        assertFalse(foodBatch.pack());
    }

    @Test
    public void naoDeveReanalisarAlimentoEmTransporte(){
        foodBatch.setStatus(BatchStatusInTransport.getInstance());
        assertFalse(foodBatch.reanalyze());
    }

    @Test
    public void naoDeveTransportarAlimentoEmTransporte(){
        foodBatch.setStatus(BatchStatusInTransport.getInstance());
        assertFalse(foodBatch.transport());
    }

    @Test
    public void deveEntregarAlimentoEmTransporte(){
        foodBatch.setStatus(BatchStatusInTransport.getInstance());
        assertTrue(foodBatch.confirmDelivery());
        assertEquals(BatchStatusDelivered.getInstance(), foodBatch.getStatus());
    }

    // Alimento entregue
    @Test
    public void naoDeveAnalisarAlimentoEntregue(){
        foodBatch.setStatus(BatchStatusDelivered.getInstance());
        assertFalse(foodBatch.analyze());
    }

    @Test
    public void naoDeveDescartarAlimentoEntregue(){
        foodBatch.setStatus(BatchStatusDelivered.getInstance());
        assertFalse(foodBatch.discard());
    }

    @Test
    public void naoDeveEmpacotarAlimentoEntregue(){
        foodBatch.setStatus(BatchStatusDelivered.getInstance());
        assertFalse(foodBatch.pack());
    }

    @Test
    public void naoDeveRealisarAlimentoEntregue(){
        foodBatch.setStatus(BatchStatusDelivered.getInstance());
        assertFalse(foodBatch.reanalyze());
    }

    @Test
    public void naoDeveTransportarAlimentoEntregue(){
        foodBatch.setStatus(BatchStatusDelivered.getInstance());
        assertFalse(foodBatch.transport());
    }

    @Test
    public void naoDeveEntregarAlimentoEntregue(){
        foodBatch.setStatus(BatchStatusDelivered.getInstance());
        assertFalse(foodBatch.confirmDelivery());
    }

}