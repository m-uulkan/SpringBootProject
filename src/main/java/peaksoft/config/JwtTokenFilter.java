package peaksoft.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import peaksoft.service.serviceImple.UserServiceImple;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final UserServiceImple userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        final String tokenHeader=request.getHeader(HttpHeaders.AUTHORIZATION);
        String username=null;
        String jwtToken=null;

        if(tokenHeader!=null && tokenHeader.startsWith("Bearer ")){
            jwtToken=tokenHeader.substring(7);
            username=jwtUtil.getUsernameFromToken(jwtToken);
        }

        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails=this.userService.loadUserByUsername(username);
            if(jwtUtil.Validate(jwtToken,userDetails)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
                        new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}

