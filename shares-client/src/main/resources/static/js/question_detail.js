let questionApp = new Vue({
    el:"#questionApp",
    data:{
        question:{},
    },
    created(){
        this.loadquestion();
    },
    methods:{
        loadquestion(){
            let qid = location.search.substring(1);
            // console.log(qid);
            if (!qid){
                return
            }
            axios.get("http://localhost:9000/v2/questions/"+qid).then(function (response){
                questionApp.question = response.data
                addDuration(questionApp.question)
            })
        },
    },
})

let postAnswerApp = new Vue({
    el:"#postAnswerApp",
    data:{
        hasError:false,
        message:"",
    },
    created() {},
    methods: {
        postAnswer(){
            let qid = location.search;
            if (!qid){
                this.message = "必须指定问题id"
                this.hasError = true
                return
            }
            qid = qid.substring(1)
            let content = $("#summernote").val()
            if (!content){
                this.message = "回答内容不能为空"
                this.hasError = true
                return;
            }
            let form = new FormData()
            form.append("questionId",qid)
            form.append("content",content)
            form.append("accessToken",token)
            axios.post("http://localhost:9000/v2/answers",form).then(function (response) {
                // console.log(response.data)
                let answer = response.data
                answersApp.answers.push(answer)
                $("#summernote").summernote("reset")
                postAnswerApp.hasError = false
                answer.duration = "刚刚"
            }).catch(function (error) {
                console.log(error)
            })
        }
    },
})

let answersApp = new Vue({
    el:"#answersApp",
    data:{
        answers:[],
    },
    created(){
        this.loadAnswers();
    },
    methods:{
        loadAnswers(){
            let qid = location.search;
            if (!qid){
                alert("必须指定问题id")
                return
            }
            qid = qid.substring(1)
            // console.log(qid)
            axios.get("http://localhost:9000/v2/answers/question/"+qid).then(function (response) {
                answersApp.answers = response.data
                // console.log(answersApp.answers)
                let answers = answersApp.answers;
                for (let i = 0; i < answers.length; i++) {
                    addDuration(answers[i])
                }
            }).catch(function (error) {
                console.log(error)
            })
        },
        postComment(answerId){
            console.log("answerId:"+answerId)
            let textarea = $("#addComment"+answerId+" textarea")
            let content = textarea.val()
            if(!content){
                return
            }
            let form = new FormData()
            form.append("answerId",answerId)
            form.append("content",content)
            form.append("accessToken",token)
            axios.post("http://localhost:9000/v2/comments",form).then(function (response) {
                // console.log(response.data)
                textarea.val("")
                $("#addComment"+answerId).collapse("hide")
                let comment = response.data
                let answers = answersApp.answers
                for (let i = 0; i < answers.length; i++) {
                    if (answers[i].id == answerId){
                        answers[i].comments.push(comment)
                        return
                    }
                }
            }).catch(function (error) {
                console.log(error)
            })
        },
        removeComment(commentId,index,comments){
            if (!commentId){
                return
            }
            axios("http://localhost:9000/v2/comments/"+commentId+"/delete",{params:{"accessToken":token}}).then(function (response) {
                // console.log(response.data)
                if (response.data != "删除成功"){
                    alert(response.data)
                }else {
                    // 1为删除1个
                    comments.splice(index,1)
                }
            }).catch(function (error) {
                console.log(error)
            })
        },
        updateComment(commentId,answerId,index,comments) {
            let textarea = $("#editComment"+commentId+ " textarea")
            // console.log(textarea)
            let content = textarea.val()
            if (!content) {
                return
            }
            let form = new FormData()
            form.append("answerId",answerId)
            form.append("content",content)
            form.append("accessToken",token)
            axios.post("http://localhost:9000/v2/comments/"+commentId+"/update",form).then(function (response) {
                // console.log(response.data)
                //comments[index] = response.data
                // set(需要改的内容，需要改的位置，改成的内容)
                Vue.set(comments,index,response.data)
                $("#editCommemt"+commentId).collapse("hide")
            }).catch(function (error) {
                console.log(error)
            })
        },
        answerSolved(answerId){
            if (!answerId){
                return
            }
            axios.get("http://localhost:9000/v2/answers/"+answerId+"/solved",{params:{"accessToken":token}}).then(function (response) {
                console.log(response.data)
            }).catch(function (error) {
                console.log(error)
            })
        }

    },
})

