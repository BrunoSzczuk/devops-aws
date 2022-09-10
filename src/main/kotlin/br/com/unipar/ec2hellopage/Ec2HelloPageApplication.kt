package br.com.unipar.ec2hellopage

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RestControllerAdvice
import kotlin.random.Random

@SpringBootApplication
class Ec2HelloPageApplication

fun main(args: Array<String>) {
    runApplication<Ec2HelloPageApplication>(*args)
}

@RestController
class HelloController {
    @GetMapping("/")
    fun hello(): String {
        if (Random.nextBoolean()) {
            throw RuntimeException("Ops, deu ruim!")
        }
        return "<html> <body> <b>Deu bom<b> </br><img src=\"https://www.ofuxico.com.br/img/upload/noticias/2019/04/30/faustao_reproducao_tv_globo_348281_36.jpg\"> </body> </html>."
    }
}


@RestControllerAdvice
class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler
    fun handleException(e: Exception): String {
        return "<html> <body> Deu ruim </br><img src=\"https://uploads.metropoles.com/wp-content/uploads/2021/01/04192048/faustao-8.jpg\"> </body> </html>."
    }
}