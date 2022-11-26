package com.merkadeam.market.web.controller;


import com.merkadeam.market.domain.Product;
import com.merkadeam.market.domain.Purchase;
import com.merkadeam.market.domain.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200","https://frond-merkadea-v2.web.app","https://merkadea-market.web.app"})
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @CrossOrigin(origins = {"https://frond-merkadea-v2.web.app"})

    @Operation(summary = "Petición GET que lista todo los productos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Petición exitosa", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Purchase.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request: Algo ha ido mal con la petición, refresca la página", content = @Content),
            @ApiResponse(responseCode = "204", description = "No Content: Petición exitosa pero sin resultado", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized: No hay permiso para recibir este contenido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Página no encontrada", content = @Content) })
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll()
    {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "Petición GET que lista todo los productos seleccionados por categoría.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Petición exitosa", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Purchase.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request: Algo ha ido mal con la petición, refresca la página", content = @Content),
            @ApiResponse(responseCode = "204", description = "No Content: Petición exitosa pero sin resultado", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized: No hay permiso para recibir este contenido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Página no encontrada", content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int productId) {
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Petición GET que lista todo los productos seleccionados, empleando la ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Petición exitosa", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Purchase.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request: Algo ha ido mal con la petición, refresca la página", content = @Content),
            @ApiResponse(responseCode = "204", description = "No Content: Petición exitosa pero sin resultado", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized: No hay permiso para recibir este contenido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Página no encontrada", content = @Content) })
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId) {
        return productService.getByCategory(categoryId)
                .map(products -> new ResponseEntity<>(products,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Petición POST que elimina los productos, empleando la ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Petición exitosa", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Purchase.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request: Algo ha ido mal con la petición, refresca la página", content = @Content),
            @ApiResponse(responseCode = "204", description = "No Content: Petición exitosa pero sin resultado", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized: No hay permiso para recibir este contenido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Página no encontrada", content = @Content) })
    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product),HttpStatus.CREATED);
    }

    @Operation(summary = "Petición DELETE que agrega productos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Petición exitosa", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Purchase.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request: Algo ha ido mal con la petición, refresca la página", content = @Content),
            @ApiResponse(responseCode = "204", description = "No Content: Petición exitosa pero sin resultado", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized: No hay permiso para recibir este contenido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Página no encontrada", content = @Content) })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId) {
        if (productService.delete(productId))
        {
            return new ResponseEntity(HttpStatus.OK);
        }else  {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }



}
