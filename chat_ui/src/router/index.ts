import { createRouter, createWebHistory } from 'vue-router'
import newChat from '../views/newChat.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'NewChat',
      component: newChat
    },
    {
      path: '/ChatHistory/:conversation',
      name: 'ChatHistory',
      component: () => import('../views/ChatHistory.vue')
    }
  ]
})

export default router
