package biz.nable.sampath.oc.services;


import biz.nable.sampath.oc.db.entity.Product;

public interface ProductService {
    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);
}
