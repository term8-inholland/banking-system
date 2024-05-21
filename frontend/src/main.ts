// src/main.js (or wherever your main entry point is)
import { createApp } from 'vue';
import { createMemoryHistory, createRouter } from 'vue-router';

import './style.css';

// base scaffold
import App from './App.vue';

// routes (views)
import Login from './views/Login.vue';
import Transfer from './views/Transfer.vue'; // import the new Transfer component

const routes = [
  { path: '/login', component: Login },
  { path: '/transfer', component: Transfer }, // add the new route
];

const router = createRouter({
  history: createMemoryHistory(),
  routes,
});

createApp(App).use(router).mount('#app');
