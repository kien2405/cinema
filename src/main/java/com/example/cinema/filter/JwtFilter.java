package com.example.ThucTapLTS.filter;

import com.example.ThucTapLTS.entity.RefreshTokenEntity;
import com.example.ThucTapLTS.entity.RoleEntity;
import com.example.ThucTapLTS.entity.UserEntity;
import com.example.ThucTapLTS.helper.JwtHelper;
import com.example.ThucTapLTS.repository.RefreshTokenRepository;
import com.example.ThucTapLTS.repository.RoleRepository;
import com.example.ThucTapLTS.repository.UserRepository;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//  Tất cả request đều phải chạy vào filter này
@Component
public class JwtFilter extends OncePerRequestFilter {
    /**
     *  Nhận được token truyền trên header
     *  Giải mã token
     *  Nếu giải mã thành công thì hợp lệ
     *  Tạo chứng thực và cho đi vào link người gọi
     */

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            UserEntity userEntity = userRepository.findByEmail(request.getHeader("Email"));
            String refreshToken = refreshTokenRepository.findLatestTokenByUserId(userEntity.getId());
            if(refreshToken != null) {
                System.out.println(refreshToken);
                //  Giải mã token
                Claims claims = jwtHelper.decodeToken(refreshToken);
                if(claims != null) {
                    // Lấy thông tin người dùng từ token (ví dụ: username)
                    String username = claims.getSubject();

                    // Lấy danh sách quyền (roles) từ cơ sở dữ liệu
                    List<RoleEntity> roles = userRepository.findRoleByEmail(username); // Ví dụ: sử dụng repository để truy vấn quyền của người dùng

                    // Tạo danh sách GrantedAuthority từ danh sách quyền
                    List<GrantedAuthority> authorities = new ArrayList<>();
                    for (RoleEntity data : roles) {
                        authorities.add(new SimpleGrantedAuthority("ROLE_" + data.getRoleName()));
                        System.out.println(authorities);
                    }

                    // Tạo chứng thực cho Security
                    Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);
                    // Đặt thông tin chứng thực vào SecurityContext
                    SecurityContextHolder.getContext().setAuthentication(authentication);

                }
            }
        } catch (Exception e) {
            System.out.println("Đã đăng nhập");
        }
        filterChain.doFilter(request,response);
    }
}
