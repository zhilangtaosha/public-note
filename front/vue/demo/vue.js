<script src="https://unpkg.com/vue"></script>

<div id="app">
  <p>{{ message }}</p>
</div>

new Vue({
  el: '#app',
  data: {
    message: 'Hello Vue.js!'
  }
})