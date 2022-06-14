<template>
  <div class="doard-detail">
    <button type="button" class="w3-button w3-round w3-blue-gray" v-on:click="fnSave">저장</button>&nbsp;
    <button type="button" class="w3-button w3-round w3-gray" v-on:click="fnList">목록</button>
  </div>
  <div class="board-contents">
    <input type="text" v-model="title" class="w3-input w3-board" placeholder="제목을 입력해주세요."/>
    <input type="text" v-model="author" class="w3-input w3-board" placeholder="작성자를 입력해주세요." v-if="idx === undefined"/>
  </div>
  <div class="board-contents">
    <textarea id="" cols="30" rows="10" v-model="contents" class="w3-input w3-board" style="resize: none;"></textarea>
    <p>data.requestBody : {{$data.requestBody}}</p>
    <p>data.idx : {{$data.idx}}</p>
  </div>
  <div class="common-buttons">
    <button type="button" class="w3-button w3-round w3-blue-gray" v-on:click="fnSave">저장</button>&nbsp;
    <button type="button" class="w3-button w3-round w3-gray" v-on:click="fnList">목록</button>
  </div>
</template>

<script>
  export default {
    data(){
      return {
        requestBody: this.$route.query,
        idx: this.$route.query.idx,

        title:'',
        author: '',
        contents: '',
        created_at: ''
      }
    },

    mounted(){
      this.fnGetView()
    },

    methods: {
      fnGetView(){
        if(this.idx !== undefined){
          this.$axios.get(this.$serverUrl + '/board/' + this.idx, {
            params: this.requestBody
          })
        }
      },

      fnList(){
        delete this.requestBody.idx
        this.$router.push({
          path: './list',
          query: this.requestBody
        })
      },
      fnView(idx){
        this.requestBody = idx
        this.$router.push({
          path: './detail',
          quert: this.requestBody
        })
      },
      fnSave(){
        let apiUrl = this.$serverUrl + './board'

        // data setting
        this.form = {
          "idx": this.idx,
          "title": this.title,
          "contents": this.contents,
          "author": this.author
        }

        if(this.idx === undefined){
          // INSERT
          this.$axios.post(apiUrl, this.form)
          .then((res) => {
            alert('글이 저장되었습니다.')
            this.fnView(res.data.idx)
          }).catch((err) => {
            if (err.message.indexOf('Network Error') > -1){
              alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
            }
          })
        } else {
          //UPDATE
          this.$axios.patch(apiUrl, this.form)
          .then((res) => {
            alert('글이 저장되었습니다.')
            this.fnView(res.data.idx)
          }).catch((err) => {
            if(err.message.indexOf('Network Error') > -1){
              alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
            }
          })
        }
      }
    }
  }

</script>






