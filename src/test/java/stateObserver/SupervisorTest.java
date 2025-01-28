package stateObserver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SupervisorTest {

    FoodBatch foodBatch;
    Supervisor supervisor;
    Boolean statusOperation;

    @BeforeEach
    public void setUp() {
        foodBatch = new FoodBatch(123,"Biscoito");
        statusOperation = foodBatch.pack();
        supervisor = new Supervisor("João","S1234");
    }

    @Test
    void deveNotificarUmSupervisor(){
        supervisor.supervisionar(foodBatch);
        statusOperation = foodBatch.reanalyze();
        assertEquals("O lote 123 foi enviado para reanálise!",supervisor.getUltimaNotificacao());
    }

    @Test
    void deveNotificarSupervisores(){
        Supervisor supervisor2 = new Supervisor("Maria", "S4321");
        supervisor.supervisionar(foodBatch);
        supervisor2.supervisionar(foodBatch);
        statusOperation = foodBatch.reanalyze();
        assertEquals("O lote 123 foi enviado para reanálise!", supervisor.getUltimaNotificacao());
        assertEquals("O lote 123 foi enviado para reanálise!", supervisor2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarSupervisor(){
        statusOperation = foodBatch.reanalyze();
        assertNull(supervisor.getUltimaNotificacao());
    }

    @Test
    void deveNotificarSupervisorLote123(){
        Supervisor supervisor2 = new Supervisor("Maria", "S4321");
        FoodBatch foodBatch2 = new FoodBatch(321,"Salgadinho");
        supervisor.supervisionar(foodBatch);
        supervisor2.supervisionar(foodBatch2);
        statusOperation = foodBatch.reanalyze();
        assertEquals("O lote 123 foi enviado para reanálise!",supervisor.getUltimaNotificacao());
        assertNull(supervisor2.getUltimaNotificacao());
    }

}