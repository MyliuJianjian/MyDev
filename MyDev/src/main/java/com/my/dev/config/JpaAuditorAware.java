package com.my.dev.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 功能描述
 *
 * @author LIUJIANJIAN
 * @date 2021年6月21日19:21:11$
 */
@Component
@Slf4j
public class JpaAuditorAware implements AuditorAware<Integer> {

    @Override
    public Optional<Integer> getCurrentAuditor() {
        Integer userId = 99;
        if (userId != null){
            return Optional.of(userId);
        } else {
            return Optional.empty();
        }
    }
}
