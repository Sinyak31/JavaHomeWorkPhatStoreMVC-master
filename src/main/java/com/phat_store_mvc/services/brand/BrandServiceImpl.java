package com.phat_store_mvc.services.brand;

import com.phat_store_mvc.model.goods.Brand;
import com.phat_store_mvc.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandServiceImpl implements BrandService {
    private BrandRepository brandRepository;

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getById(Integer id) {
        return brandRepository.findById(id).orElse(null);
    }

    @Override
    public List<Brand> getAllOrderById() {
        return brandRepository.findByOrderByIdAsc();
    }

    @Override
    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand update(Integer id, String name) {
        Optional<Brand> brandOptional = brandRepository.findById(id);
        if (brandOptional.isEmpty()) {
            throw new RuntimeException();
        }
        Brand brand = brandOptional.get();
        brand.setName(name);
        return brandRepository.save(brand);
    }

    @Override
    public boolean deleteById(Integer id) {
        if (brandRepository.findById(id).isPresent()) {
            brandRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
