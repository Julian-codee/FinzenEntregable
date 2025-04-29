package com.finzen.finzenback.Service;

import com.finzen.finzenback.Models.Entities.Gasto;
import com.finzen.finzenback.Repository.GastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    public List<Gasto> getAllGastos() {
        return gastoRepository.findAll();
    }

    public Optional<Gasto> getGastoById(Long id) {
        return gastoRepository.findById(id);
    }

    public Gasto saveGasto(Gasto gasto) {
        return gastoRepository.save(gasto);
    }

    public Gasto updateGasto(Long id, Gasto gastoDetails) {
        return gastoRepository.findById(id).map(gasto -> {
            gasto.setNombre(gastoDetails.getNombre());
            gasto.setMonto(gastoDetails.getMonto());
            gasto.setDescripcion(gastoDetails.getDescripcion());
            gasto.setFecha(gastoDetails.getFecha());
            return gastoRepository.save(gasto);
        }).orElse(null);
    }

    public void deleteGasto(Long id) {
        gastoRepository.deleteById(id);
    }
}
