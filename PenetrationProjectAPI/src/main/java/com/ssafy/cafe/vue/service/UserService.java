package com.ssafy.cafe.vue.service;

import java.util.Map;

import com.ssafy.cafe.vue.dto.User;


public interface UserService {
	
    /**
     * 사용자 정보를 DB에 저장한다.
     * INSERT
     * 
     * @param user
     */
    public int join(User user) ;

    /**
     * id, pass에 해당하는 User 정보를 반환한다.
     * SELECT
     * 
     * @param id
     * @param pass
     * @return
     * 조회된 User 정보를 반환한다.
     */
    public User login(String id, String pass);
    
    /**
     * id에 해당하는 사용자 정보를 삭제한다.
     * DELETE
     * @param id
     */
    public void leave(String id);
    
    /**
     * 해당 아이디가 이미 사용 중인지를 반환한다.
     * SELECT
     * @param id
     * @return
     */
    public boolean isUsedId(String id);

	User select(String id);

	int insert(User user);
	
	int update(User user);

	// 유저의 order정보, stamp정보를 반환한다
	public Map<String, Object> getInfo(String userId);
}
