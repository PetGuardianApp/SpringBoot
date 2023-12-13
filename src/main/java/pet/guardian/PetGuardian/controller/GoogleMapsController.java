package pet.guardian.PetGuardian.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/maps")
@CrossOrigin("*")
public class GoogleMapsController {
    @GetMapping(value = "/getNearbySearch")
    public ResponseEntity<Object> getNearbySearch(@RequestHeader String keyword,@RequestHeader String location,
                                                  @RequestHeader String radius, @RequestHeader String type)
            throws Exception {
        // URL de la API de Google Maps
        String apiUrl = "https://maps.googleapis.com/maps/api/place/nearbysearch/json" +
                "?keyword=" + keyword +
                "&location=" + location +
                "&radius=" + radius +
                "&type=" + type +
                "&key=AIzaSyAouWao_x1bulJ9RkrfYpYP49u2a9RzSXw";

        // Crear la URL y abrir la conexiÃ³n
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Configurar la solicitud
        connection.setRequestMethod("GET");

        // Leer la respuesta
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();
        connection.disconnect();

        // Obtener la respuesta
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("ERROR FILL DE LA GRAN PUTA", HttpStatus.BAD_REQUEST);
        }
    }
}