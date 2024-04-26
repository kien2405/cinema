package com.example.ThucTapLTS.helper;

import com.example.ThucTapLTS.entity.RefreshTokenEntity;
import com.example.ThucTapLTS.repository.RefreshTokenRepository;
import com.example.ThucTapLTS.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
@EnableScheduling
public class JwtHelper {
    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private UserRepository userRepository;

    //  @Value : Lấy giá trị của key khai báo bên application.yml/properties
    @Value("${secretKey.key}")
    private String secretKey;

    // Biến instance để lưu trữ dữ liệu cần truy cập trong phương thức refreshToken
    private String username;

    // Thời gian sử dụng của token, ví dụ: 5 giờ
    private static final long TOKEN_EXPIRATION_TIME = 5 * 60 * 60 * 1000;

    public String generateToken(String data){
        String token = createToken(data);
        System.out.println(data);
        refreshToken(data);
        return token;
    }

    public String createToken(String email){
        Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + TOKEN_EXPIRATION_TIME);

        String token = Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(key)
                .compact();
        return token;
    }

    public Claims decodeToken(String token) {
        Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }

    public void refreshToken(String username) {
        this.username = username;
    }

    @Scheduled(fixedRate = 3600000) // 10 giây
    public void refreshToken() {
        // Kiểm tra nếu username không null
        if (username != null) {
            Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));

            Date now = new Date();
            Date expiryDate = new Date(now.getTime() + TOKEN_EXPIRATION_TIME);

            // Chuyển đổi từ Date sang Instant
            Instant instant = expiryDate.toInstant();

            // Chuyển đổi từ Instant sang LocalDateTime
            LocalDateTime expiryLocalDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

            String newToken = createToken(username);

            RefreshTokenEntity refreshToken = new RefreshTokenEntity();
            refreshToken.setToken(newToken);
            refreshToken.setExpiredTime(expiryLocalDateTime);
            refreshToken.setUserEntity(userRepository.findByEmail(username));
            refreshTokenRepository.save(refreshToken);

            System.out.println("Refresh token thành công");
        } else {
            System.out.println("Không có username để tạo token mới");
        }
    }
}
