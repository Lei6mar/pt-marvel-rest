package mx.com.bwl.marvel_rest.service;

import mx.com.bwl.marvel_api.service.impl.MarvelApiServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MarvelService {

    @Value("${API_PUBLIC_KEY}")
    private String apiPublicKey;
    @Value("${API_PRIVATE_KEY}")
    private String apiPrivateKey;
    @Value("${API_TIMESTAMP_VALUE}")
    private String apiTimestampValue;

    public mx.com.bwl.marvel_api.vo.marvel.ResponseVO findAllCharacters(){
        mx.com.bwl.marvel_api.service.MarvelApiService marvelApiService = new MarvelApiServiceImpl(apiPublicKey, apiPrivateKey, apiTimestampValue);
        return marvelApiService.findAllCharacters();
    }

    public mx.com.bwl.marvel_api.vo.marvel.ResponseVO getCharacterById(Long id){
        mx.com.bwl.marvel_api.service.MarvelApiService marvelApiService = new MarvelApiServiceImpl(apiPublicKey, apiPrivateKey, apiTimestampValue);
        return marvelApiService.findCharacterById(id);
    }

}
