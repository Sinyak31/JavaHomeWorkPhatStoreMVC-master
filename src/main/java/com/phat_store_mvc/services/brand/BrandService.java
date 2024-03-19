package com.phat_store_mvc.services.brand;

import com.phat_store_mvc.model.goods.Brand;
import com.phat_store_mvc.services.DataService;

import java.util.List;

public interface BrandService extends DataService<Brand> {
    @Override
    List<Brand> getAll();

    @Override
    Brand getById(Integer id);

    List<Brand> getAllOrderById();

    @Override
    Brand save(Brand brand);

    @Override
    Brand update(Integer id, String name);

    @Override
    boolean deleteById(Integer id);
}
