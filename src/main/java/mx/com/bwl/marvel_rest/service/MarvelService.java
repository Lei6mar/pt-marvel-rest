package mx.com.bwl.marvel_rest.service;

import mx.com.bwl.marvel_api.service.impl.MarvelApiServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MarvelService {

    private final String apiPublicKey;
    private final String apiPrivateKey;
    private final String apiTimestampValue;

    MarvelService(){
        apiPublicKey = System.getenv("API_PUBLIC");
        apiPrivateKey = System.getenv("API_PRIVATE");
        apiTimestampValue = System.getenv("API_TIMESTAMP");
    }

    public mx.com.bwl.marvel_api.vo.marvel.ResponseVO findAllCharacters(){
        mx.com.bwl.marvel_api.service.MarvelApiService marvelApiService = new MarvelApiServiceImpl(apiPublicKey, apiPrivateKey, apiTimestampValue);
        return marvelApiService.findAllCharacters();
    }

    public mx.com.bwl.marvel_api.vo.marvel.ResponseVO getCharacterById(Long id){
        mx.com.bwl.marvel_api.service.MarvelApiService marvelApiService = new MarvelApiServiceImpl(apiPublicKey, apiPrivateKey, apiTimestampValue);
        return marvelApiService.findCharacterById(id);
    }

}
