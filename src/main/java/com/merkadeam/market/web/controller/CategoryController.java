package com.merkadeam.market.web.controller;


import com.merkadeam.market.domain.Category;
import com.merkadeam.market.domain.Purchase;
import com.merkadeam.market.domain.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = {"http://localhost:4200","https://frond-merkadea-v2.web.app","https://merkadea-market.web.app"})
@RestController
@RequestMapping("/categorys")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @Operation(summary = "Petición GET que lista todo los productos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Petición exitosa", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Purchase.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request: Algo ha ido mal con la petición, refresca la página", content = @Content),
            @ApiResponse(responseCode = "204", description = "No Content: Petición exitosa pero sin resultado", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized: No hay permiso para recibir este contenido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Página no encontrada", content = @Content) })
    @GetMapping("/alll")
    public List<Category> getAll()
    {
        return categoryService.getAll();
    }

    @Operation(summary = "Petición GET que elimina los productos, empleando la ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Petición exitosa", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Purchase.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request: Algo ha ido mal con la petición, refresca la página", content = @Content),
            @ApiResponse(responseCode = "204", description = "No Content: Petición exitosa pero sin resultado", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized: No hay permiso para recibir este contenido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Página no encontrada", content = @Content) })
    @GetMapping("/{categoryId}")
    public Optional<Category> getCategory(@PathVariable("categoryId") int categoryId)
    {
        return categoryService.getCategory(categoryId);
    }

    @Operation(summary = "Petición POST que elimina los productos, empleando la ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Petición exitosa", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Purchase.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request: Algo ha ido mal con la petición, refresca la página", content = @Content),
            @ApiResponse(responseCode = "204", description = "No Content: Petición exitosa pero sin resultado", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized: No hay permiso para recibir este contenido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Página no encontrada", content = @Content) })
    @PostMapping("/save")
    public Category save(@RequestBody Category category)
    {
        return categoryService.save(category);
    }

    @Operation(summary = "Petición DELETE que elimina los productos, empleando la ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Petición exitosa", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Purchase.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request: Algo ha ido mal con la petición, refresca la página", content = @Content),
            @ApiResponse(responseCode = "204", description = "No Content: Petición exitosa pero sin resultado", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized: No hay permiso para recibir este contenido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Página no encontrada", content = @Content) })
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int categoryId)
    {
        return categoryService.delete(categoryId);
    }
}
