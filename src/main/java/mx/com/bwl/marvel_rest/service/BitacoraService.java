package mx.com.bwl.marvel_rest.service;

import mx.com.bwl.marvel_rest.entity.Bitacora;
import mx.com.bwl.marvel_rest.repository.BitacoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BitacoraService {

    private final BitacoraRepository bitacoraRepository;

    @Autowired
    public BitacoraService(BitacoraRepository bitacoraRepository) {
        this.bitacoraRepository = bitacoraRepository;
    }

    public void save(String user, String action){
        this.bitacoraRepository.save(new Bitacora(user, new Date(), action));
    }

    public List<Bitacora> getAll(){
        return this.bitacoraRepository.findAll();
    }
}
