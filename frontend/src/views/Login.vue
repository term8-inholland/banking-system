<script setup lang="ts">
import { ref } from 'vue';

const emailHint = ref("We will never share your email with anyone");
const passwordHint = ref("");

function login(e: Event) {
  e.preventDefault();
}

</script>

<template>
  <form class="container" v-on:submit="login">
    <input id="email" name="email" type="email" placeholder="Email" required>
    <small>{{ emailHint }}</small>
    <input id="pass" name="pass" type="password" placeholder="Password" required>
    <small>{{ passwordHint }}</small>
    <input type="submit" name="action" id="submit" value="Log in">
  </form>
</template>

<style scoped>
form {
  padding-top: 6rem;
  max-width: 50%;
}
</style>
