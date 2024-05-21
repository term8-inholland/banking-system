<script setup lang="ts">
import { ref } from 'vue';

const emailHint = ref("We will never share your email with anyone");
const passwordHint = ref("");

const email = ref("");
const password = ref("");

async function login(e: Event) {
  e.preventDefault();
  try {
    const response = await fetch("http://localhost:8080/auth", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        email: email.value,
        password: password.value,
      }),
    });
    if (response.ok) {
      console.log("login successful");
    } else {
      console.error("login failed");
    }
  } catch (error) {
      console.error("login failed", error);
  }
}

</script>

<template>
  <form class="container" v-on:submit="login">
    <input id="email" name="email" v-model="email" type="email" placeholder="Email" required>
    <small>{{ emailHint }}</small>
    <input id="pass" name="pass" v-model="password" type="password" placeholder="Password" required>
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
