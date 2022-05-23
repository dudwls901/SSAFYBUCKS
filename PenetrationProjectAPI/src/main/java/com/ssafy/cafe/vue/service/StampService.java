package com.ssafy.cafe.vue.service;

import java.util.List;
import com.ssafy.cafe.vue.dto.Stamp;


public interface StampService {
    /**
     * id 사용자의 Stamp 이력을 반환한다.
     * @param id
     * @return
     */
    List<Stamp> selectByUser(String id);
}
