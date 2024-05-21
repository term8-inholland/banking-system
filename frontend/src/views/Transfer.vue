<script setup lang="ts">
import { ref } from 'vue';

// Dummy data for user's accounts with labels (in a real scenario, this data would come from an API)
const userAccounts = ref([
  { id: '1', label: 'Savings' },
  { id: '2', label: 'Debit' }
]);

// Define refs for form data
const fromAccountId = ref(userAccounts.value[0].id);
const receiverIban = ref('');
const receiverName = ref('');
const description = ref('');
const paymentDate = ref('');
const transferStatus = ref('');

function transferFunds(e: Event) {
  e.preventDefault();
  
  // Simulate an API call with a timeout
  setTimeout(() => {
    // For demonstration purposes, let's assume the transfer is always successful
    // In a real scenario, you would perform the actual API call here
    transferStatus.value = `Transferred from account ${fromAccountId.value} to ${receiverIban.value} successfully.`;
  }, 1000);
}
</script>

<template>
  <form class="container" v-on:submit="transferFunds">
    <label for="fromAccount">From which account:</label>
    <select v-model="fromAccountId" id="fromAccount" name="fromAccount" required>
      <option v-for="account in userAccounts" :key="account.id" :value="account.id">
        {{ account.label }}
      </option>
    </select>

    <label for="receiverIban">Receiver IBAN:</label>
    <input v-model="receiverIban" id="receiverIban" name="receiverIban" type="text" placeholder="Receiver IBAN" required>

    <label for="receiverName">Receiver Name:</label>
    <input v-model="receiverName" id="receiverName" name="receiverName" type="text" placeholder="Receiver Name" required>

    <label for="description">Description:</label>
    <input v-model="description" id="description" name="description" type="text" placeholder="Description">

    <label for="paymentDate">Payment execute date:</label>
    <input v-model="paymentDate" id="paymentDate" name="paymentDate" type="date" placeholder="Payment execute date" required>

    <input type="submit" name="action" value="Transfer">
  </form>
  <p>{{ transferStatus }}</p>
</template>

<style scoped>
form {
  padding-top: 2rem;
  max-width: 50%;
}

label {
  display: block;
  margin-top: 1rem;
}

input, select {
  display: block;
  width: 100%;
  margin-top: 0.5rem;
  padding: 0.5rem;
}
</style>
