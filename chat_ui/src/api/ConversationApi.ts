import request from '@/utils/request'

/**
 * 响应：
 * {
    "code": 200,
    "flag": true,
    "data": [
        {
            "question": "写一段 JavaScript 代码，输出 Hello World",
            "conversationId": "4020e02d-bf5c-49b3-8005-701b1a9f53c1"
        },
        {
            "question": "再写一段Java代码，输出以上样式",
            "conversationId": "4020e02d-bf5c-49b3-8005-701b1a9f53c1"
        },
        {
            "question": "再写一段python代码，输出以上代码的输出结果",
            "conversationId": "4020e02d-bf5c-49b3-8005-701b1a9f53c1"
        }
        ]
    }
 */
export let getQuestion = () => {
    return request.get(`Conversations`)
}


/**
 * 新增对话如数据库
 * @param Qeustion 问题及id
 * {
    "question":"再写一段python代码，输出以上代码的输出结果",
    "conversationId":"4020e02d-bf5c-49b3-8005-701b1a9f53c1"
    }
 * @returns null但是数据库增加数据

 */
export let postConversation = (Qeustion: any) => {
    return request.post(`Conversations`, Qeustion)
}

/**
 * 获取对话问题及回答
 * @param conversationId 4020e02d-bf5c-49b3-8005-701b1a9f53c1
 * @returns 
 * {
    "code": 200,
    "flag": true,
    "data": [
        {
            "question": "写一段 JavaScript 代码，输出 Hello World",
            "answer": "当然，我可以为您提供一段输出 \"Hello World\" 的 JavaScript 代码，如下所示：\n\n```javascript\nconsole.log(\"Hello World\");\n```\n\n当您在浏览器或 Node.js 环境中运行此代码时，它将在控制台中输出 \"Hello World\"。",
            "conversationId": "4020e02d-bf5c-49b3-8005-701b1a9f53c1"
        },
        {
            "question": "再写一段Java代码，输出以上样式",
            "answer": "当您说“以上样式”时，我不确定您指的是哪种样式。但是，我会写一段Java代码，它将在控制台中输出 \"Hello World\"，就像在JavaScript中一样。请注意，Java和JavaScript是不同的编程语言。\n\n```java\npublic class HelloWorld {\n    public static void main(String[] args) {\n        System.out.println(\"Hello World\");\n    }\n}\n```\n\n当您在Java环境中运行此代码时，它将在控制台中输出 \"Hello World\"。",
            "conversationId": "4020e02d-bf5c-49b3-8005-701b1a9f53c1"
        },
        {
            "question": "再写一段python代码，输出以上代码的输出结果",
            "answer": "当然，以下是一段Python代码，它将输出 Java 代码中的输出结果 \"Hello World\"：\n\n```python\nprint(\"Hello World\")\n```\n\n当您在Python环境中运行此代码时，它将在控制台中输出 \"Hello World\"。请注意，Python是一种不同于Java和JavaScript的编程语言，因此代码语法和执行方式也会有所不同。",
            "conversationId": "4020e02d-bf5c-49b3-8005-701b1a9f53c1"
        }
    ]
}
 */
export let getConversation = (conversationId: any) => {
    return request.get(`Conversations/${conversationId}`)
}

/**
 * 删除对话
 * @param conversationId 
 * @returns 
 */
export let deleteConversation = (conversationId: any) => {
    return request.delete(`Conversations/${conversationId}`)
}