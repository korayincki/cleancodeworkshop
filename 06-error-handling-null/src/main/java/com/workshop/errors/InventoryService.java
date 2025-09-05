package com.workshop.errors;

import java.util.*;

public class InventoryService {
    private final Map<String, Product> map = new HashMap<>();

    public void add(Product p){ map.put(p.id(), p); }

    public Result<Product> find(String id){
        Product data = map.get(id);

        if(data == null)
            return Result.failure(ErrorCode.NOT_FOUND);

        return Result.success(data);
    }

    public Result<Void> reserve(String id, int qty){
        Result<Product> product = find(id);

        if(!product.isSuccess()) {
            return Result.failure(product.getError());
        }

        Product p = product.getData();

        if(p.stock() < qty)
            return Result.failure(ErrorCode.INSUFFICIENT_STOCK);

        map.put(id, new Product(p.id(), p.name(), p.stock()-qty));

        return Result.success(null);
    }

    public Result<Void> release(String id, int qty){
        Result<Product> product = find(id);

        if(!product.isSuccess()) {
            return Result.failure(product.getError());
        }

        Product p = product.getData();

        map.put(id, new Product(p.id(), p.name(), p.stock()+qty));

        return Result.success(null);
    }
}
