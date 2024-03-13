<template>
    <div class="common-layout">
        <el-container class="frame">
            <el-aside class="frameaside">
                <el-col class="frameaside">
                    <el-menu class="el-menu-vertical-demo">
                        <el-menu-item index="0" class="new-chat-btn" @click="navigateToNewChat" default-active>
                            <i><svg t="1704185449277" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                    xmlns="http://www.w3.org/2000/svg" p-id="1557" width="16" height="16">
                                    <path
                                        d="M512 32C247.04 32 32 224 32 464A410.24 410.24 0 0 0 172.48 768L160 965.12a25.28 25.28 0 0 0 39.04 22.4l168-112A528.64 528.64 0 0 0 512 896c264.96 0 480-192 480-432S776.96 32 512 32z"
                                        fill="#1296db" p-id="1558"></path>
                                </svg></i>
                            <span>New Chat</span>
                        </el-menu-item>
                        <el-menu-item v-for="(conversationId, index) in uniqueConversationIds" :key="conversationId"
                            :index="index" class="history-item" @click="navigateToChatHistory(conversationId)">
                            <i><svg t="1704245953480" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                    xmlns="http://www.w3.org/2000/svg" p-id="3799" width="16" height="16">
                                    <path
                                        d="M512 64c259.2 0 469.333333 200.576 469.333333 448s-210.133333 448-469.333333 448a484.48 484.48 0 0 1-232.725333-58.88l-116.394667 50.645333a42.666667 42.666667 0 0 1-58.517333-49.002666l29.76-125.013334C76.629333 703.402667 42.666667 611.477333 42.666667 512 42.666667 264.576 252.8 64 512 64z m0 64C287.488 128 106.666667 300.586667 106.666667 512c0 79.573333 25.557333 155.434667 72.554666 219.285333l5.525334 7.317334 18.709333 24.192-26.965333 113.237333 105.984-46.08 27.477333 15.018667C370.858667 878.229333 439.978667 896 512 896c224.512 0 405.333333-172.586667 405.333333-384S736.512 128 512 128z m-157.696 341.333333a42.666667 42.666667 0 1 1 0 85.333334 42.666667 42.666667 0 0 1 0-85.333334z m159.018667 0a42.666667 42.666667 0 1 1 0 85.333334 42.666667 42.666667 0 0 1 0-85.333334z m158.997333 0a42.666667 42.666667 0 1 1 0 85.333334 42.666667 42.666667 0 0 1 0-85.333334z"
                                        fill="#1296db" p-id="3800"></path>
                                </svg>
                            </i>
                            <span class="w-150px ellipsis-text">{{ conversationId }}</span>
                            <el-popconfirm confirm-button-text="Yes" cancel-button-text="No" :icon="InfoFilled"
                                icon-color="#626AEF" title="Are you sure to delete this?" @confirm="confirmEvent"
                                @cancel="cancelEvent">
                                <template #reference>
                                    <el-button class="delete-btn" size="small" circle />
                                </template>
                            </el-popconfirm>
                        </el-menu-item>
                    </el-menu>
                </el-col>
            </el-aside>
            <el-container>
                <el-header class="el-header">
                    <el-menu style="pointer-events: none;" mode="horizontal">
                        <el-menu-item>
                            <i><svg t="1704209841688" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                    xmlns="http://www.w3.org/2000/svg" p-id="2498" width="32" height="32">
                                    <path
                                        d="M746.666667 725.333333c59.733333-12.8 106.666667-64 106.666666-128 0-72.533333-55.466667-128-128-128-17.066667 0-29.866667 4.266667-42.666666 8.533334V469.333333c0-93.866667-76.8-170.666667-170.666667-170.666666s-170.666667 76.8-170.666667 170.666666c0 17.066667 4.266667 29.866667 4.266667 46.933334-8.533333-4.266667-17.066667-4.266667-25.6-4.266667C260.266667 512 213.333333 558.933333 213.333333 618.666667S260.266667 725.333333 320 725.333333h426.666667z m0 85.333334h-426.666667C213.333333 810.666667 128 725.333333 128 618.666667c0-85.333333 55.466667-157.866667 128-183.466667C273.066667 311.466667 379.733333 213.333333 512 213.333333c110.933333 0 209.066667 72.533333 243.2 170.666667 102.4 12.8 183.466667 102.4 183.466667 213.333333s-85.333333 200.533333-192 213.333334z"
                                        fill="#7fcaf1" p-id="2499"></path>
                                </svg></i>
                            <div style="color: rgb(96, 181, 207);">AIChat</div>
                        </el-menu-item>
                    </el-menu>
                </el-header>
                <el-main class="el-main">
                    <RouterView />
                </el-main>
                <el-footer class="el-footer">
                    <div class="submit-container " style="height: 80px;">
                        <el-input v-model="textarea" :rows="3" type="textarea" placeholder="Please input"
                            @keyup.enter="handleEnter" row="2" class="fixed-height-input" />
                        <el-button @click="handleEnter" type="primary" class="submit-btn">
                            <svg t="1704200272120" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                xmlns="http://www.w3.org/2000/svg" p-id="4735" width="16" height="16">
                                <path
                                    d="M414.273 1024a19.761 19.761 0 0 1-19.741-20.488l8.762-237.514a19.75 19.75 0 0 1 4.203-11.471l503.44-641.372-822.36 475.187 249.41 129.274c9.688 5.022 13.472 16.947 8.45 26.635-5.023 9.688-16.946 13.472-26.635 8.45L38.362 606.825a19.758 19.758 0 1 1-0.793-34.65L969.914 33.436a19.76 19.76 0 0 1 29.505 19.455L890.247 965.588a19.759 19.759 0 0 1-28.849 15.125l-252.05-133.144-181.52 171.053a19.754 19.754 0 0 1-13.555 5.378z m28.276-250.126l-6.748 182.936 156.73-147.693a19.761 19.761 0 0 1 22.781-3.091l239.112 126.31 96.41-806.007L442.55 773.874z"
                                    p-id="4736" fill="#ffffff"></path>
                            </svg>
                        </el-button>
                    </div>
                </el-footer>
            </el-container>
        </el-container>
    </div>
