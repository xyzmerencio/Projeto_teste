package io.github.dougllasfps.imageliteapi.application.images;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController // Todo controlador Rest precisa dessa annotation para receber requisições HTTP
@RequestMapping("/v1/images") // Define a URL base para as requisições deste controlador
@Slf4j // Adiciona um objeto de logs para registrar informações sobre a execução
public class ImagesController {

    @PostMapping // Mapeia requisições HTTP POST para este método
    public ResponseEntity save(
            @RequestParam("file") MultipartFile file, // Recebe o arquivo enviado
            @RequestParam("name") String name, // Recebe o nome da imagem
            @RequestParam("tags") List<String> tags // Recebe as tags associadas à imagem
    ){
        // Registra informações sobre o arquivo recebido
        log.info("Imagem recebida: name: {}, size: {}", file.getOriginalFilename(), file.getSize());
        // Registra o nome definido para a imagem
        log.info("Nome definido para a imagem: {}", name);
        // Registra as tags recebidas
        log.info("Tags: {}", tags);

        // Retorna uma resposta HTTP 200 OK
        return ResponseEntity.ok().build();
    }
}
