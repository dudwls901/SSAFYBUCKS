<template>
  <b-container>
    <h1>로그인</h1>
    <b-form>
      <b-form-group :label="'아이디:'" label-for="input-1">
        <b-form-input id="input-1" v-model="form.id" type="text" required></b-form-input>
      </b-form-group>

      <b-form-group :label="'비밀번호:'" label-for="input-2">
        <b-form-input id="input-2" v-model="form.pass" type="password" required></b-form-input>
      </b-form-group>
    </b-form>

    <div>
      <b-button variant="primary" @click="login">로그인</b-button>
      <b-button variant="danger" @click="reset">취소</b-button>
    </div>
  </b-container>
</template>

<script>
  export default {
    data() {
      return {
        form: {
          id: '',
          pass: '',
        },
      }
    },
    computed: {
      loginUser() {
        return this.$store.getters.getLoginUser
      }
    },
    methods: {
      login() {
        let router = this.$router;
        this.$store.dispatch('login', {
          data: this.form,
          success: function () {
            router.replace({ name: "product-list-view" });
          },
          fail: function () {
            alert("로그인 실패입니다. 아이디와 비밀번호를 확인하세요.")
            this.data.pass = ''
          }
        });
      },
      movePage(url) {
        this.$router.push(url);
      },
      reset() {
        this.form.id = '';
        this.form.pass = '';
      },
    },
  }
</script>