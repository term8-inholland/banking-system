import { createApp } from 'vue'
import { createMemoryHistory, createRouter } from 'vue-router';

import './style.css';

// base scaffold
import App from './App.vue'

// routes (views)
import Login from './views/Login.vue';

const routes = [
  { path: '/login', component: Login },
];

const router = createRouter({
  history: createMemoryHistory(),
  routes,
});

createApp(App).use(router).mount('#app');
