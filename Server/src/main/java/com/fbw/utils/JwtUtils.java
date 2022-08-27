package com.fbw.utils;

import com.fbw.domain.User;
import com.fbw.service.IUserService;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtils {
    @Autowired
    private IUserService iuserService;
    /**
     * 过期时间5分钟
     */
    private static final long EXPIRE_TIME=24*60*60*1000;
    /**
     * 加密密钥
     */
    private static final String KEY = "wsnd";

    /**
     * 生成token
     * @return
     */
    public String createToken(User user){
        Map<String,Object> header = new HashMap();
        header.put("typ","JWT");
        header.put("alg","HS256");
        //setID:用户ID
        //setExpiration:token过期时间  当前时间+有效时间
        //setSubject:用户名
        //setIssuedAt:token创建时间
        //signWith:加密方式
        JwtBuilder builder = Jwts.builder().setHeader(header)
//                .setId(id) 这是提供的默认方式
                .claim("id",user.getOId().toString())
                .claim("userName",user.getUserName())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE_TIME))
//                .setSubject(userName)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,KEY);
        return builder.compact();
    }

    /**
     * 验证token是否有效
     * @param token  请求头中携带的token
     * @return  token验证结果  2-token过期；1-token认证通过；0-token认证失败
     */
    public Object verify(String token){
        Claims claims = null;
        try {
            //token过期后，会抛出ExpiredJwtException 异常，通过这个来判定token过期，
            claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
        }catch (ExpiredJwtException e){
            System.out.println("token过期");
            return null;
        }
        //从token中获取用户id，查询该Id的用户是否存在，存在则token验证通过
        int id = Integer.decode((String)claims.get("id"));
        String userName = (String)claims.get("userName");
        System.out.println("token验证:"+id+userName);
//        String id = claims.getId();
//        Object userService;
//        User user = iuserService.selectUserById(id);
//        System.out.println(userName);
//        System.out.println(id);
        User user = iuserService.selectById(id);
        return user;
    }
}
