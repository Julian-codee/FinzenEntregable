package com.finzen.finzenback.controller;

import com.finzen.finzenback.Models.Entities.Gasto;
import com.finzen.finzenback.Service.GastoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/finzen/gastos")
@CrossOrigin(origins = "*")
@Tag(name = "Gastos", description = "Operaciones relacionadas con los gastos")
public class GastoController {

    @Autowired
    private GastoService gastoService;

    @Operation(summary = "Obtener todos los gastos", description = "Devuelve una lista de todos los gastos registrados.")
    @GetMapping
    public List<Gasto> getAllGastos() {
        return gastoService.getAllGastos();
    }

    @Operation(summary = "Obtener un gasto por ID", description = "Devuelve un gasto específico según su ID.")
    @GetMapping("/{id}")
    public Optional<Gasto> getGastoById(@PathVariable Long id) {
        return gastoService.getGastoById(id);
    }

    @Operation(summary = "Crear un nuevo gasto", description = "Crea y guarda un nuevo gasto.")
    @PostMapping
    public Gasto createGasto(@RequestBody Gasto gasto) {
        return gastoService.saveGasto(gasto);
    }

    @Operation(summary = "Actualizar un gasto existente", description = "Actualiza un gasto ya registrado con nuevos datos.")
    @PutMapping("/{id}")
    public Gasto updateGasto(@PathVariable Long id, @RequestBody Gasto gasto) {
        return gastoService.updateGasto(id, gasto);
    }

    @Operation(summary = "Eliminar un gasto", description = "Elimina un gasto existente dado su ID.")
    @DeleteMapping("/{id}")
    public void deleteGasto(@PathVariable Long id) {
        gastoService.deleteGasto(id);
    }
}
