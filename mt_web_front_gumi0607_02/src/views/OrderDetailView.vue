<template>
  <b-card no-body header="주문 상세">
    <b-list-group flush>
      <b-list-group-item v-for="(detail,index) in details" :key="index"
        class="d-flex justify-content-between align-items-center">
        <router-link class="link" :to="{name: 'product-detail-view', params:{product_id : detail.productId}}">
          <b-avatar :src="require('@/assets/menu/'+products[detail.productId-1].img)"></b-avatar>
        </router-link>
        <span>품명: {{ products[detail.productId-1].name }}</span>
        <span>단가: {{ products[detail.productId-1].price }}원 </span>
        <span>{{ detail.quantity }}잔</span>
        <b-badge variant="primary" pill>{{ products[detail.productId-1].price * detail.quantity}}원</b-badge>
      </b-list-group-item>
      <span class="total">총 비용: {{ getTotalPrice }}</span>
      <span class="total">스탬프 적립: {{ getTotalStamp }}</span>
    </b-list-group>
  </b-card>
</template>

<script>

  export default {
    props: {
      'details': {
        type: Array,
      },
    },
    data() {
      return {
      }
    },
    created() {

    },
    computed: {
      products() {
        return this.$store.getters.getProducts;
      },
      getTotalPrice() {
        let total = 0
        this.details.forEach(element => {
          total += this.products[element.productId - 1].price * element.quantity
        });
        return total
      },
      getTotalStamp() {
        let total = 0
        this.details.forEach(element => {
          total += element.quantity
        });
        return total
      },
    },
  }
</script>

<style scoped="scoped">
  .total {
    padding: 5px;
  }
</style>