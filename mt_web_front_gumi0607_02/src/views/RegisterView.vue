<template>
  <b-container>
    <h1>회원가입</h1>
    <b-form>
      <b-form-group :label="'아이디:'" label-for="input-1">
        <b-form-input id="input-1" v-model="form.id" type="text" required></b-form-input>
        <span class="error" v-show="isRegistered==1">중복된 아이디 입니다</span>
        <span class="success" v-show="isRegistered==-1">사용 가능한 아이디 입니다</span>
      </b-form-group>

      <b-form-group :label="'이름:'" label-for="input-2">
        <b-form-input id="input-2" v-model="form.name" type="text" required></b-form-input>
      </b-form-group>

      <b-form-group :label="'비밀번호:'" label-for="input-3">
        <b-form-input id="input-3" v-model="form.pass" type="password" required></b-form-input>
      </b-form-group>
    </b-form>

    <div>
      <b-button variant="primary" @click="register">가입</b-button>
      <b-button variant="danger" @click="reset">취소</b-button>
    </div>
  </b-container>
</template>

<script>
  export default {
    name: 'register-view',
    data() {
      return {
        form: {
          id: '',
          name: '',
          pass: '',
        },
      }
    },
    created() {
      this.$store.commit("SET_ISREGISTERED_NONE")
    },
    computed: {
      isRegistered() {
        return this.$store.getters.getIsRegistered
      }
    },
    watch: {
      'form.id': function (val, oldVal) {
        console.log(oldVal);
        if(val==""){
          this.$store.commit("SET_ISREGISTERED_NONE")
        }else{
        let store = this.$store;
        this.$store.dispatch('isUsedId', {
          data: val,
          success: function () {
            store.commit("SET_ISREGISTERED_FALSE")
          },
          fail: function () {
            store.commit("SET_ISREGISTERED_TRUE")
          }
        });
        }
        
      },
    },
    methods: {
      register() {
        if (!this.form.id) {
          alert('아이디를 입력하세요.');
          return;
        }

        if (!this.form.name) {
          alert('이름을 입력하세요.');
          return;
        }

        if (!this.form.pass) {
          alert('비밀번호를 입력하세요.');
          return;
        }

        let router = this.$router;
        let store = this.$store;

        this.$store.dispatch('registerUser', {
          data: this.form,
          success: function () {
            alert("회원가입이 완료되었습니다")
            router.replace({ name: "product-list-view" });
          },
          fail: function () {
            store.commit("SET_ISREGISTERED_TRUE")
          }
        });
      },
      reset() {
        this.form.id = '';
        this.form.name = '';
        this.form.pass = '';
        this.$store.commit("SET_ISREGISTERED_FALSE")
      },
      movePage(url) {
        this.$router.push(url);
      }
    },
  }
</script>

<style scoped>
  .error {
    color: red;
  }
  .success {
    color: greenyellow;
  }
</style>