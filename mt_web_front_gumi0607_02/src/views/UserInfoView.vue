<template>
  <b-container>
    <b-card class="info" bg-variant="secondary" text-variant="white" :title="'우리 ' + loginUser.name + '회원님은요~~'">
      <b-card-text>
        로그인 할 때 아이디는 {{ loginUser.id }}를 사용합니다.<br>
        현재 모은 스탬프는 총 {{ stamp }}개로 {{grade}} 단계입니다.<br>
        앞으로 {{ stampLeft }}개만 더 모으면 다음 단계입니다!!
      </b-card-text>
    </b-card>
    <b-card header="이제까지 주문 내역은">
      <h5>주문 정보를 클릭하면 주문 내역을 살펴볼 수 있습니다</h5>
      <b-list-group>
        <template v-for="(order, index) in orders">
          <b-list-group-item class="ordered" :key="'A'+index" @click="viewDetail(index)" variant="success">
            {{ format(order.orderTime) }}</b-list-group-item>
          <order-detail-view :key="'B'+index" :details="order.details" v-show="order.isOn"></order-detail-view>
        </template>
      </b-list-group>
    </b-card>
  </b-container>
</template>

<script>
  import OrderDetailView from '@/views/OrderDetailView.vue'

  export default {
    components: { OrderDetailView },
    data() {
      return {
        stamp: 0, // 유저의 총 스태프 개수
        orders: [], // 유저의 주문 목록 (주문 상세 목록 포함 : orders.details[])
        grade: "",  // 유저의 등급
        stampLeft : 0,  // 다음 등급까지 남은 스탬프
      }
    },
    created() {
      let component = this
      this.$store.dispatch('getUserInfo', {
          data: this.loginUser,
          success: function (stamp, orders) {
            component.$data.stamp = stamp

            for (let key in orders) {
              orders[key].isOn = false
            }
            component.$data.orders = orders

            component.calStamps()
          },
          fail: function () {
          }
        });
    },
    computed: {
      loginUser() {
        return this.$store.getters.getLoginUser
      },
    }
    ,
    methods: {
      // 날짜 변환
      format(date) {
        let d = new Date(date)
        return d.getFullYear() + "년 " + (d.getMonth() + 1) + "월 " + d.getDate() + "일 " + d.getHours() + "시 " + d.getMinutes() + "분 " + d.getSeconds() + "초 " + '일월화수목금토'.charAt(d.getUTCDay()) + '요일'
      },

      // 클릭하면 주문 상세 보기
      viewDetail(index) {
        if (!this.orders[index].isOn) this.orders[index].isOn = false
        this.$set(this.orders[index], 'isOn', !this.orders[index].isOn);
      },

      // 스탬프 등급 계산
      calStamps() {
        let total = this.stamp
        let grade = ""
        let left = 0
        if (total < 50) {
          let arr = ["씨앗1", "씨앗2", "씨앗3", "씨앗4", "씨앗5"]
          let num = parseInt(total / 10)
          grade = arr[num]
          left = 10 - total % 10
        } else if (total < 125) {
          let arr = ["꽃1", "꽃2", "꽃3", "꽃4", "꽃5"]
          let num = parseInt((total - 50) / 15)
          left = 15 - total % 15
          grade = arr[num]
        } else if (total < 225) {
          let arr = ["열매1", "열매2", "열매3", "열매4", "열매5"]
          let num = parseInt((total - 125) / 20)
          grade = arr[num]
          left = 20 - total % 20
        } else if (total < 375) {
          let arr = ["커피콩1", "커피콩2", "커피콩3", "커피콩4", "커피콩5"]
          let num = parseInt((total - 225) / 25)
          grade = arr[num]
          left = 25 - total % 25
        } else {
          grade = "나무"
        }
        this.grade = grade
        this.stampLeft = left
      }
    }
  }
</script>


<style scoped="scoped">
  .info {
    margin: 10px 0;
  }

  h5 {
    margin-bottom: 30px;
  }

  .ordered {
    margin: 10px 0;
  }
</style>