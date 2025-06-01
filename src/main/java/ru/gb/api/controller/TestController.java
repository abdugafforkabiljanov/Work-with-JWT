package ru.gb.api.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.service.JwtTokenService;


@RestController
public class TestController {
    private final JwtTokenService service;

    @Autowired
    public TestController(JwtTokenService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> testEndpoint(HttpServletRequest httpServletRequest) {
        int userId = service.getUserIdFromToken(httpServletRequest);
        return new ResponseEntity<>("Hello World! " + userId, HttpStatus.OK);
    }
}
/*
1 . Avval UserDTO ni o‘rganing: Bu oddiy sinf bo‘lib, dasturga kiruvchi ma'lumotlarni tushunishga yordam beradi.
2 . LoginService ni tahlil qiling: Autentifikatsiya logikasini tushunish uchun.
3 . JwtTokenService ga chuqur kirib boring: Bu sinf dasturning yuragi, chunki token yaratish va tekshirishni boshqaradi.
4 . AuthController ni ko‘rib chiqing: Login jarayonini qanday boshqarishini tushunish uchun.
5 . JwtRequestFilter ni o‘rganing: Himoyalangan resurslarga kirishni qanday nazorat qilishini bilish uchun.
6 . Nihoyat, TestController ni ko‘ring: Yakuniy natijani ko‘rish uchun.
 */

