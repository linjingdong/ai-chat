<template>
  <div class="conversation-div" v-for="(item, index) in conversations" :key="index">
    <div class="user-div"><el-text class="mx-1">user</el-text></div>
    <div><el-text class="mx-1" type="info">{{ item.question }}</el-text></div>
    <div class="chat-div"><el-text class="mx-1" type="primary">Chat</el-text></div>
    <div :style="answerStyle" class="answer-div" v-html="renderMarkdown(item.answer)"></div>
  </div>
</template>

<script lang="ts" setup>
import { ref, watch, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import MarkdownIt from 'markdown-it';

const route = useRoute();
const conversations = ref([]);

const md = new MarkdownIt();

// 更新会话数据
const updateConversations = () => {
  const routeConversation = route.params.conversation as string;
  conversations.value = JSON.parse(routeConversation);
};

// 监听路由参数变化并更新会话数据
watch(() => route.params.conversation, () => {
  updateConversations();
});

// 组件挂载时初始化数据
onMounted(() => {
  updateConversations();
});

// 渲染 Markdown
const renderMarkdown = (text: string) => {
  return md.render(text);
};

const answerStyle = {
  // 根据 el-text 的样式设置 answer-div 的样式
  display: 'block', // 如果 el-text 是块级元素
  'margin-top': '5px', // 调整上边距
  // 其他样式...
};
</script>

<style scoped>
* {
  padding: 0px;
  margin: 0px;
}

.conversation-div {
  display: flex;
  flex-direction: column;
  padding: 20px;
  padding-left: 80px;
  padding-right: 80px;
}

.answer-div {
  font-size: 14px;
  /* 文本大小 */
  color: rgb(105, 104, 104);
  /* 灰色 */
  margin-top: 5px;
  /* 上边距 */
}

.user-div {
  padding-bottom: 15px;
}

.chat-div {
  padding-top: 15px;
}</style>