</template>

<script setup lang="ts">
import { useRouter, useRoute } from 'vue-router'
import { ref, onMounted } from 'vue'
import { InfoFilled } from '@element-plus/icons-vue'
import { getQuestion, getConversation, postConversation, deleteConversation } from '../api/ConversationApi'

interface props {
    question: string
    conversationId: any
}

let questions: props[] = ref([]);
let question: props = ref({});
question.conversationId = null
const uniqueConversationIds = ref([]);

const showaside = async () => {
    try {
        const response = await getQuestion();
        const responseData = response.data.data;

        // 确保 responseData 是数组类型，然后将其赋值给 questions
        if (Array.isArray(responseData)) {
            questions = responseData;
            const conversationIds = responseData.map(item => item.conversationId);
            uniqueConversationIds.value = Array.from(new Set(conversationIds)); // 使用 Set 保持唯一值
        } else {
            console.error('数据格式不正确：', responseData);
        }
    } catch (error) {
        console.error('获取数据时出错：', error);
    }
}

// 在 mounted 钩子中从 API 获取数据
onMounted(() => {
    showaside();
});

//获取路由和当前路由
const router = useRouter();
const route = useRoute();

//获取输入框的文字
const textarea = ref('')

//导航到首页
const navigateToNewChat = () => {
    router.push('/');
    question.conversationId = null
};

//导航到历史会话
const navigateToChatHistory = async (conversationId: any) => {
    try {
        const conversationData = await getConversation(conversationId);
        const conversation = conversationData.data.data

        // 根据当前路由来判断是否改变 conversationId 的值
        question.conversationId = conversationId

        // 这里可以将 conversationData 传递给路由组件
        router.push({
            name: 'ChatHistory',
            params: { conversation: JSON.stringify(conversation) }
        });
    } catch (error) {
        console.error('获取对话数据时出错：', error);
    }
};


//确认删除
const confirmEvent = async () => {
    await deleteConversation(question.conversationId)
    showaside()
    navigateToNewChat()
}

// 取消删除
const cancelEvent = () => {
    console.log('cancel!')
}

//按下enter键获取文本
const handleEnter = async () => {
    if (!event.shiftKey) {
        // 只有在没有按下 Shift 键的情况下才处理 Enter 键
        // 处理 Enter 键按下的逻辑
        console.log('Text entered:', textarea.value);
        if (question.conversationId === null) {
            question.question = textarea.value
            textarea.value = ''; // 清空输入框中的文字
            const responseData = await postConversation(question)
            question.conversationId = responseData.data.data
            showaside()
            navigateToChatHistory(question.conversationId)
        } else {
            question.question = textarea.value
            const responseData = await postConversation(question)
            question.conversationId = responseData.data.data
            textarea.value = ''; // 清空输入框中的文字
            navigateToChatHistory(question.conversationId)
        }
    }
}
</script>

<style scoped>
* {
    margin: 0px;
    padding: 0px;
}

.frameaside {
    width: 100vh;
    height: 100vh;
}

.frameaside .el-menu-vertical-demo {
    width: 100%;
    height: 100%;
}

.flex-grow {
    flex-grow: 1;
}

.common-layout {
    height: 100vh;
}

.frame {
    height: 100%;
}

/* 将 el-aside 固定在页面上 */
.frameaside {
    position: fixed;
    padding-top: 60px;
    top: 0;
    left: 0;
    height: 100vh;
    width: 300px;
    z-index: 1;
    /* 其他样式... */
}

/* 将 el-header 固定在页面上 */
.el-header {
    padding-left: 10px;
    padding-right: 15px;
    position: fixed;
    top: 0;
    width: 100%;
    z-index: 1;
    /* 其他样式... */
}

/* 将 el-footer 固定在页面上 */
.el-footer {
    position: fixed;
    bottom: 0;
    height: 100px;
    width: 100%;
    padding-left: 330px;
    padding-right: 40px;
    padding-top: 10px;
    padding-bottom: 10px;
    background-color: rgb(255, 255, 255);
    /* 其他样式... */
}

.fixed-height-input {
    height: auto;
    /* 设置自动高度 */
}

/* 主内容区域避免被覆盖 */
.el-main {
    padding-left: 300px;
    padding-top: 60px;
    padding-bottom: 70px;
    /* 根据 el-header 的高度设置 */
}

.new-chat-btn {
    border-bottom: 1px solid rgb(226, 226, 226);
    /* 应用与 el-header 相同的底部边框样式 */
}

.w-150px {
    padding-right: 10px;
    width: 100%;
}

.ellipsis-text {
    display: inline-block;
    white-space: nowrap;
    /* 防止换行 */
    overflow: hidden;
    /* 隐藏溢出部分 */
    text-overflow: ellipsis;
    /* 显示省略号 */
}

.icon {
    display: flex;
    justify-content: center;
    padding-right: 10px;
}

.history-item {
    padding-right: 10px;
}

.delete-btn {
    width: 15px;
    height: 15px;
    background-color: rgb(250, 250, 250);
}

.submit-container {
    display: flex;
    align-items: center;
}

.submit-btn {
    display: flex;
    justify-content: center;
    align-items: center;
    margin-left: 8px;
    width: 40px;
    height: 40px;
    border-radius: 50%;
    position: relative;
}

.submit-btn svg {
    padding-left: 8px;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
}
</style>