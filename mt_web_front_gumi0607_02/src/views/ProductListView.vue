<template>
  <div>
    <b-card bg-variant="primary" text-variant="white" title="커피">
      <b-card-text>
        뛰면서 즐기는 커피 한잔의 여유
      </b-card-text>
      <hr>
      <b-card-text>
        갓 볶은 아라비카산 원두만 고집합니다.
      </b-card-text>
    </b-card>
    <!-- 주문 -->
    <b-button v-b-toggle.sidebar-right v-show="loginUser.id" class="btn float-left btn-primary btn-lg btn-order">주문서
      보기
    </b-button>
    <b-container>
      <b-row>
        <b-sidebar id="sidebar-right" title="주문서 작성중" right="right" shadow="shadow">
          <div v-for="(item, index) in orders.details" :key="index">
            <b-card :img-src="require('@/assets/menu/' + item.img)" img-left="img-left" img-height="50" img-width="50">
              <b-card-text style="display: inline">{{item.name}}</b-card-text>
              <b-button>{{item.quantity}}</b-button>
            </b-card>
          </div>
          <b-button variant="primary" @click="orderProduct">주문</b-button>
        </b-sidebar>
      </b-row>

      <!--커피 목록 -->
      <div id="container">
        <b-row>
          <b-col cols="3" v-for="(item, index) in products" :key="index">
            <b-card class="card-menu">
              <router-link class="link" :to="{name: 'product-detail-view', params:{product_id:item.id}}">
                <b-card-img class="image" :src="require('@/assets/menu/'+item.img)"></b-card-img>
                <b-card-title>{{ item.name }}</b-card-title>
                <b-card-text>{{ item.price }}원</b-card-text>
              </router-link>

              <!--커피 버튼 -->
              <b-button-group v-show="loginUser.id">
                <!-- 주문양 버튼 -->
                <b-button variant="primary" size="lg">{{ item.quantity }}</b-button>
                <!-- 증가 버튼-->
                <b-button variant="success" @click="[increase(index), setMenu()]">
                  <b-icon icon="plus-square-fill"></b-icon>
                </b-button>
                <!-- 감소 버튼-->
                <b-button variant="secondary" @click="[decrease(index), setMenu()]">
                  <b-icon icon="file-minus-fill"></b-icon>
                </b-button>
                <!-- 의문의 버튼 -->
                <b-button variant="warning" size="lg">
                  <b-icon icon="chat-dots-fill"></b-icon>
                </b-button>
              </b-button-group>
            </b-card>
          </b-col>
        </b-row>
      </div>
    </b-container>
  </div>
</template>

<script>
  export default {
    name: 'product-list',
    data() {
      return {
        orders:{
          details: []
        }
      }
    },
    created() {
      this.$store.dispatch('getProducts', {
          fail: function () {
              alert('상품 정보를 불러올 수 없습니다')
          }
        });
    },
    computed: {
      loginUser() {
        return this.$store.getters.getLoginUser
      },
      products() {
        return this.$store.getters.getProducts;
      }
    },

    methods: {
      // 증가 기능
      increase(index) {
        this.$store.commit('COUNT_PRODUCTS_QUANTITY', {
          data: { index: index, num: 1}
        });
      },

      // 감소 기능
      decrease(index) {
        this.$store.commit('COUNT_PRODUCTS_QUANTITY', {
          data: { index: index, num: -1}
        });
      },

      // 주문서 기능
      setMenu() {
        this.orders.details = this.products.filter((element) => element.quantity > 0);
      },

      // 주문 하기
      orderProduct() {
        if (this.orders.details.length < 1) {
          alert("주문한 상품이 없습니다.");
          return;
        }

        this.orders.userId = this.loginUser.id
        let router = this.$router;

        this.$store.dispatch('orderProducts', {
          data: this.orders,
          success: function () {
            router.replace({
              name: "user-info-view"
            });
          }
        });
      },
    }
  }
</script>

<style scoped>
  .link {
    text-decoration: none;
    color: black;
  }

  .btn-order {
    margin: 50px;
  }

  #sidebar-right {
    position: absolute;
    top: 50%;
    left: 50%;
  }

  #b-col {
    padding: 20px;
  }

  .card-menu {
    margin: 10px 0;
  }

  .buttons {
    text-align: center;
  }

  .buttons>b-button {
    margin: 10px;
  }

  .image {
    object-fit: contain;
    height: 300px;
  }
</style>