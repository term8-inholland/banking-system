<script setup lang="ts">

</script>

<template>
<nav class="container-fluid">
  <ul>
    <li><strong>Acme Corp</strong></li>
  </ul>
  <ul>
    <li><a href="#">About</a></li>
    <li><a href="#">Services</a></li>
    <li><a href="#">Products</a></li>
    <li><RouterLink to="/login">Login</RouterLink></li>
    <li><RouterLink to="/transfer">Transfer</RouterLink></li>

  </ul>
</nav>
  <main class="container">
    <RouterView />
  </main>
</template>
