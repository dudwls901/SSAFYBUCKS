<template>
  <b-container fluid="fluid" class="p-4 bg-light ">
    <h4 class="center-align">
      상품 평점
    </h4>
    <b-row class="row">
      <b-col>
        <b-img thumbnail="thumbnail" fluid="fluid" :src="require('@/assets/menu/'+product.img)">
        </b-img>
      </b-col>
      <b-col cols="9">
        <b-list-group flush="flush">
          <b-list-group-item class="center-align">상품명:
            {{ product.name }}</b-list-group-item>
          <b-list-group-item class="center-align">상품단가:
            {{ product.price }}</b-list-group-item>
          <b-list-group-item class="center-align">총주문수량:
            {{ product.totalOrder }}</b-list-group-item>
          <b-list-group-item class="center-align">평가횟수:
            {{ getCommentCount }}</b-list-group-item>
          <b-list-group-item class="center-align">평균평점:
            {{ getRatingAvg }}</b-list-group-item>
        </b-list-group>
      </b-col>
    </b-row>
    <hr>


    <div style="text-align: right">
      <b-button v-show="loginUser.id" id="show-btn" @click="$bvModal.show('bv-modal-add')" class="mr-2">한줄평 남기기
      </b-button>
      <b-modal id="bv-modal-add" hide-footer>
        <template #modal-title>
          한줄평 남기기
        </template>
        <div class="d-block text-center">
          <b-form>
            <b-form-group :label="'평점:'" label-for="input-1">
              <b-form-input id="input-1" v-model="targetComment.rating" type="number" required placeholder="평점을 입력해주세요.">
              </b-form-input>
            </b-form-group>

            <b-form-group :label="'한줄평:'" label-for="input-2">
              <b-form-input id="input-2" v-model="targetComment.comment" type="text" required placeholder="한줄평을 입력해주세요.">>
              </b-form-input>
            </b-form-group>
          </b-form>
        </div>
        <b-button variant="danger" class="mr-2" block @click="checkValueAdd(targetComment)">등록</b-button>
        <b-button variant="secondary " class="mr-2" block @click="[$bvModal.hide('bv-modal-add'), clearTargetComment()]">취소</b-button>
      </b-modal>
    </div>

    <b-row class="row">
      <b-col>
        <b-card header="자신이 남긴 평가만 수정, 삭제할 수 있습니다">
          <b-list-group>
            <b-table striped="striped" hover="hover" :items="comments" :fields="fields">
              <template #cell(comment)="row">
                {{row.item.comment}}
                <b-button v-show="loginUser.id===row.item.userId" id="show-btn"
                  @click="[$bvModal.show('bv-modal-delete'), setTargetId(row.item.id)]" class="mr-2 float-right">삭제
                </b-button>
                <b-modal id="bv-modal-delete" hide-footer>
                  <template #modal-title>
                    알림
                  </template>
                  <div class="d-block text-center">
                    <h3>한줄평을 삭제하시겠습니까?</h3>
                  </div>
                  <b-button variant="danger" class="mr-2" block
                    @click="[deleteComment(),$bvModal.hide('bv-modal-delete')]">삭제</b-button>
                  <b-button variant="secondary " class="mr-2" block @click="$bvModal.hide('bv-modal-delete')">취소
                  </b-button>
                </b-modal>
                <b-button v-show="loginUser.id===row.item.userId" id="show-btn"
                  @click="[$bvModal.show('bv-modal-modify'), setTargetId(row.item.id)]" class="mr-2 float-right">수정
                </b-button>
                <b-modal id="bv-modal-modify" hide-footer>
                  <template #modal-title>
                    한줄평 수정하기
                  </template>
                  <div class="d-block text-center">
                    <b-form>
                      <b-form-group :label="'평점:'" label-for="input-1">
                        <b-form-input id="input-1" v-model="targetComment.rating" type="number" required></b-form-input>
                      </b-form-group>

                      <b-form-group :label="'한줄평:'" label-for="input-2">
                        <b-form-input id="input-2" v-model="targetComment.comment" type="text" required></b-form-input>
                      </b-form-group>
                    </b-form>
                  </div>
                  <b-button variant="danger" class="mr-2" block @click="checkValueModify(targetComment)">수정
                  </b-button>
                  <b-button variant="secondary " class="mr-2" block @click="[$bvModal.hide('bv-modal-modify'), clearTargetComment()]">취소
                  </b-button>
                </b-modal>
              </template>
            </b-table>
          </b-list-group>
        </b-card>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>

  export default {
    data() {
      return {
        product: {},
        comments: [],
        fields: [
          {
            key: 'userId',
            label: '사용자'
          }, {
            key: 'rating',
            label: '평점'
          }, {
            key: 'comment',
            label: '한줄평'
          }
        ],
        targetComment: {}, // 새로 등록하거나 수정할 코멘트
        targetId: 0,    // 수정하거나 삭제할 comments의 인덱스 (테이블과 모달창간 오류로 직접 인덱스 받아와야됨)
      }
    },
    created() {
      this.product.productId = this.$route.params.product_id

      // 제품 정보 가져오기
      let component = this
      this.$store.dispatch('getProductById', {
          data: this.product.productId,
          success: function (product, totalOrder) {
            component.$data.product = product
            component.$data.product.totalOrder = totalOrder
          },
          fail: function () {
          }
        });

      // 코멘트 리스트 가져오기
      this.$store.dispatch('getCommentById', {
          data: this.product.productId,
          success: function (comments) {
            component.$data.comments = comments
          },
          fail: function () {
          }
        });
    },
    computed: {
      loginUser() {
        return this.$store.getters.getLoginUser;
      },

      // 총 주문 횟수
      getCommentCount() {
        return this.comments.length
      },

      // 평점 평균
      getRatingAvg() {
        let total = 0
        this.comments.forEach(element => {
          total += element.rating
        });
        let n = Math.round(total / this.comments.length * 10) / 10
        return !n ? 0 : n
      },
    },
    methods: {
      // 수정하거나 삭제할 comment 설정
      setTargetId(id){
        this.targetId = id
        this.targetComment = this.comments.find((element) =>
          element.id === id
        )
      },

      clearTargetComment() {
        this.targetComment = {}
      },

      // 코멘트 추가, 수정할 때 공통으로 할 유효성 체크
      checkValue(comment) {
        let err = false;
        let msg = "";

        if (!comment.rating) {
          msg = "평점 매겨주세요 !!!";
          err = true;
        } else if (!comment.comment) {
          msg = "한줄평 입력해주세요 !!!";
          err = true;
        }

        if (comment.rating < 0 || comment.rating > 10) {
          msg = "평점은 0~10사이로 입력해주세요 !!!";
          err = true;
        }

        let result = {
          err : err,
          msg : msg
        }
        return(result)
      },

      // 코멘트 추가할 때 유효성 체크
      checkValueAdd(comment) {
        let result= this.checkValue(comment)
        let err = result.err
        let msg = result.msg

        for (let i = 0; i < this.comments.length; i++) {
          if (this.comments[i].userId === this.loginUser.id) {
            msg = "이미 평가를 등록한 유저입니다 !!!";
            err = true;
          }
        }

        if (err) {
          alert(msg);
        } else {
          this.$bvModal.hide('bv-modal-add')
          this.addComment(comment);
        }
      },

      // 코멘트 추가 실행
      addComment(comment) {
        comment.userId = this.loginUser.id
        comment.productId = this.product.id
        let component = this
        this.$store.dispatch('registerComment', {
          data: comment,
          success: function (comments) {
            component.$data.comments = comments
            component.clearTargetComment()
          },
          fail: function () {
          }
        });
      },

      // 코멘트 수정할 때 유효성 체크
      checkValueModify(comment) {
        let result= this.checkValue(comment)
        let err = result.err
        let msg = result.msg

        if (err) {
          alert(msg);
        } else {
          this.$bvModal.hide('bv-modal-modify')
          this.modifyComment(comment);
        }
      },

      // 코멘트 수정 실행
      modifyComment(comment) {
        let component = this
        this.$store.dispatch('modifyComment', {
          data: comment,
          success: function (comments) {
            component.$data.comments = comments
            component.clearTargetComment()
          },
          fail: function () {
          }
        });
      },

      // 코멘트 삭제
      deleteComment() {
        let component = this
        this.$store.dispatch('deleteComment', {
          data: this.targetComment.id,
          success: function (comments) {
            component.$data.comments = comments
            component.clearTargetComment()
          },
          fail: function () {
          }
        });
      },
    }
  }
</script>

<style scoped="scoped">
  .row {
    margin: 10px;
  }

  .center-align {
    text-align: center;
  }

  .btn {
    margin: 30px;
    size: 50px;
  }

  .mr-2 {
    margin: 0;
  }
</style>