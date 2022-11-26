package com.merkadeam.market.web.controller;

import com.merkadeam.market.domain.Purchase;
import com.merkadeam.market.domain.service.PurchaseService;
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

@CrossOrigin(origins = {"http://localhost:4200","https://frond-merkadea-v2.web.app","https://merkadea-market.web.app"})
@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @Operation(summary = "Petición POST que lista las categorias.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Petición exitosa", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Purchase.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request: Algo ha ido mal con la petición, refresca la página", content = @Content),
            @ApiResponse(responseCode = "204", description = "No Content: Petición exitosa pero sin resultado", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized: No hay permiso para recibir este contenido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Página no encontrada", content = @Content) })
    @GetMapping("/all")
    public ResponseEntity<List<Purchase>>getAll()
    {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }


    @Operation(summary = "Petición GET pedir una caregoria por ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Petición exitosa", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Purchase.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request: Algo ha ido mal con la petición, refresca la página", content = @Content),
            @ApiResponse(responseCode = "204", description = "No Content: Petición exitosa pero sin resultado", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized: No hay permiso para recibir este contenido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Página no encontrada", content = @Content) })
    @GetMapping("/client/{idClient}")
    public ResponseEntity<List<Purchase>> getByClient(@PathVariable("idClient")String clientId)
    {
        return purchaseService.getByClient(clientId)
                .map(purchases -> new ResponseEntity<>(purchases,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @Operation(summary = "Petición DELETE que elimina los productos, empleando la ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Petición exitosa", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Purchase.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request: Algo ha ido mal con la petición, refresca la página", content = @Content),
            @ApiResponse(responseCode = "204", description = "No Content: Petición exitosa pero sin resultado", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized: No hay permiso para recibir este contenido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Página no encontrada", content = @Content) })
    @PostMapping("/save")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase)
    {
        return new ResponseEntity<>(purchaseService.save(purchase),HttpStatus.CREATED);
    }

}
