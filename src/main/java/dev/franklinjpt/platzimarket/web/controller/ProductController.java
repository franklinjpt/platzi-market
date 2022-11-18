package dev.franklinjpt.platzimarket.web.controller;

import dev.franklinjpt.platzimarket.domain.Product;
import dev.franklinjpt.platzimarket.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    @ApiOperation("Get all supermarket products")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "There are not products in the database")
    })
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.of(productService.getAll());
    }

    @GetMapping("/price>{price}")
    @ApiOperation("Get all products by price and active on")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "There are not products with this requirement")
    })
    public ResponseEntity<List<Product>> getByPriceAndStatus(
            @ApiParam(value = "Price of the search", required = true, example = "4000")
            @PathVariable("price") double price)
    {
        return ResponseEntity.of(productService.getByPriceAndStatus(price));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") long productId) {
        return ResponseEntity.of(productService.getProduct(productId));
    }

    @PostMapping()
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") long productId) {
        return new ResponseEntity(this.productService.delete(productId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
