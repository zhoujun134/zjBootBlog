package com.zj.zs.converter;

import com.zj.zs.domain.dto.request.RegisterUserInfoReqDTO;
import com.zj.zs.domain.entity.UserDO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-17T22:04:49+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public UserDO toUserDO(RegisterUserInfoReqDTO request, String aesKey) {
        if ( request == null && aesKey == null ) {
            return null;
        }

        UserDO userDO = new UserDO();

        if ( request != null ) {
            userDO.setName( request.getName() );
            userDO.setUsername( request.getUsername() );
            userDO.setEmail( request.getEmail() );
            userDO.setDescription( request.getDescription() );
        }
        userDO.setPassword( cn.dev33.satoken.secure.SaSecureUtil.aesEncrypt(aesKey, request.getPassword()) );

        return userDO;
    }
}
