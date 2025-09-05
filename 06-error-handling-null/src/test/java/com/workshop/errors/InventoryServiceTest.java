package com.workshop.errors;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryServiceTest {
    @Test
    void reserves_when_enough(){
        InventoryService s = new InventoryService();
        s.add(new Product("1","Pen", 5));
        assertTrue(s.reserve("1", 3).isSuccess());
        assertTrue(s.release("1", 2).isSuccess());
    }
    @Test
    void codes_for_missing_and_insufficient(){
        InventoryService s = new InventoryService();
        assertEquals(ErrorCode.NOT_FOUND.code(), s.reserve("X", 1).getError().code());
        s.add(new Product("2","Pencil", 1));
        assertEquals(ErrorCode.INSUFFICIENT_STOCK.code(), s.reserve("2", 2).getError().code());
    }
}
