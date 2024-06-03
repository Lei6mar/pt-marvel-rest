package mx.com.bwl.marvel_rest.controller;

import mx.com.bwl.marvel_rest.entity.Bitacora;
import mx.com.bwl.marvel_rest.service.BitacoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/bitacora")
public class BitacoraController {

    private final BitacoraService bitacoraService;

    @Autowired
    public BitacoraController(BitacoraService bitacoraService) {
        this.bitacoraService = bitacoraService;
    }


    @GetMapping(produces = "application/json")
    public List<Bitacora> getBitacoraRegisters(){
        return this.bitacoraService.getAll();
    }
}
