package mx.com.bwl.marvel_rest.controller;

import mx.com.bwl.marvel_rest.service.BitacoraService;
import mx.com.bwl.marvel_rest.service.MarvelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marvel/api")
public class MarvelRestController {

    private final MarvelService marvelService;
    private final BitacoraService bitacoraService;

    @Autowired
    public MarvelRestController(MarvelService marvelService, BitacoraService bitacoraService) {
        this.bitacoraService = bitacoraService;
        this.marvelService = marvelService;
    }

    @GetMapping(value = "/getCharacters", produces = "application/json")
    public mx.com.bwl.marvel_api.vo.marvel.ResponseVO getCharacters(Authentication authentication){
        this.bitacoraService.save(authentication.getName(), "GET /getCharacters");
        return this.marvelService.findAllCharacters();
    }

    @GetMapping(value = "/getCharacters/{id}", produces = "application/json")
    public mx.com.bwl.marvel_api.vo.marvel.ResponseVO getCharacterById(@PathVariable("id") Long id, Authentication authentication){
        this.bitacoraService.save(authentication.getName(), "GET /getCharacters/".concat(String.valueOf(id)));
        return this.marvelService.getCharacterById(id);
    }
}
