<template>
  <div>
    <b-navbar toggleable="lg" type="dark" variant="info">
      <b-navbar-brand @click="movePage('/')">
        <img id="logo" src="@/assets/logo.png">
        SSAFY Cafe
      </b-navbar-brand>

      <b-navbar-nav class="ml-auto" v-show="!loginUser.id">
        <b-button size="sm" type="button" variant="primary" @click="movePage('/login')">로그인</b-button>
        <b-button size="sm" type="button" variant="warning" @click="movePage('/register')">회원가입</b-button>
      </b-navbar-nav>

      <b-navbar-nav class="ml-auto" v-show="loginUser.id">
        <b-button size="sm" type="button" variant="primary" @click="movePage('/user-info')">{{ loginUser.name }}
        </b-button>
        <b-button size="sm" type="button" variant="warning" @click="logout">로그아웃</b-button>
      </b-navbar-nav>
    </b-navbar>
  </div>
</template>

<script>
  export default {
    name: 'header-nav',
    computed: {
      loginUser() {
        return this.$store.getters.getLoginUser
      }
    },
    methods: {
      movePage(url) {
        this.$router.push(url)
      },
      logout() {
        let loginUser = this.loginUser
        let router = this.$router
        this.$store.dispatch('logout', {
          data: loginUser,
          success: function () {
              router.go(router.currentRoute)
          },
          fail: function () {
              alert('로그인을 먼저 해주세요')
          }
        });
      }
    }
  }
</script>

<style scope>
  #logo {
    width: 30px;
    height: 30px;
  }
</style>