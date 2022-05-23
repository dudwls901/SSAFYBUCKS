import Vue from "vue";
import Vuex from "vuex";
import http from "@/util/http-common";

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        loginUser: {},          // 로그인한 유저 정보
        isRegistered: 0,    // 이미 가입된 회원인지 체크할 값
        products: [],           // 전체 상품 리스트
    },
    getters: {
        getLoginUser(state) {
            return state.loginUser;
        },
        getIsRegistered(state) {
            return state.isRegistered;
        },
        getProducts(state) {
            return state.products;
        }
    },
    mutations: {
        // mutate 실행
        DO_MUTATION() { },

        // 로그인한 유저 정보를 초기화
        RESET_LOGINUSER(state) {
            state.loginUser = {}
        },

        // 로그인 성공시 로그인한 유저 정보 동기화
        LOGIN_LOGINUSER(state, payload) {
            state.loginUser = payload
        },

        // 회원 등록 여부 미표시
        SET_ISREGISTERED_NONE(state) {
            state.isRegistered = 0;
        },

        // 이미 등록된 회원이라고 설정
        SET_ISREGISTERED_TRUE(state) {
            state.isRegistered = 1;
        },

        // 이미 등록된 회원이 아니라고 설정
        SET_ISREGISTERED_FALSE(state) {
            state.isRegistered = -1;
        },

        // 상품 리스트를 동기화
        SET_PRODUCTS(state, payload) {
            for (let key in payload) {
                payload[key].quantity = 0;
            }
            state.products = payload;
        },

        // 주문 할때 담은 상품의 수량 확인
        COUNT_PRODUCTS_QUANTITY(state, payload) {
            let index = payload.data.index;
            let num = payload.data.num;
            if (num === 1) {
                state.products[index].quantity++;
            }
            else if (num === -1 && state.products[index].quantity > 0) {
                state.products[index].quantity--;
            }
        }
    },
    actions: {
        // 로그인 기능
        login({ commit }, payload) {
            http.post(`/user/login`, payload.data)
                .then((response) => {
                    commit("LOGIN_LOGINUSER", response.data);
                    payload.success();
                })
                .catch((error) => {
                    console.log(error);
                    payload.fail();
                });
        },

        // 로그아웃 기능
        logout({ commit }, payload) {
            http.get(`/user/logout`)
                .then((response) => {
                    console.log(response.data);
                    commit("RESET_LOGINUSER");
                    payload.success();
                })
                .catch((error) => {
                    console.log(error);
                    payload.fail();
                });
        },

        // 아이디 중복 검사
        isUsedId({ commit }, payload) {
            http.get(`/user/check/${payload.data}`)
                .then((response) => {
                    console.log(response.data);
                    commit("DO_MUTATION")
                    payload.success();
                })
                .catch((error) => {
                    console.log(error);
                    commit("DO_MUTATION")
                    payload.fail();
                });
        },

        // 회원가입 기능
        registerUser({ commit }, payload) {
            http.post(`/join`, payload.data)
                .then(() => {
                    commit("DO_MUTATION");
                    payload.success();
                })
                .catch((error) => {
                    console.log(error);
                    commit("DO_MUTATION");
                    payload.fail();
                })
        },

        // 상품 전체 리스트를 조회
        getProducts({ commit }, payload) {
            http.get(`/product`)
                .then((response) => {
                    commit("SET_PRODUCTS", response.data);
                })
                .catch((error) => {
                    console.log(error);
                    payload.fail();
                });
        },

        // productId에 해당하는 상품 조회
        getProductById ({ commit }, payload) {
            http.get(`/product/${payload.data}`)
                .then((response) => {
                    console.log(response.data);
                    commit("DO_MUTATION");
                    payload.success(response.data.product, response.data.totalOrder);
                })
                .catch((error) => {
                    console.log(error);
                    payload.fail();
                });
        },

        // 주문하기
        orderProducts({ commit }, payload) {
            console.log(payload.data);
            http.post(`/order`, payload.data)
                .then((response) => {
                    console.log(response);
                    commit("DO_MUTATION");
                    payload.success();
                })
                .catch((error) => {
                    console.log(error);
                });
        },

        // 유저의 주문 목록을 조회 (총 스탬프, 주문상세정보 포함)
        // 넘어온 데이터 예시
        // {"stamp":3,"orders":[{"id":1,"userId":"id 01","orderTable":"order_table 01","orderTime":"2022-03-26T15:05:33.000+00:00","completed":"N","details":[{"id":1,"orderId":1,"productId":1,"quantity":1},{"id":2,"orderId":1,"productId":2,"quantity":3}]},
        //                      { "id": 2, "userId": "id 01", "orderTable": "order_table 02", "orderTime": "2022-03-26T15:05:33.000+00:00", "completed": "N", "details": [] }]}
        getUserInfo({ commit },payload) {
            http.post(`/user/info`, payload.data)
                .then((response) => {
                    console.log(response.data);
                    commit("DO_MUTATION");
                    payload.success(response.data.stamp, response.data.orders);
                })
                .catch((error) => {
                    console.log(error);
                });
        },

        // productId에 해당하는 코멘트 목록 조회
        getCommentById ({ commit }, payload) {
            http.get(`/comment/${payload.data}`)
                .then((response) => {
                    console.log(response.data);
                    commit("DO_MUTATION");
                    payload.success(response.data);
                })
                .catch((error) => {
                    console.log(error);
                    payload.fail();
                });
        },

        // 새로운 코멘트 등록
        registerComment({ commit }, payload) {
            http.post(`/comment`, payload.data)
                .then((response) => {
                    console.log(response.data);
                    commit("DO_MUTATION");
                    payload.success(response.data);
                })
                .catch((error) => {
                    console.log(error);
                    payload.fail();
                });
        },

        // 코멘트 수정하기
        modifyComment({ commit }, payload) {
            http.put(`/comment`, payload.data)
                .then((response) => {
                    console.log(response.data);
                    commit("DO_MUTATION");
                    payload.success(response.data);
                })
                .catch((error) => {
                    console.log(error);
                    payload.fail();
                });
        },

        // 코멘트 삭제하기
        deleteComment({ commit }, payload) {
            http.delete(`/comment/${payload.data}`)
                .then((response) => {
                    console.log(response.data);
                    commit("DO_MUTATION");
                    payload.success(response.data);
                })
                .catch((error) => {
                    console.log(error);
                    payload.fail();
                });
        },
    },
        
    modules: {},
});
