package exchange.rate.exchangetest.infrastructure.usecase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import exchange.rate.exchangetest.domain.entity.Currency;
import exchange.rate.exchangetest.domain.usecase.GetCurrencyRate;
import java.lang.reflect.Type;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
class GetCurrencyRateImpl implements GetCurrencyRate {

    @Value("${currency.url}")
    private String url;

    @Value("${currency.key}")
    private String key;

    @Override
    public double execute(Currency currency) {
        String uri = UriComponentsBuilder.fromUriString(url)
            .build().encode().toUriString();
        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", key);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity<>(headers);
        // var response = new ParameterizedTypeReference<Map<String, Object>>(){};

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
            uri,
            HttpMethod.GET,
            httpEntity,
            String.class
        );
        Gson gson = new Gson();
        Type type = new TypeToken<CurrencyLayerResponse>(){}.getType();

        CurrencyLayerResponse rateResponse = gson.fromJson(responseEntity.getBody(), type);
        return rateResponse.quotes.get(currency.getQuotes());
    }
}
