package com.finzen.finzenback.Repository;

import com.finzen.finzenback.Models.Entities.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastoRepository extends JpaRepository <Gasto, Long> {
}
